
/*
Program Description:
Program that demonstrates a circular buffer. The user can add up to 8 values to the buffer before it is full. When the buffer is full and the user chooses to remove an item, the first item in the buffer is the first one to be removed (First in first out). The user can then add another value to the buffer.
Author Name: Andrea Treacy
Compiler: Borland
*/
#include <stdio.h>

#define BUFFER_SIZE 8

void addToBuffer(int *, int *, int *);
void removeFromBuffer(int *, int *, int *);
void displayBuffer(int *);


int main()
{
    int circularBuffer[BUFFER_SIZE] = {0};	// array to store the circular buffer. set all values to 0 to represent unset values
    int removeIndex =	0;	// keeps track of where in the buffer to remove a value from
	int addIndex = 0;	// keeps track of where in the buffer to add a value to
	int bufferCount = 0;	// counts the number of values in the buffer
    unsigned int choice;    //stores the user's menu choice
    int end = 0;        //controls when the do while loop ends
    
    //loop will run until end = 1 (user picks menu option 4)
    do 
    {
        printf("\n\n__________Menu__________\n");
        printf("Enter your choice:\n");
        printf("1. Add a value to the buffer\n");
        printf("2. Remove an item from the buffer\n");
        printf("3. Display the buffer\n");
        printf("4. End program\n");
        
        scanf("%u", &choice);
    
        switch(choice) 
        { 
            //add a value to the buffer
            case 1:
            {
                // Check if buffer is full
                if (bufferCount == BUFFER_SIZE) 
                {
                    printf("Buffer is full\n");
                }
                else
                {
                    addToBuffer(circularBuffer, &addIndex, &bufferCount);
                    displayBuffer(circularBuffer);
                }
                break;
            }//end case1
            
            //remove a value from the buffer
            case 2:
            {
                if (bufferCount == 0) 
                {
                    printf("Buffer is empty\n");
                }
                else
                {
                    removeFromBuffer(circularBuffer, &removeIndex, &bufferCount);
                    displayBuffer(circularBuffer);
                }
                break;
            }//end case2
            
            //display the buffer
            case 3:
            {
                if (bufferCount == 0) 
                {
                    printf("Buffer is empty\n");
                }
                else
                {
                    displayBuffer(circularBuffer);
                }
                break;
            }//end case3
            
            //end the program
            case 4:
            {
                end = 1;
                break;
            }//end case4
             
            default:
            {
                printf("Invalid choice. Choose 1-4\n");
                break;
            }
        } // end switch

   }//end do
    while (end != 1);  
    
    printf("Program is ending");
    flushall();
    getchar();
    return 0;
}



//function to add a value to the buffer
void addToBuffer(int *circularBuffer, int *addIndex, int *bufferCount)
{
    int value;
    
    printf("Enter a value: ");
    scanf("%d", &value);
    
    circularBuffer[*addIndex] = value;  //put the user input value into the buffer
    
    *bufferCount = *bufferCount + 1;	 //increase the count of buffer values after adding one
    *addIndex = *addIndex + 1;	 //increase addIndex position to prepare for next addition
    
    //when the addIndex gets to the last position in the buffer, return to the start
    if(*addIndex == BUFFER_SIZE) 
    {
        *addIndex = 0;
    }
}




//function to remove a value from the buffer
void removeFromBuffer(int *circularBuffer, int *removeIndex, int *bufferCount)
{
    int consumer;   //variable to store the removed value
    
    consumer = circularBuffer[*removeIndex];  //assing the value to be removed to consumer
    printf("The value being removed is %d\n", consumer);
    
    circularBuffer[*removeIndex] = 0; //reset the removed value to 0 to represent an unset value

    *bufferCount = *bufferCount - 1;	 //decrease the count of buffer values after removing one
    *removeIndex = *removeIndex + 1;	 //increase removeIndex position to prepare for the next removal

    //when you get to the last index in buffer, set removeIndex back to the start
    if (*removeIndex == BUFFER_SIZE) 
    {
        *removeIndex = 0;
    }
}






//function to print the values in the circular buffer
void displayBuffer(int *circularBuffer)
{
    int i;

    printf("Circular Buffer = [ ");
    
    //print the values in the circular buffer
    for(i=0; i<BUFFER_SIZE; i++)
    {
        //dont print the values that have not been set
        if(circularBuffer[i] == 0)
        {
            continue;
        }
        else
        {
            printf("%d ", circularBuffer[i]);
        }
    }
    
    printf("]\n");
}
