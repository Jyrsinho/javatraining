package AlgorithmsTwoTest;

import AlgorithmsTwo.DataStructures.Heap.MyPriorityQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyPriorityQueueTest {

    MyPriorityQueue mpq;
    @BeforeEach
    public void setUp() {
        mpq = new MyPriorityQueue(5);
    }

    @Test
    public void testShouldReturnFiveForNewMPQCapacity() {
        assertEquals(5, mpq.capacity());
    }
    @Test
    public void testShouldReturnTrueForEmptyMPQ() {
            assertTrue(mpq.isEmpty());
    }

    @Test
    public void testShouldReturnFalseForNonEmptyMPQ() {
        mpq.push(5);
        assertFalse(mpq.isEmpty());
    }

    @Test
    public void testShouldAddElementToTopOfEmptyMPQ() {
        mpq.push(4);
        assertEquals(4, mpq.top());
    }

    @Test
    public void testShouldAddNewTop() {
        mpq.push(2);
        mpq.push(1);
        assertEquals(1, mpq.top());
        assertEquals(2, mpq.size());

    }

    @Test
    public void testShouldAddOneBelowTop() {
        mpq.push(1);
        mpq.push(2);
        assertEquals(1, mpq.top());
    }

    @Test
    public void testShouldAddTwoNewTops() {
        mpq.push(3);
        mpq.push(2);
        mpq.push(1);
        assertEquals(1, mpq.top());
    }

    @Test
    public void testShouldAddthreeNewTops() {
        mpq.push(5);
        mpq.push(4);
        mpq.push(3);
        mpq.push(2);

        assertEquals(2, mpq.top());
    }

    @Test
    public void testShouldAddFourNewTops() {
        mpq.push(5);
        mpq.push(4);
        mpq.push(3);
        mpq.push(2);
        mpq.push(1);
        assertEquals(2, mpq.top());
    }


}


