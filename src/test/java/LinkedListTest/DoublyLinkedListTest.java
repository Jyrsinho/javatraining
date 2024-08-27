package LinkedListTest;
import LinkedList.Node;
import LinkedList.DoublyLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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
        assertNull(doublyLinkedList.removeHead());
    }

    @Test
    public void testShouldReturnNullWhenRemovingTheHeadFromListWithOneElement() {
        doublyLinkedList.addToHead('c');
        assertEquals('c',doublyLinkedList.removeHead());
    }

    @Test
    public void testShouldRemoveHeadFromListWithMultipleElements() {
        doublyLinkedList.addToTail('c');
        doublyLinkedList.addToTail('d');
        doublyLinkedList.addToTail('e');

        assertEquals('c',doublyLinkedList.removeHead());
        assertEquals('d',doublyLinkedList.getHead().getData());
        assertEquals('e',doublyLinkedList.getHead().getNextNode().getData());

    }

    @Test
    public void testShouldRemoveHeadAndTailWhenRemovingFromListWithOneElement() {
        doublyLinkedList.addToHead('c');
        assertEquals('c',doublyLinkedList.removeHead());
        assertNull(doublyLinkedList.getHead());
        assertNull(doublyLinkedList.getTail());
    }

    @Test
    public void testShouldReturnNullWhenTryingToRemoveTailFromEmptyList() {
        assertNull(doublyLinkedList.removeTail());
    }

    @Test
    public void testShouldRemoveTailFromListWithMultipleElements() {
        doublyLinkedList.addToTail('c');
        doublyLinkedList.addToTail('d');
        doublyLinkedList.addToTail('e');
        assertEquals('e',doublyLinkedList.removeTail());
        assertEquals('d',doublyLinkedList.getTail().getData());
        assertEquals('c',doublyLinkedList.getTail().getPrevNode().getData());
    }

    @Test
    public void testShouldRemoveTailAndHeadFromListWithOneElement() {
        doublyLinkedList.addToHead('c');
        assertEquals('c',doublyLinkedList.removeTail());
        assertNull(doublyLinkedList.getHead());
        assertNull(doublyLinkedList.getTail());
    }

    @Test
    public void testShouldReturnHeadsDataAndRemoveTheHeadIfRemoveByDataFindsElementFromTheHead() {
        doublyLinkedList.addToHead('c');
        doublyLinkedList.addToTail('d');
        doublyLinkedList.addToTail('e');
        assertEquals('c',doublyLinkedList.removeByData('c'));
        assertEquals('d',doublyLinkedList.getHead().getData());
    }

    @Test
    public void testShouldRemoveElementFromMiddleOfTheListWithRemoveByDataMethod() {
        doublyLinkedList.addToHead('c');
        doublyLinkedList.addToTail('d');
        doublyLinkedList.addToTail('e');
        assertEquals('d',doublyLinkedList.removeByData('d'));
        assertEquals('e',doublyLinkedList.getHead().getNextNode().getData());
    }

    @Test
    public void testShouldReturnTheLengthOfTheDoublyLinkedListWhenListIsEmpty(){
        assertEquals(0, doublyLinkedList.getLength());
    }

    @Test
    public void testShouldReturnTheLengthOfTheDoublyLinkedListWhenListHasOneElement(){
        doublyLinkedList.addToHead('c');
        assertEquals(1, doublyLinkedList.getLength());
    }

    @Disabled
    public void testShouldReturnTheLengthOfTheDoublyLinkedListWhenListHasMultipleElements() {
        doublyLinkedList.addToHead('c');
        doublyLinkedList.addToTail('d');
        doublyLinkedList.addToTail('e');
        assertEquals(3, doublyLinkedList.getLength());
    }
}

