package LinkedListTest;

import LinkedList.LinkedList;
import LinkedList.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class LinkedListTest {

    LinkedList linkedList;

    @BeforeEach
    public void setUp() {
        linkedList = new LinkedList();
    }

    @Test
    public void testShouldAddNewHeadToLinkedList() {
        linkedList.addToHead("Hello1");
        assertEquals("Hello1",linkedList.getHead().getData());
    }

    @Test
    public void testNewHeadShouldLinkToTheOldHead() {
        linkedList.addToHead("Hello1");
        linkedList.addToHead("Hello2");
        linkedList.addToHead("Hello3");

        Node head = linkedList.getHead();
        Node second = linkedList.getHead().getNextNode();
        Node third = second.getNextNode();

        assertEquals("Hello2",second.getData());
        assertEquals("Hello1",third.getData());
    }


    @Test
    public void testShouldAddNewTailToEmptyLinkedList() {
        linkedList.addToTail("Hello1");

        assertEquals("Hello1",linkedList.getHead().getData());
    }


    @Test
    public void testAddNewTailToLinkedList() {
        linkedList.addToHead("Hello1"); // Hello1, Hello2
        linkedList.addToTail("Hello2");

        assertEquals("Hello2",linkedList.getHead().getNextNode().getData());

    }

    @Test
    public void testAddNewTailToLinkedList2() {
        linkedList.addToTail("Hello1");
        linkedList.addToTail("Hello2");
        linkedList.addToTail("Hello3");
        assertEquals("Hello3",getTail(linkedList));
    }

    @Test
    public void testShouldRemoveTheHeadFromLinkedList() {
        linkedList.addToHead("Hello1");
        linkedList.addToHead("Hello2");
        assertEquals("Hello2",linkedList.removeHead());
    }

    @Test
    public void testShouldRemoveTheTailFromLinkedListWithOneElement() {
        linkedList.addToHead("Hello1");
        assertEquals("Hello1",linkedList.removeHead());
        assertNull(linkedList.getHead());
    }

    @Test
    public void testShouldReturnNullWhenTryingToRemoveHeadFromEmptyLinkedList() {
        assertNull(linkedList.removeHead());
    }

    @Test
    public void testShouldPrintEmptyLinkedListWithMarkersForTailAndHead() {
        String expected = "<head>: <tail>";
        assertEquals(expected, linkedList.printList());

    }

    @Test
    public void testShouldPrintLinkedListWithOneElement() {
        linkedList.addToHead("Hello1");
        String expected = "<head>: Hello1<tail>";
        assertEquals(expected, linkedList.printList());
    }

    @Test
    public void testShouldPrintLinkedListWithThreeElements() {
        linkedList.addToHead("Hello3");
        linkedList.addToHead("Hello2");
        linkedList.addToHead("Hello1");
        String expected = "<head>: Hello1, Hello2, Hello3<tail>";
        assertEquals(expected, linkedList.printList());
    }

    @Test
    public void testShouldRemoveTheTailFromListWithOneElement() {
        linkedList.addToHead("Hello1");
        linkedList.removeTail();
        assertEquals(linkedList.removeTail(),"Hello1");

    }

    @Test
    public void testShouldRemoveTheTailFromListWithThreeElements() {
        linkedList.addToHead("Hello1");
        linkedList.addToHead("Hello2");
        linkedList.addToHead("Hello3");
        linkedList.removeTail();
        assertEquals(linkedList.removeTail(),"Hello1");

    }

    @Test
    public void testShouldReturnZeroForLengthOfEmptyLinkedList() {
        assertEquals(0, linkedList.getLength());
    }

    // -----------------------------------------------------------------

    public String getTail(LinkedList linkedList) {
        Node currentNode = linkedList.getHead();
        while (currentNode.getNextNode() != null) {
            currentNode = currentNode.getNextNode();
        }
        return currentNode.getData();
    }


}

