package AlgorithmsTwoTest.LukuJarjestysTest;

import AlgorithmsTwo.LukuJarjestys.Kalenteri;
import AlgorithmsTwo.LukuJarjestys.Tapahtuma;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KalenteriTest {
    Kalenteri kalenteri;
    Tapahtuma tiistaiHuhtikuunEnsimmainenKlo10_12;
    ArrayList<Tapahtuma> testiTapahtumat;

    @BeforeEach
    public void setUp() {
        kalenteri = new Kalenteri(5, 24);
        testiTapahtumat  = new ArrayList<>();
        LocalDate tiistaiHuhtikuunEnsimmainen = LocalDate.of(2025, 4, 1);                    // tiistai
        tiistaiHuhtikuunEnsimmainenKlo10_12 = new Tapahtuma(10, 12, tiistaiHuhtikuunEnsimmainen, "B105 Luento");

    }



    @Test
    public void testShouldAddTapahtumaToKalenteri() {
        testiTapahtumat.add(tiistaiHuhtikuunEnsimmainenKlo10_12);
        kalenteri.paivitaKalenteri(testiTapahtumat);
        String lisattytapahtuma = kalenteri.getTapahtuma(1, 10);
        kalenteri.tulosta();
        assertEquals(tiistaiHuhtikuunEnsimmainenKlo10_12.getNimi(), lisattytapahtuma);

    }

    @Disabled
    public void testShouldReturnTenForAikaisinTapahtuma() {
        testiTapahtumat.add(tiistaiHuhtikuunEnsimmainenKlo10_12);
        kalenteri.paivitaKalenteri(testiTapahtumat);
        assertEquals(10,kalenteri.aikaisinAlkavaTunti());
    }

    @Disabled
    public void testShouldReturnEightForAikaisinTapahtuma() {
        Tapahtuma tapahtuma2 = new Tapahtuma(8, 10, LocalDate.of(2025,4, 4), "tapahtuma2" ); // perjantai
        testiTapahtumat.add(tiistaiHuhtikuunEnsimmainenKlo10_12);
        testiTapahtumat.add(tapahtuma2);
        kalenteri.paivitaKalenteri(testiTapahtumat);
        assertEquals(8, kalenteri.aikaisinAlkavaTunti());
    }

    @Disabled
    public void testShouldReturnTvelweForMyohaisinTapahtuma() {
        testiTapahtumat.add(tiistaiHuhtikuunEnsimmainenKlo10_12);
        kalenteri.paivitaKalenteri(testiTapahtumat);
        assertEquals(12, kalenteri.myohaisinAlkavaTunti());
    }



    @Disabled
    public void testShouldUpdateMyohaisinTapahtumaWhenAddingToKalenteri() {
        testiTapahtumat.add(tiistaiHuhtikuunEnsimmainenKlo10_12);
        kalenteri.paivitaKalenteri(testiTapahtumat);
        assertEquals(kalenteri.getViimeisenTapahtumanPVM(), tiistaiHuhtikuunEnsimmainenKlo10_12.getPaivamaara());
    }

    @Disabled
    public void testKalenteriShouldNotUpdateVarhaisinTapahtumaWhenAddingSecondTapahtuma() {
        Tapahtuma tapahtuma2 = new Tapahtuma(10, 12, LocalDate.of(2025, 4,11), "tapahtuma2" );
        testiTapahtumat.add(tiistaiHuhtikuunEnsimmainenKlo10_12);
        testiTapahtumat.add(tapahtuma2);
        kalenteri.paivitaKalenteri(testiTapahtumat);
        assertEquals(kalenteri.getEnsimmaisenTapahtumanPVM(), tiistaiHuhtikuunEnsimmainenKlo10_12.getPaivamaara());
    }

    @Disabled
    public void testKalenteriShouldUpdateVarhaisinTapahtumaWhenAddingSecondTapahtuma() {
        Tapahtuma tapahtuma2 = new Tapahtuma(10, 12, LocalDate.of(2025, 1,1), "tapahtuma2" );
        testiTapahtumat.add(tiistaiHuhtikuunEnsimmainenKlo10_12);
        testiTapahtumat.add(tapahtuma2);

        kalenteri.paivitaKalenteri(testiTapahtumat);
        assertEquals(kalenteri.getEnsimmaisenTapahtumanPVM(), tapahtuma2.getPaivamaara());
    }

    @Disabled
    public void testKalenteriShouldUpdateMyohaisinTapahtuma() {
        testiTapahtumat.add(tiistaiHuhtikuunEnsimmainenKlo10_12);
        kalenteri.paivitaKalenteri(testiTapahtumat);
        assertEquals(kalenteri.getViimeisenTapahtumanPVM(), tiistaiHuhtikuunEnsimmainenKlo10_12.getPaivamaara());
    }

    @Disabled
    public void testKalenteriShouldUpdateMyohaisinTapahtuma2() {
        Tapahtuma tapahtuma2 = new Tapahtuma(12, 14, LocalDate.of(2025, 4,11), "tapahtuma2" );
        testiTapahtumat.add(tiistaiHuhtikuunEnsimmainenKlo10_12);
        testiTapahtumat.add(tapahtuma2);
        kalenteri.paivitaKalenteri(testiTapahtumat);
        assertEquals(tapahtuma2.getPaivamaara(), kalenteri.getViimeisenTapahtumanPVM());
    }



}
