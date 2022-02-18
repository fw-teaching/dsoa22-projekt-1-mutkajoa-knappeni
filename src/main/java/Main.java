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

	static GraphData graphData = new GraphData();

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Här är alla bibliotek och deras grannar:");
		System.out.println(Route.listNodesAndLinks(graphData));
		System.out.println("Skriv in din start punkt och din destination!");
		System.out.print("Start: ");
		Node startPos = GraphData.createGraph().get(scanner.nextLine());
		System.out.print("Destination: ");
		Node endPos = GraphData.createGraph().get(scanner.nextLine());
		System.out.println(startPos);
		Route.getRoute(startPos, endPos);
		scanner.close();
	}
}
