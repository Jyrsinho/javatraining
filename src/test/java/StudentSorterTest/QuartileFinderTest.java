package StudentSorterTest;

import StudentSorter.QuartileFinder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        Double[] testArray = {0.0,25.0};
        assertEquals(12.5, doubleQuartileFinder.findMedian(testArray));
    }


    @Test
    public void testShouldFindTheGradeMedianFromEvenLengthArrayOfIntegers() {
        Integer[] testArray = {0,25};
        assertEquals(12.5, integerQuartileFinder.findMedian(testArray));
    }



    @Test
    public void testShouldFindMedianFromUnsortedArrayOfIntegers() {
        Integer[] testArray = {0,25,99};
        assertEquals(25 ,integerQuartileFinder.findMedian(testArray));
    }




    @Test
    public void testShouldFindFirstQuartileFromUnevenLengthArrayOfUnSortedIntegers() {
        Integer[] testArray = {1,25,99,50,75};
        assertEquals(13 ,integerQuartileFinder.findFirstQuartile(testArray));
    }




    @Test
    public void testShouldFindFirstQuartileFromEvenLengthArrayOfDoubles() {
        Double[] testArray = {1.0,49.0,99.0,50.0};
        assertEquals(25, doubleQuartileFinder.findFirstQuartile(testArray));

    }



    @Test
    public void testShouldFindFirstQuartileFromEvenLengthArrayOfIntegers() {
        Integer[] testArray = {1,48,49,50,52,99};
        assertEquals(48, integerQuartileFinder.findFirstQuartile(testArray));
    }


    @Test
    public void testShouldFindThirdQuartileFromUnevenLengthArrayOfIntegers() {
        Integer [] testArray = {1,49,50,75,99};
        assertEquals(87, integerQuartileFinder.findThirdQuartile(testArray));
    }
}
    /*


    @Test
    public void testShouldFindThirdQuartileFromEvenLengthArray() {
        students.addStudent(new Student("Timo22", 22, 1));
        students.addStudent(new Student("Timo25", 22, 49));
        students.addStudent(new Student("Timo24", 22, 50));
        students.addStudent(new Student("Timo75", 22, 75));

        assertEquals(62.5, students.findThirdQuartile(BY_GRADE));
    }

    @Test
    public void testShouldReturnArrayOfQuartiles() {
        students.addStudent(new Student("Timo22", 22, 1));
        students.addStudent(new Student("Timo25", 22, 49));
        students.addStudent(new Student("Timo24", 22, 50));
        students.addStudent(new Student("Timo75", 22, 75));

        double[] expected = new double []{25, 49.5, 62.5};
        assertArrayEquals(expected, students.getQuartiles(BY_GRADE));
    }

    @Test
    public void testShouldReturnArrayOfQuartiles2() {
        students.addStudent(new Student("Timo22", 22, 1));
        students.addStudent(new Student("Timo25", 22, 49));
        students.addStudent(new Student("Timo24", 22, 50));
        students.addStudent(new Student("Timo75", 22, 75));
        students.addStudent(new Student("Kaapo2", 2, 99));

        double [] expected = new double []{25, 50, 87};
        assertArrayEquals(expected, students.getQuartiles(BY_GRADE));

    }

    @Test
    public void testShouldReturnTheMedianOfStudentAges() {
        students.addStudent(new Student("Timo22", 20, 11));
        students.addStudent(new Student("Timo25", 30, 149));
        students.addStudent(new Student("Timo24", 45, 150));
        students.addStudent(new Student("Timo75", 50, 175));
        students.addStudent(new Student("Kaapo2", 60, 199));

        assertEquals(45, students.findMedian(students.getStudents(),BY_AGE));
    }

}

     */
