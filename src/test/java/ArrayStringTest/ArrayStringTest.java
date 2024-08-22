package ArrayStringTest;

import ArrayString.ArrayString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayStringTest {

    ArrayString arrayString;

    @BeforeEach
    void setUp() {
        arrayString = new ArrayString();
    }

    @Test
    public void testShouldReturnSubstring() {

        char[] testArray = new char[]{'a', 'a', 's', 'i', 0};
        char[] expectedArray = new char[]{'a', 's', 0};
        assertArrayEquals(expectedArray, arrayString.substring(testArray, 1, 2));

    }

    @Test
    public void testShouldReturnSubstring2() {

        char[] testArray = new char[]{'a', 'a', 's', 'i', 0};
        char[] expectedArray = new char[]{'a', 'a', 's', 'i', 0};
        assertArrayEquals(expectedArray, arrayString.substring(testArray, 0, 4));
    }


    @Test
    public void testShouldReturnEmptyArrayWhenGivenLengthIsZero() {
        char[] testArray = new char[]{'a', 'a', 's', 'i',0};
        char[] expectedArray = new char[]{0};
        assertArrayEquals(expectedArray, arrayString.substring(testArray, 0, 0));
    }


    @Test
    public void testShouldReturnErrorWhenGivenLengthAndStartingIndexResultInSubtstringLongerThanArray() {
        char[] testArray = new char[]{'a','a','s','i',0};
        IndexOutOfBoundsException exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            // Call a method that should throw IllegalArgumentException
            arrayString.substring(testArray,3,5);
        });
        assertEquals("Index out of bounds", exception.getMessage());
    }
}
    /*

    @Test
    public void testShouldThrowIllegalArgumentExceptionWhenGivenIndexIsOutOfBounds() {
        char[] testArray = new char[]{'a','a','s','i'};
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            // Call a method that should throw IllegalArgumentException
            arrayString.substring(testArray,5,0);
        });
        assertEquals("Substring requested is out of bounds", exception.getMessage());
    }

    @Test
    public void testShouldReplaceCharsWithOtherChars() {
        char[] sourceArray = new char[]{'a','a','s','i'};
        char[] targetArray = new char[]{'s'};
        char[] replaceTextArray = new char[]{'p'};
        char[] expectedArray = new char[]{'a','a','p','i'};


        assertArrayEquals(expectedArray, arrayString.replaceString(sourceArray, targetArray, replaceTextArray) );
    }
}


 */