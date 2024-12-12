package Recursion;

import org.junit.jupiter.api.Test;

import static Recursion.Recursion.iterativeFibonacci;
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

    @Test
    public void testRecursiveFibonacciShouldReturnOneForFibonacciOfTwo() {
        int expected = 1;
        int result = recursiveFibonacci(2);
        assertEquals(expected, result);
    }

    @Test
    public void testRecursiveFibonacciShouldReturnOneForFibonacciOfThree() {
        int expected = 2;
        int result = recursiveFibonacci(3);
        assertEquals(expected, result);
    }

    @Test
    public void testRecursiveFibonacciShouldReturnTwoForFibonacciOfFour() {
        int expected = 3;
        int result = recursiveFibonacci(4);
        assertEquals(expected, result);
    }

    @Test
    public void testRecursiveFibonacciShouldReturnFibonacciOfFive() {
        int expected = 5;
        int result = recursiveFibonacci(5);
        assertEquals(expected, result);
    }

    @Test
    public void testRecursiveFibonacciShouldReturnFibonacciOfTen() {
        int expected = 55;
        int result = recursiveFibonacci(10);
        assertEquals(expected, result);
    }

    @Test
    public void testIterativeFibonacciShouldReturnFibonacciOfZero() {
        int expected = 0;
        int result = iterativeFibonacci(0);
        assertEquals(expected, result);
    }

    @Test
    public void testIterativeFibonacciShouldReturnOneForFibonacciOfOne() {
        int expected = 1;
        int result = iterativeFibonacci(1);
        assertEquals(expected, result);
    }

    @Test
    public void testIterativeFibonacciShouldReturnOneForFibonacciOfTwo() {
        int expected = 1;
        int result = iterativeFibonacci(2);
        assertEquals(expected, result);
    }

    @Test
    public void testIterativeFibonacciShouldReturnFibonacciOfThree() {
        int expected = 2;
        int result = iterativeFibonacci(3);
        assertEquals(expected, result);
    }

    @Test
    public void testIterativeFibonacciShouldReturnFibonacciOfFour() {
        int expected = 3;
        int result = iterativeFibonacci(4);
        assertEquals(expected, result);
    }

    @Test
    public void testIterativeFibonacciShouldReturnFibonacciOfTen() {
        int expected = 55;
        int result = iterativeFibonacci(10);
        assertEquals(expected, result);
    }
}
