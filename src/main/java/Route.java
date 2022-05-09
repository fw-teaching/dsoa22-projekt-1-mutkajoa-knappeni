import java.util.ArrayList;
import java.util.LinkedHashMap;

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

    public static String listNodesAndLinks(LinkedHashMap<String, Node> graphData) {
        // Loopar alla värden i vår lista och lägger dem i en array som vi returnerar
        graphData.entrySet().forEach(Entry -> {
            ArrayList<String> neighboursArray = new ArrayList<>();
            String key = Entry.getKey();
            String name = graphData.get(key).getName();
            graphData.get(key).getNeighbours().forEach(Key -> {
                neighboursArray.add(Key.getName());
            });
            // För att formatera listNodesAndLinks till liknande som Fredrik :>
            bigString = bigString.concat("[" + key + "] " + name + "-> " + neighboursArray.toString() + "\n");
        });
        return bigString;
    }
    //A* implementering enligt angiven pseudokod
    public static ArrayList<Node> getRoute(Node startNode, Node endNode) {
        //candidates En tom lista som senare fylls med alla hittade noder
        ArrayList<Node> candidates = new ArrayList<>();
        //visited En tom lista som senare fylls med alla de noder som besökts (testats)
        ArrayList<Node> visited = new ArrayList<>();
        //currentNode En Node-variabel. Sätt den att vara samma som startNode
        Node currentNode = startNode;
        //done Är false så länge som rutten ännu beräknas. Initialiseras till false
        Boolean done = false;

        while (!done) {
            double minF = 0;
            Node nextNode = null;
            //Loopa (alla grannar till currentNode)
            for (Node neighbour : currentNode.getNeighbours()) {
                //OM (grannen inte finns i visited-listan OCH grannen inte finns i candidates-listan) 
                if ((!visited.contains(neighbour)) && (!candidates.contains(neighbour))) {
                    //Sätt in varje granne i candidates-listan
                    candidates.add(neighbour);
                    //Sätt previous (en instansvariabel i klassen Node) för grannen att vara samma som current
                    neighbour.setPrevious(currentNode);
                }
            }
            //Loopa (alla noder(candidate) i candidates-listan)
            for (Node candidate : candidates) {
                //OM candidaten är destination
                if (candidate == endNode) {
                    done = true;
                    break;
                } else {
                    //Beräkna F för innevarande kandidat
                    double f = candidate.getF(startNode, endNode);
                   
                    if ((minF == 0.0) || (minF > f)) {
                        minF = f;
                        nextNode = candidate;
                        //OM (kandiaten är en direkt granne till current)
                        if (currentNode.getNeighbours().contains(candidate)) {
                            //Uppdatera kandidatens previous att vara samma som current
                            candidate.setPrevious(currentNode);
                        }
                    }
                }
            }
            if (!done) {
                //Sätt currentNode att vara samma som next
                currentNode = nextNode;
                //Tillsätt currentNode till visited-listan
                visited.add(currentNode);
                //Ta bort currentNode från candidates-listan
                candidates.remove(currentNode);
            }

        }
        ArrayList<Node> routeArrayList = new ArrayList<>();
        currentNode = endNode;
        //Skapa rutten som returneras
        while (currentNode != startNode) {
            //Tillsätt currentNode först i route-listan
            routeArrayList.add(currentNode);
            //Sätt currentNode till currentNodes föregående nod
            currentNode = currentNode.getPrevious();
        }
        return routeArrayList;
    }
}
