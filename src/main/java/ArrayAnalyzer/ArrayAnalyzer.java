package ArrayAnalyzer;

public class ArrayAnalyzer {

    private final int[]t;

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
        int beginning = 0;
        int end = t.length - 1;
        int index = -1;
        int middle;

        while (end >= 0 && beginning <= end) {
            middle = (beginning + end) / 2;
            if (t[middle] == target) {
                index = middle;
                break;
            }
            else if (t[middle] > target) {
                end = middle - 1;
            } else {
                beginning = middle + 1;
            }
        }

        return index;
    }
}
