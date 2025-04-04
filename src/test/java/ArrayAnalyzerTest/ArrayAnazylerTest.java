package ArrayAnalyzerTest;

import ArrayAnalyzer.ArrayAnalyzer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayAnazylerTest {

    ArrayAnalyzer arrayAnalyzer;

    @BeforeEach
    public void setUp() {
        arrayAnalyzer = new ArrayAnalyzer();
    }


    @Test
    public void testHistogramShouldHaveLengthOfTen() {
        int[] array = {1,2,3,4,5,6,7,8,9};
        ArrayAnalyzer arrayAnalyzer = new ArrayAnalyzer(array);

        int [] histogram = arrayAnalyzer.createHistogram();
        assertEquals(10, histogram.length);
    }

    @Test
    public void testHistogramShouldHaveTwoInIndexFive() {
        int[] array = {5,5};
        ArrayAnalyzer arrayAnalyzer = new ArrayAnalyzer(array);

        int [] histogram = arrayAnalyzer.createHistogram();

        assertEquals(2,histogram[5]);

    }

    @Test
    public void testHistogramShouldHaveTwoInIndexZeroAndTwoInIndexNine() {
        int[] array = {0,0,9,9};
        ArrayAnalyzer arrayAnalyzer = new ArrayAnalyzer(array);

        int [] histogram = arrayAnalyzer.createHistogram();
        assertEquals(2,histogram[0]);
        assertEquals(2,histogram[9]);
    }


    @Test
    public void testShouldReturnThreeFromArrayFullOfThrees() {
        int[] array = {3,3,3,3,3};
        ArrayAnalyzer arrayAnalyzer = new ArrayAnalyzer(array);

        assertEquals(3, arrayAnalyzer.findMode());

    }

    @Test
    public void testShouldReturnFourFromArrayFullOfFours() {
        int[] array = {4,4,4};
        ArrayAnalyzer arrayAnalyzer = new ArrayAnalyzer(array);

        assertEquals(4, arrayAnalyzer.findMode());

    }

    @Test
    public void testShouldReturnFiveFromArrayFiveFiveTwo() {
        int[] array = {2,5,5};
        ArrayAnalyzer arrayAnalyzer = new ArrayAnalyzer(array);

        assertEquals(5, arrayAnalyzer.findMode());
    }

    @Test
    public void testShouldReturnZeroFromArraySixSixZeroZeroZero() {
        int[] array = {6,6,0,0,0};
        ArrayAnalyzer arrayAnalyzer = new ArrayAnalyzer(array);

        assertEquals(0, arrayAnalyzer.findMode());
    }

    @Test
    public void testShouldReturnTheModeFromArray() {
        int[] array = {1,1,4,4,4,2,2};
        ArrayAnalyzer arrayAnalyzer = new ArrayAnalyzer(array);
        assertEquals(4, arrayAnalyzer.findMode());
    }

    @Test
    public void testShouldReturnTheModeFromArray2() {
        int[] array = {1,2,3,7,4,5,6,7,8,9};
        ArrayAnalyzer arrayAnalyzer = new ArrayAnalyzer(array);
        assertEquals(7, arrayAnalyzer.findMode());
    }

    @Test
    public void testShouldReturnTheMiddleIndexOfArrayWithBinarySearch() {
        int[] array = {1,2,3,4,5,6,7,8,9};
        ArrayAnalyzer arrayAnalyzer = new ArrayAnalyzer(array);
        assertEquals(4, arrayAnalyzer.findIndexOf(5));
    }

    @Test
    public void testShouldReturnIndexTwoOfIntegerThreeFromArrayWithBinarySearch() {
        //             0  1  2  3  4  5  6  7  8
        int[] array = {1 ,2, 3, 4, 5, 6, 7, 8, 9};
        ArrayAnalyzer arrayAnalyzer = new ArrayAnalyzer(array);
        assertEquals(2, arrayAnalyzer.findIndexOf(3));

    }

    @Test
    public void testShouldReturnIndexOfIntegerOneFromArrayWithBinarySearch() {
        int[] array = {1,2,3,4,5,6,7,8,9};
        ArrayAnalyzer arrayAnalyzer = new ArrayAnalyzer(array);
        assertEquals(0, arrayAnalyzer.findIndexOf(1));

    }

    @Test
    public void testShouldReturnIndexOfIntegerNineFromArrayWithBinarySearch() {
        int[] array = {1,2,3,4,5,6,7,8,9};
        ArrayAnalyzer arrayAnalyzer = new ArrayAnalyzer(array);
        assertEquals(8, arrayAnalyzer.findIndexOf(9));

    }

    @Test
    public void testShouldReturnNegativeNumberWhenArrayDoesNotContainTarget() {
        int[] array = {1,2,3,4,6,7,8,9};
        ArrayAnalyzer arrayAnalyzer = new ArrayAnalyzer(array);
        assertEquals(-1, arrayAnalyzer.findIndexOf(5));
    }


    @Test
    public void testSortArrayByParityShouldReturnEmptyArrayWhenGivenEmptyArray() {
        int[] testArray = {};
        int [] expected = {};
        int [] result = arrayAnalyzer.sortArrayByParity(testArray);
        assertArrayEquals(expected, result);

    }

    @Test
    public void testSortArrayByParityShouldReturnArrayZeroOneUnchanged() {
        int[] testArray = {0,1};
        int [] expected = {0,1};
        int [] result = arrayAnalyzer.sortArrayByParity(testArray);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSortArrayByParityShouldReturnArrayOneZeroSorted() {
        int[] testArray = {1,0};
        int [] expected = {0,1};
        int [] result = arrayAnalyzer.sortArrayByParity(testArray);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSortArrayByParitShouldSortUnsortedArrayOfSixElements() {
        int[] testArray = {1,3,5,2,4,6};
        int [] expected = {6,1,4,3,2,5};
        int [] result = arrayAnalyzer.sortArrayByParity(testArray);
        printArray(result);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSortArrayByParityShouldSortUnsortedArrayOfSixElements() {
        int[] testArray = {1,4,3,6,5,8};
        int [] expected = {8,5,6,3,4,1};
        int [] result = arrayAnalyzer.sortArrayByParity(testArray);
        printArray(result);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSortArrayByParityShouldSortUnsortedArrayOfFourElements() {
        int[] testArray = {4,2,5,7};
        int [] expected = {4,7,2,5};
        int [] result = arrayAnalyzer.sortArrayByParity(testArray);
        printArray(result);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSortArrayByParityShouldSortUnsortedArrayOfFourElementsOddsInTheBeginning() {
        int[] testArray = {5,7,4,2};
        int [] expected = {2,5,4,7};
        int [] result = arrayAnalyzer.sortArrayByParity(testArray);
        printArray(result);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testTurnIntoBinaryShouldReturnBinaryRepresentationOfAnArrayOfIntegers() {
        int[] testArray = {1,1};
        String[] expected = {"00000001", "00000001"};
        String[] result = arrayAnalyzer.turnIntoBinary(testArray);
        
    }

    @Test
    public void testFindKOrShouldReturnZeroForEmptyArray() {
        int[] testArray = {};
        int k = 1;
        int expected = 0;
        int result = arrayAnalyzer.findKOr(testArray, k);
        assertEquals(expected, result);
    }

    @Test
    public void testFindKOrShouldReturnOneForArrayOfTwoOnesAndKOne() {
        int[] testArray = {1,1};
        int k = 1;
        int expected = 1;
        int result = arrayAnalyzer.findKOr(testArray, k);
        assertEquals(expected, result);
    }

    public void printArray(int [] array) {
        for (int integer: array) {
            System.out.print(integer + " ");
        }
    }

}
