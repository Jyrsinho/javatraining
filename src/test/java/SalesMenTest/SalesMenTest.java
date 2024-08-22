package SalesMenTest;

import org.junit.jupiter.api.Test;

import static SalesMen.Salesmen.*;
import static org.junit.jupiter.api.Assertions.*;

public class SalesMenTest {



    @Test
    public void testShouldReturnAverageSale() {
        int[] sales = {1,2,3};

        assertEquals(2, countAverageSales(sales));

    }

    @Test
    public void testShouldReturnBestAverage() {
        int [][] sales = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };


        assertEquals(2, bestAverage(sales));
    }

    @Test
    public void testShouldReturnMedianFromArrayOfUnevenAmountOfIntegers() {
        int [] t = {1,2,3};
        assertEquals(2, findMedian(t));

    }

    @Test
    public void testShouldReturnMedianFromArrayOfUnevenAmountOfIntegers2() {
        int [] t = {1,2,3,4,5};
        assertEquals(3, findMedian(t));

    }


    @Test
    public void testShouldReturnMedianFromArrayOfEvenAmountOfIntegers() {
        int [] t = {1,2,3,4};
        assertEquals(2.5, findMedian(t));

    }

    @Test
    public void testShouldReturnMedianFromArrayOfEvenAmountOfIntegers2() {
        int [] t = {0,1,2,3,4,5,6,7,8,9};
        assertEquals(4.5, findMedian(t));

    }

    @Test
    public void testShouldReturnBestMedianFromTwoDimensionalArrayOfSales() {
        int [][]t = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        assertEquals(2, findBestMedianSales(t));
    }

    @Test
    public void testShouldReturnTrueThatArrayIsSorted(){
        int []t = {1,2,3};

        assertTrue(arrayIsSorted(t));
    }

    @Test
    public void testShouldReturnFalseThatArrayIsNotSorted(){
        int []t = {1,3,2};

        assertFalse(arrayIsSorted(t));
    }

    @Test
    public void testShouldReturnTrueThatArrayIsInAscendingOrder() {
        int []t = {1,2,3};
        assertTrue(arrayIsAscending(t));
    }

    @Test
    public void testShouldReturnFalseWhenArrayIsNotInAscendingOrder() {
        int []t = {3,2,1};
        assertFalse(arrayIsAscending(t));
    }

    @Test
    public void testShouldReturnFalseThatArrayIsSorted2(){
        int []t = {3,2,1};
        assertTrue(arrayIsSorted(t));
    }

    @Test
    public void testShouldReturnAverageSaleFromArrayContainingNegativeValuesForAbsentMonths() {
        int[] sales = {-1,1,2,3,-1};

        assertEquals(2, countAverageSales(sales));

    }

    @Test
    public void testShouldRemoveNegativeValuesFromArrayContainingNegativeValuesForAbsentMonths() {
        int [] testSales = {-1,1,2,3,-1};
        int [] cleanSales = removeNegativeValueSales(testSales);

        assertEquals(3, cleanSales.length);
        assertEquals(1, cleanSales[0]);
        assertEquals(3, cleanSales[2]);


    }
}

    /*

    @Test
    public void testShouldReturnMedianFromArrayContainingNegativeValuesForAbsentMonths1() {
        int [] t = {-1, 1, 2, 3, -1, -1, -1};

        assertEquals(2, findMedian(t));
    }

}

     */
