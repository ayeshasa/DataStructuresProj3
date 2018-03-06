/**
     * Ayesha Saleem 
     * The input is the number of vertexes (target groups) followed by the number edges (surrogates).
     * The user then inputs the target groups and the actual surrogates (string, string, int) 
     * where the integer is the cost of that edge (the surrogate talking to the target groups)
     * The output is the lowest cost of the the initial vertex speaking to every target group 
     * going through the least amount of surrogates as possible.  
     */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Vector;
import java.io.*;
import java.util.*;

public class program3503{
	
static int targetgroups= 0;
static int surrogates=0;
static Scanner scan= new Scanner(System.in);
static int [][]graph;
/**
 * PRE CONDITIONS
 *
 *The method asks the user to input the number of vertexes and edges as well as the edges in
 *the form (String, String, int) where the two strings are the vertexes the edge is touching
 *and the integer is the cost of the edge. The program then creates a matrix for the input. 
 */
public static void main(String[] args)throws IOException{
	targetgroups=scan.nextInt();
	surrogates=scan.nextInt();
	int cost;
	String vertex1;
	String vertex2;
	graph= new int[surrogates][surrogates];
	ArrayList <String> targets =new ArrayList<String>();
	 Vertex vertex= new Vertex();
	 Edge edges= new Edge(); 
	 int source=0;
	
	 for(int i=0; i<targetgroups; i++){
		vertex1=scan.next();
		if(!targets.equals(vertex1)){
			targets.add(vertex1);
			vertex=new Vertex(vertex1);	
		}
	 }
		
	 for(int i=0; i<surrogates; i++){
		vertex1=scan.next();
		if(i==0){	
		targets.add(0, vertex1);
		}
		vertex2=scan.next();
		cost=scan.nextInt();
		if(!targets.equals(vertex1)){
			targets.add(vertex1);
		}
		edges=new Edge(vertex1, vertex2, cost);	
		int t= targets.indexOf(vertex1);
		int z= targets.indexOf(vertex2);
		graph[t][z]=cost;
	//	Vertex.allEdges.add(edges);
	 }	 
	 program3503.dijkstra(graph, source);
	// System.out.println(Vertex.allEdges);
	}// end main
/**
 * POST CONDITIONS
 *
 *The method calls the method Dijsktra and passes its matrix (int array [][]) and a integer
 *called source (source is (should always be) zero (I think)). 
 */

/**
 * PRE CONDITIONS
 *
 *The method takes the graph as an input (2-dim array) as well as an integer which holds the
 * source. The method sets the distance from the source to the source to 0 and calls the method
 * Distance()
 */

public static void dijkstra(int graph[][], int source)
{
    int dist[] = new int[surrogates]; 
    Boolean visited[] = new Boolean[surrogates];
    for (int i = 0; i < surrogates; i++){
        dist[i] = Integer.MAX_VALUE;
        visited[i] = false;
    }
    dist[source] = 0; //trump can't talk to himself -_-
    for (int count = 0; count < targetgroups-1; count++){
        int t = Distance(dist, visited);
        visited[t] = true;
        for (int k = 0; k < targetgroups; k++)
            if (!visited[k] && graph[t][k]!=0 &&
                    dist[t] != Integer.MAX_VALUE &&
                    dist[t]+graph[t][k] < dist[k])
                dist[k] = dist[t] + graph[t][k];
    }
    FinalAnswer(dist, targetgroups);
	}

/**
 * POST CONDITIONS
 *
 *The method calls the method FinalAnswers() and passes the array dist (int) and the integer targetgroups 
 */

/**
 * PRE CONDITIONS
 *
 *The method takes the distance array (int array) as well as the visited array (boolean array)
 * The method then sets the minimum to the biggest number java allows and creates an array that
 * holds the number of jumps. The method iterates through the visited array and updates
 * the distance if the min is less and if the number of jumps are less. 
 */
static int Distance(int dist[], Boolean visited[])
{
    int min = Integer.MAX_VALUE,minIndex=-1; //(better and bigger than 100000000) (hahaha i'm so funny)
    int jumpnum[]= new int[visited.length]; 
    int counter=0;
    for(int i=0; i<visited.length; i++){
    	jumpnum[i]=0;
    }
    for (int j = 0; j < targetgroups; j++){
        if (visited[j] == false){
        if(dist[j] <= min && jumpnum[j]<counter){
        	 min = dist[j];
             minIndex = j;
             jumpnum[j]=jumpnum[j++];
             counter++;
        	}
        }
}
    return 0;
}
/**
 * POST CONDITIONS
 *
 *The method returns the the integer 0. The method also should correctly computer dist[] which
 *contains the shortest path with the shortest jumps for the input. 
 */


/**
 * PRE CONDITIONS
 *
 *The method takes the distance array (int array) as well as the target groups (integer) and 
 *adds all the numbers in the distance array together. 
 */
static void FinalAnswer(int dist[], int n)
{
	 int finalInt=0;
    for (int i = 0; i < targetgroups; i++){
        finalInt= finalInt+ dist[i];
    }
    	System.out.println(finalInt);
	}
/**
 * POST CONDITIONS
 *
 *The method prints the finalInt, an integer which displays the shortest path with the 
 *shortest jumps for the input given. 
 */

}// end class
