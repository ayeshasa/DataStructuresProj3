import java.util.ArrayList;
// make it dynamic
public class Vertex {
String v_name;
static ArrayList <Edge> allEdges;
boolean found; 
int distances;

public Vertex (String n){
    v_name = n;
}
public Vertex(){
	
}
public String getName(){
	return v_name;
}

}