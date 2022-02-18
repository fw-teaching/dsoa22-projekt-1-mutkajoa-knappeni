import java.util.ArrayList;

public class Node extends GraphData {

    public String name;
    public String key;
    public double hValue;
    public double latitude;
    public double longitude;
    public Node previous;
    public ArrayList<Node> neighbours = new ArrayList<>();

    public Node(String name, double latitude, double longitude) {
        setName(name);
        setLatitude(latitude);
        setLongitude(longitude);
    }

    public double calculateH(Node endNode) {
        Node currentNode = this;
        hValue = Utils.getDistance(currentNode.getLatitude(), currentNode.getLongitude(), endNode.getLatitude(), endNode.getLongitude());
        return hValue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void addNeighbour(Node node) {
        neighbours.add(node);
    }

    public ArrayList<Node> getNeighbours() {
        return neighbours;
    }
    public void setPrevious(Node previous) {
        this.previous = previous;
    }
    public Node getPrevious() {
        return previous;
    }
    public double calculateG(Node startNode){
        double g = 0;
        Node currentNode = this;
        
        while(currentNode != startNode){
            //beräkna avståndet till föregående nod
            //addera avståndet till G
            g += currentNode.calculateH(currentNode.getPrevious());          
            //sätt current att vara samma som current.previous
            currentNode = currentNode.getPrevious();
        }
        return g;
    }
    public double getF(Node startNode, Node endNode){
        return calculateG(startNode) + calculateH(endNode); 
    }

}