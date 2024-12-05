package SortingAlgorithmsTest;

import SortingAlgorithms.SortingAlgorithms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortingAlgorithmsTest {

    SortingAlgorithms sortingAlgorithms;

    @BeforeEach
    public void setup() {
        sortingAlgorithms = new SortingAlgorithms();
    }

    @Test
    public void testCreateRandomIntArrayShouldCreateArrayWithGivenSize() {
        int size = 20;
        int[] testAlgorithm = sortingAlgorithms.createRandomIntegerArray(size, 0, 100);
        assertEquals(20, testAlgorithm.length);

    }

    @Test
    public void testBubbleSortShouldReturnAnIntegerArray() {
        int[] testAlgorithm = {0};
        int []expected = {0};
        int[] result = sortingAlgorithms.bubbleSort(testAlgorithm, true);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testBubbleSortShouldSortArrayOfTwoIntegers() {
        int[] testAlgorithm = {2,1};
        int []expected = {1,2};
        int[] result = sortingAlgorithms.bubbleSort(testAlgorithm, true);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testBubbleSortShouldSortArrayOfThreeIntegers() {
        int[] testAlgorithm = {4, 3, 2,};
        int []expected = {2,3,4};
        int[] result = sortingAlgorithms.bubbleSort(testAlgorithm, true);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testBubbleSortShouldSortArrayOfFiveIntegersWithDuplicates() {
        int[] testAlgorithm = {2, 3, 3, 2, 1};
        int []expected = {1,2,2,3,3};
        int[] result = sortingAlgorithms.bubbleSort(testAlgorithm, true);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testBubbleSortShouldSortArrayOfFiveIntegersToDescendingOrder() {
        int[] testAlgorithm = {2,1,4,5,3};
        int []expected = {5,4,3,2,1};
        int[] result = sortingAlgorithms.bubbleSort(testAlgorithm, false);
        assertArrayEquals(expected, result);
    }

    /*
    @Test
    public void testInsertionSortShouldReturnAnIntegerArray() {
        int[] testAlgorithm = {0};
        int []expected = {0};
        int[] result = sortingAlgorithms.InsertionSort(testAlgorithm);
        assertArrayEquals(expected, result);
    }

     */


}
