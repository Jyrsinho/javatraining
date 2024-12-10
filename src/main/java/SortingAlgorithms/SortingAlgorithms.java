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
     * Sorts the given array using selection sort
     * @param array to be sorted
     * @param ascending if true, array will be sorted in ascending order, if false will be sorted in descending order.
     * @return sorted array
     */
    public int[] selectionSort(int[] array, boolean ascending) {

        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex] && ascending || array[j] > array[minIndex] && !ascending) {
                    minIndex = j;
                }
            } //end of inner for loop
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        } // end of outer for loop

        return array;
    }

    /**
     * Sorts the given array using merge sort
     * @param array to be sorted
     * @return sorted array
     */
    public int[] mergeSort(int[] array) {

        return array;

    }

    /**
     * Helper function for mergesort. Merges the given two arrays into new array in ascending order.
     * @param array1 array to be merged
     * @param array2 array to be merged
     */
    public int [] merge(int[] array1, int[] array2) {

        int []mergedArray = new int[array1.length + array2.length];

        return mergedArray;
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

        // Do the while loop as long as the sorted area of the array does not cover the whole array
        while (sortedLimit > 0) {

            for (int i = 0; i < sortedLimit; i++) {
                // Compare element in the indexes i and i+1. If we are sorting to ascending order then change
                // element's positions when element in position i is greater than element in position i+1.
                // Reverse the condition when going for descending orde
                if (ascending && array[i] > array[i+1] || (!ascending && array[i] < array[i+1])) {
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
                }
            // Update the sorted area to cover one more element from the end of the array
            sortedLimit -= 1;
        }

        return array;
    }

    /**
     * Sorts the given array using Selection sort.
     * @param array to be sorted
     * @param ascending if true, array will be sorted in ascending order, if false will be sorted in descending order.
     * @return array sorted
     */
    public int[] insertionSort(int[] array, boolean ascending) {

        // for loop goes over all the cards from index 1 to the end of the array
        for (int i = 1; i < array.length; i++) {
            int j = i - 1;
            // while loop compares i:th element in the array against all the elements in the left and swaps their place
            // if the comparison conditions are met
            while (j >= 0) {
                if (array[i] < array[j] && ascending || array[i] > array[j] && !ascending) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    j--;
                    i--;
                }
                else {
                     break;
                }
            } // end of while loop
        } //end of for loop

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
        System.out.println();

        System.out.println("Created new unsorted random integer array of size  " + arraySize + " with min value of " + min + " and max value of " + max +": ");
        testArray = sortingAlgorithms.createRandomIntegerArray(arraySize, min, max);
        printArray(testArray);
        System.out.println();
        System.out.println("Sorted the array with Insertion Sort in ascending order: ");
        printArray(sortingAlgorithms.insertionSort(testArray, true));
        System.out.println();
        System.out.println("Sorted the array with Insertion Sort in descending order: ");
        printArray(sortingAlgorithms.insertionSort(testArray, false));

        System.out.println("Created new unsorted random integer array of size  " + arraySize + " with min value of " + min + " and max value of " + max +": ");
        testArray = sortingAlgorithms.createRandomIntegerArray(arraySize, min, max);
        printArray(testArray);
        System.out.println();
        System.out.println("Sorted the array with Selection Sort in ascending order: ");
        printArray(sortingAlgorithms.selectionSort(testArray, true));
        System.out.println();
        System.out.println("Sorted the array with Selection Sort in descending order: ");
        printArray(sortingAlgorithms.selectionSort(testArray, false));
        System.out.println();



    }

}
