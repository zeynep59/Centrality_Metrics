import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph<T> implements GraphInterface {

	private ArrayList<String> vertices; //to keep vertex names
	private int[][] adjacency; //to keep edges
	private int size;
	
	private float maxCloseness = -1;
	private int maxBetweenness = -1;
	private String maxClosenessS;
	private String maxBetweennessS;
	private ArrayList<Integer> betweenness = new ArrayList<Integer>();

	
	public Graph(int size) {
		vertices = new ArrayList<String>();
		adjacency = new int[size][size];
		this.size = size;
	}
	
	public void addEdge(String source, String destination) {
		if(!vertices.contains(source))
			vertices.add(source);
		if(!vertices.contains(destination))
			vertices.add(destination);
		
		int source_index = vertices.indexOf(source);
		int destination_index = vertices.indexOf(destination);
		adjacency[source_index][destination_index] = 1;
		adjacency[destination_index][source_index] = 1;
	}
	
	

	
	public int size() {
		return this.size;
	}
	
	public int[][] getAdjacency(){
		return adjacency;
	}
	
	public ArrayList<String> getVertices(){
		return vertices;
	}
	
	public void print() {
		for (String v : vertices) {
			System.out.print("\t(" + v + ")");
		}
		System.out.println();
		for (int i = 0; i < vertices.size(); i++) {
			System.out.print("(" + vertices.get(i) + ")\t");
			for (int j = 0; j < adjacency.length; j++) {
				System.out.print(adjacency[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println("Edges");
		int edge_count = 0;
		int total_weight = 0;
		for (int i = 0; i < vertices.size(); i++) {
			for (int j = 0; j < vertices.size(); j++) {
				if (adjacency[i][j] > 0 && i<=j) {
					System.out.println(vertices.get(i) + "-" + vertices.get(j) + ":" + adjacency[i][j]);
					edge_count++;
					total_weight += adjacency[i][j];
				}
			}
		}
		System.out.println("Total " + edge_count + " edges.");
		System.out.println("Total weight is " + total_weight);
		System.out.println();
	}
	

	
	

	public int unvisitedNeighbor(int index, int[] visited) {
		for (int i = 0; i < adjacency.length; i++) {
			if (adjacency[index][i] != 0 && visited[i] == 0)
				return i;
		}
		return -1;
	}

	public void shortestPath(String source) {
		int[] visited=  new int[vertices.size()];
		int startIndex  = vertices.indexOf(source);
		
		Queue<ArrayList<String>> traversalq = new LinkedList<>();
		ArrayList<String> path = new ArrayList<>();
		path.add(source); 
		traversalq.add(path);
		visited[startIndex] = -1; 
		float closeness = 0;
		
		for(int i=0; i<vertices.size(); i++)
			betweenness.add(0);
		
		//start to traversal
		while(!traversalq.isEmpty()) {
			
			path = traversalq.poll();
			int lastNode = vertices.indexOf(path.get(path.size()-1));
			int v;
			
			while((v=unvisitedNeighbor(lastNode, visited))!=-1) { //till there is no neighbor
				visited[v] = -1;
				ArrayList<String> newpath = new ArrayList<>();
				newpath = (ArrayList<String>) path.clone();
				newpath.add(vertices.get(v)); //Continue as adding on the old path.
				traversalq.add(newpath);
				fillBetweenness(newpath);
				closeness+=newpath.size()-1;
			}
		}
		
		closeness = 1/closeness;
		
		if(closeness>maxCloseness && closeness<0.5) { //
			maxCloseness = closeness;
			maxClosenessS = source;
		}

	}
	
	
	public void fillBetweenness(ArrayList<String> path) {
		for(int i=0; i<path.size(); i++) {
			int index = vertices.indexOf(path.get(i));
			betweenness.set(index, betweenness.get(index)+1);

		}
	}
	

	public void allShtstPaths() {		
		for(int i=0; i<vertices.size(); i++) {
			shortestPath(vertices.get(i));
		}
		highestValue();
	}
	
	
	public void highestValue() {
	
		for(int i=0; i<vertices.size(); i++) {
			if(betweenness.get(i)>maxBetweenness) {
				maxBetweennessS = vertices.get(i);
				maxBetweenness = betweenness.get(i);
			}
		}
	}
	
	
	public float getCloseness() {
		return maxCloseness;
	}
	
	public String getClosestSource() {
		return maxClosenessS;
	}
	
	
	public int getBetweenness() {
		return maxBetweenness/2;
	}
	
	public String getBetweennestSource() {
		return maxBetweennessS;
	}
	
	
}
