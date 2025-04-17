package AlgorithmsTwoTest.LukuJarjestysTest;

import AlgorithmsTwo.LukuJarjestys.AikatauluRuutu;
import AlgorithmsTwo.LukuJarjestys.Tapahtuma;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Aikatauluruutu pitää sisällään tiedon siitä, montako
 */
public class AikatauluRuutuTest {

    // Testataan että aikatauluruutu osaa palauttaa saannollisen tapahtumansa ja poikkeuksensa
    AikatauluRuutu aikatauluRuutu;
    Tapahtuma tapahtuma1;
    Tapahtuma tapahtuma2;

    @BeforeEach
    public void setUp() {
        aikatauluRuutu = new AikatauluRuutu();
        LocalDate tiistaiEnsimmainenHuhtikuuta = LocalDate.of(2025,4, 1);
        tapahtuma1 = new Tapahtuma(10, 12, tiistaiEnsimmainenHuhtikuuta, "saannollinenTapahtuma");
        tapahtuma2 = new Tapahtuma(10,12, tiistaiEnsimmainenHuhtikuuta, "poiukkeusTapahtuma");
    }

    @Test
    public void testAikaTauluRuutuShouldReturnItsMostFrequentTapahtuma() {
        int paivienMaara = 0;
        Tapahtuma tapahtuma = new Tapahtuma(10, 11, LocalDate.of(2025, 4, 16), "testitapahtuma");
        aikatauluRuutu.lisaa(tapahtuma);
        aikatauluRuutu.analysoi(paivienMaara);
        Tapahtuma saannollinenTapahtuma = aikatauluRuutu.getSaannollinen();
        assertEquals(tapahtuma, saannollinenTapahtuma);
    }

    @Test
    public void testAikatauluRuutuShouldReturnMostFrequentTapahtumaWhenTwoDifferentTapahtuma() {
        int toistojenMaara = 3;
        aikatauluRuutu.lisaa(tapahtuma1);
        aikatauluRuutu.lisaa(tapahtuma1);
        aikatauluRuutu.lisaa(tapahtuma2);
        aikatauluRuutu.analysoi(toistojenMaara);
        Tapahtuma expected = aikatauluRuutu.getSaannollinen();
        assertEquals(tapahtuma1, expected);

    }
}
