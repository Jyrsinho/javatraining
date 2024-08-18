package SalesMenTest;

import org.junit.jupiter.api.Test;

import static SalesMen.Salesmen.bestAverage;
import static SalesMen.Salesmen.findMedian;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SalesMenTest {



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

}
