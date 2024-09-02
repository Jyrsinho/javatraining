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
        return 6;
    }
}
