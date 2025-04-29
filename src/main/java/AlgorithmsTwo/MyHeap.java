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
        int top = heap[0];
        heap[0] = heap[size];
        heap[size] = 0;

        heapify(0);

        return top;

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

    public int getSize() {
        return size;
    }


    private void heapify (int comparableIndex) {
        int smallerChildIndex;
        int firstChildIndex = comparableIndex * 2 + 1;
        int secondChildIndex = comparableIndex * 2 + 2;

        if (firstChildIndex > size || secondChildIndex > size) {
            return;
        }

        if (heap[firstChildIndex] < heap[secondChildIndex]) {
           smallerChildIndex = firstChildIndex;
        } else {
            smallerChildIndex = secondChildIndex;
        }

        if (heap[smallerChildIndex] < heap[comparableIndex]) {
            swap(smallerChildIndex, comparableIndex);
        }
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
