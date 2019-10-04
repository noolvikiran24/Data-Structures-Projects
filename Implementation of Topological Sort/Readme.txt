Readme File

Please find the instructions to run program below:

- Download the Main.java, AcyclicGraph.txt and the CyclicGraph.txt files which are uploaded.
- From the command line, Go to the location where the above file is saved.
- Compile the file using the command javac Main.java.
- Now run the file using the command java Main.
- The program will ask for the pathname of the file with adjacency matrix representation of an acyclic graph(AcyclicGraph.txt) and the file with cyclic graph(CyclicGraph.txt).
- Give the pathnames, Click Enter
- The result will be displayed.


Notes:
- I have uploaded the file with adjacency matrix representation of acyclic and cyclic graph, If the file is in the same folder from which the program is executed then giving just the "AcyclicGraph.txt" and "CyclicGraph.txt" as pathname will be sufficient else the entire pathname of the file should be provided.
- I have started the topological sort by giving 1 as the starting node, The program visits all the other nodes later and performs the necessary task.


Example Result:

Kirans-MacBook-Air:Assignment 5 kirannoolvi$ javac Main.java
Kirans-MacBook-Air:Assignment 5 kirannoolvi$ java Main
Please enter the pathname of the file with adjacency matrix representation of an acyclic graph:AcyclicGraph.txt
Please enter the pathname of the file with adjacency matrix representation of a cyclic graph:CyclicGraph.txt

ACYCLIC GRAPH
The Adjacency Matrix Representation showing all the edges of the given graph is as below:
0 0 0 1 1 0 0 0 0 0 0 
0 0 1 1 0 0 0 0 0 0 0 
0 -1 0 1 0 1 0 1 0 0 0 
-1 -1 -1 0 1 0 0 0 0 0 0 
-1 0 0 -1 0 0 1 0 1 0 0 
0 0 -1 0 0 0 1 0 0 0 0 
0 0 0 0 -1 -1 0 0 1 0 0 
0 0 -1 0 0 0 0 0 1 1 0 
0 0 0 0 -1 0 -1 -1 0 -1 -1 
0 0 0 0 0 0 0 -1 1 0 1 
0 0 0 0 0 0 0 0 1 -1 0 

Topological order of the vertices after performing Topological Sort(DFS) on the given graph is as below:
8 -> 6 -> 4 -> 3 -> 5 -> 10 -> 9 -> 7 -> 2 -> 1 -> 0

CYCLIC GRAPH
The Adjacency Matrix Representation showing all the edges of the given graph is as below:
0 0 0 1 1 0 0 0 0 0 0 
0 0 1 1 0 0 0 0 0 0 0 
0 -1 0 1 0 -1 0 1 0 0 0 
-1 -1 -1 0 1 0 0 0 0 0 0 
-1 0 0 -1 0 0 1 0 1 0 0 
0 0 1 0 0 0 -1 0 0 0 0 
0 0 0 0 -1 1 0 0 1 0 0 
0 0 -1 0 0 0 0 0 1 1 0 
0 0 0 0 -1 0 -1 -1 0 -1 -1 
0 0 0 0 0 0 0 -1 1 0 1 
0 0 0 0 0 0 0 0 1 -1 0 

A cycle has been found in the given directed graph and the cycle which is found is as below:
2 -> 3 -> 4 -> 6 -> 5 -> 2

Kirans-MacBook-Air:Assignment 5 kirannoolvi$ 
