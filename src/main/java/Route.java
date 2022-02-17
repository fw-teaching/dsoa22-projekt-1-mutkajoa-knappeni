import java.util.ArrayList;

public class Route {
    static String bigString = "key  Name                      Neighbours\n";

    public static String listNodesAndLinks(GraphData graphData) {
        GraphData.createGraph().entrySet().forEach(Entry -> {
            ArrayList<String> neighboursArray = new ArrayList<>();
            String key = Entry.getKey();
            String name = GraphData.createGraph().get(key).getName();
            GraphData.createGraph().get(key).getNeighbours().forEach(Key -> {
                neighboursArray.add(Key.getName());
            });
            bigString = bigString.concat(key + " " + name + " " + neighboursArray.toString() + "\n");
        });
        return bigString;
    }
}
