package ArrayAnalyzerTest;

import ArrayAnalyzer.ArrayAnalyzer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayAnazylerTest {



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

    /*
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

     */
}
