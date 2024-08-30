package LinkedListTest;

import LinkedList.LinkedList;
import LinkedList.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {

    LinkedList<String> linkedList;

    @BeforeEach
    public void setUp() {
        linkedList = new LinkedList<String>();
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

        Node<String> head = linkedList.getHead();
        Node<String> second = linkedList.getHead().getNextNode();
        Node<String> third = second.getNextNode();

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

    @Test
    public void testShouldReturnOneForLengthOfLinkedListWithOneElement() {
        linkedList.addToHead("Hello1");
        assertEquals(1, linkedList.getLength());
    }

    @Test
    public void testShouldReturThreeForLengthOfLinkedListWithThreeElements() {
        linkedList.addToHead("Hello1");
        linkedList.addToHead("Hello2");
        linkedList.addToHead("Hello3");
        assertEquals(3, linkedList.getLength());
    }

    @Test
    public void testShouldReturnFalseIfLLDoesNotContainData() {
        linkedList.addToHead("Hello1");
        assertFalse(linkedList.contains("Hello2"));
    }

    @Test
    public void testShouldReturnTrueIfLLDoesContainData() {
        linkedList.addToHead("Hello1");
        assertTrue(linkedList.contains("Hello1"));
    }

    @Test
    public void testShouldReturnFalseForContainsWhenLinkedListIsEmpty() {
        assertFalse(linkedList.contains("Hello2"));
    }


    @Test
    public void testShouldRemoveSpesificPieceOfDataFromList1(){
        linkedList.addToHead("Hello1");
        linkedList.addToHead("Hello2");
        linkedList.addToHead("Hello3");
        linkedList.addToHead("Hello4");
        linkedList.remove("Hello2");
        assertFalse(linkedList.contains("Hello2"));
    }

    @Test
    public void testShouldRemoveSpesificPieceOfDataFromListContainingOneElement() {
        linkedList.addToHead("Hello1");
        assertEquals("Hello1", linkedList.remove("Hello1"));
        assertFalse(linkedList.contains("Hello1"));
    }

    @Test
    public void testShouldRemoveNothingWhenGivenDataIsNotInLinkedList() {
        linkedList.addToHead("Hello1");
        linkedList.addToHead("Hello2");
        linkedList.addToHead("Hello3");
        linkedList.addToHead("Hello4");
        assertNull(linkedList.remove("Tomaatti"));
    }

    @Test
    public void testShouldReturnNullWhenTryingToRemoveFromEmptyLinkedList() {
        assertNull(linkedList.remove("Tomaatti"));
    }

    @Test
    public void testShouldRemoveElementFromTheEndOfTheLinkedList() {
        linkedList.addToHead("Hello1");
        linkedList.addToHead("Hello2");
        linkedList.addToHead("Hello3");
        linkedList.addToHead("Hello4");
        assertEquals("Hello4",linkedList.remove("Hello4"));
        assertFalse(linkedList.contains("Hello4"));
    }

    @Test
    public void testShouldRemoveElementFromTheBeginningOfTheLinkedList() {
        linkedList.addToHead("Hello1");
        linkedList.addToHead("Hello2");
        linkedList.addToHead("Hello3");
        linkedList.addToHead("Hello4");
        assertEquals("Hello1",linkedList.remove("Hello1"));
        assertFalse(linkedList.contains("Hello1"));
    }

    @Test
    public void testShouldReturnListAsAString() {
        linkedList.addToHead("A");
        linkedList.addToHead("B");
        linkedList.addToHead("C");
        assertEquals("CBA", linkedList.getList());
    }

    @Test
    public void testShouldPrintOutErrorIfThereIsNoGIvenDataInTheList() throws Exception {
        linkedList.addToHead("C");
        linkedList.addToHead("B");

        Exception exception = assertThrows(Exception.class, () -> {
            linkedList.swap("A", "B");
        });
        assertEquals(exception.getMessage(),"The list does not contain given data");

    }

    @Test
    public void testShouldSwapTwoElementsInTHeMiddleOFTheList() throws Exception {
        linkedList.addToHead("A");
        linkedList.addToHead("B");
        linkedList.addToHead("C");
        linkedList.addToHead("D");
        linkedList.addToHead("E");
        linkedList.swap("D","B");
        assertEquals("EBCDA",linkedList.getList());
    }

    @Test
    public void testShouldSwapTwoElementsNextToEachOtherInTheMiddleOfTheList() throws Exception {
        linkedList.addToHead("A");
        linkedList.addToHead("B");
        linkedList.addToHead("C");
        linkedList.addToHead("D");

        linkedList.swap("B","C");
        assertEquals("DBCA",linkedList.getList());
    }

     @Test
     public void testShouldSwapTwoElementsWhenOneIsTheHeadAndOtherIsTheTail() throws Exception {
        linkedList.addToHead("A");
        linkedList.addToHead("B");
        linkedList.addToHead("C");
        linkedList.addToHead("D");
        linkedList.swap("A","D");
        assertEquals("ACBD",linkedList.getList());
     }

     @Test
     public void testShouldSwapTwoElementsInAListWithTwoElements() throws Exception {
         linkedList.addToHead("A");
         linkedList.addToHead("B");
         linkedList.swap("A", "B");
         assertEquals("AB", linkedList.getList());
     }

     @Disabled
     public void testShouldThrowExceptionWhenTryingToSwapWhenTheListIsEmpty() throws Exception {

     }




    // -----------------------------------------------------------------

    public String getTail(LinkedList<String> linkedList) {
        Node<String> currentNode = linkedList.getHead();
        while (currentNode.getNextNode() != null) {
            currentNode = currentNode.getNextNode();
        }
        return (String) currentNode.getData();
    }


}

