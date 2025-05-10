package AlgorithmsTwoTest.EsitietoTest;

import AlgorithmsTwo.Esitieto.Kurssi;
import AlgorithmsTwo.Esitieto.KurssiLista;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KurssiListaTest {
        KurssiLista kurssiLista;
    @BeforeEach
    public void setUp() {
        kurssiLista = new KurssiLista();

    }

    @Test
    public void testShouldReturnFalseWhenKurssiListaHasOnlyOneElementWithNoEnnakkotieto() {
        Kurssi kurssi1 = new Kurssi(1, "jaakiekko", 1, new ArrayList<>());
        kurssiLista.lisaaKurssi(kurssi1);
        assertFalse(kurssiLista.onSilmukka());
    }

    @Test
    public void testOnSilmukkaShouldReturnTrueWhenOneElementWithItselfAsEnnakkotieto() {
        Kurssi kurssi = new Kurssi(1, "jaakiekko", 1, new int[] {1});
        kurssiLista.lisaaKurssi(kurssi);
        assertTrue(kurssiLista.onSilmukka());
    }
}
