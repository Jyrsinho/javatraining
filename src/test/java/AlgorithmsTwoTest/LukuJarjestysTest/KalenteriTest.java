package AlgorithmsTwoTest.LukuJarjestysTest;

import AlgorithmsTwo.LukuJarjestys.Kalenteri;
import AlgorithmsTwo.LukuJarjestys.Tapahtuma;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static AlgorithmsTwo.LukuJarjestys.Utils.viikonpaiva;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class KalenteriTest {
    Kalenteri kalenteri;
    Tapahtuma tapahtuma1;
    ArrayList<Tapahtuma> testiTapahtumat;

    @BeforeEach
    public void setUp() {
        kalenteri = new Kalenteri(5, 24);
        testiTapahtumat  = new ArrayList<>();
        kalenteri.paivitaKalenteri(testiTapahtumat);
        LocalDate ld = LocalDate.of(2025, 4, 1);                    // tiistai
        tapahtuma1 = new Tapahtuma(10, 12, ld, "B105 Luento");

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
    public void testShouldAddTapahtumaToKalenteri() {
        testiTapahtumat.add(tapahtuma1);
        kalenteri.paivitaKalenteri(testiTapahtumat);
        String lisattytapahtuma = kalenteri.getTapahtuma(1, 10);
        kalenteri.tulosta();
        assertEquals(tapahtuma1.getNimi(), lisattytapahtuma);

    }

    @Test
    public void testShouldReturnTenForAikaisinTapahtuma() {
        testiTapahtumat.add(tapahtuma1);
        kalenteri.paivitaKalenteri(testiTapahtumat);
        assertEquals(10,kalenteri.aikaisinAlkavaTunti());
    }

    @Test
    public void testShouldReturnEightForAikaisinTapahtuma() {
        Tapahtuma tapahtuma2 = new Tapahtuma(8, 10, LocalDate.of(2025,4, 4), "tapahtuma2" ); // perjantai
        testiTapahtumat.add(tapahtuma1);
        testiTapahtumat.add(tapahtuma2);
        kalenteri.paivitaKalenteri(testiTapahtumat);
        assertEquals(8, kalenteri.aikaisinAlkavaTunti());
    }

    @Test
    public void testShouldReturnTvelweForMyohaisinTapahtuma() {
        testiTapahtumat.add(tapahtuma1);
        kalenteri.paivitaKalenteri(testiTapahtumat);
        assertEquals(12, kalenteri.myohaisinAlkavaTunti());
    }



    @Test
    public void testShouldUpdateMyohaisinTapahtumaWhenAddingToKalenteri() {
        testiTapahtumat.add(tapahtuma1);
        kalenteri.paivitaKalenteri(testiTapahtumat);
        assertEquals(kalenteri.getViimeisenTapahtumanPVM(), tapahtuma1.getPaivamaara());
    }

    @Test
    public void testKalenteriShouldNotUpdateVarhaisinTapahtumaWhenAddingSecondTapahtuma() {
        Tapahtuma tapahtuma2 = new Tapahtuma(10, 12, LocalDate.of(2025, 4,11), "tapahtuma2" );
        testiTapahtumat.add(tapahtuma1);
        testiTapahtumat.add(tapahtuma2);
        kalenteri.paivitaKalenteri(testiTapahtumat);
        assertEquals(kalenteri.getEnsimmaisenTapahtumanPVM(), tapahtuma1.getPaivamaara());
    }

    @Test
    public void testKalenteriShouldUpdateVarhaisinTapahtumaWhenAddingSecondTapahtuma() {
        Tapahtuma tapahtuma2 = new Tapahtuma(10, 12, LocalDate.of(2025, 1,1), "tapahtuma2" );
        testiTapahtumat.add(tapahtuma1);
        testiTapahtumat.add(tapahtuma2);

        kalenteri.paivitaKalenteri(testiTapahtumat);
        assertEquals(kalenteri.getEnsimmaisenTapahtumanPVM(), tapahtuma2.getPaivamaara());
    }

    @Test
    public void testKalenteriShouldUpdateMyohaisinTapahtuma() {
        testiTapahtumat.add(tapahtuma1);
        kalenteri.paivitaKalenteri(testiTapahtumat);
        assertEquals(kalenteri.getViimeisenTapahtumanPVM(), tapahtuma1.getPaivamaara());
    }

    @Test
    public void testKalenteriShouldUpdateMyohaisinTapahtuma2() {
        Tapahtuma tapahtuma2 = new Tapahtuma(12, 14, LocalDate.of(2025, 4,11), "tapahtuma2" );
        testiTapahtumat.add(tapahtuma1);
        testiTapahtumat.add(tapahtuma2);
        kalenteri.paivitaKalenteri(testiTapahtumat);
        assertEquals(tapahtuma2.getPaivamaara(), kalenteri.getViimeisenTapahtumanPVM());
    }



}
