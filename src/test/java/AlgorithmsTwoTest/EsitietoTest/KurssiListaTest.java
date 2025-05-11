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
        kurssiLista.lisaaKurssi(new Kurssi(0, "dummy", 0, new ArrayList<>()));

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
        kurssiLista.tulosta();
    }

    @Test
    public void testOnSilmukkaShouldReturnTrueForTwoElementsWithSilmukka() {
        Kurssi kurssi1 = new Kurssi(1, "jaakiekko", 1, new int[] {2});
        Kurssi kurssi2 = new Kurssi(2, "salibandy", 1, new int[] {1});
        kurssiLista.lisaaKurssi(kurssi1);
        kurssiLista.lisaaKurssi(kurssi2);
        assertTrue(kurssiLista.onSilmukka());
        kurssiLista.tulosta();
    }

    @Test
    public void testOnSilmukkaShouldReturnFalseForTwoElementsWithoutSilmukka() {
        Kurssi kurssi1 = new Kurssi(1, "jaakiekko", 1, new int[] {2});
        Kurssi kurssi2 = new Kurssi(2, "salibandy", 1, new ArrayList<>());
        kurssiLista.lisaaKurssi(kurssi1);
        kurssiLista.lisaaKurssi(kurssi2);
        assertFalse(kurssiLista.onSilmukka());
        kurssiLista.tulosta();
    }

    @Test
    public void testShouldReturnOnSilmukkaWhenFiveElementsWithSilmukka() {
        Kurssi kurssi1 = new Kurssi(1, "jaakiekko", 1, new int[] {2});
        Kurssi kurssi2 = new Kurssi(2, "salibandy", 1, new int[] {3});
        Kurssi kurssi3 = new Kurssi(3, "syominen ", 1, new int[] {4,5,6});
        Kurssi kurssi4 = new Kurssi(4, "istuminen", 1, new int[] {5});
        Kurssi kurssi5 = new Kurssi(5, "uiminen", 1, new int[] {6});
        Kurssi kurssi6 = new Kurssi(6, "puiminen", 1, new int[] {1});
        kurssiLista.lisaaKurssi(kurssi1);
        kurssiLista.lisaaKurssi(kurssi2);
        kurssiLista.lisaaKurssi(kurssi3);
        kurssiLista.lisaaKurssi(kurssi4);
        kurssiLista.lisaaKurssi(kurssi5);
        kurssiLista.lisaaKurssi(kurssi6);
        assertTrue(kurssiLista.onSilmukka());
        kurssiLista.tulosta();
    }
}
