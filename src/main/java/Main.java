import java.util.ArrayList;
import java.util.Collections;
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
		String showGraph = Route.listNodesAndLinks(graphData);
		Scanner scanner = new Scanner(System.in);
		boolean firstTry = true;

		mainLoop: while (true) {
			System.out.println("Välj 1 om du vill se alla bibliotek och deras grannar.");
			System.out.println("Välj 2 om du vill se kortaste rutten mellan två bibliotek.");
			System.out.println("Välj 3 om du vill avsluta programmet.");
			String mainChoice = scanner.nextLine();
			if (mainChoice.equals("1")) {
				System.out.println("Här är alla bibliotek och deras grannar:");
				System.out.println(showGraph);
			} else if (mainChoice.equals("2")) {
				routeLoop: while (true) {
					// Olik text om det är första gången man kollar kortaste rutten
					if (firstTry == true) {
						System.out.println(
								"Tryck på \"enter\" för att gå vidare, \"s\" för att visa alla bibliotek och deras grannar eller \"q\" för att hoppa tillbaka till huvudmenyn.");
						firstTry = false;
						// Om man matar in fel key så kommer det "försök pånytt"
					} else {
						System.out.println(
								"Tryck på \"enter\" för att försöka på nytt, \"s\" för att visa alla bibliotek och deras grannar eller \"q\" för att hoppa tillbaka till huvudmenyn.");
					}
					String routeChoice = scanner.nextLine();
					if (routeChoice.equals("q")) {
						firstTry = true;
						break routeLoop;
					} else if (routeChoice.equals("s")) {
						System.out.println("Här är alla bibliotek och deras grannar:");
						System.out.println(showGraph);
						firstTry = true;
					} else {
						System.out.println("Skriv in din startpunkt och din destination!");
						System.out
								.println(
										"Använd förkortningen under \"key\" när du matar in startpunkt och destination!");
						System.out.print("Startpunkt: ");
						Node startPos = graphData.get(scanner.nextLine().toLowerCase());
						if (startPos != null) {
							System.out.print("Destination: ");
							Node endPos = graphData.get(scanner.nextLine().toLowerCase());
							if (endPos != null) {
								ArrayList<Node> shortroute = new ArrayList<Node>(Route.getRoute(startPos, endPos));
								shortroute.add(startPos);
								Collections.reverse(shortroute);
								System.out.println("Kortaste rutten:");
								for (Node node : shortroute) {
									System.out.println(
											String.format("%s. [%s] %s", (shortroute.lastIndexOf(node) + 1),
													node.getKey(),
													node.getName()));
								}
								firstTry = true;
								break routeLoop;
							} else {
								System.out.println("Destinationen finns inte i listan!");
							}
						} else {
							System.out.println("Startpunkten finns inte i listan!");
						}
					}
				}
			} else if (mainChoice.equals("3")) {
				System.out.println("Tack och adjö!");
				break mainLoop;
			}
		}
		scanner.close();
	}
}
