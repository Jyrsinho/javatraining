package SalesMen;

import java.util.Arrays;

public class Salesmen {


    int [][] sales = {
            // 1      2       3       4     5       6        7       8       9        10        11     12
            {1856,  498,  30924,  87478,    328,   2653,     387,   3754,   385787,   2873,     276,    32   },
            {-1,    5456,  3983,    6464,   9957,   4785,    3875,   3838,     4959,   1122,     -1,    -1     },
            {  -1,   -1,    -1,      -1,    -1,    -1,     232,   4546,      564,   4544,    3434,   1212  }
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

    /**
     * Counts the salesman's sales avg
     * @param sales salesman's yearly sales in an array
     * @return salesman's sales avg
     */
    public static double countAverageSales(int []sales) {
        int sum = 0;
        int numberOfActiveMonths = 0;

        for (int sale : sales) {
            if (sale != -1) {
                sum += sale;            //checks whether the sale-value is valid. -1 marks absent months
                numberOfActiveMonths++;
            }
        }

        return (double) sum / numberOfActiveMonths;

    }

    public static int findBestMedianSales(int [][]sales) {

        double currentMedian;
        double bestMedian = 0;
        int bestMedianholder = 0;

        for (int salesman = 0; salesman < sales.length; salesman++) {
            // TODO CLEAN SALES ARRAY FROM NEGATIVE VALUE
            currentMedian = findMedian(sales[salesman]);
            if (currentMedian > bestMedian) {
                bestMedian = currentMedian;
                bestMedianholder = salesman;
            }
        }
        return bestMedianholder;
    }


    public static int [] removeNegativeValueSales(int []sales) {
        int lengthOfCleanArray = 0;
        for (int sale : sales) {
            if (sale >= 0) {
                lengthOfCleanArray++;
            }
        }

        int[] cleanedSales = new int[lengthOfCleanArray];
        int indexToBeAddedIn = 0;
        for (int i = 0; i < sales.length; i++) {
            if (sales[i] >= 0) {
                cleanedSales[indexToBeAddedIn] = sales[i];
                indexToBeAddedIn++;
            }
        }

        return cleanedSales;


    }


    public static double findMedian(int[]sales) {
        double median;
        Arrays.sort(sales);

        int [] cleanedSales = removeNegativeValueSales(sales);

        // cases when the array has even number of elements
        if (cleanedSales.length % 2 == 1) {
            median = cleanedSales[cleanedSales.length / 2];
        // cases when the arrays has even number of elements
        } else{
            double firstMedian = cleanedSales[sales.length / 2];
            double secondMedian = cleanedSales[sales.length / 2 - 1];
            median = (firstMedian + secondMedian) / 2;
        }

        return median;
    }

    public static boolean arrayIsSorted(int []t) {
        boolean sorted = true;
        boolean arrayIsAscending = arrayIsAscending(t);

        for (int i = 0; i < t.length-1; i++) {
            if (arrayIsAscending && t[i] > t[i+1]) {
                sorted = false;
                break;
            }
            if (!arrayIsAscending && t[i] < t[i+1]) {
                sorted = false;
                break;
            }

        }

        return sorted;
    }

    public static boolean arrayIsAscending(int []t) {
        if (t.length == 1) return true;
        return t[0] < t[1];

    }

}
