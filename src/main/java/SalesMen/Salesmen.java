package SalesMen;

import java.util.Arrays;

public class Salesmen {


    int [][] sales = {
            // 1      2       3       4     5       6        7       8       9        10        11     12
            {1856,  498,  30924,  87478,    328,   2653,     387,   3754,   385787,   2873,     276,    32   },
            {5865, 5456,  3983,    6464,   9957,   4785,    3875,   3838,     4959,   1122,    7766,   2534  },
            {  23,   55,    56,      99,    265,    376,     232,   4546,      564,   4544,    3434,   1212  }
    };


    public Salesmen() {

    }


    public static int bestAverage(int [][]sales) {

        double highestAverage = 0;
        double currentAverage;
        int highestAverageSalesman = 0;

        for (int i = 0; i < sales.length; i++) {
            currentAverage = countAverageSales(sales[i]);

            if (currentAverage > highestAverage) {
                highestAverage = currentAverage;
                highestAverageSalesman = i;
            }
        }

        return highestAverageSalesman;
        }


    public static double countAverageSales(int []sales) {
        int sum = 0;

        for (int sale : sales) {
            sum += sale;
        }

        return sum / sales.length;

    }

    public static int findBestMedianSales(int [][]sales) {

        double currentMedian;
        double bestMedian = 0;
        int bestMedianholder = 0;

        for (int salesman = 0; salesman < sales.length; salesman++) {
            currentMedian = findMedian(sales[salesman]);
            if (currentMedian > bestMedian) {
                bestMedian = currentMedian;
                bestMedianholder = salesman;
            }
        }
        return bestMedianholder;
    }


    public static double findMedian(int[]sales) {
        double median;
        Arrays.sort(sales);

        if (sales.length%2 == 1) {
            median = sales[sales.length / 2];
        } else{
            double firstMedian= sales[sales.length/2];
            double secondMedian= sales[sales.length/2 - 1];
            median = (firstMedian+secondMedian)/2;
        }

        return median;
    }

    public static boolean arrayIsSorted(int []t) {
        boolean sorted = true;

        for (int i = 0; i < t.length-1; i++) {
            if (t[i] > t[i+1]) {
                sorted = false;
            }
        }

        return sorted;
    }

}
