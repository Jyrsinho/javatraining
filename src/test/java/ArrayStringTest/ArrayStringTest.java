package ArrayStringTest;

import ArrayString.ArrayString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
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


    @Test
    public void testShouldReturnTrueIfTrueArraysHaveTheSameContent() {
        char[] testArray1 = new char[]{'a','a','s','i',0};
        char[] testArray2 = new char[]{'a','a','s','i',0};
        assertTrue(arrayString.arraysAreEqual(testArray1, testArray2));
    }

    @Test
    public void testShouldReturnFalseIfFalseArraysDontHaveTheSameContent() {
        char[] testArray1 = new char[]{'a','a','s','i',0};
        char[] testArray2 = new char[]{'a','a','s','i','a',0};
    }


    @Test
    public void testShouldReturnFalseIfFalseArraysDontHaveTheSameContent2() {
        char[] testArray1 = new char[]{'a','a','s','i',0};
        char[] testArray2 = new char[]{'a','a','s','a',0};
    }


    @Disabled
    public void testShouldReplaceStringsWithOneCharacterChanging() {
        char[] sourceArray = new char[]{'a','a','s','i',0};
        char[] targetArray = new char[]{'s',0};
        char[] replaceTextArray = new char[]{'p',0};
        char[] expectedArray = new char[]{'a','a','p','i',0};

        assertArrayEquals(expectedArray, arrayString.replaceString(sourceArray, targetArray, replaceTextArray) );
    }

    @Disabled
    public void testShouldReplaceStringsWithOneCharacterChangingIntoTwoCharacters() {
        char[] sourceArray = new char[]{'a','a','s','i',0};
        char[] targetArray = new char[]{'s', 0};
        char[] replaceTextArray = new char[]{'p', 'e'};

        char[] expectedArray = new char[]{'a','a','p','e','i',0};
        assertArrayEquals(expectedArray, arrayString.replaceString(sourceArray, targetArray, replaceTextArray) );
    }

    @Disabled
    public void testShouldReplaceStringsWithOneCharacterChangingToTwoCharacters() {
        char[] sourceArray = new char[]{'a','a','s','i',0};
        char[] targetArray = new char[]{'s'};
        char[] replaceTextArray = new char[]{'p', 'p'};

        char[] expectedArray = new char[]{'a','a','p','p','i',0};
        assertArrayEquals(expectedArray, arrayString.replaceString(sourceArray, targetArray, replaceTextArray) );
    }

    @Disabled
    public void testShouldReplaceStringsWithTwoCharactersChanging() {
        char[] sourceArray = new char[]{'a','a','s','i',0};
        char[] targetArray = new char[]{'s', 'i'};
        char[] replaceTextArray = new char[]{'p','a'};

        char[] expectedArray = new char[]{'a','a','p','a',0};
        assertArrayEquals(expectedArray, arrayString.replaceString(sourceArray, targetArray, replaceTextArray) );
    }

    @Disabled
    public void testShouldHandleCasesWhereTargetArraysFirstInstanceAppearsWithoutRestOfTargetArraysElements() {

        char[] sourceArray = new char[]{'a','a','s','i','a',0};
        char[] targetArray = new char[]{'a','s',};
        char[] replaceTextArray = new char[]{'p', 'e'};

        char[] expectedArray = new char[]{'a','p','e','i','a',0};
        assertArrayEquals(expectedArray, arrayString.replaceString(sourceArray, targetArray, replaceTextArray) );
    }
}


