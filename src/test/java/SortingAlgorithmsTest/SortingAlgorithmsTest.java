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
        int[] testArray = sortingAlgorithms.createRandomIntegerArray(size, 0, 100);
        assertEquals(20, testArray.length);

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

    @Test
    public void testBubbleSortReturnAlreadySortedArrayUnchanged() {
        int[] testAlgorithm = {1,2,3,4,5};
        int []expected = {1,2,3,4,5};
        int[] result = sortingAlgorithms.bubbleSort(testAlgorithm, true);
        assertArrayEquals(expected, result);
    }


    @Test
    public void testInsertionSortShouldReturnAnIntegerArray() {
        int[] testAlgorithm = {0};
        int []expected = {0};
        int[] result = sortingAlgorithms.insertionSort(testAlgorithm, true);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testInsertionSortShouldSortArrayOfTwoIntegers() {
        int[] testAlgorithm = {2,1};
        int []expected = {1,2};
        int[] result = sortingAlgorithms.insertionSort(testAlgorithm, true);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testInsertionSortShouldSortArrayOfFiveIntegers() {
        int[] testAlgorithm = {1, 3,5,2,4};
        int []expected = {1,2,3,4,5};
        int[] result = sortingAlgorithms.insertionSort(testAlgorithm, true);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testInsertionSortShouldConvertDescendingArrayToAscending() {
        int[] testAlgorithm = {5,4,3,2,1};
        int []expected = {1,2,3,4,5};
        int[] result = sortingAlgorithms.insertionSort(testAlgorithm, true);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testInsertionSortShouldSortArrayWithDuplicates() {
        int[] testAlgorithm = {3,3,2,2,1};
        int []expected = {1,2,2,3,3};
        int[] result = sortingAlgorithms.insertionSort(testAlgorithm, true);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testInsertionSortShouldSortArrayOfFiveIntegersToDescendingOrder() {
        int[] testAlgorithm = {2,1,3,4,5};
        int []expected = {5,4,3,2,1};
        int[] result = sortingAlgorithms.insertionSort(testAlgorithm, false);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testInsertionSortShouldReturnAlreadySortedArrayUnchanged() {
        int[] testAlgorithm = {5,4,3,2,1};
        int []expected = {5,4,3,2,1};
        int[] result = sortingAlgorithms.insertionSort(testAlgorithm, false);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSelectionSortShouldReturnAnIntegerArray() {
        int[] testAlgorithm = {0};
        int []expected = {0};
        int[] result = sortingAlgorithms.selectionSort(testAlgorithm, true);
        assertArrayEquals(expected, result);

    }

    @Test
    public void testSelectionSortShouldSortArrayOfTwoIntegers() {
        int[] testAlgorithm = {2,1};
        int []expected = {1,2};
        int []result = sortingAlgorithms.selectionSort(testAlgorithm,true);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSelectionSortShouldSortArrayOfFiveIntegersToAscendingOrder() {
        int[] testAlgorithm = {2,1,3,4,5};
        int []expected = {1,2,3,4,5};
        int[] result = sortingAlgorithms.selectionSort(testAlgorithm, true);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSelectionSortShouldSortArrayOfFiveIntegersToDescendingOrder() {
        int[] testAlgorithm = {2,1,3,4,5};
        int []expected = {5,4,3,2,1};
        int[] result = sortingAlgorithms.selectionSort(testAlgorithm, false);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSelectionSortShouldReturnAlreadySortedArrayUnchanged() {
        int[] testAlgorithm = {5,4,3,2,1};
        int []expected = {5,4,3,2,1};
        int[] result = sortingAlgorithms.selectionSort(testAlgorithm, false);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testMergeSortShouldReturnAnIntegerArray() {
        int[] testArray = {0};
        int []expected = {0};
        int[] result = sortingAlgorithms.mergeSort(testArray, true);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testMergeShouldCombineTwoArraysOfOneElementIntoSortedArray() {
        int[] testArray1 = {0};
        int[] testArray2 = {1};
        int []expected = {0,1};
        int[] result = sortingAlgorithms.merge(testArray1, testArray2, true);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testMergeShouldSortTwoArraysOfThreeElementsIntoSortedArray() {
        int[] testArray1 = {0,2,4};
        int[] testArray2 = {1,3,5};
        int []expected = {0,1,2,3,4,5};
        int[] result = sortingAlgorithms.merge(testArray1, testArray2, true);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testMergeShouldSortArrayOfThreeElementsAndAnArrayOfTwoElementsIntoSortedArray() {
        int[] testArray1 = {0,2,3};
        int[] testArray2 = {1,4};
        int []expected = {0,1,2,3,4};
        int[] result = sortingAlgorithms.merge(testArray1, testArray2, true);
        assertArrayEquals(expected, result);
    }

    @Test
    public void mergeShouldMergeTwoArraysOfFiveWhereFirstContainsSmallerElementsThanSecondArray() {
        int[] testArray1 = {0,1,2,3,4};
        int[] testArray2 = {5,6,7,8,9};
        int []expected = {0,1,2,3,4,5,6,7,8,9};
        int[] result = sortingAlgorithms.merge(testArray1, testArray2, true);
        assertArrayEquals(expected, result);
    }

    @Test
    public void mergeSortShouldSortArrayOfTwoIntegersIntoAscendingOrder() {
        int[] testArray1 = {2,1};
        int [] expected = {1,2};
        int[] result = sortingAlgorithms.mergeSort(testArray1,true);
        assertArrayEquals(expected, result);
    }

    @Test
    public void mergeSortShouldSortArrayOfFiveIntegersToAscendingOrder() {
        int[] testArray1 = {2,1,3,4,5};
        int[] expected = {1,2,3,4,5};
        int[] result = sortingAlgorithms.mergeSort(testArray1, true);
        assertArrayEquals(expected, result);

    }

    @Test
    public void mergeSortShouldReturnSortedAlgorithmUnchanged() {
        int[] testArray1 = {0,1,2,3,4,5};
        int []expected = {0,1,2,3,4,5};
        int[] result = sortingAlgorithms.mergeSort(testArray1, true);
        assertArrayEquals(expected, result);
    }

    @Test
    public void mergeSortShouldSortArrayOfFiveIntegersToDescendingOrder() {
        int[] testArray1 = {3,2,5,1,4};
        int[] expected = {5,4,3,2,1};
        int[] result = sortingAlgorithms.mergeSort(testArray1, false);
        assertArrayEquals(expected, result);

    }




}
