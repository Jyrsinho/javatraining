package LinkedListStringTest;

import LinkedList.Node;
import LinkedListString.LinkedListString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class LinkedListStringTest {

    LinkedListString lsString;
    LinkedListString lsString1;
    LinkedListString lsString2;


    @BeforeEach
    void setUp() {
        lsString = new LinkedListString();
        lsString1 = new LinkedListString();
        lsString2 = new LinkedListString();

        lsString1.append('a');
        lsString1.append('b');
        lsString1.append('c');

        lsString2.append('d');




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
    public void testShouldReturnHeadWhenAskingCharacterAt0InListWithSingleElement() {
        lsString.append('c');
        Character expected = 'c';
        assertEquals(expected, lsString.charAt(0));
    }

    @Test
    public void testShouldReturnHeadWhenAskingCharacterAt0InListWithMultipleElements() {
        lsString.append('d');
        lsString.append('e');
        lsString.append('f');
        assertEquals('d', lsString.charAt(0));
    }

    @Test
    public void testShouldReturnSecondElemetnWhenAskingCharacterAt1InListWithMultipleElements() {
        lsString.append('c');
        lsString.append('d');
        lsString.append('e');

        assertEquals('d', lsString.charAt(1));
    }

    @Test
    public void testShouldReturnTailWhenAskingCharacterAt2InListWithThreeElements() {
        lsString.append('c');
        lsString.append('d');
        lsString.append('e');
        assertEquals('e', lsString.charAt(2));
    }

    @Test
    public void testShouldReturnNullWhenAskingCharacterAt1InListWithSingleElement() {
        lsString.append('c');
        assertNull(lsString.charAt(1));
    }

    @Test
    public void testShouldReturnNullWhenAskingCharacterAtZeroInListWithZeroElements() {
        assertNull(lsString.charAt(0));
    }

    @Test
    public void testShouldConcatenateTwoLSStringsWhenSecondHasOnlyOneElement() {
        lsString.concatenate(lsString1, lsString2); //lsString1: a,b,c //lsString2: d
        Character expected = 'a';
        assertEquals(expected, lsString.getHead().getData());
        assertEquals('d',getTail(lsString));
        lsString.printString();
    }

    @Test
    public void testShouldConcatenateTwoLSStringsWhenSecondHasOnlyOneElements() {
        lsString2.append('e');
        lsString2.append('f');

        lsString.concatenate(lsString1, lsString2); //lsString1: a,b,c //lsString2: d,e,f
        assertEquals('f',getTail(lsString));
        lsString.printString();
    }

    @Test
    public void testShouldReturnRemovedCharacterWhenRemovingOneElementFromListWithOneElement() {
        lsString.append('c');
        assertEquals('c', lsString.remove(0));
    }

    @Test
    public void testShouldReturnRemovedCharacterWhenRemovingOneElementFromListWithMultipleElements() {
        assertEquals('b',lsString1.remove(1)); // lsString1: a, b, c

    }

    @Test
    public void testShouldRemoveListMiddleWhenCallingRemoveIndexOneAndListHasThreeElements() {
        assertEquals('b', lsString1.remove(1)); // lsString: a,b,c
    }

    @Test
    public void testShouldRemoveListEndWhenCallingRemoveIndexOneAndListHasThreeElements() {
        assertEquals('c', lsString1.remove(2)); // lsString: a,b,c
    }

    @Test
    public void testShouldRetainListIntegrityWhenRemovingFromTheMiddleOfTheList() {
        assertEquals('b', lsString1.remove(1)); // lsString: a,b,c
        assertEquals('c', lsString1.getHead().getNextNode().getData());
        assertEquals('a', lsString1.getHead().getData());
    }

    @Test
    public void testShouldRemoveFromTheEndOfTheList() {
        assertEquals('c', lsString1.remove(2));
        assertEquals('b', lsString1.getHead().getNextNode().getData());
        assertEquals('a', lsString1.getHead().getData());
    }

    @Test
    public void testShouldRemoveOneCharacterFromTheBeginning() {
        lsString1.removeCharsFrom(0,1);
        assertEquals('b', lsString1.getHead().getData());
    }

    @Test
    public void testShouldRemoveAllCharactersFromTheList() {
        lsString1.removeCharsFrom(0,3);
        assertNull(lsString1.getHead());
    }

    @Test
    public void testShouldRemoveOneCharacterFromTheMiddleOfThreeElementList() {
        lsString1.removeChars(1,1);     //lsString1 == abc
        assertEquals("ac", lsString1.getString());
    }

    @Test
    public void testShouldRemoveTwoFirstCharactersFromTheListOfFourElements() {
        lsString.append('a');
        lsString.append('b');
        lsString.append('c');
        lsString.append('d');
        lsString.removeChars(0,2);
        assertEquals("cd", lsString.getString());
    }

    @Test
    public void testShouldRemoveTwoLastCharactersFromTheListOfFourElements() {
        lsString.append('a');
        lsString.append('b');
        lsString.append('c');
        lsString.append('d');
        lsString.removeChars(2,2);
        assertEquals("ab", lsString.getString());
    }


    @Test
    public void testShouldRemoveAllCharactersFromTheList2() {

        lsString1.removeChars(0,3);
        assertNull(lsString1.getHead());
    }


    @Test
    public void testShouldDoNothingWhenGivenStartingIndexOutsideListsLenght() {
        lsString1.removeChars(4,2);
        assertEquals("abc", lsString1.getString());

    }

    @Test
    public void testShouldRemoveAlCharactersItCanWhenGivenBiggerAmountToRemoveThanThereAreElementsInTheList() {
        lsString1.removeChars(0,4);
        assertNull(lsString1.getHead());

    }

    public Character getTail (LinkedListString lsString) {
        Node<Character> current = lsString.getHead();
        while (current.getNextNode() != null) {
            current = current.getNextNode();
        }
        return current.getData();
    }

}
