package QueueTest;

import DataStructures.Queue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueueTest {

    @Test
    public void testShouldAddNodesToQueue() {
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
    public void testShouldRemoveNodeFromQueue() {
        Queue<String> queue = new Queue<>();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");

        assertEquals("a", queue.dequeue());
        assertEquals("b", queue.peek());
    }
}
