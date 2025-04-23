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
                if (grid[i][j] == 1 && visited[i][j] == false) {
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
        visit(row + 1, col);
        visit(row - 1, col);
        visit(row, col - 1);
        visit(row, col + 1);

    }

    public int getAmoutOfIslands() {
        return amoutOfIslands;
    }

}
