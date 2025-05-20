package AlgorithmsTwoTest.AikatauluTest;

import AlgorithmsTwo.Aikataulu.AikatauluTehtava;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AikatauluTest {

    AikatauluTehtava.AikaTaulu aikaTaulu = new AikatauluTehtava.AikaTaulu();
    ArrayList<Integer> dummyKayttajanToiveet = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        aikaTaulu = new AikatauluTehtava.AikaTaulu();
        aikaTaulu.lisaaKayttaja(dummyKayttajanToiveet);

    }

    @Test
    public void testShouldGiveAikaToOneUser() {
        ArrayList<Integer> kayttajan1Toiveet = new ArrayList<>();
        kayttajan1Toiveet.add(1);
        aikaTaulu.lisaaKayttaja(kayttajan1Toiveet);
        int [] aikataulutus = aikaTaulu.jaaAikataulu();
        int[] expected = {-1, 1};
        aikaTaulu.tulostaAikataulu();
        assertArrayEquals(expected, aikataulutus);
    }

    @Test
    public void testShouldGiveAikaToTwoUsersWhenNoCompetingPreferences() {
        ArrayList<Integer> kayttajan1Toiveet = new ArrayList<>();
        kayttajan1Toiveet.add(1);
        ArrayList<Integer> kayttajan2Toiveet = new ArrayList<>();
        kayttajan2Toiveet.add(2);
        aikaTaulu.lisaaKayttaja(kayttajan1Toiveet);
        aikaTaulu.lisaaKayttaja(kayttajan2Toiveet);
        int [] aikataulutus = aikaTaulu.jaaAikataulu();
        int [] expected = {-1, 1, 2};
        aikaTaulu.tulostaAikataulu();
        assertArrayEquals(expected, aikataulutus);
    }

    @Test
    public void testShouldGiveAikaToFirstUserWhenCompetingPreferences() {
        ArrayList<Integer> kayttajan1Toiveet = new ArrayList<>();
        kayttajan1Toiveet.add(1);
        ArrayList<Integer> kayttajan2Toiveet = new ArrayList<>();
        kayttajan2Toiveet.add(1);
        aikaTaulu.lisaaKayttaja(kayttajan1Toiveet);
        aikaTaulu.lisaaKayttaja(kayttajan2Toiveet);
        int[] aikataulutus = aikaTaulu.jaaAikataulu();
        int [] expected = {-1, 1};
        aikaTaulu.tulostaAikataulu();
        assertArrayEquals(expected, aikataulutus);
    }

    @Test
    public void testShouldGiveAikaToAllThreeUsersWhenCompetingPreferences() {
        ArrayList<Integer> kayttajan0Toiveet = new ArrayList<>();
        kayttajan0Toiveet.add(1);
        kayttajan0Toiveet.add(3);
        ArrayList<Integer> kayttajan1Toiveet = new ArrayList<>();
        kayttajan1Toiveet.add(2);
        ArrayList<Integer> kayttajan2Toiveet = new ArrayList<>();
        kayttajan2Toiveet.add(1);
        aikaTaulu.lisaaKayttaja(kayttajan0Toiveet);
        aikaTaulu.lisaaKayttaja(kayttajan1Toiveet);
        aikaTaulu.lisaaKayttaja(kayttajan2Toiveet);
        // matching palauttaa aikojen indekseihin sijoitetut asiakkaat
        // eli tuloksena pitais siis olla
        // ajat:        0   1   2   3
        // kayttajat:   -1  3   1   0
        int[] aikataulutus = aikaTaulu.jaaAikataulu();
        int[] expected = {-1, 3, 2, 1};
        aikaTaulu.tulostaAikataulu();
        assertArrayEquals(expected, aikataulutus);
    }

    @Test
    public void opettajanTestiSyote1() {
       ArrayList<Integer> kayttajan0Toiveet = new ArrayList<>();
       ArrayList<Integer> kayttajan1Toiveet = new ArrayList<>();
       ArrayList<Integer> kayttajan2Toiveet = new ArrayList<>();
       kayttajan0Toiveet.add(3);

       kayttajan1Toiveet.add(3);
       kayttajan1Toiveet.add(2);

       kayttajan2Toiveet.add(3);
       kayttajan2Toiveet.add(1);

       aikaTaulu.lisaaKayttaja(kayttajan0Toiveet);
       aikaTaulu.lisaaKayttaja(kayttajan1Toiveet);
       aikaTaulu.lisaaKayttaja(kayttajan2Toiveet);

       int[] aikataulutus = aikaTaulu.jaaAikataulu();
       int[] expected = {-1, 3, 2, 1};
       aikaTaulu.tulostaAikataulu();
       assertArrayEquals(expected, aikataulutus);
    }

}
