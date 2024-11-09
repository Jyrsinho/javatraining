package StackTest;

import DataStructures.Stack;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest {

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
}
