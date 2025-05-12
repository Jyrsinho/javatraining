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
    public void testParserShouldCreateKurssiListaWithThreeKurssiAndDummy() {
        String testiSyote = """
                1 kokkaus 1: 2 0
                2 ruuanlaitto 2:    1 0 
                3 pesapallo 3: 1 0 0 0
                """;
        Parser parser = new Parser();
        ArrayList<KurssiLista> kurssilistat = parser.kasitteleSyote(testiSyote);
        KurssiLista kurssiLista = kurssilistat.getFirst();
        ArrayList<Kurssi> kurssit = kurssiLista.getKurssit();
        int expected = 4;
        assertEquals(expected, kurssit.size());
    }

    @Test
    public void testParserShouldCreateXKurssiListat() {
        // KURSSISSA 5 on kaksi ":" merkkia. Ehka me nyt mietitaan parserin toiminta uudestaan
        String testiSyote = """
                1 Ainoa_kurssi 3 : 0
                0
                1 Ainoa_kurssi 3 : 1 0
                0
                1 EkaKurssi 3 : 0
                2 TokaKurssi 2 : 2 0
                0
                1 KurssiA 3 : 0
                2 KurssiB 3 : 1 0
                0
                1 Algoritmit 4: 11 14 15 12 7 5 3 0
                2 Biologia 1: 0
                3 C-kurssi 3: 0
                4 Diskurssianalyysi 3: 10 14 6 1 15 7 0
                5 Erikoiskurssi: 4: 8 0
                6 Fiilistelykurssi 1: 2 3 0
                7 Graduseminaari 3: 3 11 2 15 14 0
                8 Harjoitustyö 1: 0
                9 Itsenäinen_projekti 3: 2 1 14 4 3 10 0
                10 Jatkokurssi 3: 11 5 8 13 12 0
                11 Kokeelliset_menetelmät 3: 3 6 0
                12 Luonnontiede 3: 6 2 14 3 0
                13 Menetelmäopinnot 1: 11 2 7 14 6 15 0
                14 Numismatiikka 4: 2 6 0
                15 Ohjelmistotuotanto 4: 14 11 12 0
                0
                0
                """;
        Parser parser = new Parser();
        ArrayList<KurssiLista> kurssiListat = parser.kasitteleSyote(testiSyote);
        int expected = 5;
        int actual = kurssiListat.size();
        assertEquals(expected, actual);


    }


}
