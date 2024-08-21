package StudentSorterTest;

import StudentSorter.QuartileFinder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuartileFinderTest {

    private QuartileFinder<Double> doubleQuartileFinder;
    private QuartileFinder<Integer> integerQuartileFinder;

    @BeforeEach
    public void setUp() {
        doubleQuartileFinder = new QuartileFinder<>();
        integerQuartileFinder = new QuartileFinder<>();
    }

    @Test
    public void testShouldFindTheGradeGradeMedianFromUnevenLengthArrayOfDoubles() {
        Double[] testArray = {0.0, 25.0, 50.0, 75.0, 100.0};
        assertEquals(50, doubleQuartileFinder.findMedian(testArray));
    }


    @Test
    public void testShouldFindTheGradeGradeMedianFromUnevenLengthArray2OfDoubles() {
        Double[] testArray = {0.0, 25.0, 50.0};
        assertEquals(25, doubleQuartileFinder.findMedian(testArray));
    }


    @Test
    public void testShouldFindTheGradeMedianFromEvenLengthArrayOfDoubles() {
        Double[] testArray = {0.0, 25.0};
        assertEquals(12.5, doubleQuartileFinder.findMedian(testArray));
    }


    @Test
    public void testShouldFindTheGradeMedianFromEvenLengthArrayOfIntegers() {
        Integer[] testArray = {0, 25};
        assertEquals(12.5, integerQuartileFinder.findMedian(testArray));
    }


    @Test
    public void testShouldFindMedianFromUnsortedArrayOfIntegers() {
        Integer[] testArray = {0, 25, 99};
        assertEquals(25, integerQuartileFinder.findMedian(testArray));
    }


    @Test
    public void testShouldFindFirstQuartileFromUnevenLengthArrayOfUnSortedIntegers() {
        Integer[] testArray = {1, 25, 99, 50, 75};
        assertEquals(13, integerQuartileFinder.findFirstQuartile(testArray));
    }


    @Test
    public void testShouldFindFirstQuartileFromEvenLengthArrayOfDoubles() {
        Double[] testArray = {1.0, 49.0, 99.0, 50.0};
        assertEquals(25, doubleQuartileFinder.findFirstQuartile(testArray));

    }


    @Test
    public void testShouldFindFirstQuartileFromEvenLengthArrayOfIntegers() {
        Integer[] testArray = {1, 48, 49, 50, 52, 99};
        assertEquals(48, integerQuartileFinder.findFirstQuartile(testArray));
    }


    @Test
    public void testShouldFindThirdQuartileFromUnevenLengthArrayOfIntegers() {
        Integer[] testArray = {1, 49, 50, 75, 99};
        assertEquals(87, integerQuartileFinder.findThirdQuartile(testArray));
    }


    @Test
    public void testShouldFindThirdQuartileFromEvenLengthArrayOfDoubles() {
        Double[] testArray = {1.0, 49.0, 50.0, 75.0};
        assertEquals(62.5, doubleQuartileFinder.findThirdQuartile(testArray));
    }


    @Test
    public void testShouldReturnArrayOfQuartilesWithDoubles() {

        Double[] testArray = {1.0, 49.0, 50.0, 75.0};
        Double[] expected = new Double []{25.0, 49.5, 62.5};
        assertArrayEquals(expected, doubleQuartileFinder.getQuartiles(testArray));
    }


    @Test
    public void testShouldReturnArrayOfQuartilesWithIntegers() {
        Integer[] testArray = {1, 49, 50, 75, 99};

        Double [] expected = new Double []{25.0, 50.0, 87.0};
        assertArrayEquals(expected, integerQuartileFinder.getQuartiles(testArray));

    }

}

