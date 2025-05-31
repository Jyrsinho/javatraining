package AlgorithmsTwoTest.EsitietoTest;

import AlgorithmsTwo.Esitieto.Esitieto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class KurssiListaTest {
    Esitieto.KurssiLista kurssiLista;

    @BeforeEach
    public void setUp() {
        kurssiLista = new Esitieto.KurssiLista();
        kurssiLista.lisaaKurssi(new Esitieto.Kurssi(0, "dummy", 0, new ArrayList<>()));

    }

    @Test
    public void testShouldReturnFalseWhenKurssiListaHasOnlyOneElementWithNoEnnakkotieto() {
        Esitieto.Kurssi kurssi1 = new Esitieto.Kurssi(1, "jaakiekko", 1, new ArrayList<>());
        kurssiLista.lisaaKurssi(kurssi1);
        kurssiLista.analysoiKurssilista();
        assertFalse(kurssiLista.onSilmukka());
    }

    @Test
    public void testOnSilmukkaShouldReturnTrueWhenOneElementWithItselfAsEnnakkotieto() {
        Esitieto.Kurssi kurssi = new Esitieto.Kurssi(1, "jaakiekko", 1, new int[]{1});
        kurssiLista.lisaaKurssi(kurssi);
        kurssiLista.analysoiKurssilista();
        assertTrue(kurssiLista.onSilmukka());
    }


    @Test
    public void testOnSilmukkaShouldReturnTrueForTwoElementsWithSilmukka() {
        Esitieto.Kurssi kurssi1 = new Esitieto.Kurssi(1, "jaakiekko", 1, new int[]{2});
        Esitieto.Kurssi kurssi2 = new Esitieto.Kurssi(2, "salibandy", 1, new int[]{1});
        kurssiLista.lisaaKurssi(kurssi1);
        kurssiLista.lisaaKurssi(kurssi2);
        kurssiLista.analysoiKurssilista();
        assertTrue(kurssiLista.onSilmukka());
    }


    @Test
    public void testOnSilmukkaShouldReturnFalseForTwoElementsWithoutSilmukka() {
        Esitieto.Kurssi kurssi1 = new Esitieto.Kurssi(1, "jaakiekko", 1, new int[]{2});
        Esitieto.Kurssi kurssi2 = new Esitieto.Kurssi(2, "salibandy", 1, new ArrayList<>());
        kurssiLista.lisaaKurssi(kurssi1);
        kurssiLista.lisaaKurssi(kurssi2);
        kurssiLista.analysoiKurssilista();
        assertFalse(kurssiLista.onSilmukka());
    }

    @Test
    public void testShouldReturnOnSilmukkaWhenFiveElementsWithSilmukka() {
        Esitieto.Kurssi kurssi1 = new Esitieto.Kurssi(1, "jaakiekko", 1, new int[]{2});
        Esitieto.Kurssi kurssi2 = new Esitieto.Kurssi(2, "salibandy", 1, new int[]{3});
        Esitieto.Kurssi kurssi3 = new Esitieto.Kurssi(3, "syominen ", 1, new int[]{4, 5, 6});
        Esitieto.Kurssi kurssi4 = new Esitieto.Kurssi(4, "istuminen", 1, new int[]{5});
        Esitieto.Kurssi kurssi5 = new Esitieto.Kurssi(5, "uiminen", 1, new int[]{6});
        Esitieto.Kurssi kurssi6 = new Esitieto.Kurssi(6, "puiminen", 1, new int[]{1});
        kurssiLista.lisaaKurssi(kurssi1);
        kurssiLista.lisaaKurssi(kurssi2);
        kurssiLista.lisaaKurssi(kurssi3);
        kurssiLista.lisaaKurssi(kurssi4);
        kurssiLista.lisaaKurssi(kurssi5);
        kurssiLista.lisaaKurssi(kurssi6);
        kurssiLista.analysoiKurssilista();
        assertTrue(kurssiLista.onSilmukka());
    }


    @Test
    public void testShouldSortKurssiListaWithLinearOrder() {
        Esitieto.Kurssi kurssi1 = new Esitieto.Kurssi(1, "jaakiekko", 1, new ArrayList<>());
        Esitieto.Kurssi kurssi2 = new Esitieto.Kurssi(2, "salibandy", 2, new int[]{1});
        Esitieto.Kurssi kurssi3 = new Esitieto.Kurssi(3, "istuminen", 3, new int[]{2});
        kurssiLista.lisaaKurssi(kurssi1);
        kurssiLista.lisaaKurssi(kurssi2);
        kurssiLista.lisaaKurssi(kurssi3);
        kurssiLista.analysoiKurssilista();
        int[] expected = {1, 2, 3};
        int[] actual = kurssiLista.getSuoritusJarjestys();
        assertFalse(kurssiLista.onSilmukka());
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testShouldSortKurssiListaWithTwoCoursesHavingSamePrerequisite() {
        Esitieto.Kurssi kurssi1 = new Esitieto.Kurssi(1, "jaakiekko", 1, new ArrayList<>());
        Esitieto.Kurssi kurssi2 = new Esitieto.Kurssi(2, "salibandy", 2, new int[]{1});
        Esitieto.Kurssi kurssi3 = new Esitieto.Kurssi(3, "istuminen", 3, new int[]{1});
        kurssiLista.lisaaKurssi(kurssi1);
        kurssiLista.lisaaKurssi(kurssi2);
        kurssiLista.lisaaKurssi(kurssi3);
        kurssiLista.analysoiKurssilista();
        int[] expected = {1, 2, 3};
        int[] actual = kurssiLista.getSuoritusJarjestys();
        assertArrayEquals(expected, actual);
    }


    @Test
    public void testShouldSortTwoPrerequisitesWithDifferentPeriods() {
        Esitieto.Kurssi kurssi1 = new Esitieto.Kurssi(1, "jaakiekko", 2, new int[]{2, 3});
        Esitieto.Kurssi kurssi2 = new Esitieto.Kurssi(2, "salibandy", 4, new ArrayList<>());
        Esitieto.Kurssi kurssi3 = new Esitieto.Kurssi(3, "istuminen", 3, new ArrayList<>());
        kurssiLista.lisaaKurssi(kurssi1);
        kurssiLista.lisaaKurssi(kurssi2);
        kurssiLista.lisaaKurssi(kurssi3);
        kurssiLista.analysoiKurssilista();
        assertFalse(kurssiLista.onSilmukka());
        int[] expected = {3, 2, 1};
        int[] actual = kurssiLista.getSuoritusJarjestys();
        assertArrayEquals(expected, actual);

    }


    @Test
    public void testShouldSortTwoPrerequisitesInLeafLevelWhenLoopStartsInLeafLevel() {
        Esitieto.Kurssi kurssi1 = new Esitieto.Kurssi(1, "jaakiekko", 2, new ArrayList<>());
        Esitieto.Kurssi kurssi2 = new Esitieto.Kurssi(2, "salibandy", 1, new ArrayList<>());
        kurssiLista.lisaaKurssi(kurssi1);
        kurssiLista.lisaaKurssi(kurssi2);
        kurssiLista.analysoiKurssilista();
        int[] expected = {2, 1};
        int[] actual = kurssiLista.getSuoritusJarjestys();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testShouldFindLoop() {
        Esitieto.Kurssi kurssi1 = new Esitieto.Kurssi(1, "LahdeKritiikki", 1, new ArrayList<>());
        Esitieto.Kurssi kurssi2 = new Esitieto.Kurssi(2, "Etiikka", 2, new int[]{6, 5});
        Esitieto.Kurssi kurssi3 = new Esitieto.Kurssi(3, "Tutkimusmenetelmat", 3, new int[]{2, 8, 4, 5});
        Esitieto.Kurssi kurssi4 = new Esitieto.Kurssi(4, "Tietosuoja", 4, new int[]{});
        Esitieto.Kurssi kurssi5 = new Esitieto.Kurssi(5, "Filosofia", 1, new int[]{7, 6});
        Esitieto.Kurssi kurssi6 = new Esitieto.Kurssi(6, "Aidinkielie", 2, new int[]{});
        Esitieto.Kurssi kurssi7 = new Esitieto.Kurssi(7, "Diskurssianalyysi", 3, new int[]{2, 6, 1});
        Esitieto.Kurssi kurssi8 = new Esitieto.Kurssi(8, "Tilastotiede", 4, new int[]{});
        kurssiLista.lisaaKurssi(kurssi1);
        kurssiLista.lisaaKurssi(kurssi2);
        kurssiLista.lisaaKurssi(kurssi3);
        kurssiLista.lisaaKurssi(kurssi4);
        kurssiLista.lisaaKurssi(kurssi5);
        kurssiLista.lisaaKurssi(kurssi6);
        kurssiLista.lisaaKurssi(kurssi7);
        kurssiLista.lisaaKurssi(kurssi8);
        kurssiLista.analysoiKurssilista();
        assertTrue(kurssiLista.onSilmukka());
    }


}


