package AlgorithmsTwoTest.LukuJarjestysTest;

import AlgorithmsTwo.LukuJarjestys.Poikkeustaja;
import AlgorithmsTwo.LukuJarjestys.Tapahtuma;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PoikkeustajaTest {

    Poikkeustaja poikkeustaja;
    Tapahtuma keskiviikko10_12_16_4_25;


    Tapahtuma keskiviikko_10_12_9_4_25;

    ArrayList<Tapahtuma> testiTapahtumat;

    @BeforeEach
    public void setUp() {
        testiTapahtumat = new ArrayList<Tapahtuma>();

        LocalDate keskiviikko_9_4 = LocalDate.of(2025, 4,9);
        keskiviikko_10_12_9_4_25 = new Tapahtuma(10, 11, keskiviikko_9_4, "keskiviikko_9_4");

        LocalDate keskiviikko16_4_25 = LocalDate.of(2025, 4, 16);
        keskiviikko10_12_16_4_25 = new Tapahtuma(10, 11, keskiviikko16_4_25, "keskiviikko10_12");
        poikkeustaja = new Poikkeustaja();
    }

    @Test
    public void testPoikkeustajaShouldHaveTwoWednesdaysInPaivienMaara() {
        testiTapahtumat.add(keskiviikko10_12_16_4_25);
        testiTapahtumat.add(keskiviikko_10_12_9_4_25);
        poikkeustaja.lajitteleTapahtumat(testiTapahtumat);
        assertEquals(2, poikkeustaja.getTapahtumaPaivanMaara(2));


    }

    @Test
    public void testShouldAddTapahtumaToTapahtumatWhenOnlyOneTapahtuma() {
        testiTapahtumat.add(keskiviikko_10_12_9_4_25);

        poikkeustaja.lajitteleTapahtumat(testiTapahtumat);
        ArrayList<Tapahtuma> saannolliset = poikkeustaja.getSaannolliset();
        assertEquals(saannolliset.getFirst().getNimi(), "keskiviikko19_12");
    }
}
