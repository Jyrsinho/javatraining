package ArrayStringTest;

import ArrayString.ArrayString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArrayStringTest {

    ArrayString arrayString;

    @BeforeEach
    void setUp() {
        arrayString = new ArrayString();
    }

    @Test
    public void testShouldReturnSubstring() {

        char[] testArray = new char[]{'a','a','s','i'};
        char[] expectedArray = new char[]{'a','s'};
        assertArrayEquals(expectedArray, arrayString.substring(testArray, 1, 2) );

    }

    @Test
    public void testShouldReturnSubstring2() {

    char[] testArray = new char[]{'a','a','s','i'};
    char[] expectedArray = new char[]{'a','a','s','i'};
    assertArrayEquals(expectedArray, arrayString.substring(testArray, 0, 4) );
}

    @Test
    public void testShouldReturnEmptyArrayWhenGivenLengthIsZero() {
        char[] testArray = new char[]{'a','a','s','i'};
        char[] expectedArray = new char[]{};
        assertArrayEquals(expectedArray, arrayString.substring(testArray, 0, 0) );
    }

    @Test
    public void testShouldReturnErrorWhenGivenLengthAndStartingIndexResultInSubtstringLongerThanArray() {
        char[] testArray = new char[]{'a','a','s','i'};
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            // Call a method that should throw IllegalArgumentException
            arrayString.substring(testArray,3,5);
        });

    }
}
