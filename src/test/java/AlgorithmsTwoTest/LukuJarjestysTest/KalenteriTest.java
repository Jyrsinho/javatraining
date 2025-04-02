package AlgorithmsTwoTest.LukuJarjestysTest;

import AlgorithmsTwo.LukuJarjestys.Kalenteri;
import AlgorithmsTwo.LukuJarjestys.Tapahtuma;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KalenteriTest {
    Kalenteri kalenteri;
    Tapahtuma tapahtuma1;

   @BeforeEach
   public void setUp() {
       kalenteri = new Kalenteri(5, 24);
       tapahtuma1 = new Tapahtuma(10, 12, "01.04.2025", "B105 Luento");
   }

   @Test
   public void testShouldReturnEiOlemassaTapahtumaWhenAskingTapahtumaThatIsNotInKalenteri() {
       assertEquals("TapahtumaEiOlemassa", kalenteri.getTapahtuma(0, 10).getClass().getSimpleName());

   }

   @Test
   public void testShouldReturnZeroForDateThatIsMOnday() {
       String pvm = "31.03.2025";
       assertEquals(0, kalenteri.viikonpaiva(pvm));
   }

   @Test
   public void testShouldReturnOneForDateThatIsTuesday() {
       String pvm = "01.04.2025";
       assertEquals(1, kalenteri.viikonpaiva(pvm));
   }

   @Test
   public void testShouldReturnOneForDateThatIsWednesday() {
       String pvm = "02.04.2025";
       assertEquals(2, kalenteri.viikonpaiva(pvm));
   }

   @Test
   public void testShouldReturnNegativeValueForWeekend() {
       String pvm = "05.04.2025";
       assertEquals(-1, kalenteri.viikonpaiva(pvm));
   }

   @Test
    public void testShouldAddTapahtumaToKalenteri() {
       kalenteri.lisaaTapahtuma(tapahtuma1);
       Tapahtuma lisattytapahtuma = kalenteri.getTapahtuma(1, 10);
       kalenteri.tulosta();
       assertEquals(tapahtuma1, lisattytapahtuma);

   }
}
