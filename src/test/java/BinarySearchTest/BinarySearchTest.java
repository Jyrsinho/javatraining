package BinarySearchTest;

import BinarySearch.Result;
import org.junit.jupiter.api.Test;

import static BinarySearch.BinarySearch.binarySearch;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class BinarySearchTest {

// ------------------------------------------------------------------------
// TESTING THE BINARYSEARCH FUNCTION

    @Test
    public void testShouldReturnZeroWhenSearchedIntegerIsTheOnlyIntegerInTheArray() {
        int target = 1;
        int[] array = {1};
        int expected = 0;
        int result = binarySearch(array, target).getIndex();
        assertEquals(expected, result);

    }

    @Test
    public void testShouldReturnOneWhenSearchedIntegerIsTheSecondIntegerInAnUnevenArray() {
        int[] array = {1, 2, 3};
        int target = 2;
        int expected = 1;
        Result resultObject = binarySearch(array, target);
        int result = resultObject.getIndex();
        assertEquals(expected, result);
    }

    @Test
    public void testShouldReturnZeroWhenSearchedIntegerIsTheFirstIntegerInAnUnEvenArray() {
        int[] array = {1, 2, 3};
        int target = 1;
        int expected = 0;
        Result resultObject = binarySearch(array, target);
        int result = resultObject.getIndex();
        assertEquals(expected, result);
    }

    @Test
    public void testSholdReturnTwoWhenSearchedIntegerIsTheLastIntegerInAnUnevenArrayOfThreeElements() {
        int[] array = {1, 2, 3};
        int target = 3;
        int expected = 2;
        Result resultObject = binarySearch(array, target);
        int result = resultObject.getIndex();
        assertEquals(expected, result);
    }

    @Test
    public void testShouldReturnThreeWhenSearchedIntegerIsTheLastIntegerInEvenNumberedArrayOfFourElements() {
        int[] array = {1, 2, 3, 4};
        int target = 4;
        int expected = 3;
        Result resultObject = binarySearch(array, target);
        int result = resultObject.getIndex();
        assertEquals(expected, result);
    }

    @Test
    public void testShouldReturnZeroWhenSearchedIntegerIsTheFirstIntegerInEvenNumberedArray() {
        int[] array = {1, 2, 3, 4};
        int target = 1;
        int expected = 0;
        Result resultObject = binarySearch(array, target);
        int result = resultObject.getIndex();
        assertEquals(expected, result);
    }

    @Test
    public void testShoudlReturnOneWhenSearchedIntegerIsTheSecondtIntegerInEvenNumberedArray() {
        int[] array = {1, 2, 3,4};
        int target = 2;
        int expected = 1;
        Result resultObject = binarySearch(array, target);
        int result = resultObject.getIndex();
        assertEquals(expected, result);
    }

    @Test
    public void testShouldReturnNegativeValueWhenTargetIsNotInTheArray() {
        int[] array = {1, 2, 3};
        int target = 4;
        int expected = -1;
        Result resultObject = binarySearch(array, target);
        int result = resultObject.getIndex();
        assertEquals(expected, result);

    }

    @Test
    public void testShouldReturnNegativeValueWhenGIvenEmptyArray() {
        int[] array = {};
        int target = 0;
        int expected = -1;
        Result resultObject = binarySearch(array, target);
        int result = resultObject.getIndex();
        assertEquals(expected, result);

    }


    @Test
    public void testShouldReturnOneAsNumberOfComparisonsWhenTargetIsFoundInFirstComparison() {
        int[] array = {1, 2, 3, 4, 5};
        int target = 3;
        int expected = 1;
        Result resultObject = binarySearch(array, target);
        int result = resultObject.getNumberOfComparisons();
        assertEquals(expected, result);
    }

    @Test
    public void testShouldReturnNumberOfComparisonsWhenTargetIsFoundInThirdComparison() {
        int[] array = { 3, 5, 6, 7, 8, 9 };
        int target = 9;
        int expected = 3;
        Result resultObject = binarySearch(array, target);
        int result = resultObject.getNumberOfComparisons();
        assertEquals(expected, result);
    }

    @Test
    public void testShouldReturnZeroComparisonForEmptyArray() {
        int[] array = {};
        int target = 0;
        int expected = 0;
        Result resultObject = binarySearch(array, target);
        int result = resultObject.getNumberOfComparisons();
        assertEquals(expected, result);
    }

}