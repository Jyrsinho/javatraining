package AlgorithmsTwo.GraafiAlgoritmeja;

import java.util.*;

import static AlgorithmsTwo.GraafiAlgoritmeja.Util.constructAdjacencyList;

public class Dijkstra {
   private int[] distances;
   private int[] previous;

    /**
     * Annetaan graafi kaksiulotteisena taulukkona. Kukin sisempi taulukko sisältää tiedon, mistä solmusta mennään
     * mihinkin solmuun ja mikä kyseisen kaaren paino on.
     * @param src the vertex where we start from
     * @param V amount of vertices
     * @param edges array of edges
     */
    public int[] dijkstra(int src, int V, int[][] edges) {
        /*
        Input: src = 0, V = 5, edges[][] = [[0, 1, 4], [0, 2, 8], [1, 4, 6], [2, 3, 2], [3, 4, 10]]
         */
        // Create adjacency list
        ArrayList<ArrayList<ArrayList<Integer>>> adjacencyList = constructAdjacencyList(edges, V);

        // PriorityQueue to store vertices to be processed
        // Each element is a pair: [distance, node]
        PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.get(0)));

        // Create distance array and initialize it to infinity
        distances = new int[V];
        previous = new int[V];
        Arrays.fill(distances, Integer.MAX_VALUE);

        // Insert source with distance 0
        distances[src] = 0;
        ArrayList<Integer> start = new ArrayList<>();

        start.add(0);
        start.add(src);
        pq.offer(start);

        while (!pq.isEmpty()) {

            // Get the node with the minimum distance
            ArrayList<Integer> current = pq.poll();
            int cDistance = current.get(0);
            int u = current.get(1);

            // Traverse all adjacent vertices of the current node
            for (ArrayList<Integer> neighbor : adjacencyList.get(u)) {
                int v = neighbor.get(0);
                int weight = neighbor.get(1);

                //if there is a shorter path to v hrough u
                if (distances[v] > cDistance + weight) {
                    // Update distance of v
                    distances[v] = cDistance + weight;
                    previous[v] = u;

                    // Add updated pair to the priorityQueue
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(distances[v]);
                    temp.add(v);
                    pq.offer(temp);
                }
            }
        }
        return distances;
    }

    public Stack<Integer> shortestPath(int src, int dest) {
       Stack<Integer> shortestPath = new Stack<>();

       int node = dest;

       while (node != src) {
          shortestPath.push(node);
          node = previous[node];
       }
       shortestPath.push(src);

       return shortestPath;
    }

    public int[] getPrevious() {
        return previous;
    }


    public static void main(String[] args) {
        Dijkstra dijkstra = new Dijkstra();
        // Driver program to test methods of graph class
        int V = 5;
        int src = 0;

        // Edge list format: {u, v, weight}
        int[][] edges = {
                {0, 1, 4}, {0, 2, 8}, {1, 4, 6},
                {2, 3, 2}, {3, 4, 10}
        };

        // Get shortest path distances
        int[] result = dijkstra.dijkstra(src, V, edges);

        // Print shortest distances in one line
        for (int d : result)
            System.out.print(d + " ");

        System.out.println();
        // Get shortest path from a to b
        Stack<Integer> shortestPath = dijkstra.shortestPath(0,3);
        Stack<Integer> shortestPath2 = dijkstra.shortestPath(0,4);

       while (!shortestPath.isEmpty()) {
           Integer node = shortestPath.pop();
           System.out.print(node +" ");
       }
        System.out.println();
       while (!shortestPath2.isEmpty()) {
           Integer node = shortestPath2.pop();
           System.out.print(node + " ");
       }

    }

}

