import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AddingEdges {

	public AddingEdges(File fileName, GraphInterface graph) throws FileNotFoundException {//constructor
		addingEdges(fileName, graph);
	}
	
	private void addingEdges(File fileName, GraphInterface graph) throws FileNotFoundException {
		
		Scanner scan = new Scanner(fileName);
	   while(scan.hasNextLine()) {
		   String [] content = scan.nextLine().split(" ");
		   graph.addEdge(content[0], content[1]);
	   }
		
	} 	}

