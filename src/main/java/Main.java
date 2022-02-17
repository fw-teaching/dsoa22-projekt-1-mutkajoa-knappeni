import java.util.ArrayList;

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

		System.out.println("key    Name                         Neighbours");
		GraphData.createGraph().entrySet().forEach(Entry -> {
			ArrayList<String> neighboursArray = new ArrayList<>();
			String key = Entry.getKey();
			String name = GraphData.createGraph().get(key).getName();
			GraphData.createGraph().get(key).getNeighbours().forEach(Key -> {
				neighboursArray.add(Key.getName());
			});
			System.out.println(String.format("[%s] %s -> %s", key, name, neighboursArray));
		});
	}
}
