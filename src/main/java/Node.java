import java.util.ArrayList;

public class Node {

    String name;
    String key;
    double latitude;
    double longitude;
    ArrayList<Node> neighbours = new ArrayList<>();

    public Node(String name, double latitude, double longitude) {
        setName(name);
        setLatitude(latitude);
        setLongitude(longitude);
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
        // this.neighbours =neighbours;
    }

    public ArrayList<Node> getNeighbours() {
        return neighbours;
    }

}