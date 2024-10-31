package AlgorithmsOneTest;

import org.junit.jupiter.api.Test;

import static AlgorithmsOne.Algorithms.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlgorithmsTest {

    @Test
    public void testShouldReturnModuloOfTwoIntegers() {
        int a = 5;
        int b = 2;
        int expected = 1;
        assertEquals(modulo(a, b), expected);

    }

    @Test
    public void testShouldReturnModuloOfTwoIntegers2() {
        int a = 4;
        int b = 2;
        int expected = 0;
        assertEquals(expected, modulo(a,b));
    }

    @Test
    public void testShouldReturnModuloOfTwoIntegers3() {
        int a = 0;
        int b = 5;
        int expected = 0;
        assertEquals(expected, modulo(a,b));
    }

    @Test
    public void testShouldReturnModuloOfTwoIntegers4() {
        int a = 4;
        int b = 0;
        int expected = -1;
        assertEquals(expected, modulo(a,b));
    }

    @Test
    public void testShouldReturnModuloOfTwoIntegers5() {
        int a = -5;
        int b = 2;
        int expected = 1;

    }

    @Test
    public void testTwoOfTheSameShouldReturnFalseForStringsWithLessThanTwoChars() {
        String s = "a";
        boolean expected = false;
        assertEquals(twoOfTheSame(s), expected);
    }

    @Test
    public void testTwoOfTheSameShouldReturnTrueForAA() {
        String s = "aa";
        boolean expected = true;
        assertEquals(twoOfTheSame(s), expected);
    }

    @Test
    public void testTwoOfTheSameShouldReturnFalseForAB() {
        String s = "ab";
        boolean expected = false;
        assertEquals(twoOfTheSame(s), expected);
    }

    @Test
    public void testTwoOfTheSameShouldReturnFalseForABC() {
        String s = "abc";
        boolean expected = false;
        assertEquals(twoOfTheSame(s), expected);
    }

    @Test
    public void testTwoOfTheSameShouldReturnTrueForABDD() {
        String s = "abdd";
        boolean expected = true;
        assertEquals(twoOfTheSame(s), expected);
    }

    @Test
    public void testLargerThanAvgShouldReturnNegativeOneForEmptyArray() {
        int[] t = {};
        int expected = -1;
        assertEquals(largerThanAvg(t), expected);
    }

    @Test
    public void testLargerThanAvgShouldReturnZeroForArrayWithOneElement() {
        int[] t = {1};
        int expected = 0;
        assertEquals(largerThanAvg(t), expected);
    }

    @Test
    public void testLargerThanAvgShouldReturnOneForArrayWithTwoElements() {
        int[] t = {1, 2};
        int expected = 1;
        assertEquals(largerThanAvg(t), expected);
    }

    @Test
    public void testLargerThanAvgShouldReturnTwo(){
        int[] t = {1, 2, 3, 5, 5};
        int expected = 2;
        assertEquals(largerThanAvg(t), expected);
    }

    @Test
    public void testShouldReturSameArrayWhenItContainsNoDuplicates() {
        int [] t = {1, 2, 3, 5,};
        int[] expected = t;
        assertEquals(compressIntArray(t), expected);
    }
}
