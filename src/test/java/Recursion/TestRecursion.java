package Recursion;

import org.junit.jupiter.api.Test;

import static Recursion.Recursion.recursiveFibonacci;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRecursion {

    @Test
    public void testRecursiveFibonacciShouldReturnZeroForFibonacciOfZero() {
        int expected = 0;
        int result = recursiveFibonacci(0);
        assertEquals(expected, result);
    }

    @Test
    public void testRecursiveFibonacciShouldReturnOneForFibonacciOfOne() {
        int expected = 1;
        int result = recursiveFibonacci(1);
        assertEquals(expected, result);
    }
}
