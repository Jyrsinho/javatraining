package ArrayAnalyzer;

import static java.lang.Long.toBinaryString;

public class ArrayAnalyzer {

    private final int[]t;



    public ArrayAnalyzer() {
        this.t = new int[10];
    }

    /**
     * Constructor that gets the array to be analyzed as a parameter
     * @param t array to be analyzed
     */
    public ArrayAnalyzer(int[]t ) {
        this.t = t;
    }




    /**
     * Creates a histogram from the array
     * @return histogram from the array
     */
    public int[] createHistogram() {

        int MAX_RESPONSE = 10;
        int []histogram= new int[MAX_RESPONSE];

        for (int j : t) {
            histogram[j]++;
        }


        return histogram;
    }



    public int findMode() {

        int []histogram = createHistogram();

        int mode = 0;
        int largestmodeValue = 0;

        for (int i = 0; i < histogram.length; i++) {
            if (histogram[i] > largestmodeValue) {
                mode = i;
                largestmodeValue = histogram[i];
            }
        }
        return mode;
    }

    public int findIndexOf(int target) {
        int start = 0;
        int end = t.length;
        int index = -1;
        int middle;

        while (start < end) {
            middle = Math.floorDiv(start + end , 2);
            if (t[middle] == target) {
                index = middle;
                break;
            }
            else if (t[middle] > target) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }

        return index;
    }


    /**
     * Sort the array so that whenever nums[i] is odd, i is odd, and whenever nums[i] is even, i is even.
     * @param nums array to be sorted
     * @return array where uneven indexes have uneven numbers and even indexes have even numbers
     */
    public int[] sortArrayByParity(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if (i + nums[i] % 2 != 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if ((i + nums[j]) % 2 == 0) {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                    }
                }
            }
        }
        return nums;
        }


    /**
     * You are given an integer array nums, and an integer k.
     * Let's introduce K-or operation by extending the standard bitwise OR.
     * In K-or, a bit position in the result is set to 1 if at least k
     * numbers in nums have a 1 in that position.
     * @param nums array to be analyzed
     * @param k how many numbers are needed to be one in order to make function count them as ones in result
     * @return resulting binary number as integer
     */
    public int findKOr(int[] nums, int k) {
        String[] binaryArray = turnIntoBinary(nums);

        return 0;

    }

    /**
     * turns array of integers into a string array that holds the 8bit binary representations of the integers
     * @param nums array of integers
     * @return string array holding 8bit binary representations of the integers in the original array
     */
    public String[] turnIntoBinary(int[] nums) {

        String[] binaryArray = new String[nums.length];

        // turn all the integers in the array into binary strings
        for (int i = 0; i < nums.length; i++) {
            binaryArray[i] = toBinaryString(nums[i]);
        }

        return binaryArray;

    }


    public static void main(String[] args) {


    }
}
