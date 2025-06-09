package AlgorithmsTest;

import Algorithms.Heap.MyMaxHeap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyMaxHeapTest {

    MyMaxHeap heap;

    @BeforeEach
    public void setUp() {
        heap = new MyMaxHeap();
    }

    @Test
    public void testShouldAddElementToTopOfEmptyHeap() {
        heap.insert(1);
        int expected = 1;
        int actual = heap.peek();
        assertEquals(expected, actual);
    }

    @Test
    public void testShouldGrowTheSizeOfTheHeap() {
        heap.insert(1);
        int expected = 1;
        int actual = heap.getSize();
        assertEquals(expected, actual);
    }

    @Test
    public void testShouldAddTwoElementsToEmptyHeap() {
        heap.insert(2);
        heap.insert(1);
        int expected = 2;
        int actual = heap.peek();
        assertEquals(expected, actual);
    }

    @Test
    public void testShouldAddFiveElementsAndRemoveThemInOrder() {
        heap.insert(5);
        heap.insert(1);
        heap.insert(10);
        heap.insert(2);
        heap.insert(3);

        assertEquals(10, heap.pop());
        assertEquals(5, heap.pop());
    }

    @Test
    public void testShouldCreateAHeap() {
        int[] testArray = {4, 2, 1};
        MyMaxHeap heapFromArray = new MyMaxHeap(testArray);
        int[] actual = heapFromArray.getHeap();
        int[] expected = {4, 2, 1};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testShouldCreateAMaxHeapWhenGivenArrayThatIsNotAlreadyAMaxHeap() {
        int[] testArray = {1, 2, 3};
        MyMaxHeap heapFromArray = new MyMaxHeap(testArray);
        int[] actual = heapFromArray.getHeap();
        int[] expected = {3, 2, 1};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testShouldSortGivenArrayWhenArrayHasOnlyOneElement() {
        int [] testArray = {1};
        int[] sortedArray = heap.heapsort(testArray);
        int[] expected = {1};
        assertArrayEquals(expected, sortedArray);
    }

    @Test
    public void testShouldSortArrayWithThreeElements() {
        int [] testArray = {1, 2, 3};
        int [] sortedArray = heap.heapsort(testArray);
        int [] expected = {1,2,3};
        assertArrayEquals(expected, sortedArray);
    }

    @Test
    public void testShouldSortArrayWithThreeELements2() {
        int[] testArray = {1, 3, 2};
        int [] sortedArray = heap.heapsort(testArray);
        int [] expected = {1,2,3};
        assertArrayEquals(expected, sortedArray);
    }

    @Test
    public void testShouldSortArrayWithThreeElements3() {
        int[] testArray = {3,2,1};
        int [] sortedArray = heap.heapsort(testArray);
        int [] expected = {1,2,3};
        assertArrayEquals(expected, sortedArray);
    }
}