package AlgorithmsTwoTest.IslandCounterTest;

import AlgorithmsTwo.CountIslands.IslandCounter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IslandCounterTest {

    IslandCounter islandCounter;

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void testCountIslandsShouldReturnZeroForEmptyInput() {
        int[][] testInput = new int[][]{};
        IslandCounter islandCounter = new IslandCounter(testInput);
        int expected = 0;
        islandCounter.countIslands();
        int actual = islandCounter.getAmoutOfIslands();
        assertEquals(expected, actual);
    }

    @Test
    public void testCountIslandsShouldRetunrOneForWhenThereIsOneOne(){
        int[][] testInput = new int[][]{{1}};
        IslandCounter islandCounter = new IslandCounter(testInput);
        int expected = 1;
        islandCounter.countIslands();
        int actual = islandCounter.getAmoutOfIslands();
        assertEquals(expected, actual);
    }

    @Test
    public void testCountIslandsShouldReturnZeroWhenThereIsOnlyZeroes() {
        int[][] testInput = new int[][]{
                                        {0,0},
                                        {0,0}
                                            };
        IslandCounter islandCounter = new IslandCounter(testInput);
        islandCounter.countIslands();
        int expected = 0;
        islandCounter.countIslands();
        int actual = islandCounter.getAmoutOfIslands();

        assertEquals(expected, actual);
    }

    @Test
    public void testCountIslandsShouldReturnOneWhenThereIsTwoAdjacentOnes() {
        int [][] testInput = new int[][]{
                { 0 , 1 , 1 },
                { 0 , 0 , 0 }
        };
        IslandCounter islandCounter = new IslandCounter(testInput);
        int expected = 1;
        islandCounter.countIslands();
        int actual = islandCounter.getAmoutOfIslands();
        islandCounter.printVisited();
        assertEquals(expected, actual);

    }
}

