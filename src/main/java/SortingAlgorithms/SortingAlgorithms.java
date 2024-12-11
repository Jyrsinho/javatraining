package SortingAlgorithms;

import java.util.Arrays;
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
     * @param ascending if true sorted into an ascending order, if false sorted into descending order
     * @return sorted array
     */
    public int[] mergeSort(int[] array, boolean ascending) {
        // Base Case and edge case handling
        if (array == null || array.length <= 1) {
            return array;
        }

        int midpoint = array.length / 2;

        // Sort Left side of the array
        int[] leftArray = mergeSort(Arrays.copyOfRange(array, 0, midpoint), ascending);
        // Sort Right side of the array
        int [] rightArray = mergeSort(Arrays.copyOfRange(array, midpoint , array.length), ascending);
        // Merge two arrays
        return merge(leftArray, rightArray, ascending);

    }

    /**
     * Helper function for mergesort. Merges the given two arrays into new array in ascending order.
     * @param leftArray array to be merged
     * @param rightArray array to be merged
     */
    public int [] merge(int[] leftArray, int[] rightArray, boolean ascending) {

        int []mergedArray = new int[leftArray.length + rightArray.length];

        int mergedArrayIndex = 0;
        int leftArrayIndex = 0;
        int rightArrayIndex = 0;

        while (leftArrayIndex < leftArray.length && rightArrayIndex < rightArray.length) {
             if (ascending && leftArray[leftArrayIndex] < rightArray[rightArrayIndex]  || !ascending && leftArray[leftArrayIndex] > rightArray[rightArrayIndex] ) {
                mergedArray[mergedArrayIndex] = leftArray[leftArrayIndex];
                leftArrayIndex++;
            }

            else {
                mergedArray[mergedArrayIndex] = rightArray[rightArrayIndex];
                rightArrayIndex++;
            }
            mergedArrayIndex++;
        }

        while (leftArrayIndex < leftArray.length) {
            mergedArray[mergedArrayIndex] = leftArray[leftArrayIndex];
            leftArrayIndex++;
            mergedArrayIndex++;
        }

        while (rightArrayIndex < rightArray.length) {
            mergedArray[mergedArrayIndex] = rightArray[rightArrayIndex];
            rightArrayIndex++;
            mergedArrayIndex++;
        }

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

    //TODO: QUICK SORT

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


    /**
     * Sorts the given array using Quick sort.
     * @param array to be sorted
     * @return array sorted
     */
    public int[] quickSort (int[] array) {
        return array;
    }


    /**
     * Prints out the exectution time of given algorithm with array of given size
     */
    public void printExecutionTime(int arraysize, String method) {

        int[] array = createRandomIntegerArray(arraysize, 0, arraysize);
        // Record start time
        long startTime = System.nanoTime();

        // Call the function to measure
        switch (method) {
            case "mergesort":
                mergeSort(array, true);
                break;
                case "bubblesort":
                    bubbleSort(array, true);
                    break;
                    case "insertionsort":
                        insertionSort(array, true);
                        break;
                        case "selectionsort":
                            selectionSort(array, true);
                            break;
                        default:
                            System.out.println("invalid sort method: " + method);
                            break;
        }

        // Record end time
        long endTime = System.nanoTime();

        // Calculate execution time in nanoseconds
        long executionTime = endTime - startTime;
        System.out.println("Execution time: " + (executionTime / 1_000_000) + " milliseconds");


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
        System.out.println();

        System.out.println("Created new unsorted random integer array of size  " + arraySize + " with min value of " + min + " and max value of " + max +": ");
        testArray = sortingAlgorithms.createRandomIntegerArray(arraySize, min, max);
        printArray(testArray);
        System.out.println();
        System.out.println("Sorted the array with Merge Sort in ascending order: ");
        printArray(sortingAlgorithms.mergeSort(testArray, true));
        System.out.println();
        System.out.println("Sorted the array with Merge Sort in descending order: ");
        printArray(sortingAlgorithms.mergeSort(testArray, false));
        System.out.println();

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
        System.out.println("------------------------------------------------------------------");

        System.out.println("Lets compare the execution times:");
        System.out.println();
        int arraysize = 10000;
        System.out.println("Execution time of Mergesort for array of "+arraysize+" elements: ");
        sortingAlgorithms.printExecutionTime(arraysize, "mergesort");
        System.out.println();

        System.out.println("Execution time of Selection Sort for array of "+arraysize+" elements: ");
        sortingAlgorithms.printExecutionTime(arraysize, "selectionsort");
        System.out.println();

        System.out.println("Execution time of Insertion Sort for array of "+arraysize+" elements: ");
        sortingAlgorithms.printExecutionTime(arraysize, "insertionsort");
        System.out.println();

        System.out.println("Execution time of Bubble Sort for array of "+arraysize+" elements: ");
        sortingAlgorithms.printExecutionTime(arraysize, "bubblesort");
        System.out.println();

    }

}
