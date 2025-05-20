package AlgorithmsTwoTest.EsitietoTest;

import org.junit.jupiter.api.Test;

import static AlgorithmsTwo.Esitieto.Esitieto.Util.laskeUusiperiodi;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UtilTest {

    @Test
    public void testShouldReturnThreeIfKurssiPeriodIsThreeAndLatestIsZero() {
        int myohaisin = 0;
        int kurssinPeriodi = 3;
        int expected = 3;
        int actual = laskeUusiperiodi(myohaisin, kurssinPeriodi);
        assertEquals(expected, actual);
    }

    @Test
    public void testShouldReturnThreeWhenLatestIsTwoAndPeriodisThre() {
        int myohaisin = 2;
        int kurssinPeriodi = 3;
        int expected = 3;
        int actual = laskeUusiperiodi(myohaisin, kurssinPeriodi);
        assertEquals(expected, actual);
    }

    @Test
    public void testShouldReturn11WhenMyohaisinIs10AndPeriodiIs3() {
        int myohaisin = 10;
        int kurssinperiodi = 3;
        int expected = 11;
        int actual = laskeUusiperiodi(myohaisin, kurssinperiodi);
        assertEquals(expected, actual);
    }
    @Test
    public void testShouldReturn13WhenMyohaisinIs10AndPeriodiIs1() {
        int myohaisin = 10;
        int kurssinperiodi = 1;
        int expected = 13;
        int actual = laskeUusiperiodi(myohaisin, kurssinperiodi);
        assertEquals(expected, actual);
    }

    @Test
    public void testShouldReturn8For4And4() {
        int myohaisin = 4;
        int kurssinperiodi = 4;
        int expected = 8;
        int actual = laskeUusiperiodi(myohaisin, kurssinperiodi);
        assertEquals(expected, actual);
    }
}
