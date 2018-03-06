public class Edge{
String destination;
String source;
int cost;
boolean used;

public Edge (String n, String m, int c){
    this.destination= m;
    this.source= n;
    this.cost=c;
  
    
}
public Edge(){
}

public int getCost(){
	return cost;
}
public String getSource(){
	return source;
}
public String getDestination(){
	return destination;
}


}