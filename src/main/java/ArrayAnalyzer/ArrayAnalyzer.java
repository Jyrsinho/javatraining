package ArrayAnalyzer;

public class ArrayAnalyzer {

    private int[]t;

    public ArrayAnalyzer(int[]t ) {
        this.t = t;
    }


    /**
     * Creates a histogram from the array
     * @return
     */
    public int[] createHistogram() {

        int [] histogram = new int[10];

        for (int i = 0; i < t.length; i++) {

        }
        return histogram;
    }


    public int findMode() {

        int []histogram = createHistogram();

        int mode = 0;
        int modevalue = histogram[0];

        for (int i = 0; i < t.length; i++) {
            if (histogram[i] < modevalue) {
                mode = i;
            }
        }

        return mode;
    }
}
