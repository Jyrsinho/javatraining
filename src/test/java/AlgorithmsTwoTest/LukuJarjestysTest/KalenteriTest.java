package AlgorithmsTwoTest.LukuJarjestysTest;

import AlgorithmsTwo.LukuJarjestys.Kalenteri;
import AlgorithmsTwo.LukuJarjestys.Tapahtuma;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class KalenteriTest {
    Kalenteri kalenteri;
    Tapahtuma tapahtuma1;

    @BeforeEach
    public void setUp() {
        kalenteri = new Kalenteri(5, 24);
        LocalDate ld = LocalDate.of(2025, 4, 1);                    // tiistai
        tapahtuma1 = new Tapahtuma(10, 12, ld, "B105 Luento");

    }

    @Test
    public void testShouldReturnEiOlemassaTapahtumaWhenAskingTapahtumaThatIsNotInKalenteri() {
        assertEquals("TapahtumaEiOlemassa", kalenteri.getTapahtuma(0, 10).getClass().getSimpleName());

    }

    @Test
    public void testShouldReturnZeroForDateThatIsMOnday() {
        LocalDate pvm = LocalDate.of(2025, 3,31);
        assertEquals(0, kalenteri.viikonpaiva(pvm));
    }

    @Test
    public void testShouldReturnOneForDateThatIsTuesday() {
        LocalDate pvm = LocalDate.of(2025, 4, 1);
        assertEquals(1, kalenteri.viikonpaiva(pvm));
    }

    @Test
    public void testShouldReturnOneForDateThatIsWednesday() {
        LocalDate pvm = LocalDate.of(2025,4,2);
        assertEquals(2, kalenteri.viikonpaiva(pvm));
    }

    @Test
    public void testShouldReturnNegativeValueForWeekend() {
        LocalDate pvm = LocalDate.of(2025, 4, 5);
        assertEquals(-1, kalenteri.viikonpaiva(pvm));
    }

    @Test
    public void testShouldAddTapahtumaToKalenteri() {
        kalenteri.lisaaTapahtuma(tapahtuma1);
        Tapahtuma lisattytapahtuma = kalenteri.getTapahtuma(1, 10);
        kalenteri.tulosta();
        assertEquals(tapahtuma1, lisattytapahtuma);

    }

    @Test
    public void testShouldReturnTenForAikaisinTapahtuma() {
        kalenteri.lisaaTapahtuma(tapahtuma1);
        assertEquals(10,kalenteri.aikaisinTapahtuma());
    }

    @Test
    public void testShouldReturnEightForAikaisinTapahtuma() {
        kalenteri.lisaaTapahtuma(tapahtuma1);
        Tapahtuma tapahtuma2 = new Tapahtuma(8, 10, LocalDate.of(2025,4, 4), "tapahtuma2" ); // perjantai
        kalenteri.lisaaTapahtuma(tapahtuma2);
        assertEquals(8, kalenteri.aikaisinTapahtuma());
    }

    @Test
    public void testShouldReturnElevenForMyohaisinTapahtuma() {
        kalenteri.lisaaTapahtuma(tapahtuma1);
        assertEquals(11, kalenteri.myohaisinTapahtuma());
    }

    @Test
    public void testShouldReturnTwentyOneForMyohaisinTapahtuma() {
        kalenteri.lisaaTapahtuma(tapahtuma1);
        Tapahtuma tapahtuma2 = new Tapahtuma(20, 22, LocalDate.of(2024,1,23), "tapahtuma2" );
        kalenteri.lisaaTapahtuma(tapahtuma2);
        assertEquals(21, kalenteri.myohaisinTapahtuma());
    }

    @Test
    public void testShouldReturnTrueForTapahtumaJatkuu() {
        kalenteri.lisaaTapahtuma(tapahtuma1);
        assertTrue(kalenteri.tapahtumaJatkuu(1, 11));
    }

    @Test
    public void testShouldReturnFalseForTapahtumaJatkuu() {
        kalenteri.lisaaTapahtuma(tapahtuma1);
        assertFalse(kalenteri.tapahtumaJatkuu(1, 12));
    }

    @Test
    public void testShouldReturnFalseForTapahtumaJatkuuWhenTapahtumaJustStarted() {
        kalenteri.lisaaTapahtuma(tapahtuma1);
        assertFalse(kalenteri.tapahtumaJatkuu(1, 10));
    }

    @Test
    public void testKalenteriShouldReturnEnsimmainenPaivaOfKalenteri() {
        kalenteri.lisaaTapahtuma(tapahtuma1);
        String expected = "1.4.2025";
        assertEquals(expected, kalenteri.ensimmaisenTapahtumanPV());
    }

    @Test
    public void testKalenteriShouldReturnEnsimmainenPaivaOfKalenteri2() {
        kalenteri.lisaaTapahtuma(tapahtuma1);
        Tapahtuma tapahtuma2 = new Tapahtuma(10, 20, LocalDate.of(2025,1,23), "tapahtuma2" );
        kalenteri.lisaaTapahtuma(tapahtuma2);
        String expected = "23.1.2025";
        assertEquals(expected, kalenteri.ensimmaisenTapahtumanPV());
    }

    @Test
    public void testKalenteriShouldReturnViimeinenPaivaOfKalenteri() {
        kalenteri.lisaaTapahtuma(tapahtuma1);
        String expected = "1.4.2025";
        assertEquals(expected, kalenteri.viimeisenTapahtumanPV());
    }

    @Test
    public void testKalenteriShouldNotAddEventWhenThereAlreadyIsAnEventInThatSameTimeSlot() {
        Tapahtuma olemassaolevaTapahtuma = new Tapahtuma(10, 14, LocalDate.of(2025,4,9), "olemassaoleva" );
        kalenteri.lisaaTapahtuma(olemassaolevaTapahtuma);
        Tapahtuma eiSaaLisata = new Tapahtuma(10, 14, LocalDate.of(2025,4,9), "eiSaaLisata" );
        kalenteri.lisaaTapahtuma(eiSaaLisata);
        assertEquals( 1, kalenteri.getTapahtumienMaara());

    }

    @Test
    public void testKalenteriShouldNotAddEventWhenAlreadyAnEventWithinTHatTImeSlot() {
        Tapahtuma olemassaolevaTapahtuma = new Tapahtuma(10, 14, LocalDate.of(2025,4,2), "olemassaoleva" );
        kalenteri.lisaaTapahtuma(olemassaolevaTapahtuma);
        Tapahtuma eiSaaLisata = new Tapahtuma(13, 15, LocalDate.of(2025,4,9), "eiSaaLisata" );
        kalenteri.lisaaTapahtuma(eiSaaLisata);
        assertEquals( 1, kalenteri.getTapahtumienMaara());
    }


}
