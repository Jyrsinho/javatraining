package AlgorithmsTwoTest.LukuJarjestysTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static AlgorithmsTwo.LukuJarjestys.Utils.etsiPaivanEdellinenToisto;
import static AlgorithmsTwo.LukuJarjestys.Utils.etsiPaivanSeuraavaToisto;
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
    public void testShouldGiveNextTuesdayWhenStartingDayIsMonday() {
        LocalDate expected = tiistaiKahdeksasHuhtikuuta;
        LocalDate actual = etsiPaivanSeuraavaToisto(maanantaiSeitsemasHuhtikuuta, tiistai);
        assertEquals(expected, actual);
        }

    @Test
    public void testShouldGiveNextWeeksTuesdayWhenStartingDayIsWednesday() {
        LocalDate expected = tiistaiviidestoistaHuhtikuuta;
        LocalDate actual = etsiPaivanSeuraavaToisto(keskiviikkoYhdeksasHuhtikuuta, tiistai);
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

    }