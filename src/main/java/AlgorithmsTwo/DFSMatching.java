package AlgorithmsTwo;

import java.util.*;

public class DFSMatching {
    private int m, n; // m: number of people, n: number of books
    private List<Integer>[] adj;
    private int[] matchTo;
    private boolean[] visited;

    public DFSMatching(int m, int n) {
        this.m = m;
        this.n = n;
        adj = new List[m];
        for (int i = 0; i < m; i++) adj[i] = new ArrayList<>();
        matchTo = new int[n]; // matchTo[book] = person
        Arrays.fill(matchTo, -1);
    }

    public void addEdge(int person, int book) {
        adj[person].add(book);
    }

    private boolean dfs(int person) {
        for (int book : adj[person]) {
            if (visited[book]) continue;
            visited[book] = true;

            //tarkistetaan onko kyseinen kirja vapaa
            if (matchTo[book] == -1 || dfs(matchTo[book])) {
                matchTo[book] = person;
                return true;
            }
        }
        return false;
    }

    public int maxMatching() {
        int result = 0;
        for (int person = 0; person < m; person++) {
            visited = new boolean[n];
            if (dfs(person)) result++;
        }
        return result;
    }

    public void printMatches() {
        for (int book = 0; book < n; book++) {
            if (matchTo[book] != -1) {
                System.out.println("Person " + matchTo[book] + " matched with Book " + book);
            }
        }
    }

    public static void main(String[] args) {
        DFSMatching match = new DFSMatching(4, 4);

        match.addEdge(0, 0);
        match.addEdge(0, 1);
        match.addEdge(1, 0);
        match.addEdge(2, 1);
        match.addEdge(2, 2);
        match.addEdge(3, 3);

        int result = match.maxMatching();
        System.out.println("Maximum matching: " + result);
        match.printMatches();
    }
}
