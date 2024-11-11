package StackTest;

import DataStructures.Stack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest {

    Stack<Character> abcdStack;

    @BeforeEach
    public void setUp() {
        abcdStack = new Stack<>();
        abcdStack.push('d');
        abcdStack.push('c');
        abcdStack.push('b');
        abcdStack.push('a');

    }

    @Test
    public void testShouldPushElementsToStack() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.getSize());
    }

    @Test
    public void testShouldThrowStackOverflowException() {
        Stack<Integer> stack = new Stack<>(2);
        stack.push(1);
        stack.push(2);
        assertThrows(StackOverflowError.class, () -> {
            stack.push(4);
        });
    }

    @Test
    public void testShouldPeekElementFromStack() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.peek());
        assertEquals(3, stack.peek());
        assertEquals(3, stack.getSize());
    }

    @Test
    public void testShouldThrowNoSuchElementExceptionWhenPeekingEmptyStack() {
        Stack<Integer> stack = new Stack<>();
        assertThrows(NoSuchElementException.class, stack::peek);
    }

    @Test
    public void testShouldPopElementFromStack() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.pop());
        assertEquals(1, stack.peek());
        assertEquals(1, stack.getSize());
    }

    @Test
    public void testShouldThrowNoSuchElementExceptionWhenPoppingEmptyStack() {
        Stack<Integer> stack = new Stack<>();
        assertThrows(NoSuchElementException.class, stack::pop);

    }

    @Test
    public void testShouldReturnTrueForIsThereWhenLookingForElementThatStackHas() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertTrue(stack.isThere(1));
    }

    @Test
    public void testShouldReturnFalseForWhenLookingForElementThatStackHasNot() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);

        assertFalse(stack.isThere(4));
    }

    @Test
    public void testShouldLeaveStackUnchangedWhenExitinIsThereMethod() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        stack.isThere(3);
        assertEquals(3, stack.getSize());
        assertEquals(3, stack.peek());

    }

    @Test
    public void testShouldRotateTheStacksTwoTopElements() {

        abcdStack.rotate(1);
        assertEquals('b', abcdStack.pop());
        assertEquals('a', abcdStack.pop());
    }

    @Test
    public void testShouldRotateTheStacksThreeTopElements() {

        abcdStack.rotate(2);
        assertEquals('b', abcdStack.pop());
        assertEquals('c', abcdStack.pop());
        assertEquals('a', abcdStack.pop());

    }

    @Test
    public void testShouldRotateTheStacksFourTopElements() {
        abcdStack.rotate(3);
        assertEquals('b', abcdStack.pop());
        assertEquals('c', abcdStack.pop());
        assertEquals('d', abcdStack.pop());
        assertEquals('a', abcdStack.pop());
    }

    @Test
    public void testShouldNotRotate() {
        abcdStack.rotate(0);
        assertEquals('a', abcdStack.pop());
        assertEquals('b', abcdStack.pop());
        assertEquals('c', abcdStack.pop());
        assertEquals('d', abcdStack.pop());
    }
}
