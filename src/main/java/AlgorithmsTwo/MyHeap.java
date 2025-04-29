package AlgorithmsTwo;

public class MyHeap {

    int[] heap;
    int size;


    public MyHeap(int capacity) {
        heap = new int[capacity];
        size = 0;
    }

    public int peek() {
        return heap[0];
    }

    public void insert(int value) {
       heap[size] = value;
       bubbleUp(size);
       size++;

       if (size == heap.length) {
           addSpaceToHeap();
       }
    }

    public int extract() {
        if (size == 0) {
            return -1;
        }
        size--;
        return heap[0];

    }

    public void bubbleUp(int comparableIndex) {
        int parentIndex = comparableIndex / 2;

        while (parentIndex >= 0 && heap[parentIndex] > heap[comparableIndex]) {
            swap(parentIndex, comparableIndex);
            comparableIndex = parentIndex;
            parentIndex = comparableIndex / 2;
        }
    }

    public int getCapacity() {
        return heap.length;
    }


    private void addSpaceToHeap() {
        int[] newHeap = new int[heap.length * 2];
        System.arraycopy(heap, 0, newHeap, 0, heap.length);
        heap = newHeap;
    }


    private void swap(int parentIndex, int comparableIndex) {
        int temp = heap[parentIndex];
        heap[parentIndex] = heap[comparableIndex];
        heap[comparableIndex] = temp;

    }


    public void printHeap() {
        int amountOfNodes = 1;

        for (int i = 0; i < size;) {
            for (int j = 0; j < amountOfNodes; j++) {
                System.out.println(heap[i]);
                i++;
            }
            amountOfNodes = amountOfNodes * 2;
        }
    }
}
