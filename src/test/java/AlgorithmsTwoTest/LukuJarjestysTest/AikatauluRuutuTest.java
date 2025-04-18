package AlgorithmsTwoTest.LukuJarjestysTest;

import AlgorithmsTwo.LukuJarjestys.AikatauluRuutu;
import AlgorithmsTwo.LukuJarjestys.Tapahtuma;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Aikatauluruutu pitää sisällään tiedon siitä, montako
 */
public class AikatauluRuutuTest {

    // Testataan että aikatauluruutu osaa palauttaa saannollisen tapahtumansa ja poikkeuksensa
    AikatauluRuutu aikatauluRuutu;
    Tapahtuma tapahtuma1;
    Tapahtuma tapahtuma2;
    Tapahtuma tapahtuma3;
    Tapahtuma tapahtuma4;

    @BeforeEach
    public void setUp() {
        aikatauluRuutu = new AikatauluRuutu(5);
        LocalDate tiistaiEnsimmainenHuhtikuuta = LocalDate.of(2025,4, 1);
        LocalDate tiistaiKahdeksasHuhtikuuta = LocalDate.of(2025,4, 8);
        LocalDate tiistaiViidestoistaHuhtikuuta = LocalDate.of(2025,4, 15);
        LocalDate tiistaiKahdeskymmenestoinenHuhtikuuta = LocalDate.of(2025,4, 22);
        tapahtuma1 = new Tapahtuma(10, 12, tiistaiEnsimmainenHuhtikuuta, "saannollinenTapahtuma");
        tapahtuma2 = new Tapahtuma(10,12, tiistaiKahdeksasHuhtikuuta,    "saannollinenTapahtuma");
        tapahtuma3 = new Tapahtuma(10,12, tiistaiViidestoistaHuhtikuuta, "saannollinenTapahtuma");
        tapahtuma4 = new Tapahtuma(10, 12, tiistaiKahdeskymmenestoinenHuhtikuuta, "epasaannollinenTapahtuma");
    }

    @Test
    public void testAikaTauluRuutuShouldReturnEiTapahtumaaWhenItsMostFrequentTapahtuma() {

        Tapahtuma tapahtuma = new Tapahtuma(10, 11, LocalDate.of(2025, 4, 16), "testitapahtuma");
        aikatauluRuutu.lisaa(tapahtuma);
        aikatauluRuutu.analysoi();
        String expected = "EiTapahtumaa";
        String actual = aikatauluRuutu.getSaannollinen();
        assertEquals(expected, actual);
    }

    @Test
    public void testAikatauluRuutuShouldReturnMostFrequentTapahtumaWhenTwoDifferentTapahtuma() {
        aikatauluRuutu.lisaa(tapahtuma1);
        aikatauluRuutu.lisaa(tapahtuma2);
        aikatauluRuutu.lisaa(tapahtuma3);
        aikatauluRuutu.lisaa(tapahtuma4);
        aikatauluRuutu.analysoi();
        String actual = aikatauluRuutu.getSaannollinen();
        assertEquals("saannollinenTapahtuma", actual);

    }

    @Test
    public void testAikatauluRuutuShouldRetunrTapahtumaWithEarlierDateWhenTwoTapahtumatAreAsFrequent() {
        int toistejenMaara = 2;
        AikatauluRuutu aikatauluRuutu2 = new AikatauluRuutu(toistejenMaara);
        aikatauluRuutu2.lisaa(tapahtuma1);
        aikatauluRuutu2.lisaa(tapahtuma4);
        aikatauluRuutu2.analysoi();
        String actual = aikatauluRuutu2.getSaannollinen();
        assertEquals(tapahtuma1.getNimi(), actual);
    }

    @Test
    public void testAikaTauluRuutuShouldKnowThatThereIsAPoikkeus() {
        AikatauluRuutu aikatauluRuutu4 = new AikatauluRuutu(4);
        aikatauluRuutu4.lisaa(tapahtuma1);
        aikatauluRuutu4.lisaa(tapahtuma2);
        aikatauluRuutu4.lisaa(tapahtuma3);
        aikatauluRuutu4.lisaa(tapahtuma4);
        aikatauluRuutu4.analysoi();
        ArrayList<Tapahtuma> poikkeukset = aikatauluRuutu4.getPoikkeukset();
        String expected = "epasaannollinenTapahtuma";
        String actual = poikkeukset.getFirst().getNimi();
        for (int i = 0; i < poikkeukset.size(); i++) {
            System.out.println(poikkeukset.get(i).getNimi());
        }
        assertEquals(expected, actual);
    }

    @Test
    public void testAikatauluRuutuShouldKnowThatNoEventIsAPoikkeus(){
        aikatauluRuutu.lisaa(tapahtuma1);
        aikatauluRuutu.lisaa(tapahtuma2);
        aikatauluRuutu.lisaa(tapahtuma3);
        aikatauluRuutu.lisaa(tapahtuma4);
        aikatauluRuutu.analysoi();
        ArrayList<Tapahtuma> poikkeukset = aikatauluRuutu.getPoikkeukset();
        int expected = 2;
        int actual = poikkeukset.size();
        for (int i = 0; i <poikkeukset.size() ; i++) {
            System.out.println(poikkeukset.get(i).getNimi());
        }
        assertEquals(expected, actual);

    }

}
