package AlgorithmsTwoTest.EsitietoTest;

import AlgorithmsTwo.Esitieto.Kurssi;
import AlgorithmsTwo.Esitieto.KurssiLista;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

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
        kurssiLista.analysoiKurssilista();
        assertFalse(kurssiLista.onSilmukka());
    }

    @Test
    public void testOnSilmukkaShouldReturnTrueWhenOneElementWithItselfAsEnnakkotieto() {
        Kurssi kurssi = new Kurssi(1, "jaakiekko", 1, new int[] {1});
        kurssiLista.lisaaKurssi(kurssi);
        kurssiLista.analysoiKurssilista();
        assertTrue(kurssiLista.onSilmukka());
        kurssiLista.tulosta();
    }

    @Test
    public void testOnSilmukkaShouldReturnTrueForTwoElementsWithSilmukka() {
        Kurssi kurssi1 = new Kurssi(1, "jaakiekko", 1, new int[] {2});
        Kurssi kurssi2 = new Kurssi(2, "salibandy", 1, new int[] {1});
        kurssiLista.lisaaKurssi(kurssi1);
        kurssiLista.lisaaKurssi(kurssi2);
        kurssiLista.analysoiKurssilista();
        assertTrue(kurssiLista.onSilmukka());
        kurssiLista.tulosta();
    }

    @Test
    public void testOnSilmukkaShouldReturnFalseForTwoElementsWithoutSilmukka() {
        Kurssi kurssi1 = new Kurssi(1, "jaakiekko", 1, new int[] {2});
        Kurssi kurssi2 = new Kurssi(2, "salibandy", 1, new ArrayList<>());
        kurssiLista.lisaaKurssi(kurssi1);
        kurssiLista.lisaaKurssi(kurssi2);
        kurssiLista.analysoiKurssilista();
        assertFalse(kurssiLista.onSilmukka());
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
        kurssiLista.analysoiKurssilista();
        assertTrue(kurssiLista.onSilmukka());
        kurssiLista.tulosta();
    }

    @Test
    public void testShouldSortKurssiListaWithLinearOrder() {
        Kurssi kurssi1 = new Kurssi(1, "jaakiekko", 1, new ArrayList<>());
        Kurssi kurssi2 = new Kurssi(2, "salibandy", 2, new int[] {1});
        Kurssi kurssi3 = new Kurssi(3, "istuminen", 3, new int[] {2});
        kurssiLista.lisaaKurssi(kurssi1);
        kurssiLista.lisaaKurssi(kurssi2);
        kurssiLista.lisaaKurssi(kurssi3);
        kurssiLista.analysoiKurssilista();
        int[] expected = {1,2,3};
        int [] actual = kurssiLista.getSuoritusJarjestys();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testShouldSortKurssiListaWithTwoCoursesHavingSamePrerequisite() {
        Kurssi kurssi1 = new Kurssi(1, "jaakiekko", 1, new ArrayList<>());
        Kurssi kurssi2 = new Kurssi(2, "salibandy", 2, new int[] {1});
        Kurssi kurssi3 = new Kurssi(3, "istuminen", 3, new int[] {1});
        kurssiLista.lisaaKurssi(kurssi1);
        kurssiLista.lisaaKurssi(kurssi2);
        kurssiLista.lisaaKurssi(kurssi3);
        kurssiLista.analysoiKurssilista();
        int[] expected = {1,2,3};
        int[] actual = kurssiLista.getSuoritusJarjestys();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testShouldSortTwoPrerequisitesWithDifferentPeriods() {
        Kurssi kurssi1 = new Kurssi(1, "jaakiekko", 2, new int[] {2,3} );
        Kurssi kurssi2 = new Kurssi(2, "salibandy", 4, new ArrayList<>());
        Kurssi kurssi3 = new Kurssi(3, "istuminen", 3, new ArrayList<>());
        kurssiLista.lisaaKurssi(kurssi1);
        kurssiLista.lisaaKurssi(kurssi2);
        kurssiLista.lisaaKurssi(kurssi3);
        kurssiLista.analysoiKurssilista();
        assertFalse(kurssiLista.onSilmukka());
        int[] expected = {3,2,1};
        int[] actual = kurssiLista.getSuoritusJarjestys();
        kurssiLista.tulosta();
         assertArrayEquals(expected, actual);

    }

    @Test
    public void testShouldSortTwoPrerequisitesInLeafLevelWhenLoopStartsInLeafLevel() {
        Kurssi kurssi1 = new Kurssi(1, "jaakiekko", 2, new ArrayList<>());
        Kurssi kurssi2 = new Kurssi(2, "salibandy", 1, new ArrayList<>());
        kurssiLista.lisaaKurssi(kurssi1);
        kurssiLista.lisaaKurssi(kurssi2);
        kurssiLista.analysoiKurssilista();
        int[] expected = {2,1};
        int [] actual = kurssiLista.getSuoritusJarjestys();
        kurssiLista.tulosta();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testShouldFindLoop() {
        Kurssi kurssi1 = new Kurssi(1, "LahdeKritiikki", 1, new ArrayList<>());
        Kurssi kurssi2 = new Kurssi(2, "Etiikka", 2, new int[] {6,5});
        Kurssi kurssi3 = new Kurssi(3, "Tutkimusmenetelmat", 3, new int[] {2,8,4,5});
        Kurssi kurssi4 = new Kurssi(4, "Tietosuoja",4, new int[] {} );
        Kurssi kurssi5 = new Kurssi(5, "Filosofia", 1 ,new int[] {7,6});
        Kurssi kurssi6 = new Kurssi(6, "Aidinkielie", 2, new int[]{});
        Kurssi kurssi7 = new Kurssi(7, "Diskurssianalyysi", 3, new int[] {2,6,1});
        Kurssi kurssi8 = new Kurssi(8, "Tilastotiede", 4, new int[] {});
        kurssiLista.lisaaKurssi(kurssi1); kurssiLista.lisaaKurssi(kurssi2); kurssiLista.lisaaKurssi(kurssi3);
        kurssiLista.lisaaKurssi(kurssi4); kurssiLista.lisaaKurssi(kurssi5); kurssiLista.lisaaKurssi(kurssi6);
        kurssiLista.lisaaKurssi(kurssi7); kurssiLista.lisaaKurssi(kurssi8);
        kurssiLista.analysoiKurssilista();
        kurssiLista.tulosta();
        assertTrue(kurssiLista.onSilmukka());
    }


}
