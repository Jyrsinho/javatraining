package AlgorithmsTwoTest.EsitietoTest;

import AlgorithmsTwo.Esitieto.Kurssi;
import AlgorithmsTwo.Esitieto.KurssiLista;
import AlgorithmsTwo.Esitieto.Parser;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest {

    @Test
    public void testParserShouldGiveOneEsitietoCase() {
        String testiSyote = """
                1 Sähly 1: 0
                2 Pitsinnypläys 4:    1       0 0 0
                """;
        Parser parser = new Parser();
        ArrayList<KurssiLista> kurssilistat = parser.kasitteleSyote(testiSyote);
        int expected = 1;
        assertEquals(expected, kurssilistat.size());
    }

    @Test
    public void testParserShouldGiveTwoEsitietoCases() {
        String testiSyote = """
                1 kokkaus 1: 2 0
                2 ruuanlaitto 2:    1 0 0 
                1 jaakiekko 1: 2 0
                2 pesapallo 3: 1 0 0 0
                """;
        Parser parser = new Parser();
        ArrayList<KurssiLista> kurssilistat = parser.kasitteleSyote(testiSyote);
        int expected = 2;
        assertEquals(expected, kurssilistat.size());
    }

    @Test
    public void testParserShouldCreateKurssiListaWithThreeKurssi() {
        String testiSyote = """
                1 kokkaus 1: 2 0
                2 ruuanlaitto 2:    1 0 
                3 pesapallo 3: 1 0 0 0
                """;
        Parser parser = new Parser();
        ArrayList<KurssiLista> kurssilistat = parser.kasitteleSyote(testiSyote);
        KurssiLista kurssiLista = kurssilistat.getFirst();
        ArrayList<Kurssi> kurssit = kurssiLista.getKurssit();
        int expected = 3;
        kurssiLista.tulostaKurssit();
        assertEquals(expected, kurssit.size());
    }


}
