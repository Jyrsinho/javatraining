package LinkedListTest;
import LinkedList.Node;
import LinkedList.DoublyLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoublyLinkedListTest {

    private DoublyLinkedList<Character> doublyLinkedList;

    @BeforeEach
    public void setUp()  {
        doublyLinkedList = new DoublyLinkedList<Character>();
    }

    @Test
    public void testAddHeadToEmptyList() {
        doublyLinkedList.addToHead('c');
        assertEquals('c' ,doublyLinkedList.getHead().getData());
    }

    @Test
    public void testShouldAddHeadAndTailToSameElementWhenAddingHeadToEmptyList() {
        doublyLinkedList.addToHead('c');
        assertEquals('c', doublyLinkedList.getHead().getData());
        assertEquals('c', doublyLinkedList.getTail().getData());
    }

    @Test
    public void testAddHeadToListWithOneElement() {
        doublyLinkedList.addToHead('c');
        doublyLinkedList.addToHead('d');
        assertEquals('d',doublyLinkedList.getHead().getData());
        assertEquals('c',doublyLinkedList.getTail().getData());
    }

    @Test
    public void testAddHeadToListWithThreeElements() {
        doublyLinkedList.addToHead('c');
        doublyLinkedList.addToHead('d');
        doublyLinkedList.addToHead('e');

        assertEquals('e',doublyLinkedList.getHead().getData());
        assertEquals('c',doublyLinkedList.getTail().getData());
        assertEquals('d',doublyLinkedList.getHead().getNextNode().getData());
        assertEquals('d',doublyLinkedList.getTail().getPrevNode().getData());
    }

    @Test
    public void testShouldAddTailToEmptyList() {
        doublyLinkedList.addToTail('c');
        assertEquals('c',doublyLinkedList.getTail().getData());
    }

    @Test
    public void testShouldAddTheSameTailAndHeadWhenAddingTailToEmptyList() {
        doublyLinkedList.addToTail('c');
        assertEquals('c',doublyLinkedList.getTail().getData());
        assertEquals('c',doublyLinkedList.getHead().getData());
    }

    @Test
    public void testShouldAddTheTailToAListWithOneElementWithoutUpdatingTheHead() {
        doublyLinkedList.addToHead('b');
        doublyLinkedList.addToTail('c');
        assertEquals('c',doublyLinkedList.getTail().getData());
        assertEquals('b',doublyLinkedList.getHead().getData());
    }

    @Test
    public void testShouldAddNewTailAndUpdateThePreviousValueOfTheNewTail() {
        doublyLinkedList.addToHead('c');
        doublyLinkedList.addToTail('d');
        assertEquals('c', doublyLinkedList.getTail().getPrevNode().getData());
        assertEquals('d', doublyLinkedList.getHead().getNextNode().getData());
    }

    @Test
    public void testShouldAddNewTailToListWithTwoElementsAndUpdateTheNextAndPreviousValues() {
        doublyLinkedList.addToTail('c');
        doublyLinkedList.addToTail('d');
        doublyLinkedList.addToTail('e');
        assertEquals('e',doublyLinkedList.getTail().getData());
        assertEquals('d',doublyLinkedList.getTail().getPrevNode().getData());
        assertEquals('d',doublyLinkedList.getHead().getNextNode().getData());

    }

    @Test
    public void testShouldReturnNullWhenTryingToRemoveHeadOfAnEmptyList() {
        assertEquals(null, doublyLinkedList.removeHead());
    }
}

