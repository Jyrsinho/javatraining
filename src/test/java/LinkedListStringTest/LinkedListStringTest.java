package LinkedListStringTest;

import LinkedList.Node;
import LinkedListString.LinkedListString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class LinkedListStringTest {

    LinkedListString lsString;

    @BeforeEach
    void setUp() {
        lsString = new LinkedListString();
    }

    @Test
    public void testShouldAppendCharacterToEmptyLinkedList() {
        lsString.append('c');
        Character expected = 'c';
        assertEquals(expected, lsString.getHead().getData());
        assertNull(lsString.getHead().getNextNode());
        lsString.printString();

    }

    @Test
    public void testShouldAppendCharacterToListWithOneCharacter() {
        lsString.append('c');
        lsString.append('d');

        lsString.printString();
        Character expected = 'c';
        assertEquals(expected, lsString.getHead().getData());
        assertEquals('d', lsString.getHead().getNextNode().getData());

    }

    @Test
    public void testShouldAppendCharacterToListWithMMultipleCharacters() {
        lsString.append('c');
        lsString.append('d');
        lsString.append('e');

        lsString.printString();
        Character expected = 'c';
        assertEquals(expected, lsString.getHead().getData());
        assertEquals('d', lsString.getHead().getNextNode().getData());
        assertEquals('e', getTail(lsString));

    }

    @Test
    public void testShouldCreateStringJyri() {
        lsString.append('J');
        lsString.append('Y');
        lsString.append('R');
        lsString.append('I');
        assertEquals("JYRI", lsString.getString());
    }

    @Test
    public void testShouldReturnHeadWhenAskingCharacterAt0() {
        lsString.append('c');
        Character expected = 'c';
        assertEquals(expected, lsString.charAt(0));
    }


    public Character getTail (LinkedListString lsString) {
        Node<Character> current = lsString.getHead();
        while (current.getNextNode() != null) {
            current = current.getNextNode();
        }
        return current.getData();
    }

}
