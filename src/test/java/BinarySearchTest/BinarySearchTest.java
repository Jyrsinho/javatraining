package BinarySearchTest;

import BinarySearch.Result;
import org.junit.jupiter.api.Disabled;
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
    public void testShouldReturnOneWhenSearchedIntegerIsTheLastIntegerInEvenNumberedArray() {
        int[] array = {1, 2, 3, 4};
        int target = 4;
        int expected = 3;
        Result resultObject = binarySearch(array, target);
        int result = resultObject.getIndex();
        assertEquals(expected, result);
    }


    @Disabled
    public void testShouldReturnTheAmountOFComparisonsInBinarySearch() {
        int[] array = {1, 2, 3, 4, 5};

    }
}