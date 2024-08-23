package LinkedListTest;

import LinkedList.LinkedList;
import LinkedList.Node;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedListTest {

    @Test
    public void testShouldAddNewHeadToLinkedList() {
        LinkedList linkedList = new LinkedList();

        linkedList.addToHead("Hello1");

        assertEquals("Hello1",linkedList.getHead());
    }

}

