package LinkedListStringTest;

import LinkedListString.LinkedListString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedListStringTest {

    @BeforeEach
    void setUp() {

    }

    @Test
    public void testShouldAppendCharacterToEmptyLinkedList() {
        LinkedListString lsString = new LinkedListString();
        lsString.append('c');
        Character expected = 'c';
        assertEquals(expected, lsString.getHead().getData());
        lsString.printString();

    }

}
