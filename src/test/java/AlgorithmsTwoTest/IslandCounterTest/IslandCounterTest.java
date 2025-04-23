package AlgorithmsTwoTest.IslandCounterTest;

import AlgorithmsTwo.CountIslands.IslandCounter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IslandCounterTest {

    IslandCounter islandCounter;

    @BeforeEach
    public void setUp() {
        islandCounter = new IslandCounter();
    }

    @Test
    public void testCountIslandsShouldReturnZeroForEmptyInput() {
        int[][] testInput = new int[][]{};
        int expected = 0;
        int actual =  islandCounter.countIslands(testInput);
        assertEquals(expected, actual);
    }

    @Test
    public void testCountIslandsShouldRetunrOneForWhenThereIsOneOne(){
        int[][] testInput = new int[][]{{1}};
        int expected = 1;
        int actual =  islandCounter.countIslands(testInput);
        assertEquals(expected, actual);
    }

    @Test
    public void testCountIslandsShouldReturnZeroWhenThereIsOnlyZeroes() {
        int[][] testInput = new int[][]{
                                        {0,0},
                                        {0,0}
                                            };
        int expected = 0;
        int actual =  islandCounter.countIslands(testInput);
        assertEquals(expected, actual);
    }

    @Test
    public void testCountIslandsShouldReturnOneWhenThereIsTwoAdjacentOnes() {
        int [][] testInput = new int[][]{
                { 0 , 1 , 1 },
                { 0 , 0 , 0 }
        };
        int expected = 1;
        int actual =  islandCounter.countIslands(testInput);
        assertEquals(expected, actual);
    }
}

