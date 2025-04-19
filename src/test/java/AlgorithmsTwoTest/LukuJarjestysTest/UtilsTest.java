package AlgorithmsTwoTest.LukuJarjestysTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static AlgorithmsTwo.LukuJarjestys.Utils.*;
import static AlgorithmsTwo.LukuJarjestys.Utils.viikonpaiva;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UtilsTest {

    LocalDate maanantaiSeitsemasHuhtikuuta;
    LocalDate tiistaiKahdeksasHuhtikuuta;
    LocalDate keskiviikkoYhdeksasHuhtikuuta;
    LocalDate maanantaiNeljastoistaHuhtikuuta;
    LocalDate tiistaiviidestoistaHuhtikuuta;
    int tiistai;


    @BeforeEach
    public void setUp() {
        maanantaiSeitsemasHuhtikuuta = LocalDate.of(2025, 4, 7);
        tiistaiKahdeksasHuhtikuuta = LocalDate.of(2025, 4, 8);
        keskiviikkoYhdeksasHuhtikuuta = LocalDate.of(2025, 4, 9);
        maanantaiNeljastoistaHuhtikuuta = LocalDate.of(2025, 4, 14);
        tiistaiviidestoistaHuhtikuuta = LocalDate.of(2025, 4, 15);
        tiistai = 1;
    }



    @Test
    public void testShouldReturnZeroForDateThatIsMOnday() {
        LocalDate pvm = LocalDate.of(2025, 3,31);
        assertEquals(0, viikonpaiva(pvm));
    }

    @Test
    public void testShouldReturnOneForDateThatIsTuesday() {
        LocalDate pvm = LocalDate.of(2025, 4, 1);
        assertEquals(1, viikonpaiva(pvm));
    }

    @Test
    public void testShouldReturnOneForDateThatIsWednesday() {
        LocalDate pvm = LocalDate.of(2025,4,2);
        assertEquals(2, viikonpaiva(pvm));
    }

    @Test
    public void testShouldReturnNegativeValueForWeekend() {
        LocalDate pvm = LocalDate.of(2025, 4, 5);
        assertEquals(-1, viikonpaiva(pvm));
    }


    @Test
    public void testShouldGiveNextTuesdayWhenStartingDayIsMonday() {
        LocalDate expected = tiistaiKahdeksasHuhtikuuta;
        LocalDate actual = etsiPaivanSeuraavaToisto(maanantaiSeitsemasHuhtikuuta, tiistai);
        assertEquals(expected, actual);
        }

    @Test
    public void testEtsiSeuraavaShouldGiveNextWeeksTuesdayWhenStartingDayIsWednesday() {
        LocalDate expected = tiistaiviidestoistaHuhtikuuta;
        LocalDate actual = etsiPaivanSeuraavaToisto(keskiviikkoYhdeksasHuhtikuuta, tiistai);
        assertEquals(expected, actual);
    }

    @Test
    public void testEtsiSeuraavaShouldReturnGivenDayWhenStartingDayIsTuesday() {
        LocalDate expected = tiistaiviidestoistaHuhtikuuta;
        LocalDate actual = etsiPaivanSeuraavaToisto(tiistaiviidestoistaHuhtikuuta, tiistai);
        assertEquals(expected, actual);
    }

    @Test
    public void testEtsiEdellinenToistoShouldGivePreviousTuesdayWhenGivenWednesday() {
        LocalDate expected = tiistaiKahdeksasHuhtikuuta;
        LocalDate actual = etsiPaivanEdellinenToisto(keskiviikkoYhdeksasHuhtikuuta, tiistai);
        assertEquals(expected, actual);
    }

    @Test
    public void testEtsiEdellinenShouldGivePreviousWeeksTuesdayWhenGivenMonday() {
        LocalDate expected = tiistaiKahdeksasHuhtikuuta ;
        LocalDate actual  = etsiPaivanEdellinenToisto(maanantaiNeljastoistaHuhtikuuta, tiistai);
        assertEquals(expected, actual);
    }

    @Test
    public void testEtsiEdellinenShouldGiveSameTuesdayWhenSearchingNextTuesday() {
        LocalDate expected = tiistaiKahdeksasHuhtikuuta;
        LocalDate actual = etsiPaivanEdellinenToisto(tiistaiKahdeksasHuhtikuuta, tiistai);
        assertEquals(expected, actual);
    }

    }