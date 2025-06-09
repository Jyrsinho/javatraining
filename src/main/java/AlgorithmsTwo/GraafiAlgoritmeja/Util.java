package AlgorithmsTwo.GraafiAlgoritmeja;

import java.util.ArrayList;

public class Util {

    public static ArrayList<ArrayList<ArrayList<Integer>>> constructAdjacencyList(int[][]edges, int V) {
        ArrayList<ArrayList<ArrayList<Integer>>> adjacencyList = new ArrayList<>();

        //Initialize the adjacency list
        for (int i = 0; i < V; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // Fill the adjacency list from edges
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            // Add edge from u to v
            ArrayList<Integer> e1 = new ArrayList<>();
            e1.add(v);
            e1.add(wt);
            adjacencyList.get(u).add(e1);

            // Since the graph is undirected, add edge from v to u
            ArrayList<Integer> e2 = new ArrayList<>();
            e2.add(u);
            e2.add(wt);
            adjacencyList.get(v).add(e2);
        }

        return adjacencyList;

    }
}
