package AlgorithmsTwoTest;

import AlgorithmsTwo.MyHeap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeapTest {

    /*
    Tehdaan MinHeap
    Testtaan että kekoon voi
    - lisata alkioita
    - poistaa alkioita
    - heapsort
     */
    MyHeap myHeap;

    @BeforeEach
    public void setup() {
        myHeap = new MyHeap(5);
    }

    @Test
    public void testShouldAddElementToHeap() {
        myHeap.insert(1);
        assertEquals(1, myHeap.peek());
    }

    @Test
    public void testShouldAddNewTopToHeap() {
        myHeap.insert(2);
        myHeap.insert(1);
        myHeap.printHeap();
        assertEquals(1, myHeap.peek());
    }
    @Test
    public void testShouldAddTwoNewTops() {
        myHeap.insert(3);
        myHeap.insert(2);
        myHeap.insert(1);
        assertEquals(1, myHeap.peek());
    }

    @Test
    public void testHeapShouldAllocateNewSpace() {
        myHeap.insert(6);
        myHeap.insert(5);
        myHeap.insert(3);
        myHeap.insert(2);
        myHeap.insert(1);
        myHeap.insert(4);
        assertEquals(10, myHeap.getCapacity());
        assertEquals(1, myHeap.peek());

    }

    @Test
    public void testHeapShouldReturnNegativeOneWhenTryingToRemoveFromEmptyHeap() {
        assertEquals(-1, myHeap.extract());
    }

    @Test
    public void testHeapShouldRemoveOnlyElementFromHeap(){
        myHeap.insert(1);
        assertEquals(1, myHeap.extract());
        assertEquals(0, myHeap.getSize());

    }

    @Test
    public void testHeapShouldRemoveElementFromHeapAndSetNewTop(){
        myHeap.insert(1);
        myHeap.insert(2);
        assertEquals(1, myHeap.extract());
        assertEquals(2, myHeap.peek());
    }

    @Test
    public void testHeapShouldRemoveElementFromHeapAndSetNewTop2(){
        myHeap.insert(5);
        myHeap.insert(4);
        myHeap.insert(3);
        myHeap.insert(2);
        myHeap.insert(1);
        myHeap.printHeap();
        assertEquals(1,myHeap.extract());
        System.out.println();
        myHeap.printHeap();
        assertEquals(2, myHeap.extract());
        assertEquals(3, myHeap.extract());

    }

    @Test
    public void testHeapSortShouldReturnEmptyArrayWhenGivenEmptyArray() {
        int[] testArray = {};
        int[] sortedArray = myHeap.heapsort(testArray);
        int[] expected = {};
        assertArrayEquals(expected, sortedArray);

    }

}
