# Kruskal's Algorithm Project 2021

Author Name: Andrea Treacy
Compiler: Visual Studio Code


## Description
Program that uses Kruskal’s algorithm to find the minimum spanning tree of a weighted graph. It is considered to be a greedy algorithm. It starts by adding the edge with the smallest weight to the minimum spanning tree. It then adds the edge with the next smallest weight to the minimum spanning tree. If adding an edge will create a cycle the edge is not added. Unlike Prim's Algorithm the edges do not need to be connected to each other to be added. This process runs until all of the vertices are connected to the minimum spanning tree. As this process continues there may be multiple trees being formed, but they will join together to make one minimum spanning tree in the end.
