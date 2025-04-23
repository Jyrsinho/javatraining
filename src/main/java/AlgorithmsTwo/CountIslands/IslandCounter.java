package AlgorithmsTwo.CountIslands;

public class IslandCounter {
    private int[][] grid;
    private boolean[][] visited;
    private int amoutOfIslands;

    public IslandCounter(int[][] grid) {
        this.grid = grid;
        visited = new boolean[grid.length][grid[0].length];
        amoutOfIslands = 0;

    }

    public void countIslands() {
        if (grid.length == 0) {
            return;
        }

        visit(0,0 );

    }

    private void visit(int row, int col) {
        if (visited[row][col]) {
            return;
        }
        if (grid[row][col] == 0) {
            return;
        }
        visited[row][col] = true;
        visit(row+1, col);
        visit(row, col+1);

    }

    public int getAmoutOfIslands() {
        return amoutOfIslands;
    }

}
