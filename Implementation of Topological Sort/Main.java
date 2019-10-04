
import java.io.File;
import java.util.Scanner;

public class Main {



  Node head;


    class Node{
        int value;
        Node next;
        Node(int n){
            this.value =n;
            next=null;
        }
    }

     public Node addNode(Node head, int n){
        Node newNode = new Node(n);

        if(head==null){
            return newNode;


        }

        else{
            head.next=addNode(head.next,n);
            return head;

        }


    }


    public void printList(Node head){
       if(head==null){
           return;
       }
       else{
           System.out.print(head.value);
           if(head.next!=null){
               System.out.print(" -> ");
           }
           printList(head.next);
       }

    }

    public void cycleFound(int cycleVertices[], int q){
       System.out.println();
        System.out.println("A cycle has been found in the given directed graph and the cycle which is found is as below:");
        int i=0;
       while(cycleVertices[i]!=q){
            i++;
        }

        for(int j=i;j<cycleVertices.length;j++){
            if(cycleVertices[j]!=0){
                System.out.print( cycleVertices[j]+ " -> ");
            }

        }
        System.out.println(q);
        System.out.println();
    }
    Node topologicalSortMethod(int s, int V, Node start, int vertexVisited[], int graphRep[][],int vertexVisitedTS[], int k, int cycleArr[]){
        vertexVisited[s]=1;
       // System.out.println(s);
        cycleArr[k]=s;

for(int j=s; j<V; j++) {
    for (int i = 0; i < V; i++) {
        if (graphRep[s][i] == 1) {
            if (vertexVisited[i] == 1) {
                // System.out.println("S:"+s);
                cycleFound(cycleArr, i);
                //vertexVisited[s]=0;
                System.exit(0);
                return null;


            }
            if (vertexVisitedTS[i] == 1) {
                continue;
            }
            k=k+1;
            start = topologicalSortMethod(i, V, start, vertexVisited, graphRep, vertexVisitedTS,k,cycleArr);


        }

    }
}

        //System.out.println(s);
        vertexVisitedTS[s]=1;
        vertexVisited[s]=0;
        start= addNode(start, s);
        return start;




    }


    public static void main(String[] args) {

	// write your code here

        Main topologicalSort = new Main();
      Main.Node start = topologicalSort.head;

       System.out.print("Please enter the pathname of the file with adjacency matrix representation of an acyclic graph:");
        Scanner sc1 = new Scanner(System.in);
        String pathname1 = sc1.nextLine();
        System.out.print("Please enter the pathname of the file with adjacency matrix representation of a cyclic graph:");
        Scanner sc2 = new Scanner(System.in);
        String pathname2 = sc2.nextLine();

        int V = 11;
       // Boolean isCG=false;
        int vertexVisited[] = new int[V];
        int vertexVisitedTS[] = new int[V];
        int cycleArr[] = new int[V];

        for(int i=0;i<V; i++){
            vertexVisited[i]=0;
        }
        for(int i=0;i<V; i++){
            vertexVisitedTS[i]=0;
        }
        for(int i=0;i<V; i++){
            cycleArr[i]=0;
        }
        int graphRep [][] = new int[V][V];

        try {
            File graphFile = new File(pathname1);
            Scanner sc = new Scanner(graphFile);

            for(int i=0; i<V; i++){
                for(int j=0;j<V;j++){
                    graphRep[i][j] = sc.nextInt();
                }
            }

        }
        catch(Exception e){
            System.out.println("The given pathname is not correct");
        }
        System.out.println();
        System.out.println("ACYCLIC GRAPH");
        //System.out.println();
        System.out.println("The Adjacency Matrix Representation showing all the edges of the given graph is as below:");
        for(int i=0; i<V; i++){
            for(int j=0;j<V;j++){
                System.out.print(graphRep[i][j]+" ");
            }
            System.out.println();
        }


        start = topologicalSort.topologicalSortMethod(1, V, start, vertexVisited, graphRep, vertexVisitedTS,1,cycleArr);

        for(int i=0; i<V; i++){

            if(vertexVisitedTS[i]==0){
                start = topologicalSort.topologicalSortMethod(i, V, start,vertexVisited, graphRep,vertexVisitedTS,i,cycleArr);
            }

        }

       System.out.println();
        System.out.println("Topological order of the vertices after performing Topological Sort(DFS) on the given graph is as below:");
       topologicalSort.printList(start);
        System.out.println();


        for(int i=0;i<V; i++){
            vertexVisited[i]=0;
        }
        for(int i=0;i<V; i++){
            vertexVisitedTS[i]=0;
        }
        for(int i=0;i<V; i++){
            cycleArr[i]=0;
        }


        try {
            File graphFile = new File(pathname2);
            Scanner sc4 = new Scanner(graphFile);

            for(int i=0; i<V; i++){
                for(int j=0;j<V;j++){
                    graphRep[i][j] = sc4.nextInt();
                }
            }

        }
        catch(Exception e){
            System.out.println("The given pathname is not correct");
        }
        Main cyclicGraph = new Main();
        Main.Node cycStart = cyclicGraph.head;
        System.out.println();
        System.out.println("CYCLIC GRAPH");
        //System.out.println();
        
        
         System.out.println("The Adjacency Matrix Representation showing all the edges of the given graph is as below:");
        for(int i=0; i<V; i++){
            for(int j=0;j<V;j++){
                System.out.print(graphRep[i][j]+" ");
            }
            System.out.println();
        }

        cycStart = topologicalSort.topologicalSortMethod(1, V, cycStart, vertexVisited, graphRep, vertexVisitedTS,1,cycleArr);

        for(int i=0; i<V; i++){

            if(vertexVisitedTS[i]==0){
                cycStart = topologicalSort.topologicalSortMethod(i, V, cycStart,vertexVisited, graphRep,vertexVisitedTS,i,cycleArr);
            }

        }

        System.out.println();
        System.out.println("Topological Sort(DFS) of the given graph is as below:");
        topologicalSort.printList(cycStart);
        System.out.println();


      /* for(int i=0; i<V;i++){
        System.out.println(vertexVisitedTS[i]);
        } */


    }
}
