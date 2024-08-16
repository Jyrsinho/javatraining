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

        for (int i = 0; i < histogram.length; i++) {
            for (int j = 0; j < t.length; j++) {
                if (t[j] == i) histogram[i]++;
            }
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
