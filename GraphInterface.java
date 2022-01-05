import java.util.ArrayList;
import java.util.List;

public interface GraphInterface<T> {

	public void addEdge(String source, String destination); 
	
	public void print();
	
	public int size(); //returns the size of graph (number of vertex)
	
	public  ArrayList<String> getVertices();
	
	public void allShtstPaths() ;//Finds the shortest paths between all possible combinations of binary nodes.

	public float getCloseness();   // returns tthe highest closeness value of the graph
	
	public String getClosestSource();  //returns the node has the highest closeness value
	
	public String getBetweennestSource(); //returns the node has the highest betweenness value
	
	public int getBetweenness(); //returns the highest betweenness value of the graph
}
