package AlgorithmsTwo.CountComponents;

import java.util.ArrayList;

public class Vertex {
    // lista komponentin kaarista
    int id;
    ArrayList<Vertex> edges;

    public Vertex(int id) {
        this.edges = new ArrayList<Vertex>();
        this.id = id;
    }

    public void addAnEdge (Vertex vertex) {
        edges.add(vertex);
    }


}
