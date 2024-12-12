package StringAnalyzerTest;

import StringAnalyzer.StringAnalyzer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        int result = stringAnalyzer.wordsInString(testString);
        assertEquals(expected, result);
    }

    @Test
    public void testStringAnalyzerShouldReturnOneForSingleWord() {
        String testString = "hello";
        int expected = 1;
        int result = stringAnalyzer.wordsInString(testString);
        assertEquals(expected, result);
    }

    @Test
    public void testStringAnalyzerShouldReturnTwoForTwoWords() {
        String testString = "hello world";
        int expected = 2;
        int result = stringAnalyzer.wordsInString(testString);
        assertEquals(expected, result);
    }

    @Test
    public void testStringAnalyzerShouldReturnThreeForThreeWords() {
        String testString = "hello cruel world";
        int expected = 3;
        int result = stringAnalyzer.wordsInString(testString);
        assertEquals(expected, result);
    }

    //Tapaus jossa välilyönti on merkkijonon alussa
    @Test
    public void testStringAnalyzerShouldHandleSpacesInBeginningOfString() {
        String testString = "   hello world";
        int expected = 2;
        int result = stringAnalyzer.wordsInString(testString);
        assertEquals(expected, result);
    }
}



//Tapaus jossa välilyönti on merkkijonon lopussa

//Tapaus jossa välilyönti on useampi peräkkäin.