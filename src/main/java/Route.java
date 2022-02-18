import java.util.ArrayList;

public class Route {
    public Node startNode;
    public Node endNode;
    static String bigString = "key    Name                        Neighbours\n";

    public Route(Node startnNode, Node endNode) {
        setStartNode(startNode);
        setEndNode(endNode);
    }

    public void setStartNode(Node startNode) {
        this.startNode = startNode;
    }

    public void setEndNode(Node endNode) {
        this.endNode = endNode;
    }

    public Node getEndNode() {
        return endNode;
    }

    public Node getStartNode() {
        return startNode;
    }

    public static String listNodesAndLinks(GraphData graphData) {
        GraphData.createGraph().entrySet().forEach(Entry -> {
            ArrayList<String> neighboursArray = new ArrayList<>();
            String key = Entry.getKey();
            String name = GraphData.createGraph().get(key).getName();
            GraphData.createGraph().get(key).getNeighbours().forEach(Key -> {
                neighboursArray.add(Key.getName());
            });
            bigString = bigString.concat("[" + key + "] " + name + "-> " + neighboursArray.toString() + "\n");
        });
        return bigString;
    }

    public static Node getRoute(Node startNode, Node endNode) {
        ArrayList<String> candidates = new ArrayList<>();
        ArrayList<String> visited = new ArrayList<>();
        Node currentNode = startNode;
        Boolean done = false;

        while (done == false) {
            int minF = 0;
            String nextNode = null;
        }
        return;
    }
}
