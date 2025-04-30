package AlgorithmsTwo.CountComponents;

import java.util.ArrayList;

public class Graph {
    private ArrayList<Vertex> vertices;

    public Graph() {
        vertices = new ArrayList<>();
    }


    /**
     * Creates an edge to the graph.
     * If given Vertices dont exist those are also created.
     * @param fromVertexValue vertex where the edge goes grom
     * @param toVertexValue vertex where the edge goes to
     */
    public void addEdge(int fromVertexValue, int toVertexValue) {
        Vertex fromVertex = getVertexByValue(fromVertexValue);
        if (fromVertex == null) {
            fromVertex = new Vertex(vertices.size(), fromVertexValue);
            vertices.add(fromVertex);
        }

        Vertex toVertex = getVertexByValue(toVertexValue);
        if (toVertex == null) {
            toVertex = new Vertex(vertices.size(), toVertexValue);
            vertices.add(toVertex);
        }
        fromVertex.addEdge(toVertex);

    }

    public Vertex getVertexByValue(int vertexValue) {
        for (Vertex v : vertices) {
            if (v.getValue() == vertexValue) {
                return v;
            }
        }
        return null;
    }

    public Vertex getVertexById(int vertexId) {
        if (vertexId > vertices.size()) {
            return null;
        }
        return vertices.get(vertexId);
    }


    public ArrayList<Vertex> getVertices() {
        return vertices;
    }


    /**
     * return the amount of vertices
     * @return the amount of vertices
     */
    public int getSize() {
       return vertices.size();
    }

    public void printGraph() {
        int index = 0;
        for (Vertex v : vertices) {
            System.out.printf("Graafin indeksissä %d on %d%n", index, v.getValue());
            ArrayList<Vertex> edges = v.getEdges();
            StringBuilder sb = new StringBuilder();
            if (edges.isEmpty()) {
                System.out.println("Solulla ei ole lapsia");
            }else {
                for (int i = 0; i < edges.size(); i++) {
                    sb.append(vertices.get(i).getValue());
                    sb.append(" ");
                }
                System.out.printf("Sen lapset ovat: %s", sb);
            }
            System.out.println();
            index++;
        }
    }
}
