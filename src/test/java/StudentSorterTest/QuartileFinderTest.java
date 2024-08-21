package StudentSorterTest;

import StudentSorter.QuartileFinder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuartileFinderTest {

    private QuartileFinder<Double> doubleQuartileFinder;

    @BeforeEach
    public void setUp() {
        doubleQuartileFinder = new QuartileFinder<>();
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
}
    /*

    @Test
    public void testShouldFindMedianFromUnsortedArray() {
        students.addStudent(new Student("Timo22", 22, 0));
        students.addStudent(new Student("Timo25", 22, 25));
        students.addStudent(new Student("Aapo2", 2, 99));
        students.sort();
        assertEquals(25 ,students.findMedian(students.getStudents(), BY_GRADE));
    }

    @Test
    public void testShouldFindFirstQuartileFromUnevenLengthArray() {
        students.addStudent(new Student("Timo22", 22, 1));
        students.addStudent(new Student("Timo25", 22, 25));
        students.addStudent(new Student("Aapo2", 2, 99));
        students.addStudent(new Student("Timo24", 22, 50));
        students.addStudent(new Student("Timo75", 22, 75));

        assertEquals(13 ,students.findFirstQuartile(BY_GRADE));
    }

    @Test
    public void testShouldFindFirstQuartileFromEvenLengthArray() {
        students.addStudent(new Student("Timo22", 22, 1));
        students.addStudent(new Student("Timo25", 22, 49));
        students.addStudent(new Student("Aapo2", 2, 99));
        students.addStudent(new Student("Timo24", 22, 50));

        assertEquals(25,students.findFirstQuartile(BY_GRADE));

    }

    @Test
    public void testShouldFindFirstQuartileFromEvenLengthArray2() {
        students.addStudent(new Student("Timo22", 22, 1));
        students.addStudent(new Student("Timo48", 22, 48));
        students.addStudent(new Student("Timo25", 22, 49));
        students.addStudent(new Student("Timo24", 22, 50));
        students.addStudent(new Student("Aapo2", 2, 52));
        students.addStudent(new Student("Aapo2", 2, 99));

        assertEquals(48,students.findFirstQuartile(BY_GRADE));

    }

    @Test
    public void testShouldFindThirdQuartileFromUnevenLengthArray() {
        students.addStudent(new Student("Timo22", 22, 1));
        students.addStudent(new Student("Timo25", 22, 49));
        students.addStudent(new Student("Timo24", 22, 50));
        students.addStudent(new Student("Timo75", 22, 75));
        students.addStudent(new Student("Aapo2", 2, 99));

        assertEquals(87, students.findThirdQuartile(BY_GRADE));
    }

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
