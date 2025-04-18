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
    Tapahtuma tiistaiEnsimmainenHuhtikuutaTap;
    Tapahtuma tiistaiKahdeksasHuhtikuutaTap;
    Tapahtuma tiistaiViidestoistaHuhtikuutaTap;
    Tapahtuma tiistaiKahdesKymmenesToinenHuhtikuutaTap;

    LocalDate tiistaiEnsimmainenHuhtikuuta;
    LocalDate tiistaiKahdeksasHuhtikuuta;
    LocalDate tiistaiViidestoistaHuhtikuuta;
    LocalDate tiistaiKahdeskymmenestoinenHuhtikuuta;
    @BeforeEach
    public void setUp() {

        tiistaiEnsimmainenHuhtikuuta = LocalDate.of(2025,4, 1);
        tiistaiKahdeksasHuhtikuuta = LocalDate.of(2025,4, 8);
        tiistaiViidestoistaHuhtikuuta = LocalDate.of(2025,4, 15);
        tiistaiKahdeskymmenestoinenHuhtikuuta = LocalDate.of(2025,4, 22);

        aikatauluRuutu = new AikatauluRuutu(tiistaiEnsimmainenHuhtikuuta, tiistaiKahdeskymmenestoinenHuhtikuuta, 10);
        tiistaiEnsimmainenHuhtikuutaTap = new Tapahtuma(10, 12, tiistaiEnsimmainenHuhtikuuta, "saannollinenTapahtuma");
        tiistaiKahdeksasHuhtikuutaTap = new Tapahtuma(10,12, tiistaiKahdeksasHuhtikuuta,    "randomTapahtuma");
        tiistaiViidestoistaHuhtikuutaTap = new Tapahtuma(10,12, tiistaiViidestoistaHuhtikuuta, "saannollinenTapahtuma");
        tiistaiKahdesKymmenesToinenHuhtikuutaTap = new Tapahtuma(10, 12, tiistaiKahdeskymmenestoinenHuhtikuuta, "epasaannollinenTapahtuma");
    }

    @Test
    public void testAikaTauluRuutuShouldReturnEiTapahtumaaWhenItsMostFrequentTapahtuma() {

        Tapahtuma tapahtuma = new Tapahtuma(10, 11, LocalDate.of(2025, 4, 16), "testitapahtuma");
        aikatauluRuutu.lisaa(tapahtuma);
        aikatauluRuutu.analysoi();
        String expected = "Ei Tapahtumaa";
        String actual = aikatauluRuutu.getSaannollinen();
        assertEquals(expected, actual);
    }

    @Test
    public void testAikatauluRuutuShouldReturnMostFrequentTapahtumaWhenTwoDifferentTapahtuma() {
        aikatauluRuutu.lisaa(tiistaiEnsimmainenHuhtikuutaTap);
        aikatauluRuutu.lisaa(tiistaiKahdeksasHuhtikuutaTap);
        aikatauluRuutu.lisaa(tiistaiViidestoistaHuhtikuutaTap);
        aikatauluRuutu.lisaa(tiistaiKahdesKymmenesToinenHuhtikuutaTap);
        aikatauluRuutu.analysoi();
        String actual = aikatauluRuutu.getSaannollinen();
        assertEquals("saannollinenTapahtuma", actual);

    }

    @Test
    public void testAikatauluRuutuShouldRetunrTapahtumaWithEarlierDateWhenTwoTapahtumatAreAsFrequent() {
        AikatauluRuutu aikatauluRuutu2 = new AikatauluRuutu(tiistaiEnsimmainenHuhtikuuta, tiistaiKahdeksasHuhtikuuta, 10);
        aikatauluRuutu2.lisaa(tiistaiEnsimmainenHuhtikuutaTap);
        aikatauluRuutu2.lisaa(tiistaiKahdeksasHuhtikuutaTap);
        aikatauluRuutu2.analysoi();
        String actual = aikatauluRuutu2.getSaannollinen();
        assertEquals(tiistaiEnsimmainenHuhtikuutaTap.getNimi(), actual);
    }



    @Test
    public void testAikatauluRuutuShouldKnowThatThereIsTwoPoikkeus(){
        aikatauluRuutu.lisaa(tiistaiEnsimmainenHuhtikuutaTap);
        aikatauluRuutu.lisaa(tiistaiKahdeksasHuhtikuutaTap);
        aikatauluRuutu.lisaa(tiistaiViidestoistaHuhtikuutaTap);
        aikatauluRuutu.lisaa(tiistaiKahdesKymmenesToinenHuhtikuutaTap);
        aikatauluRuutu.analysoi();
        ArrayList<Tapahtuma> poikkeukset = aikatauluRuutu.getPoikkeukset();
        int expected = 2;
        int actual = poikkeukset.size();
        for (int i = 0; i <poikkeukset.size() ; i++) {
            System.out.println(poikkeukset.get(i).getNimi());
        }
        assertEquals(expected, actual);
    }

    @Test
    public void testAikatauluRuutuShouldKnowThatMissingEventIsSaannollinen() {
        AikatauluRuutu aikatauluRuutu2 = new AikatauluRuutu(tiistaiEnsimmainenHuhtikuuta, tiistaiKahdeskymmenestoinenHuhtikuuta, 10);
        aikatauluRuutu2.lisaa(tiistaiEnsimmainenHuhtikuutaTap);
        aikatauluRuutu2.lisaa(tiistaiKahdeksasHuhtikuutaTap);
        aikatauluRuutu2.analysoi();
        String expected = "Ei Tapahtumaa";
        String actual = aikatauluRuutu2.getSaannollinen();
        assertEquals(expected, actual);
    }
}