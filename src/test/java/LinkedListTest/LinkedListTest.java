package LinkedListTest;

import LinkedList.LinkedList;
import LinkedList.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Disabled
    public void testAddNewTailToLinkedList() {
        linkedList.addToHead("Hello1"); // Hello1, Hello2
        linkedList.addToTail("Hello2");

        assertEquals("Hello2",linkedList.getTail().getData());
        assertEquals("Hello2",linkedList.getHead().getNextNode().getData());

    }

    @Test
    public void testShouldAddNewTailToEmptyLinkedList() {
        linkedList.addToTail("Hello1");

        assertEquals("Hello1",linkedList.getTail().getData());
        assertEquals("Hello1",linkedList.getHead().getData());
    }

    @Disabled
    public void testShouldReturnSameNodeAsHeadAndTailIfNodeIsAddedToEmptyLinkedList() {
        linkedList.addToHead("Hello1");

        assertEquals("Hello1",linkedList.getHead().getData());
        assertEquals("Hello1",linkedList.getTail().getData());
    }

}

