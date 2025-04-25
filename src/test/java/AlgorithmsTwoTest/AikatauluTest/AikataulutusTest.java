package AlgorithmsTwoTest.AikatauluTest;

import AlgorithmsTwo.Aikataulu.AikaTaulutus;
import AlgorithmsTwo.Aikataulu.Kayttaja;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AikataulutusTest {
    ArrayList<Kayttaja> kayttajat;
    Kayttaja kayttaja1;
    Kayttaja kayttaja2;
    Kayttaja kayttaja3;
    ArrayList<Integer> kayttajanToiveet;

    @BeforeEach
    public void setUp() {
        kayttajanToiveet = new ArrayList<>();
        kayttajat = new ArrayList<>();
        ArrayList<Integer> kayttajan1Toiveet = new ArrayList<>();
        kayttajan1Toiveet.add(1);

        ArrayList<Integer> kayttajan2Toiveet = new ArrayList<>();
        kayttajan2Toiveet.add(2);

        ArrayList<Integer> kayttajan3Toiveet = new ArrayList<>();
        kayttajan3Toiveet.add(1);
        kayttajan3Toiveet.add(2);
        kayttajan3Toiveet.add(3);

        kayttaja1= new Kayttaja(1, kayttajan1Toiveet);
        kayttaja2= new Kayttaja(2, kayttajan2Toiveet);
        kayttaja3 = new Kayttaja(3, kayttajan3Toiveet);
    }

    @Test
    public void testShouldReturnOneForOneUserAndOneAika() {
        kayttajat.add(kayttaja1);
        AikaTaulutus aikaTaulutus = new AikaTaulutus(kayttajat);
        String expected = "    1";
        String actual = aikaTaulutus.jaaAikataulu();
        assertEquals(expected, actual);
    }

    @Test
    public void testShouldRetunrOneAndTwoForUsersOneANdTwo() {
        kayttajat.add(kayttaja1);
        kayttajat.add(kayttaja2);
        AikaTaulutus aikaTaulutus = new AikaTaulutus(kayttajat);
        String expected = "    1    2";
        String actual = aikaTaulutus.jaaAikataulu();
        assertEquals(expected, actual);
    }

    @Test
    public void testShouldReturnThreeForOneOneForTwoAndTwoForThree() {
        kayttajat.add(kayttaja1);
        kayttajat.add(kayttaja2);
        kayttajat.add(kayttaja3);
        AikaTaulutus aikaTaulutus = new AikaTaulutus(kayttajat);
        String expected = "    1    2    3";
        String actual = aikaTaulutus.jaaAikataulu();
        assertEquals(expected, actual);

    }

    @Test
    public void testShouldGiveOneTwoAndTwoOne() {
        kayttajat.add(kayttaja2);
        kayttajat.add(kayttaja1);
        AikaTaulutus aikaTaulutus = new AikaTaulutus(kayttajat);
        String expected = "    2    1";
        String actual = aikaTaulutus.jaaAikataulu();
        assertEquals(expected, actual);
    }

    @Test
    public void testShouldGiveTimeOnlyForOneAndTwoWhenFourWantsTheSameTimes() {
        ArrayList<Integer> kayttajanToiveet4 = new ArrayList<>();
        kayttajanToiveet4.add(1);
        kayttajanToiveet4.add(2);
        Kayttaja kayttaja4 = new Kayttaja(4, kayttajanToiveet4);
        kayttajat.add(kayttaja1);
        kayttajat.add(kayttaja2);
        kayttajat.add(kayttaja4);
        AikaTaulutus aikaTaulutus = new AikaTaulutus(kayttajat);
        String expected = "    1    2    0";
        String actual = aikaTaulutus.jaaAikataulu();
        assertEquals(expected, actual);
    }

    @Test
    public void testShouldGiveTimeToUserOneIfUsersWithBiggerIDWantTheSam() {
       kayttajat.add(kayttaja1);
       kayttajat.add(kayttaja2);
       kayttajanToiveet.add(1);
       kayttajanToiveet.add(2);
       Kayttaja kayttaja6 = new Kayttaja(6, kayttajanToiveet);
       kayttajat.add(kayttaja6);
       AikaTaulutus aikaTaulutus = new AikaTaulutus(kayttajat);
       String expected = "    1    2    0";
       String actual = aikaTaulutus.jaaAikataulu();
       assertEquals(expected, actual);
    }
}
