/*Author: Andrea Treacy
Date: 02/04/2021 
Compiler: Visual Studio Code*/
// Simple weighted graph representation 
// Uses an Adjacency Linked Lists, suitable for sparse graphs

import java.io.*;
import java.util.Scanner;  // for user input


class GraphLists {
    class Node {
        public int vert;
        public int wgt;
        public Node next;
    }
    
    // V = number of vertices
    // E = number of edges
    // adj[] is the adjacency lists array
    private int V, E;
    private Node[] adj;
    private Node z;
    private int[] mst;
    
    // used for traversing graph
    private int[] visited;
    private int id;
    
    
    // default constructor
    public GraphLists(String graphFile)  throws IOException
    {
        int u, v;
        int e, wgt;
        Node t;

        FileReader fr = new FileReader(graphFile);
		BufferedReader reader = new BufferedReader(fr);
	           
        String splits = " +";  // multiple whitespace as delimiter
		String line = reader.readLine();        
        String[] parts = line.split(splits);
        System.out.println("Parts[] = " + parts[0] + " " + parts[1]);
        
        V = Integer.parseInt(parts[0]);
        E = Integer.parseInt(parts[1]);
        
        // create sentinel node
        z = new Node(); 
        z.next = z;
        
        // create adjacency lists, initialised to sentinel node z 
        visited = new int[V+1];      
        adj = new Node[V+1];        
        for(v = 1; v <= V; ++v)
            adj[v] = z;               
        
       // read the edges
        System.out.println("Reading edges from text file");
        for(e = 1; e <= E; ++e)
        {
            line = reader.readLine();
            parts = line.split(splits);
            u = Integer.parseInt(parts[0]);
            v = Integer.parseInt(parts[1]); 
            wgt = Integer.parseInt(parts[2]);
            
            System.out.println("Edge " + toChar(u) + "--(" + wgt + ")--" + toChar(v));    
            
            // write code to put edge into adjacency matrix   
            t = new Node();  
            //add values to the new node
			t.vert = v;
			t.wgt = wgt;
			
			//adj[u] is currently pointing to the first node connected to vertex u. The first node will
            //be z if the list is empty
			//this new node t is being placed in front of the current first node
			
			//make the new node point to the current first node
			t.next = adj[u];
			
			//make adj[u] point to the new node which is now the first node connected to vertex u
			adj[u] = t;  

			//add a node the same as above for the v vertex
			Node t2 = new Node();
			t2.vert = u;
			t2.wgt = wgt;
			t2.next = adj[v];
			adj[v] = t2; 
        }	
    }
   
    // convert vertex into char for pretty printing
    private char toChar(int u)
    {  
        return (char)(u + 64);
    }
    
    // method to display the graph representation
    public void display() {
        int v;
        Node n;
        
        for(v=1; v<=V; ++v){
            System.out.print("\nadj[" + toChar(v) + "] ->" );
            for(n = adj[v]; n != z; n = n.next) 
                System.out.print(" |" + toChar(n.vert) + " | " + n.wgt + "| ->");    
        }
        System.out.println("");
    }




    // method to initialise Depth First Traversal of Graph
    public void DF( int s) 
    {
        id = 0;     //id is an attribute of the class for holding the position in the visited array
        // set to 0 as nothing has been visited yet

        //set all elements in visited to 0 as nothing has been visited yet
        for(int v=1; v<=V; ++v) 
        {
            visited[v] = 0;
        }

        System.out.print("\nDepth First Graph Traversal Using Recursion\n");
        System.out.println("Starting with Vertex " + toChar(s));
        dfVisit( 0, s);  // start visiting graph vertices using
        // Depth First from starting vertex s. 0 means you have not been to any other vertex

        System.out.print("\n\n"); 
    }


    // Recursive Depth First Traversal for adjacency matrix
    private void dfVisit( int prev, int v)
    {
        System.out.println(" DF just visited vertex " + toChar(v));
        int u;
        
        visited[v] = ++id;     //id is an attribute of the class for holding the position in the visited array
        //increment id by 1 and put it in visited[v] meaning v has been visited
		
		for(Node t = adj[v]; t != z; t = t.next)
		{
			u = t.vert;
			//if not visited
			if(visited[u] == 0)
			{
				dfVisit(v, u);
			}
		}//end for
      
    }






    // method to initialise Breadthth First Traversal of Graph
    public void BF( int s) 
    {
        id = 0;     //id is an attribute of the class for holding the position in the visited array
        // set to 0 as nothing has been visited yet

        // set all elements in visited to 0 as nothing has been visited yet
        for(int v=1; v<=V; ++v) 
        {
            visited[v] = 0;
        }

        System.out.print("\nBreadth First Graph Traversal Using a Queue\n");
        System.out.println("Starting with Vertex " + toChar(s));
        BF_iteration(s);  // start visiting graph vertices using
        // Depth First from starting vertex s. 0 means you have not been to any other vertex

        System.out.print("\n\n");  
    }


    // Iteritive Breadth First Traversal for adjacency list
    private void BF_iteration(int s)
    {
        Queue q = new Queue();
        q.enQueue(s);    //put the starting vertex onto the queue
        int u, v;

        //while queue is not empty
        while(! q.isEmpty())
        {
            //take the value from the front of the queue and put it into v
            v = q.deQueue();

            //if v has not been visited
            if(visited[v] == 0) 
            {
                visited[v] = ++id;  //id is an attribute of the class for holding the position in the visited array
                //increment id by 1 and put it in visited[v] meaning v has been visited
                System.out.println("  BF just visited vertex " + toChar(v));

                //go through each vertex connected to vertex t
                for(Node t = adj[v]; t != z; t = t.next)
                {
                    u = t.vert;

                    //if vertex u has not been visited
                    if(visited[u] == 0)
                    {
                        //put vertex u onto the queue
                        q.enQueue(u);
                    }
  
                }//end for
                
            }//end outer if

        }//end while
      
    }



    
	public void MST_Prim(int s)
	{
        int v, u;
        int wgt, wgt_sum = 0;
        int[]  dist, parent, hPos;
        Node t;

        System.out.println("Minimum Spanning Tree starting from vertex " + toChar(s));

        // set up the three arrays' size
        dist = new int[V+1];
        parent = new int[V+1];
        hPos = new int[V+1];

        // initialise the arrays
        for(v=0; v <= V; v++)
        {
            dist[v] = Integer.MAX_VALUE;
            parent[v] = 0;
            hPos[v] = 0;
        }
        
        dist[s] = 0;
        
        Heap pq =  new Heap(V, dist, hPos);
        pq.insert(s);
        
        // run while heap is not empty
        while (! pq.isEmpty())  
        {
            v = pq.remove();    // remove the item from the top of the heap
            hPos[v] = 0;    // without this line the starting vertex will remain in position 1
            wgt_sum = wgt_sum + dist[v];    // add the dist of the vertex removed to the min spanning tree

            System.out.println(toChar(parent[v]) + " ___ (" + dist[v] + ") ___ " + toChar(v));

            dist[v] = -dist[v];     // mark vertex as done by making distance negative

            // move through all the vertices
            for(t = adj[v]; t != z; t = t.next)
            {
                u = t.vert;
                wgt = t.wgt;

                // if wgt is less than the distance of vertex u
                if(wgt < dist[u])
                { 
                    dist[u] = wgt;
                    parent[u] = v;
                    //System.out.println("Parent = " + toChar(parent[u])); // code for keeping track of the parent

                    // if vertex not in heap insert it
                    if(hPos[u] == 0)
                    {
                        pq.insert(u);
                    }
                    // if vertex is already in heap sift it up the heap
                    else
                    {
                        pq.siftUp(hPos[u]);
                    }
                }//end outer if

            }//end for
        
        }//end while

        System.out.print("\n\nWeight of MST = " + wgt_sum + "\n");
        
        mst = parent;                    		
	}

    
    public void showMST()
    {
            System.out.print("\n\nMinimum Spanning tree parent array is:\n");
            for(int v = 1; v <= V; ++v)
                System.out.println(toChar(v) + " -> " + toChar(mst[v]));
            System.out.println("");
    }

}

public class PrimLists {
    public static void main(String[] args) throws IOException
    {
        int s;
        String fname; 
        
        Scanner scan = new Scanner(System.in);  // Create a Scanner object for user input

        // file name is wGraph1.txt
        System.out.println("Enter the name of the text file");
        fname = scan.nextLine();

        // type 12 for vertex L
        System.out.println("Enter the starting vertex in number form");
        s = scan.nextInt();

        scan.close();   // close the scanner

        // check if vertex exists on the graph
        if(s < 14 && s > 0)
        {
            GraphLists g = new GraphLists(fname);
        
            g.display();             
                
            //Depth first traversal using recursion
            g.DF(s);
            
            //Breadth first traversal using a queue
            g.BF(s);
            
            //Prim (best first traversal using a priority queue/heap)
            g.MST_Prim(s);
            
            g.showMST();
        }
        else
        {
            System.out.println("Vertex does not exist");
        }         
    } 
}


/*

Heap Code for efficient implementation of Prim's Alg

*/

class Heap
{
    private int[] a;	   // heap array
    private int[] hPos;	   // hPos[h[k]] == k
    private int[] dist;    // dist[v] = priority of v
    private int max;     //used for printing the arrays

    private int N;         // heap size
   
    // The heap constructor gets passed from the Graph:
    //    1. maximum heap size
    //    2. reference to the dist[] array
    //    3. reference to the hPos[] array
    public Heap(int maxSize, int[] _dist, int[] _hPos) 
    {
        N = 0;
        a = new int[maxSize + 1];
        dist = _dist;
        hPos = _hPos;
        max = maxSize;
    }


    public boolean isEmpty() 
    {
        return N == 0;
    }


    public void siftUp( int k) 
    {
		// k is the vertex's current position on the heap
		
        int v = a[k];

        a[0] = 0;
        dist[0] = Integer.MIN_VALUE;

        //compare the distance of the v vertex with the distance of it's parent vertex. 
        //run while if child distance is smaller
        while(dist[v] < dist[a[k/2]])
        {
            a[k] = a[k/2]; // parent vertex is assigned the position of the child vertex
            hPos[a[k]] = k;		// hpos stores the new position of the parent
            k = k/2;	// this will be the new index of the child (the index of its former parent)
        }

        a[k] = v;   // finishing position of vertex v on heap
        hPos[v] = k;    // update the position of vertex v in hpos


        // Extra code for displaying the arrays
        /*
        System.out.println("\nhPos array after siftup: \n");
        char ch = 'A';
        for(int i=1; i <= max; i++)
        {
            System.out.println(ch + " is in position " + hPos[i]);
            ch++;
        }
        */
        
        /*
        System.out.println("\nheap array after siftup: \n");
        char ch2;
        for (int i=1; i <= max; i++ )
        {
            ch2 = (char)(a[i] + 64);
            System.out.println(ch2);
        }
        */

        /*
        System.out.println("\ndist array after siftup: \n");
        char ch3 = 'A';
        for (int i=1; i <= max; i++ )
        {
            System.out.println(ch3 + " is " + dist[i] + " away from the min spanning tree");
            ch3++;
        }
        */
    }


    public void siftDown( int k) 
    {
        int v, j;
       
        v = a[k];  
        
		// check if there is a left child
        while((2 * k) <= N)
        {
            j = (2 * k);	//temp variable to store index of left child

			// check if left child's distance is smaller than right child's distance
            if(j < N && dist[a[j]] > dist[a[j+1]])
            {
                j++;    // if right is greater than left increment j
            }

			// if distance of parent is less than distance of child exit here
            if(dist[v] <= dist[a[j]]) 
            {
                break;  
            }

            a[k] = a[j];    // child is assigned parent position
            hPos[a[k]] = k;     // update new position of parent
            k = j;      // new index position of vertex v
        }

        a[k] = v;   // assign finishing position of vertex v to heap
        hPos[v] = k;    // update position of the vertex v in hPos array
    }


    public void insert( int x) 
    {
        a[++N] = x;
        siftUp( N);
    }


    public int remove() 
    {   
        int v = a[1];
        hPos[v] = 0; // v is no longer in heap      
        
        a[1] = a[N--];
        siftDown(1);
        
        a[N+1] = 0;  // put null node into empty spot
        
        return v;
    }

}



// Queue class used for Breadth First graph traversal

class Queue {

    private class Node {
        int data;
        Node next;
    }

    Node z;
    Node head;
    Node tail;

     public Queue() {
        z = new Node(); 
        z.next = z;
        head = z;  
        tail = null;
    }


  public void display() {
    System.out.println("\nThe queue values are:\n");

    Node temp = head;
    while( temp != temp.next) {
        System.out.print( temp.data + "  ");
        temp = temp.next;
    }
    System.out.println("\n");
  }


  public void enQueue( int x) {
    Node temp;

    temp = new Node();
    temp.data = x;
    temp.next = z;

    if(head == z)    // case of empty list insert node at head
    {
        head = temp;
    }
    else                // case of list not empty place new node at the end of the queue
    {
        tail.next = temp;   //make the current last node point to the new node
    }
    tail = temp;        // make tail point to the new node as tail needs to point to the last (newest) node
  }


  // assume the queue is non-empty when this method is called
  //remove the first item in the queue
public int deQueue() {
   int x = head.data;
   head = head.next;  //point head to the next item after first is removed

   //if the queue is empty
   if(head == head.next)
   {
     tail = null;
   }
   return x;
  }


  //check if queue is empty
  public boolean isEmpty() {
    return head == head.next; //returns true if empty, false if not empty
  }

} // end of Queue class

