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
    public void printArray(int[] array) {
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

    public static void main (String[] args) {

        SortingAlgorithms sortingAlgorithms = new SortingAlgorithms();
        int [] testArray = sortingAlgorithms.createRandomIntegerArray(100, 0, 100);
        sortingAlgorithms.printArray(testArray);
    }

}
