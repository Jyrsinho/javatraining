package AlgorithmsTwoTest.EsitietoTest;

import AlgorithmsTwo.Esitieto.KurssiLista;
import AlgorithmsTwo.Esitieto.Parser;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest {

    @Test
    public void testParserShouldGiveTwoEsitietoCases() {
        String testiSyote = """
                1 Sähly 1: 7 3 8 0
                2 Pitsinnypläys 4: 5 4 8 6 1 10
                7 3 0  0       0
                """;
        Parser parser = new Parser();
        ArrayList<KurssiLista> kurssilistat = parser.kasitteleSyote(testiSyote);
        int expected = 2;
        assertEquals(expected, kurssilistat.size());
    }
}
