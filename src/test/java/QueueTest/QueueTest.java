package QueueTest;

import DataStructures.Queue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {

    @Test
    public void testShouldAddNodesToQueue() throws Exception {
        Queue<String> queue = new Queue<>();
        assertEquals(0, queue.getSize());

        queue.enqueue("a");
        assertEquals(1, queue.getSize());
        assertEquals("a", queue.peek());

        queue.enqueue("b");
        assertEquals(2, queue.getSize());
        assertEquals("a", queue.peek());

        queue.enqueue("c");
        assertEquals(3, queue.getSize());
        assertEquals("a", queue.peek());

    }

    @Test
    public void testShouldNotBeAbleToAddNodesToQueueIfMaximumSizeIsReached() throws Exception {
        Queue<String> queue = new Queue<>(3);
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        Exception thrown = assertThrows(Exception.class, () -> {
            queue.enqueue("d");
        });
        assertEquals("Queue is full", thrown.getMessage());

    }

    @Test
    public void testShouldRemoveNodeFromQueue() throws Exception {
        Queue<String> queue = new Queue<>();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");


        assertEquals("a", queue.dequeue());
        assertEquals("b", queue.peek());
    }

    @Test
    public void testShouldReturnNullWhenTryingToRemoveFromEmptyQueue() {
        Queue<String> queue = new Queue<>();
        assertNull(queue.dequeue());
    }
}
