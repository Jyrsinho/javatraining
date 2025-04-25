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

    @BeforeEach
    public void setUp() {

        kayttajat = new ArrayList<>();
        ArrayList<Integer> kayttajan1Toiveet = new ArrayList<>();
        kayttajan1Toiveet.add(1);

        ArrayList<Integer> kayttajan2Toiveet = new ArrayList<>();
        kayttajan2Toiveet.add(2);

        kayttaja1= new Kayttaja(1, kayttajan1Toiveet);
        kayttaja2= new Kayttaja(2, kayttajan2Toiveet);
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
}
