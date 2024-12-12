package StringAnalyzerTest;

import StringAnalyzer.StringAnalyzer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static StringAnalyzer.StringAnalyzer.wordsInString;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringAnalyzerTest {

    StringAnalyzer stringAnalyzer;

    @BeforeEach
    public void setUp() {
        stringAnalyzer = new StringAnalyzer();
    }

    @Test
    public void testStringAnalyzerShouldReturnZeroForEmptyString() {
        String testString = "";
        int expected = 0;
        int result = wordsInString(testString);
        assertEquals(expected, result);
    }

    @Test
    public void testStringAnalyzerShouldReturnOneForSingleWord() {
        String testString = "hello";
        int expected = 1;
        int result = wordsInString(testString);
        assertEquals(expected, result);
    }

    @Test
    public void testStringAnalyzerShouldReturnTwoForTwoWords() {
        String testString = "hello world";
        int expected = 2;
        int result = wordsInString(testString);
        assertEquals(expected, result);
    }

    @Test
    public void testStringAnalyzerShouldReturnThreeForThreeWords() {
        String testString = "hello cruel world";
        int expected = 3;
        int result = wordsInString(testString);
        assertEquals(expected, result);
    }

    //Tapaus jossa välilyönti on useampi peräkkäin.
    @Test
    public void testStringAnalyzerShouldHandleSpacesInTheMiddleOfString() {
        String testString = "hello     world";
        int expected = 2;
        int result = wordsInString(testString);
        assertEquals(expected, result);
    }

    //Tapaus jossa välilyönti on merkkijonon lopussa
    @Test
    public void testStringAnalyzerShouldHandleSpacesInTheEndOfString() {
        String testString = "hello world   ";
        int expected = 2;
        int result = wordsInString(testString);
        assertEquals(expected, result);
    }

    // //Tapaus jossa välilyönti on merkkijonon alussa
    @Test
    public void testStringAnalyzerShouldHandleSpacesInTheBeginningOfString() {
        String testString = "     hello world";
        int expected = 2;
        int result = wordsInString(testString);
        assertEquals(expected, result);
    }

    //Tapaus jossa välilyöntejä on kaikkialla
    @Test
    public void testStringAnalyzerShouldHandleSpacesBeginningEndAndMiddleOfString() {
        String testString = "   hello   world   ";
        int expected = 2;
        int result = wordsInString(testString);
        assertEquals(expected, result);
    }

}




