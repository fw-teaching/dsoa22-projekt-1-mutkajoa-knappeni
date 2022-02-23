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

    public static ArrayList<Node> getRoute(Node startNode, Node endNode) {

        ArrayList<Node> candidates = new ArrayList<>();
        ArrayList<Node> visited = new ArrayList<>();
        Node currentNode = startNode;
        Boolean done = false;

        while (!done) {
            Double minF = 0.0;
            Node nextNode = null;
           
                for (Node neighbour : currentNode.getNeighbours()) {
                    if ((!visited.contains(neighbour)) && (!candidates.contains(neighbour))) {
                        candidates.add(neighbour);
                        neighbour.setPrevious(currentNode);
                    }
                }

           
            for (Node node : candidates) {
                if (node == endNode) {
                    done = true;
                    break;
                } else {
                    Double f = node.getF(node, endNode);

                    if ((minF == 0) || (minF > f)) {
                        minF = f;
                        nextNode = node;
                        if (currentNode.getNeighbours().contains(node)) {
                            node.setPrevious(currentNode);
                        }
                    }
                }
            }
            if (!done) {
                currentNode = nextNode;
                visited.add(currentNode);
                candidates.remove(currentNode);
            }

        }
        ArrayList<Node> routeArrayList = new ArrayList<>();
        currentNode = endNode;
        while (currentNode != startNode) {
            routeArrayList.add(currentNode);
            currentNode = currentNode.getPrevious();
        }
        return routeArrayList;
    }
}
