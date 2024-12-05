package SortingAlgorithmsTest;

import SortingAlgorithms.SortingAlgorithms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

}
