package StudentSorter;

import java.util.Arrays;

public class QuartileFinder<T extends Number > {

        public QuartileFinder() {


        }


        public Double[] getQuartiles(T[] array ) {

        Double[] quartiles = new Double[3];
        quartiles[0] = findFirstQuartile(array);
        quartiles[1] = findMedian(array);
        quartiles[2] = findThirdQuartile(array);


        for (double quartile : quartiles) {
            System.out.println(quartile);
        }

        return quartiles;
    }

    public void sort (T[]array) {

            Arrays.sort(array);
    }



    public double findMedian(T[] array) {
        sort(array);
        int n = array.length;

        if (n % 2 == 1) return  array[n/2].doubleValue();

        else return  (array[n / 2].doubleValue() + array[n / 2 - 1].doubleValue()) / 2;
    }


    public double findFirstQuartile(T[]array) {
        int mid = array.length / 2;
        T [] lowerHalf = Arrays.copyOfRange(array, 0, mid);

        System.arraycopy(array, 0, lowerHalf, 0, lowerHalf.length);

        return findMedian(lowerHalf);
    }


    public double findThirdQuartile(T[] array) {
        int mid = array.length / 2;
        T [] upperHalf;

        if (array.length % 2 == 1){
            upperHalf = Arrays.copyOfRange(array, mid+1, array.length);
        }
        else {
            upperHalf = Arrays.copyOfRange(array, mid, array.length);
        }

        return findMedian(upperHalf);
    }
}
