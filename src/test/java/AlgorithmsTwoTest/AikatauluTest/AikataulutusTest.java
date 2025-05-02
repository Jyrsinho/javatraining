package AlgorithmsTwoTest.AikatauluTest;

import AlgorithmsTwo.Aikataulu.AikaTaulutus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AikataulutusTest {

    ArrayList<ArrayList<Integer>> kayttajienToiveet;
    ArrayList<Integer> kayttajan1Toiveet;

    @BeforeEach
    public void setUp() {
        kayttajan1Toiveet = new ArrayList<>();
        kayttajienToiveet = new ArrayList<>();
    }



    @Test
    public void testShouldGiveUserOneTimeOneWhenNoOtherUsersOrTimes() {
        kayttajan1Toiveet.add(1);
        kayttajienToiveet.add(kayttajan1Toiveet);
        AikaTaulutus aikaTaulutus = new AikaTaulutus(kayttajienToiveet);
        aikaTaulutus.jaaAikataulu();
        int [] actual = aikaTaulutus.annaAsiakkaidenAjat();
        int []expected = new int[1];
        assertArrayEquals(expected,actual);

    }
}
