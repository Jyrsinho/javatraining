package AlgorithmsTwoTest.AikatauluTest;

import AlgorithmsTwo.Aikataulu.Parser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest {
    Parser parser;

    @BeforeEach
    public void setUp() {
        parser = new Parser();
    }

    @Test
    public void testParseShouldCreateNewTapausFromSyote() {
        String testiSyote = """
                3 1 2 0
                3 0
                3 1 0
                0 0
                """;
        parser.kasitteleSyote(testiSyote);
        parser.tulostaAikataulutukset();
        assertEquals(1, parser.annaTapaukset().size());
    }

    @Test
    public void testParseShouldCreateNewTapauksetFromSyote() {
        String testiSyote = """
                3 1 2 0
                3 0
                3 1 0
                0
                4 2 5 0 2 4 0 4 2 0 0
                1 2 4 0 1 0 1 3 5 0 4 0 1 4 0 0
                0
                """;
        parser.kasitteleSyote(testiSyote);
        parser.tulostaAikataulutukset();
        assertEquals(3, parser.annaTapaukset().size());
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
        parser.kasitteleSyote(testiSyote);
        parser.tulostaAikataulutukset();
        assertEquals(2, parser.annaTapaukset().size());
    }
}
