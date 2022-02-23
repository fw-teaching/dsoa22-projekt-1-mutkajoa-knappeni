import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * Projekt 1 - ruttsökning med A*
 *
 * Datastrukturer och algoritmer
 *
 * Programmeringsteam:
 * mutkajoa
 * knappeni
 */
public class Main {

	

	public static void main(String[] args) {
		LinkedHashMap<String, Node> graphData = GraphData.createGraph();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Här är alla bibliotek och deras grannar:");
		//System.out.println(Route.listNodesAndLinks(graphData));
		System.out.println("Skriv in din start punkt och din destination!");
		System.out.print("Start: ");
		Node startPos = graphData.get(scanner.nextLine());
		System.out.print("Destination: ");
		Node endPos = graphData.get(scanner.nextLine());
		System.out.println(startPos);
		ArrayList<Node> shortroute = new ArrayList<Node>( Route.getRoute(startPos, endPos));
		for (Node node : shortroute) {
			System.out.println(node.getKey());
		}
		scanner.close();
		System.out.println("code runned");
		
	}
}
