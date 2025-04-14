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
    Tapahtuma keskiviikko10_12;
    ArrayList<Tapahtuma> testiTapahtumat;

    @BeforeEach
    public void setUp() {
        testiTapahtumat = new ArrayList<Tapahtuma>();

        LocalDate keskiviikko16_4_25 = LocalDate.of(2025, 4, 16);
        keskiviikko10_12 = new Tapahtuma(10, 11, keskiviikko16_4_25, "keskiviikko10_12");
        poikkeustaja = new Poikkeustaja();
    }


    @Test
    public void testShouldAddTapahtumaToTapahtumatWhenOnlyOneTapahtuma() {
        testiTapahtumat.add(keskiviikko10_12);

        poikkeustaja.lajitteleTapahtumat(testiTapahtumat);
        ArrayList<Tapahtuma> saannolliset = poikkeustaja.getSaannolliset();
        assertEquals(saannolliset.getFirst().getNimi(), "keskiviikko19_12");
    }
}
