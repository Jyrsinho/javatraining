package Algorithms.Heap;

public class MyMaxHeap {

    /**
     * Harjoitellaan MaxHeap tekemistä ja Heap sorttia
     */
    private int[] heap;
    private int size;

    public MyMaxHeap() {
        heap  = new int[10];
        this.size = 0;
    }

    /**
     * Creates a heap from an array
     * @param array to be given
     */
    public MyMaxHeap(int[] array) {
        heap = array;
        this.size = array.length;

        heapify();
    }

    public void insert(int value) {
        // lisataan value taulukon loppuun
        // verrataan valueta sen jokaiseen vanhempaan
        // jos suurempi kuin vanhempi vaihdetaan

        int childIndex = size;
        heap[childIndex] = value;

        int parentIndex = (size - 1) / 2;

        while (parentIndex >= 0 && heap[parentIndex] < heap[childIndex]) {
            swap(parentIndex, childIndex);

            childIndex = parentIndex;
            parentIndex = (childIndex - 1)  /  2;

        }

        size++;
    }


    public int peek() {
       return heap[0];
    }


    public int pop() {
        int top = heap[0];
        heap[0] = heap[size- 1];
        size--;
        maxHeapify(0);

        return top;
    }

    /**
     * Sort given array using heapsort
     * @param array to be sorted
     * @return sorted array
     */
    public int[] heapsort(int [] array) {
        heap = array;
        size = array.length;
        heapify();

        // käydään koko taulukko läpi lopusta alkuun
        for (int i = size-1; i > 0 ; i--) {
            heap[i] = pop();

        }

        // ensimmäisessä indeksissä on aina suurin joten siirretään se taulukon loppuun ja poistetaan taulukon loppu
        // heapistä

        return heap;

    }


    /**
     * Fixes the heap properties
     * @param index starting index to bubble element down
     */
    private void maxHeapify(int index) {
        int leftChild = leftChild(index);
        int rightChild = rightChild(index);


        int largest = index;

        if (leftChild < size && heap[leftChild] > heap[largest]) {
            largest = leftChild;
        }

        if (rightChild < size && heap[rightChild] > heap[largest]) {
            largest = rightChild;
        }

        if (largest != index) {
            swap(index, largest);
            maxHeapify(largest);
        }


    }

    private void heapify() {
        // kutsutaan maxHeapify heapin ylemmälle puolikkaalle
        int pivot = size / 2 - 1;
        for (int i = pivot; i >= 0 ; i--) {
            maxHeapify(i);
        }
    }


    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    /**
     * Returns the left child of the given index
     */
    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }


    public int getSize() {
        return size;
    }

    public int[] getHeap() {
        return heap;
    }
}
