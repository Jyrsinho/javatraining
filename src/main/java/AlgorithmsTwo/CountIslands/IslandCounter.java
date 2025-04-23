package AlgorithmsTwo.CountIslands;

import java.util.Arrays;

public class IslandCounter {
    private int saartenMaara;

    public IslandCounter() {
        this.saartenMaara = 0;
    }

    public int countIslands(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

       int saartenMaara = 0;

       boolean [][] visited = initializeVisitedArray(grid.length,  grid[0].length);

       return saartenMaara;
    }

    private boolean[][] initializeVisitedArray(int a, int b) {
        boolean[][] visited = new boolean[a][b];
        for (int i = 0; i < visited.length; i++) {
            Arrays.fill(visited[i], false);
        }
        return visited;
    }
}
