package LinkedListTest;
import LinkedList.Node;
import LinkedList.DoublyLinkedList;
import org.junit.jupiter.api.BeforeEach;
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
        assertEquals('c' ,doublyLinkedList.getHead());
    }
}
