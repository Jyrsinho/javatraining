package AlgorithmsTwo.CountComponents;

import java.util.ArrayList;

public class Vertex {
    int id;
    int value;

    // lista komponentin kaarista kokonaislukuina, jotka vastaavat kohdeSolmujen iideitä
    ArrayList<Vertex> edges;

    public Vertex(int id, int value) {
        this.edges = new ArrayList<>();
        this.id = id;
        this.value = value;
    }

    public void addEdge (Vertex toVertex) {
        edges.add(toVertex);
    }

    public int getId() {
        return id;
    }

    public int getValue() {
        return value;
    }

    public ArrayList<Vertex> getEdges() {
        return edges;
    }

}
