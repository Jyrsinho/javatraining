package AlgorithmsTwoTest;

import AlgorithmsTwo.DataStructures.Heap.MyPriorityQueue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyPriorityQueueTest {

        @Test
        public void testShouldReturnTrueForEmptyMPQ() {

            MyPriorityQueue mpq = new MyPriorityQueue();
            assertTrue(mpq.isEmpty());

        }
    }


