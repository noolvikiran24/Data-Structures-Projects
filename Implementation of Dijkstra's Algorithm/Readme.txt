Readme File

Please find the instructions to run program below:

- Download the Main.java and the adjacencyMatrix.txt files which are uploaded.
- From the command line, Go to the location where the above file is saved.
- Compile the file using the command javac Main.java.
- Now run the file using the command java Main.
- The program will ask for the pathname of the file with adjacency matrix representation of the graph(adjacencyMatrix.txt).
- Give the pathname, Click Enter
- The result will be displayed.


Notes:
- I have uploaded the file with adjacency matrix representation, If the file is in the same folder from which the program is executed then giving just the "adjacencyMatrix.txt" as pathname will be sufficient else the entire pathname of the file should be provided.
- I am computing the minimum distance of each vertex from the source vertex 0.

Example result:
Kirans-MacBook-Air:Assignment 4 kirannoolvi$ javac Main.java
Kirans-MacBook-Air:Assignment 4 kirannoolvi$ java Main
Please enter the pathname of the file with adjacency matrix representation of the graph:adjacencyMatrix.txt

The Adjacency Matrix Representation of the given graph is as below:
0 8 2 5 0 0 0 0 0 0 
8 0 0 2 0 13 0 0 0 0 
2 0 0 2 5 0 0 0 0 0 
5 2 2 0 1 6 3 0 0 0 
0 0 5 1 0 0 1 0 0 0 
0 13 0 6 0 0 2 3 9 0 
0 0 0 3 1 2 0 6 0 0 
0 0 0 0 0 3 6 0 7 10 
0 0 0 0 0 9 0 7 0 6 
0 0 0 0 0 0 0 10 6 0 

The final result after running Dijkstra's algorithm is as below:
Minimum distance of vertex 0 from source vertex 0 is 0
Minimum distance of vertex 1 from source vertex 0 is 6
Minimum distance of vertex 2 from source vertex 0 is 2
Minimum distance of vertex 3 from source vertex 0 is 4
Minimum distance of vertex 4 from source vertex 0 is 5
Minimum distance of vertex 5 from source vertex 0 is 8
Minimum distance of vertex 6 from source vertex 0 is 6
Minimum distance of vertex 7 from source vertex 0 is 11
Minimum distance of vertex 8 from source vertex 0 is 17
Minimum distance of vertex 9 from source vertex 0 is 21
Kirans-MacBook-Air:Assignment 4 kirannoolvi$ 
