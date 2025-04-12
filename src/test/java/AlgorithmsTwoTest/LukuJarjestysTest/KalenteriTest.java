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
    public void testShouldReturnTvelweForMyohaisinTapahtuma() {
        kalenteri.lisaaTapahtuma(tapahtuma1);
        assertEquals(12, kalenteri.myohaisinTapahtuma());
    }

    @Test
    public void testShouldReturnTwentyTwoForMyohaisinTapahtuma() {
        kalenteri.lisaaTapahtuma(tapahtuma1);
        Tapahtuma tapahtuma2 = new Tapahtuma(20, 22, LocalDate.of(2024,1,23), "tapahtuma2" );
        kalenteri.lisaaTapahtuma(tapahtuma2);
        assertEquals(22, kalenteri.myohaisinTapahtuma());
    }

    @Test
    public void testShouldReturnTrueForTapahtumaJatkuu() {
        kalenteri.lisaaTapahtuma(tapahtuma1);
        assertTrue(kalenteri.tapahtumaJatkuu(1, 11));
    }

    @Test
    public void testShouldReturnFalseForTapahtumaJatkuu() {
        kalenteri.lisaaTapahtuma(tapahtuma1);
        assertFalse(kalenteri.tapahtumaJatkuu(1, 13));
    }

    @Test
    public void testShouldReturnFalseForTapahtumaJatkuuWhenTapahtumaJustStarted() {
        kalenteri.lisaaTapahtuma(tapahtuma1);
        assertFalse(kalenteri.tapahtumaJatkuu(1, 10));
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
    public void testShouldAddTapahtumaJatkuuToSecondTimeSlotOfTapahtuma() {
        kalenteri.lisaaTapahtuma(tapahtuma1);
        Tapahtuma[][] tapahtumaKalenteri = kalenteri.getTapahtumaKalenteri();
        Tapahtuma tapahtumanToinenTunti = tapahtumaKalenteri[kalenteri.viikonpaiva(tapahtuma1.getPaivamaara())][tapahtuma1.getViimeinenAlkavaTunti() -1];
        assertEquals("TapahtumaJatkuu" ,tapahtumanToinenTunti.getClass().getSimpleName());
    }

    @Test
    public void testKalenteriShouldNotAddEventWhenAlreadyAnEventWithinTHatTImeSlot() {
        Tapahtuma olemassaolevaTapahtuma = new Tapahtuma(10, 14, LocalDate.of(2025,4,2), "olemassaoleva" );
        kalenteri.lisaaTapahtuma(olemassaolevaTapahtuma);
        Tapahtuma eiSaaLisata = new Tapahtuma(13, 15, LocalDate.of(2025,4,9), "eiSaaLisata" );
        kalenteri.lisaaTapahtuma(eiSaaLisata);
        assertEquals( 1, kalenteri.getTapahtumienMaara());
    }

    @Test
    public void testKalenteriShouldDetermineThatTapahtumaJatkuuWhenTwoAdjacentEventsHaveSameName() {
        Tapahtuma tapahtuma1 = new Tapahtuma(10, 12, LocalDate.of(2025, 4,10), "tapahtuma1" );
        Tapahtuma tapahtuma2 = new Tapahtuma(12, 14, LocalDate.of(2025, 4,10), "tapahtuma1" );
        kalenteri.lisaaTapahtuma(tapahtuma1);
        kalenteri.lisaaTapahtuma(tapahtuma2);
        assertTrue(kalenteri.tapahtumaJatkuu(kalenteri.viikonpaiva(tapahtuma1.getPaivamaara()), tapahtuma2.getEnsimmainenAlkavaTunti()));
    }

    @Test
    public void testKalenteriShouldDetermineThatTapahtumaJatkuuFollowingEventsHaveSameName() {
        Tapahtuma tapahtuma1 = new Tapahtuma(12, 14, LocalDate.of(2025, 4,10), "tapahtuma1" );
        Tapahtuma tapahtuma2 = new Tapahtuma(10, 12, LocalDate.of(2025, 4,10), "tapahtuma1" );
        kalenteri.lisaaTapahtuma(tapahtuma1);
        kalenteri.lisaaTapahtuma(tapahtuma2);
        assertTrue(kalenteri.tapahtumaJatkuu(kalenteri.viikonpaiva(tapahtuma1.getPaivamaara()), tapahtuma1.getEnsimmainenAlkavaTunti()));
    }

    @Test
    public void testKalenteriShouldKnowThatUusiTapahtumaHasPreviousOneWithSameName() {
        Tapahtuma tapahtuma1 = new Tapahtuma(10, 12, LocalDate.of(2025, 4,10), "tapahtuma1" );
        Tapahtuma tapahtuma2 = new Tapahtuma(12, 14, LocalDate.of(2025, 4,10), "tapahtuma1" );
        kalenteri.lisaaTapahtuma(tapahtuma1);
        assertTrue(kalenteri.yhdistaJatkuvat(kalenteri.viikonpaiva(tapahtuma2.getPaivamaara()),tapahtuma2));
    }

    @Test
    public void testKalenteriShouldKnowThatUusiTapahtumaHasNoPreviousOneWithSameName() {
        Tapahtuma tapahtuma1 = new Tapahtuma(10, 12, LocalDate.of(2025, 4,10), "tapahtuma1" );
        Tapahtuma tapahtuma2 = new Tapahtuma(12, 14, LocalDate.of(2025, 4,10), "tapahtuma12" );
        kalenteri.lisaaTapahtuma(tapahtuma1);
        assertFalse(kalenteri.yhdistaJatkuvat(kalenteri.viikonpaiva(tapahtuma2.getPaivamaara()),tapahtuma2));
    }

    @Test
    public void testKalenteriShouldKnowThatUusiTapahtumaHasNextOneWithSameName() {
        Tapahtuma tapahtuma1 = new Tapahtuma(12, 14, LocalDate.of(2025, 4,10), "tapahtuma1" );
        Tapahtuma tapahtuma2 = new Tapahtuma(10, 12, LocalDate.of(2025, 4,10), "tapahtuma1" );
        kalenteri.lisaaTapahtuma(tapahtuma1);
        assertTrue(kalenteri.yhdistaJatkuvat(kalenteri.viikonpaiva(tapahtuma2.getPaivamaara()),tapahtuma2));
    }

    @Test
    public void testKalenteriShouldKnowThatUusiTapahtumaHasNoNextOneWithSameName() {
        Tapahtuma tapahtuma1 = new Tapahtuma(12, 14, LocalDate.of(2025, 4,10), "tapahtuma1" );
        Tapahtuma tapahtuma2 = new Tapahtuma(10, 11, LocalDate.of(2025, 4,10), "tapahtuma1" );
        kalenteri.lisaaTapahtuma(tapahtuma1);
        assertTrue(kalenteri.yhdistaJatkuvat(kalenteri.viikonpaiva(tapahtuma2.getPaivamaara()),tapahtuma2));
    }

    @Test
    public void testKalenteriShouldUpdateVarhaisinTapahtumaWhenAddingToKaleteri() {
        kalenteri.lisaaTapahtuma(tapahtuma1);
        assertEquals(kalenteri.getEnsimmaisenTapahtumanPVM(), tapahtuma1.getPaivamaara());
    }

    @Test
    public void testShouldUpdateMyohaisinTapahtumaWhenAddingToKalenteri() {
        kalenteri.lisaaTapahtuma(tapahtuma1);
        assertEquals(kalenteri.getViimeisenTapahtumanPVM(), tapahtuma1.getPaivamaara());
    }

    @Test
    public void testKalenteriShouldNotUpdateVarhaisinTapahtumaWhenAddingSecondTapahtuma() {
        kalenteri.lisaaTapahtuma(tapahtuma1);
        Tapahtuma tapahtuma2 = new Tapahtuma(10, 12, LocalDate.of(2025, 4,11), "tapahtuma2" );
        kalenteri.lisaaTapahtuma(tapahtuma2);
        assertEquals(kalenteri.getEnsimmaisenTapahtumanPVM(), tapahtuma1.getPaivamaara());
    }

    @Test
    public void testKalenteriShouldUpdateVarhaisinTapahtumaWhenAddingSecondTapahtuma() {
        kalenteri.lisaaTapahtuma(tapahtuma1);
        Tapahtuma tapahtuma2 = new Tapahtuma(10, 12, LocalDate.of(2025, 1,1), "tapahtuma2" );
        kalenteri.lisaaTapahtuma(tapahtuma2);
        assertEquals(kalenteri.getEnsimmaisenTapahtumanPVM(), tapahtuma2.getPaivamaara());
    }

    @Test
    public void testKalenteriShouldUpdateMyohaisinTapahtuma() {
        kalenteri.lisaaTapahtuma(tapahtuma1);
        assertEquals(kalenteri.getViimeisenTapahtumanPVM(), tapahtuma1.getPaivamaara());
    }

    @Test
    public void testKalenteriShouldUpdateMyohaisinTapahtuma2() {
        kalenteri.lisaaTapahtuma(tapahtuma1);
        Tapahtuma tapahtuma2 = new Tapahtuma(12, 14, LocalDate.of(2025, 4,11), "tapahtuma2" );
        kalenteri.lisaaTapahtuma(tapahtuma2);
        assertEquals(tapahtuma2.getPaivamaara(), kalenteri.getViimeisenTapahtumanPVM());
    }

}
