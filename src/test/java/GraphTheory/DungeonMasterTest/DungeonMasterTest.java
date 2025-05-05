package GraphTheory.DungeonMasterTest;

import GraphTheory.DungeonMaster.DungeonMaster;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        dungeonMaster.solveMazeBFS();
        int expected = -1;
        int actual = dungeonMaster.getAmountOfSteps();
        dungeonMaster.printVisited();
        assertEquals(expected, actual);

    }

    @Test
    public void testDungeonMasterShouldReturnTwoWhenSolvingMazeTakesTwoSteps() {
        int [][] maze = {
                {2, 1, 3}
        };
        DungeonMaster dungeonMaster = new DungeonMaster(maze);
        dungeonMaster.solveMazeBFS();
        int expected = 2;
        int actual = dungeonMaster.getAmountOfSteps();
        dungeonMaster.printVisited();
        assertEquals(expected, actual);
    }
}
