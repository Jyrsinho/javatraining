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
                0
                """;
        parser.kasitteleSyote(testiSyote);
        assertEquals(1, parser.annaTapaukset().size());
    }
}
