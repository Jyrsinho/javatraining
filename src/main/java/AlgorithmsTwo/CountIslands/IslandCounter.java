package AlgorithmsTwo.CountIslands;

public class IslandCounter {
    private int[][] grid;
    private boolean[][] visited;
    private int amoutOfIslands;

    public IslandCounter(int[][] grid) {
        this.grid = grid;
        if (grid.length != 0) {
            visited = new boolean[grid.length][grid[0].length];
        }
        amoutOfIslands = 0;

    }

    public void countIslands() {
        if (grid.length == 0) {
            return;
        }

        while (true) {
            int[] seuraavaSaari = etsiSeuraavaSaari();

            if (seuraavaSaari[0] == -1) {
                break;
            }
            this.amoutOfIslands++;
            visit(seuraavaSaari[0], seuraavaSaari[1]);
        }

    }

    private int[] etsiSeuraavaSaari() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }


    private void visit(int row, int col) {
        if (visited[row][col]) {
            return;
        }
        if (grid[row][col] == 0) {
            return;
        }
        visited[row][col] = true;

        if (isVisitable(row +1, col)){
            visit(row + 1, col);
        }
        if (isVisitable(row - 1, col)) {
            visit(row - 1, col);
        }
        if (isVisitable(row, col + 1)) {
            visit(row, col + 1);
        }
        if (isVisitable(row, col - 1)) {
            visit(row, col - 1);
        }
    }

    /**
     * returns true if given row and column combination in an island is visitable.
     * Index is visitable when it is within the bounds of grid, is not already visited and does not
     * contain value zero
     * @param row
     * @param col
     * @return true if index is visitable, false if not
     */
    private boolean isVisitable(int row, int col) {
       if (row < 0 || col < 0) {
           return false;
       }

       if (row >= grid.length) {
           return false;
       }
       if (col >= grid[0].length) {
           return false;
       }
       if (grid[row][col] == 0) {
           return false;
       }
       if (visited[row][col]) {
           return false;
       }
            return true;
    }


    public int getAmoutOfIslands() {
        return amoutOfIslands;
    }

    public void printVisited() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }
    }

}
