package GraphTheory.DungeonMasterTest;

import GraphTheory.DungeonMaster.DungeonMaster;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DungeonMasterTest {


    @BeforeEach
    public void setUp() {

    }

    @Test
    public void testDungeonMasterShouldReturnNegativeOneWhenNoPathOutOfMaze() {
        int[][] maze = {
                {2, 1, 1 },
                {0, 0, 0,},
                {1, 1, 3}
        };
        DungeonMaster dungeonMaster = new DungeonMaster(maze);
        boolean reachedEnd = dungeonMaster.solveMazeBFS();
        int expected = -1;
        int actual = dungeonMaster.getAmountOfSteps();
        dungeonMaster.printVisited();
        assertEquals(expected, actual);
        assertFalse(reachedEnd);

    }

    @Test
    public void testDungeonMasterShouldReturnTwoWhenSolvingMazeTakesTwoSteps() {
        int [][] maze = {
                {2, 1, 3}
        };
        DungeonMaster dungeonMaster = new DungeonMaster(maze);
        boolean reachedEnd = dungeonMaster.solveMazeBFS();
        int expected = 2;
        int actual = dungeonMaster.getAmountOfSteps();
        dungeonMaster.printVisited();
        assertTrue(reachedEnd);
        assertEquals(expected, actual);
    }

    @Test
    public void testDungeonMasterShouldSolve3x3Grid() {
        int [][] maze = {
                {2, 1, 1},
                {0, 1, 0},
                {3, 1, 1}
        };
        DungeonMaster dungeonMaster = new DungeonMaster(maze);
        boolean reachedEnd = dungeonMaster.solveMazeBFS();
        int expected = 4;
        int actual = dungeonMaster.getAmountOfSteps();
        assertTrue(reachedEnd);
        assertEquals(expected, actual);
    }

    @Test
    public void testDungeonMasterShoudGiveShortestPath() {
        int [][] maze = {
                {2, 1, 3},
        };
        DungeonMaster dungeonMaster = new DungeonMaster(maze);
        boolean reachedEnd = dungeonMaster.solveMazeBFS();
        String expected = "[[0, 0], [0, 1], [0, 2]]";
        String actual = dungeonMaster.getShortestPath();
        dungeonMaster.printVisited();
        dungeonMaster.printPrevious();
        assertEquals(expected, actual);
    }

    @Test
    public void testDungeonMasterShouldGiveShortestPathOn5x5Grid() {
        int[][] maze = {
                { 0, 1, 1, 1, 0},
                { 2, 1, 0, 1, 0},
                { 1, 0 ,0, 1, 1},
                { 1, 0, 3, 0, 1},
                { 1, 0, 1, 1, 1}
        };
        DungeonMaster dungeonMaster = new DungeonMaster(maze);
        boolean reachedEnd = dungeonMaster.solveMazeBFS();
        String expected = "[[1, 0], [1, 1], [0, 1], [0, 2], [0, 3], [1, 3], [2, 3], [2, 4], [3, 4], [4, 4], [4, 3], [4, 2], [3, 2]]";
        String actual = dungeonMaster.getShortestPath();
        dungeonMaster.printVisited();
        dungeonMaster.printPrevious();
        assertEquals(expected, actual);
    }
}
