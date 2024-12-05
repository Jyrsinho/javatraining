package SortingAlgorithms;

import java.util.Random;

/**
 * Class for practicing sorting algorithms
 */
public class SortingAlgorithms {


    /**
     * Method for printing all the elements in the array
     * @param array to be printed
     */
    public static void printArray(int[] array) {
        for (int element : array) {
            System.out.print(element + ", ");
        }
        System.out.println();
    }

    /**
     * Creates a given sized array with random integer values between given minimum and maximum values
     * @param arraysize number of elements in the array
     * @param min minimum value of the element in the array
     * @param max maximum value of the element in the arrays
     */
    public int [] createRandomIntegerArray(int arraysize, int min, int max) {
        Random random = new Random();
        int [] randomArray = new int[arraysize];

        for (int i = 0; i < arraysize; i++) {
            randomArray[i] = random.nextInt(max + 1);
        }

        return randomArray;
    }


    /**
     * Sorts the given array using bubble sort.
     * @param array to be sorted
     * @param ascending if true, array will be sorted in ascending order, if false will be sorted in descending order.
     * @return sorted array
     */
    public int[] bubbleSort(int[] array, boolean ascending) {
        if (array.length < 2)
            return array;

        int sortedLimit = array.length - 1;

        while (sortedLimit > 0) {
            for (int i = 0, j = i + 1; i < sortedLimit; i++, j++) {
                if (ascending) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
                }
                else {
                    if (array[i] < array[j]) {
                        int temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                    }
                }
                }

            sortedLimit -= 1;
        }

        return array;
    }

    /**
     * Sorts the given array using Selection sort.
     * @param array to be sorted
     * @return array sorted
     */
    public int[] selectionSort(int[] array) {
        return array;
    }

    public static void main (String[] args) {
        int min = 0;
        int max = 20;
        int arraySize = 20;
        SortingAlgorithms sortingAlgorithms = new SortingAlgorithms();
        int [] testArray = sortingAlgorithms.createRandomIntegerArray(arraySize, min, max);

        System.out.println("Created unsorted random integer array of size  " + arraySize + " with min value of " + min + " and max value of " + max +": ");
        printArray(testArray);
        System.out.println();
        System.out.println("Sorted the array with Bubble Sort in ascending order: ");
        printArray(sortingAlgorithms.bubbleSort(testArray, true));
        System.out.println();
        System.out.println("Sorted the array with Bubble Sort in descending order: ");
        printArray(sortingAlgorithms.bubbleSort(testArray, false));

    }

}
