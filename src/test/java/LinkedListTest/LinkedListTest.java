package LinkedListTest;

import DataStructures.LinkedList;
import DataStructures.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {

    LinkedList<String> linkedList;
    LinkedList<Character> linkedListChar;

    @BeforeEach
    public void setUp() {

        linkedList = new LinkedList<String>();
        linkedListChar = new LinkedList<Character>();

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

     @Test
     public void testShouldSwapTwoElementsInTheTailEndOfTheList() throws Exception {
        linkedList.addToHead("A");
        linkedList.addToHead("B");
        linkedList.addToHead("C");
        linkedList.addToHead("D");
        linkedList.swap("A","B");
        assertEquals("DCAB",linkedList.getList());
     }

     @Test
     public void testShouldSwapTwoElementsInTheHeadOfTheList() throws Exception {
        linkedList.addToHead("A");
        linkedList.addToHead("B");
        linkedList.swap("A","B");
        assertEquals("AB",linkedList.getList());
     }

     @Test
     public void testShouldThrowExceptionWhenTryingToSwapWhenTheListIsEmpty() throws Exception {
         Exception exception = assertThrows(Exception.class, () -> {
             linkedList.swap("A", "B");
         });
         assertEquals(exception.getMessage(),"The list does not contain given data");
     }

     @Test
     public void testShouldReturnTheTailWithGetNthLastElementParameter0()   {
        linkedList.addToHead("A");
        linkedList.addToHead("B");
        linkedList.addToHead("C");
        assertEquals("A", linkedList.getNthLastElement(0));
     }

     @Test
     public void testShouldReturnTheElementTwoStepsFromTailWithGetNthLastElementParameter2()   {
         linkedList.addToHead("A");
         linkedList.addToHead("B");
         linkedList.addToHead("C");
         assertEquals("C", linkedList.getNthLastElement(2));
     }

     @Test
     public void testShouldReturnTheHeadWhenCallingGetNthLastWithParameterZeroListOfOne() {
        linkedList.addToHead("A");
        assertEquals("A", linkedList.getNthLastElement(0));
     }

     @Test
     public void testShouldReturnNullWhenCallingGetNthLastWithParameterHigherThanListLentgt() {
        linkedList.addToHead("A");
        linkedList.addToHead("B");
         assertNull(linkedList.getNthLastElement(2));

     }

     @Test
     public void testShouldReturnTail() {
        linkedList.addToHead("A");
        linkedList.addToHead("B");
        linkedList.addToHead("C");
        assertEquals("A", linkedList.getTail().getData());
     }

     @Test
     public void testShouldReturnTheHeadAndTail() {
        linkedList.addToHead("A");
        assertEquals("A", linkedList.getTail().getData());
     }

     @Test
     public void testShouldReturnNullWhenAskingForTailFromEmptyList() {
        assertNull(linkedList.getTail());
     }

     @Test
     public void testShouldCreateListRepresentationOfIntegerLessThanTen() {

        LinkedList<Integer> integerList = linkedList.intToList(4);
        assertEquals(4, integerList.getHead().getData());

     }

     @Test
     public void testShouldCreateListRepresentationOfIntegerInThousands() {
         LinkedList<Integer> integerList = linkedList.intToList(1210);
         assertEquals("1210", integerList.getList());
         assertEquals(integerList.getHead().getData(), 1);
         assertEquals(integerList.getHead().getNextNode().getData(),2);
    }

    @Test
    public void testShouldCreateListRepresentationOfIntegerZero() {
        LinkedList<Integer> integerList = linkedList.intToList(0);
        assertEquals("0", integerList.getList());
        assertEquals(integerList.getHead().getData(), 0);
    }

    @Test
    public void testShouldSumUpTwoIntegerListsWithOneElement() {
        LinkedList<Integer> integerList1 = linkedList.intToList(3);
        LinkedList<Integer> integerList2 = linkedList.intToList(5);

        LinkedList<Integer> sumList = linkedList.sumOfLists(integerList1, integerList2);
        String expected = "8";
        assertEquals(expected, sumList.getList());
    }

    @Test
    public void testShouldSumUpTwoIntegerListsWithThreeElements() {
        LinkedList<Integer> integerList1 = linkedList.intToList(321);
        LinkedList<Integer> integerList2 = linkedList.intToList(654);

        LinkedList<Integer> sumList = linkedList.sumOfLists(integerList1, integerList2);
        String expected = "975";
        assertEquals(expected, sumList.getList());
    }

    @Test
    public void testShouldSumUpTwoIntegerListsWithOneElementWhenSumIsMoreThanTen() {
        LinkedList<Integer> integerList1 = linkedList.intToList(5);
        LinkedList<Integer> integerList2 = linkedList.intToList(6);

        LinkedList<Integer> sumList = linkedList.sumOfLists(integerList1, integerList2);
        String expected = "11";
        assertEquals(expected, sumList.getList());
    }

    @Test
    public void testShouldSumUpTwoIntegerListsWithDifferentLengths() {
        LinkedList<Integer> integerList1 = linkedList.intToList(50);
        LinkedList<Integer> integerList2 = linkedList.intToList(102);

        LinkedList<Integer> sumList = linkedList.sumOfLists(integerList1, integerList2);
        String expected = "152";
        assertEquals(expected, sumList.getList());
    }

    @Test
    public void testShouldSumUpTwoIntegerListsWithAddedValuesHigherThanTen() {
        LinkedList<Integer> integerList1 = linkedList.intToList(543);
        LinkedList<Integer> integerList2 = linkedList.intToList(1678);

        LinkedList<Integer> sumList = linkedList.sumOfLists(integerList1, integerList2);
        String expected = "2221";
        assertEquals(expected, sumList.getList());
    }


    @Test
    public void testShouldReturnMiddleNodeTwoOftheListWithThreeElements() {
        linkedListChar.addToHead('C');
        linkedListChar.addToHead('B');
        linkedListChar.addToHead('A');
        assertEquals('B', linkedListChar.getMiddle());
    }

    @Test
    public void testShouldReturnMiddleNodeThreeOftheListWithFiveElements() {
        linkedListChar.addToHead('E');
        linkedListChar.addToHead('D');
        linkedListChar.addToHead('C');
        linkedListChar.addToHead('B');
        linkedListChar.addToHead('A');
        assertEquals('C', linkedListChar.getMiddle());
    }

    @Test
    public void testShouldReturnRighWeightedMiddleFromListWithFourElements() {
        linkedListChar.addToHead('A');
        linkedListChar.addToHead('B');
        linkedListChar.addToHead('C');
        linkedListChar.addToHead('D');
        assertEquals('B', linkedListChar.getMiddle());
    }

    @Test
    public void testShouldReturnNullWhenLinkedListHasLessThanThreeElements (){
        linkedListChar.addToHead('A');
        linkedListChar.addToHead('B');
        assertNull(linkedListChar.getMiddle());
    }

    @Test
    public void testShouldReturnNullWhenLinkedListHasNoElements (){
        assertNull(linkedListChar.getMiddle());
    }

    @Test
    public void testShouldMoveFirstElementToLastElement() {
        linkedListChar.addToHead('A');
        linkedListChar.addToHead('B');
        linkedListChar.addToHead('C');
        linkedListChar.addToHead('D');
        linkedListChar.firstToLast();

        assertEquals(linkedListChar.getTail().getData(), 'D');
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

