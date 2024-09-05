package StackTest;

import DataStructures.Stack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

}
