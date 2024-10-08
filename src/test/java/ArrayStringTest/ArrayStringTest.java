package ArrayStringTest;

import ArrayString.ArrayString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

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


    @Test
    public void testShouldReplaceStringsWithOneCharacterChanging() {
        char[] sourceArray = new char[]{'a','a','s','i',0};
        char[] targetArray = new char[]{'s',0};
        char[] replaceTextArray = new char[]{'p',0};
        char[] expectedArray = new char[]{'a','a','p','i',0};

        System.out.println("SourceArray: " + Arrays.toString(sourceArray));
        System.out.println("ExpectedArray: "+ Arrays.toString(expectedArray));
        System.out.println("TestResult_" + Arrays.toString(arrayString.replaceString(sourceArray, targetArray, replaceTextArray)));

        assertArrayEquals(expectedArray, arrayString.replaceString(sourceArray, targetArray, replaceTextArray) );
    }

    @Test
    public void testShouldReplaceStringsWithOneCharacterChangingIntoTwoCharacters() {
        char[] sourceArray = new char[]{'a','a','s','i',0};
        char[] targetArray = new char[]{'s', 0};
        char[] replaceTextArray = new char[]{'p', 'e',0};
        char[] expectedArray = new char[]{'a','a','p','e','i',0};
        System.out.println("SourceArray: " + Arrays.toString(sourceArray));
        System.out.println("ExpectedArray: "+ Arrays.toString(expectedArray));
        System.out.println("TestResult_" + Arrays.toString(arrayString.replaceString(sourceArray, targetArray, replaceTextArray)));

        assertArrayEquals(expectedArray, arrayString.replaceString(sourceArray, targetArray, replaceTextArray) );
    }

    @Test
    public void testShouldReplaceStringsWithOneCharacterChangingToTwoCharacters2() {
        char[] sourceArray = new char[]{'a','a','s','i',0};
        char[] targetArray = new char[]{'s',0};
        char[] replaceTextArray = new char[]{'p', 'p',0};
        char[] expectedArray = new char[]{'a','a','p','p','i',0};

        System.out.println("SourceArray: " + Arrays.toString(sourceArray));
        System.out.println("ExpectedArray: "+ Arrays.toString(expectedArray));
        System.out.println("TestResult_" + Arrays.toString(arrayString.replaceString(sourceArray, targetArray, replaceTextArray)));
        assertArrayEquals(expectedArray, arrayString.replaceString(sourceArray, targetArray, replaceTextArray) );
    }

    @Test
    public void testShouldReplaceStringsWithTwoCharactersChanging() {
        char[] sourceArray = new char[]{'a','a','s','i',0};
        char[] targetArray = new char[]{'s', 'i',0};
        char[] replaceTextArray = new char[]{'p','a',0};

        char[] expectedArray = new char[]{'a','a','p','a',0};
        assertArrayEquals(expectedArray, arrayString.replaceString(sourceArray, targetArray, replaceTextArray) );
    }

    @Test
    public void testShouldHandleCasesWhereTargetArraysFirstInstanceAppearsWithoutRestOfTargetArraysElements() {

        char[] sourceArray = new char[]{'a','a','s','i','a',0};
        char[] targetArray = new char[]{'a','s',0};
        char[] replaceTextArray = new char[]{'p', 'e',0};
        char[] expectedArray = new char[]{'a','p','e','i','a',0};
        System.out.println("SourceArray: " + Arrays.toString(sourceArray));
        System.out.println("ExpectedArray: "+ Arrays.toString(expectedArray));
        System.out.println("TestResult_" + Arrays.toString(arrayString.replaceString(sourceArray, targetArray, replaceTextArray)));
        assertArrayEquals(expectedArray, arrayString.replaceString(sourceArray, targetArray, replaceTextArray) );
    }

    @Test
    public void testShouldHandleCasesWhereReplaceTextIsShorterThanTargetArraysElements() {
        char[] sourceArray = new char[]{'a','a','s','i','a',0};
        char[] targetArray = new char[]{'a','a',0};
        char[] replaceTextArray = new char[]{'b',0};
        char[] expectedArray = new char[]{'b','s','i','a',0};

        System.out.println("SourceArray: " + Arrays.toString(sourceArray));
        System.out.println("ExpectedArray: "+ Arrays.toString(expectedArray));
        System.out.println("TestResult_" + Arrays.toString(arrayString.replaceString(sourceArray, targetArray, replaceTextArray)));
        assertArrayEquals(expectedArray, arrayString.replaceString(sourceArray, targetArray, replaceTextArray) );
    }

    @Test
    public void testShouldHandleCasesWhereThereAreMultipleInstancesToBeReplacedByLongerString() {
        char[] sourceArray = new char[]{'a','a','s','i','a',0};
        char[] targetArray = new char[]{'a',0};
        char[] replaceTextArray = new char[]{'p', 'e',0};
        char[] expectedArray = new char[]{'p','e','p','e','s','i','p','e',0};

        System.out.println("SourceArray: " + Arrays.toString(sourceArray));
        System.out.println("ExpectedArray: "+ Arrays.toString(expectedArray));
        System.out.println("TestResult_" + Arrays.toString(arrayString.replaceString(sourceArray, targetArray, replaceTextArray)));
        assertArrayEquals(expectedArray, arrayString.replaceString(sourceArray, targetArray, replaceTextArray) );

    }

    @Test
    public void testShouldReturnLargerArrayWithNullValues() {
        char[] sourceArray = new char[]{'a','a','s','i','a',0};
        char[] expectedArray = new char[]{'a','a','s','i','a',0,0,0};
        assertArrayEquals(expectedArray, arrayString.copyAndIncreaseArraySize(sourceArray,2));
    }

    @Test
    public void testShouldReturnOneLongerArrayThanBeforeAppend() {
        char[] array1 = new char[]{3, 'a', 'u', 't'};
        char appended = 'o';

        char[] expectedArray = arrayString.append(array1,appended);
        char expected = expectedArray[0];
        assertEquals(4, expected);

    }

    @Test
    public void testShouldReturnOneLongerArrayThanBeforeAppend2() {
        char[] array1 = new char[]{0};
        char appended = 'o';

        char[] expectedArray = arrayString.append(array1,appended);
        char expected = expectedArray[0];
        assertEquals(1, expected);
    }

    @Test
    public void testShouldAppendCharacterToArrayString() {
        char[] array1 = new char[]{3,'a','u','t'};
        char appended = 'o';
        char[] expectedArray = new char[]{4,'a','u','t','o'};
        char[] actualArray = arrayString.append(array1,appended);
        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void testShouldAppendCharacterToArrayString2() {
        char[] array1 = new char[]{0};
        char appended = 'o';
        char[] expectedArray = new char[]{1, 'o'};
        char[] actualArray = arrayString.append(array1,appended);
        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void testShouldGiveEightForArrayLengthAfterConcatenationOfTwoFourLongCharArrays() {
        char[] array1 = new char[]{4, 'a', 'u', 't','o'};
        char[] array2 = new char[]{4, 'p', 'a', 'l', 'o'};

        char[] actualArray = arrayString.concatenate(array1,array2);
        assertEquals(8, actualArray[0]);
    }

    @Test
    public void testShouldGive0ForLengthWhenConcatenatingTwoEmptyCharArrays() {
        char[] array1 = new char[]{0};
        char[] array2 = new char[]{0};
        char[] actualArray = arrayString.concatenate(array1,array2);
        assertEquals(0, actualArray[0]);
    }

    @Test
    public void testShouldReturnConcatenatedStringAfterConcatenation() {
        char[] array1 = new char[]{4, 'a', 'u', 't', 'o'};
        char[] array2 = new char[]{4, 'p', 'a', 'l', 'o'};
        char[] expectedArray = new char[]{8,'a', 'u', 't', 'o','p', 'a', 'l', 'o'};
        char[] actualArray = arrayString.concatenate(array1,array2);
        assertArrayEquals(expectedArray, actualArray);
}

    @Test
    public void testShouldReturnCharacterAFromArrayConsistingOnlyOfA() {
        char[] array1 = new char[]{1,'a'};
        char expected = arrayString.charAt(array1,1);
        assertEquals('a', expected);
    }
}

