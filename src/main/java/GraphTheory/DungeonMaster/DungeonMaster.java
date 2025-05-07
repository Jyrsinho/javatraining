package GraphTheory.DungeonMaster;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Finds a shortest path out of two dimensional grid maze.
 * Starting position is marked as number two. End position is marked
 * as 3. Ones are traversable, zeros are not.
 */
public class DungeonMaster {

    private int[][] maze;
    private int[][][] previous;

    private boolean[][] visited;

    private Queue<Integer> rowQueue;
    private Queue<Integer> colQueue;

                            //N   S  E   W
    private final int[] DR = {1, -1,  0, 0};
    private final int[] DC = {0,  0, -1, 1};

    private final int numberOfRows;
    private final int numberOfColumns;

    private int startingRow;
    private int startingCol;

    private boolean reachedEnd;

    private int amountOfSteps;
    private int nodesLeftInLayer;
    private int nodesInNextLayer;

    public DungeonMaster(int [][] maze) {
        this.maze = maze;
        this.numberOfRows = maze.length;
        this.numberOfColumns = maze[0].length;
        this.visited = new boolean[maze.length][maze[0].length];
        this.reachedEnd = false;

        this.rowQueue = new LinkedList<Integer>();
        this.colQueue = new LinkedList<Integer>();

        this.previous = new int[numberOfRows][numberOfColumns][2];
    }


    public boolean solveMazeBFS() {
        int [] startingPosition = findStartingPosition(maze);
        startingRow = startingPosition[0];
        startingCol = startingPosition[1];
        visited[startingRow][startingCol] = true;
        previous[startingRow][startingCol][0] = -1;
        previous[startingRow][startingCol][1] = -1;

        rowQueue.add(startingRow);
        colQueue.add(startingCol);
        nodesLeftInLayer = 1;

        while (!rowQueue.isEmpty() ) {
            int r = rowQueue.poll();
            int c = colQueue.poll();

            if (maze[r][c] == 3) {
               reachedEnd = true;
               return reachedEnd;
            }

            visitNeighbours(r, c);
            nodesLeftInLayer --;

            // End of current BFS layer
            if (nodesLeftInLayer == 0) {
                nodesLeftInLayer = nodesInNextLayer;
                nodesInNextLayer = 0;
                amountOfSteps++;
            }
        }
        return reachedEnd;
    }


    private void visitNeighbours(int r, int c) {
        for (int i = 0; i< 4; i++) {
            int rr = r + DR[i];
            int cc = c + DC[i];

            // tarkistetaan ettei vierailla gridin ulkopuolisissa soluissa eika soluissa joissa on 0
            if (rr < 0  || cc < 0) {
                continue;
            }
            if (rr >= numberOfRows || cc >= numberOfColumns) {
                continue;
            }

            if (maze[rr][cc] == 0) {
                continue;
            }
            if (visited[rr][cc]) {
                continue;
            }

            visited[rr][cc] = true;
            previous[rr][cc] = new int[] {r, c};
            rowQueue.add(rr);
            colQueue.add(cc);
            nodesInNextLayer++;
        }

    }



    private int[] findStartingPosition(int[][] maze) {
        int[] startingPosition = new int[2];
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (maze[i][j] == 2) {
                    startingPosition[0] = i;
                    startingPosition[1] = j;
                }
            }
        }
        return startingPosition;
    }

    private int[] findEnd() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (maze[i][j] == 3) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }


   public String getShortestPath() {
        int[][] endToStart = new int[amountOfSteps + 1][2];
        int[] end = findEnd();
        if (end == null) {
            return  "";
        }

        // adding the end node to the path

        int currentRow = end[0];
        int currentCol = end[1];

        endToStart[0][0] = currentRow;
        endToStart[0][1] = currentCol;

        int index = 0;

        while (currentRow != -1) {
            int nextRow = previous[currentRow][currentCol][0];
            int nextCol = previous[currentRow][currentCol][1];

           endToStart[index][0] = currentRow;
           endToStart[index][1] = currentCol;

            currentRow = nextRow;
            currentCol = nextCol;
            index++;

        }



        endToStart = reversePath(endToStart);


        return Arrays.deepToString(endToStart);

   }

   private int[][] reversePath(int[][] endToStart) {
        int[][] startToEnd = new int[endToStart.length][endToStart[0].length];

       for (int i = 0,  j = endToStart.length -1 ; i < endToStart.length; i++, j--) {
           startToEnd[i] = endToStart[j];
       }

       return startToEnd;

   }

   public void printVisited() {
       PrintStream out = System.out;
       out.println("Visited: ");
        for (int i = 0; i < visited.length; i++) {
           for (int j = 0; j < visited[0].length; j++) {
               out.print(visited[i][j] + " ");
           }
            System.out.println();
       }
   }

   public void printPrevious() {
        PrintStream out = System.out;
        out.println("Previous: ");
        for (int i = 0; i < previous.length; i++) {
            for (int j = 0; j < previous[0].length; j++) {
                out.print("[" + previous[i][j][0] + "," + previous[i][j][1] + "]");
            }
            System.out.println();
        }
   }

   public int getAmountOfSteps() {
       if (reachedEnd) {
           return amountOfSteps;
       } else {
           return -1;
       }
   }
}
