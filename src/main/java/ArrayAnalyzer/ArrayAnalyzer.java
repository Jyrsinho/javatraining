package ArrayAnalyzer;

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


    public static void main(String[] args) {


    }
}
