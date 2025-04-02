package AlgorithmsTwoTest;

import AlgorithmsTwo.DataStructures.Heap.MyPriorityQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyPriorityQueueTest {

    MyPriorityQueue mpq;
    @BeforeEach
    public void setUp() {
        mpq = new MyPriorityQueue();
    }
        @Test
        public void testShouldReturnTrueForEmptyMPQ() {

            assertTrue(mpq.isEmpty());

        }

        @Test
        public void testShouldReturnFalseForNonEmptyMPQ() {

        }
    }


