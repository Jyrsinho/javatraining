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
        linkedList.removeHead();
        assertEquals("Hello1",linkedList.getHead().getData());
    }

    @Test
    public void testShouldRemoveTheTailFromLinkedListWithOneElement() {
        linkedList.addToHead("Hello1");
        linkedList.removeHead();
        assertNull(linkedList.getHead());
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

