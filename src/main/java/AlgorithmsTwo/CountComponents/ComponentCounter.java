package AlgorithmsTwo.CountComponents;

import java.util.ArrayList;

public class ComponentCounter {

    boolean[] visited;

    public ComponentCounter() {
    }

    public int countComponents(Graph graph) {
        int numberOfComponents = 0;
        visited = new boolean[graph.getSize()];

        if (graph.getSize() == 0) {
            return numberOfComponents;
        }

       int nextUnvisited = findNextUnvisited();
        Vertex current = graph.getVertexById(nextUnvisited);

        while (current!= null) {
            numberOfComponents++;
            dfs(current);
            int nextUnvisitedIndex = findNextUnvisited();
            if (nextUnvisitedIndex == -1) {
                break;
            }
            current= graph.getVertexById(findNextUnvisited());

        }

        return numberOfComponents;
    }

    public void dfs(Vertex current) {
        if (visited[current.getId()]) {
            return;
        }
        visited[current.getId()]= true;

        ArrayList<Vertex> edges = current.getEdges();

        for (Vertex edge : edges) {
            if (!visited[edge.getId()]) {
                dfs(edge);
            }
        }


    }

    public int findNextUnvisited() {
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return i;
            }
        }
        return -1;
    }
}
