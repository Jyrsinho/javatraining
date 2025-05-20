package AlgorithmsTwoTest.AikatauluTest;

import AlgorithmsTwo.Aikataulu.AikatauluTehtava;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParserTest {
    AikatauluTehtava.Parser parser;
    InputStream originalIn;

    @BeforeEach
    public void setUp() {
        originalIn = System.in;
        parser = new AikatauluTehtava.Parser();
    }


    @AfterEach
    public void tearDown() {
        System.setIn(originalIn);

    }


    @Test
    public void testParseShouldCreateNewAikatauluFromSyote() {
        String testiSyote = """
                3 1 2 0
                3 0
                3 1 0
                0 0
                1 2 3
                """;
        InputStream testInput = new ByteArrayInputStream(testiSyote.getBytes());
        System.setIn(testInput);

        ArrayList<AikatauluTehtava.AikaTaulu> aikataulut = parser.kasitteleSyote();

        assertEquals(1, aikataulut.size());
    }

    @Test
    public void testParseShouldCreateThreeNewAikatauluFromSyote() {
        String testiSyote = """
                3 1 2 0
                3 0
                3 1 0
                0
                4 2 5 0 2 4 0 4 2 0 0
                1 2 4 0 1 0 1 3 5 0 4 0 1 4 0 0
                0
                """;
        InputStream testInput = new ByteArrayInputStream(testiSyote.getBytes());
        System.setIn(testInput);
        ArrayList<AikatauluTehtava.AikaTaulu> aikataulut = parser.kasitteleSyote();
        assertEquals(3, aikataulut.size());
    }

    @Test
    public void testParserShouldNotChopTens() {
        String testiSyote = """
                3 7 0
                4 6 7 9 0
                9 0
                        10 0
                0
                2 5 0
                11 0
                9 0
                0
                0
                """;
        InputStream testInput = new ByteArrayInputStream(testiSyote.getBytes());
        System.setIn(testInput);
        ArrayList<AikatauluTehtava.AikaTaulu> aikataulut = parser.kasitteleSyote();
        assertEquals(2, aikataulut.size());
    }


   @Test
   public void testParserShouldCreateThreeUsersWithPreferredTimesOneTwoAndThree() {
        String testiSyote = """
                1 2 3 0
                1 2 0
                1 2 3  0
                0 0 
                """;
        InputStream testInput = new ByteArrayInputStream(testiSyote.getBytes());
        System.setIn(testInput);
        ArrayList<AikatauluTehtava.AikaTaulu> aikataulut = parser.kasitteleSyote();
        AikatauluTehtava.AikaTaulu aikaTaulu = aikataulut.getFirst();
        ArrayList<Integer> dummynToiveet = aikaTaulu.getKayttajanToiveet(0);
        ArrayList<Integer> ekanKayttajanToiveet = aikaTaulu.getKayttajanToiveet(1);
        ArrayList<Integer> tokanKayttajantoiveet = aikaTaulu.getKayttajanToiveet(2);
        ArrayList<Integer> kolmannenKayttajantoiveet = aikaTaulu.getKayttajanToiveet(3);
        System.out.println(Arrays.toString(dummynToiveet.toArray()));
        System.out.println(Arrays.toString(ekanKayttajanToiveet.toArray()));
        System.out.println(Arrays.toString(tokanKayttajantoiveet.toArray()));
        System.out.println(Arrays.toString(kolmannenKayttajantoiveet.toArray()));
        assertTrue(dummynToiveet.isEmpty());
        assertEquals(1, ekanKayttajanToiveet.get(0));
        assertEquals(2, ekanKayttajanToiveet.get(1));
        assertEquals(3, ekanKayttajanToiveet.get(2));
        assertEquals(1, tokanKayttajantoiveet.get(0));
        assertEquals(2, tokanKayttajantoiveet.get(1));
        assertEquals(1, kolmannenKayttajantoiveet.get(0));
        assertEquals(2, kolmannenKayttajantoiveet.get(1));
        assertEquals(3, kolmannenKayttajantoiveet.get(2));
   }

}
