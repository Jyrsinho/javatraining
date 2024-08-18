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

        int highestAverage = 0;
        int highestAverageSalesman = 0;
        int sum = 0;

        for (int i = 0; i < sales.length; i++) {
            for (int j = 0; j < sales[i].length; j++) {
            sum += sales[i][j];
            }
            if (sum / sales[i].length > highestAverage) {
                highestAverage = sum / sales[i].length;
                highestAverageSalesman = i;
            }
        }

        return highestAverageSalesman;
        }


    public static int bestMedian(int [][]sales) {

        int currentMedian = 0;
        int bestMedian = 0;
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


    public static int findMedian(int[]sales) {
        int median;
        Arrays.sort(sales);
        median = sales[sales.length / 2];

        return median;
    }

}
