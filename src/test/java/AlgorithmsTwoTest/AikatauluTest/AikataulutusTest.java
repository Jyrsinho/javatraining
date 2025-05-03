package AlgorithmsTwoTest.AikatauluTest;

import AlgorithmsTwo.Aikataulu.AikaTaulutus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AikataulutusTest {

    ArrayList<ArrayList<Integer>> kayttajienToiveet;
    ArrayList<Integer> kayttajan1Toiveet;
    ArrayList<Integer> kayttajan2Toiveet;
    ArrayList<Integer> kayttajan3Toiveet;
    ArrayList<Integer> kayttajan4Toiveet;

    @BeforeEach
    public void setUp() {
        kayttajan1Toiveet = new ArrayList<>();
        kayttajan2Toiveet = new ArrayList<>();
        kayttajan3Toiveet = new ArrayList<>();
        kayttajan4Toiveet = new ArrayList<>();
        kayttajienToiveet = new ArrayList<>();
    }



    @Test
    public void testShouldGiveUserOneTimeOneWhenNoOtherUsersOrTimes() {
        kayttajan1Toiveet.add(1);
        kayttajienToiveet.add(kayttajan1Toiveet);
        AikaTaulutus aikaTaulutus = new AikaTaulutus(kayttajienToiveet);
        aikaTaulutus.jaaAikataulu();
        int [] actual = aikaTaulutus.annaAsiakkaidenAjat();
        int []expected = new int[]{0, 1};
        aikaTaulutus.tulostaAjat();
        assertArrayEquals(expected,actual);

    }

    @Test
    public void tstShouldGiveThreeUsersTime() {
       kayttajan1Toiveet.add(1);
       kayttajan2Toiveet.add(2);
       kayttajan3Toiveet.add(3);
       kayttajienToiveet.add(kayttajan1Toiveet);
       kayttajienToiveet.add(kayttajan2Toiveet);
       kayttajienToiveet.add(kayttajan3Toiveet);

       AikaTaulutus aikaTaulutus = new AikaTaulutus(kayttajienToiveet);
       aikaTaulutus.jaaAikataulu();
       int [] actual = aikaTaulutus.annaAsiakkaidenAjat();
       int []expected =  {0, 1, 2, 3};
       aikaTaulutus.tulostaAjat();
       assertArrayEquals(expected,actual);
    }

    @Test
    public void testShouldGiveTwoUsersTimeAndOneZero() {
        kayttajan1Toiveet.add(1);
        kayttajan1Toiveet.add(2);
        kayttajan2Toiveet.add(2);
        kayttajan2Toiveet.add(2);
        kayttajan3Toiveet.add(1);
        kayttajan3Toiveet.add(2);
        kayttajienToiveet.add(kayttajan1Toiveet);
        kayttajienToiveet.add(kayttajan2Toiveet);
        kayttajienToiveet.add(kayttajan3Toiveet);

        AikaTaulutus aikaTaulutus = new AikaTaulutus(kayttajienToiveet);
        aikaTaulutus.jaaAikataulu();
        int [] actual = aikaTaulutus.annaAsiakkaidenAjat();
        int [] expected = {0, 1, 2, 0};
        aikaTaulutus.tulostaAjat();
        assertArrayEquals(expected,actual);
    }

    @Test
    public void testShouldKnowHowToShuffleTimesBetweenUsers() {
        kayttajan1Toiveet.add(1);
        kayttajan1Toiveet.add(2);
        kayttajan2Toiveet.add(3);
        kayttajan2Toiveet.add(1);
        kayttajan2Toiveet.add(2);
        kayttajan2Toiveet.add(3);
        kayttajan3Toiveet.add(1);
        kayttajan3Toiveet.add(2);
        kayttajan3Toiveet.add(3);

        kayttajienToiveet.add(kayttajan1Toiveet);
        kayttajienToiveet.add(kayttajan2Toiveet);
        kayttajienToiveet.add(kayttajan3Toiveet);

        AikaTaulutus aikaTaulutus = new AikaTaulutus(kayttajienToiveet);
        aikaTaulutus.jaaAikataulu();
        int [] actual = aikaTaulutus.annaAsiakkaidenAjat();
        int [] expected = {0, 1, 3, 2};
        aikaTaulutus.tulostaAjat();
        assertArrayEquals(expected,actual);
    }

    @Test
    public void testShouldGiveAikaToKayttajaWithSmallerIndex() {
        kayttajan1Toiveet.add(1);
        kayttajan2Toiveet.add(2);
        kayttajan3Toiveet.add(1);
        kayttajan3Toiveet.add(2);

        kayttajienToiveet.add(kayttajan1Toiveet);
        kayttajienToiveet.add(kayttajan2Toiveet);
        kayttajienToiveet.add(kayttajan3Toiveet);
        kayttajienToiveet.add(kayttajan4Toiveet);

        AikaTaulutus aikaTaulutus = new AikaTaulutus(kayttajienToiveet);
        aikaTaulutus.jaaAikataulu();
        int [] actual = aikaTaulutus.annaAsiakkaidenAjat();
        int [] expected = {0, 1,2,0,0};
        aikaTaulutus.tulostaAjat();
        assertArrayEquals(expected,actual);

    }
}
