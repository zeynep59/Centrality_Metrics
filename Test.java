import java.io.File;
import java.io.FileNotFoundException;

public class Test {

	public static final int DEFAULT_CAPACITY1 = 50;
	public static final int DEFAULT_CAPACITY = 1540;

	public static void main(String[] args) throws FileNotFoundException {

		GraphInterface graph = new Graph(DEFAULT_CAPACITY1);
		GraphInterface graph2 = new Graph(DEFAULT_CAPACITY);
		
		File file =new File( "karate_club_network.txt");
		AddingEdges addElement = new AddingEdges(file, graph);
		graph.allShtstPaths();
		System.out.println("Zachary Karate Club Network – The Highest Node and value for Closeness   "+graph.getClosestSource() +"  " + graph.getCloseness());
		System.out.println("Zachary Karate Club Network – The Highest Node and value for Betweennes  "+graph.getBetweennestSource() +"  " + graph.getBetweenness());

		
		
		File file2 =new File( "facebook_social_network.txt");
		AddingEdges addElement2 = new AddingEdges(file2, graph2);
		graph2.allShtstPaths();
		System.out.println("\nFacebook Social  Network – The Highest Node and value for Closeness  "+graph2.getClosestSource() +"  " + graph2.getCloseness());
		System.out.println("Facebook Social  Network – The Highest Node and value  for Betweennes  "+graph2.getBetweennestSource() +"  " + graph2.getBetweenness());

		/*output://after 20 seconds the output will be seen
		 

			Zachary Karate Club Network – The Highest Node and value for Closeness   1  0.01724138
			Zachary Karate Club Network – The Highest Node and value for Betweennes  1  263

			Facebook Social  Network – The Highest Node and value for Closeness  418  3.4352456E-4
			Facebook Social  Network – The Highest Node and value  for Betweennes  223  77736
		 */
		
	}

}
