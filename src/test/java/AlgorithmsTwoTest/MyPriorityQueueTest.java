package AlgorithmsTwoTest;

import AlgorithmsTwo.DataStructures.Heap.MyPriorityQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyPriorityQueueTest {

    MyPriorityQueue mpq;
    MyPriorityQueue mpqNumbersOneToThree;
    @BeforeEach
    public void setUp() {
        mpq = new MyPriorityQueue(5);
        mpqNumbersOneToThree = new MyPriorityQueue(5);
        mpqNumbersOneToThree.push(1);
        mpqNumbersOneToThree.push(2);
        mpqNumbersOneToThree.push(3);
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
        mpq.tulosta();
        assertEquals(1, mpq.top());
    }

    @Test
    public void testShouldUpdateCapacity() {
        mpq.push(5);
        mpq.push(4);
        mpq.push(3);
        mpq.push(2);
        assertEquals(5, mpq.capacity());
        mpq.push(1);
        assertEquals(10, mpq.capacity());

    }

    @Test
    public void testPopShouldRemoveTopItem() {
        mpqNumbersOneToThree.tulosta();

        System.out.println();
        System.out.println("-----------------------");
        System.out.println();
        assertEquals(1 , mpqNumbersOneToThree.pop());
        mpqNumbersOneToThree.tulosta();

    }

    @Test
    public void testPopShouldRemoveTopItemAndSetNewTopItem() {
        mpq.push(4);
        mpq.push(5);
        mpq.pop();

        mpq.tulosta();
        assertEquals(5, mpq.top());

    }

    @Test
    public void testPopShouldKnowHowToFixItself() {
        mpqNumbersOneToThree.tulosta();
        mpqNumbersOneToThree.pop();
        System.out.println();
        mpqNumbersOneToThree.tulosta();
        assertEquals(mpqNumbersOneToThree.top(), 2);
    }


}


