import java.io.File;
import java.util.Scanner;


class Dijkstra{
 public int minDistancevalue(Boolean visited[], int distance[], int V){

     int minNode=-1; // Some initial value of the node
     int minDist=Integer.MAX_VALUE;
     for(int i=0;i<V;i++){
         if(distance[i]<=minDist && (!visited[i])){

             minNode = i;
             minDist = distance[i];
         }
     }
     return minNode;


 }




    public int[] actualAlgorithm(int[][] graphRep, int sourceVertex, int V){

        Boolean visited[] = new Boolean[V];

        for(int i=0;i<V;i++){
            visited[i] = false; // Setting each of the visited vertex value to false initially
        }

        int distance[] = new int[V];
        for(int i=0; i<V; i++){
            distance[i]=Integer.MAX_VALUE; // Initially setting the distance to some maximum value, Imitating Infinity
        }
        distance[sourceVertex] =0; // Now setting the distance of source vertex to 0

        for(int i=1; i<V; i++){
            int minVertex;
            minVertex= minDistancevalue(visited, distance, V);
            visited[minVertex] = true;

            for(int j=0;j<V;j++){
                if((graphRep[minVertex][j]!=0) && (!visited[j])){
                    if(distance[minVertex]!=Integer.MAX_VALUE){
                        if(distance[minVertex]+graphRep[minVertex][j]<distance[j]){
                            distance[j] = distance[minVertex]+graphRep[minVertex][j];

                        }
                    }
                }

            }

        }
 return distance;


    }




}

public class Main {

    public static void finalResult(int distance[], int source, int V){
        for(int i=0;i<V;i++){
            System.out.println("Minimum distance of vertex "+i+" from source vertex "+source+" is "+distance[i]);
        }

    }

    public static void main(String[] args) {


        Dijkstra d = new Dijkstra();

        
        System.out.print("Please enter the pathname of the file with adjacency matrix representation of the graph:");
        Scanner sc1 = new Scanner(System.in);
        String pathname = sc1.nextLine();
        int V = 10;
        int graphRep [][] = new int[V][V];
        int finResult[] = new int[V];

      try {
          File graphFile = new File(pathname);
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
System.out.println("The Adjacency Matrix Representation of the given graph is as below:");
        for(int i=0; i<V; i++){
            for(int j=0;j<V;j++){
                System.out.print(graphRep[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();

        finResult =  d.actualAlgorithm(graphRep, 0, V);
        System.out.println("The final result after running Dijkstra's algorithm is as below:");
        finalResult(finResult,0,V);

    }
    }



