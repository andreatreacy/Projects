# Prim's Algorithm Project 2021

Author Name: Andrea Treacy
Compiler: Visual Studio Code


## Description
Program that uses Prim’s algorithm to find the minimum spanning tree of a weighted graph. The user enters the graph file name and chooses which vertex to start with. The program starts at the chosen vertex and adds the edge with the smallest weight connected to the vertex to the minimum spanning tree. It then adds the edge with the next smallest weight connected to any vertex connected to an edge on the minimum spanning tree. If adding an edge will create a cycle the edge is not added. It continues to do this until all of the vertices are connected to the minimum spanning tree.

This program also demonstrates Depth First Graph Traversal Using Recursion and Breadth First Graph Traversal Using a Queue. Depth First graph traversal starts at a chosen vertex and moves through vertices as far as it can go along each branch before backtracking. Breadth First graph traversal starts at a chosen vertex and goes through all of the neighbouring vertices at the current depth, then it moves onto the vertices at the next depth level.
