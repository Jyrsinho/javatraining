package AlgorithmsTwoTest.EsitietoTest;

import AlgorithmsTwo.Esitieto.Esitieto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest {
    InputStream originalIn;

    @BeforeEach
    public void setUp() {
        originalIn = System.in;
    }


    @AfterEach
    public void tearDown() {
        System.setIn(originalIn);

    }

    @Test
    public void testParserShouldGiveOneEsitietoCase() {

        String simulatedInput = """
                1 Sähly 1: 0
                2 Pitsinnypläys 4:    1       0 0 0
                """;
        InputStream testInput = new ByteArrayInputStream(simulatedInput.getBytes());
        // 3. Redirect System.in to our test input
        System.setIn(testInput);

        // 4. Run the method that reads from System.in
        Esitieto.Parser parser = new Esitieto.Parser();
        ArrayList<Esitieto.KurssiLista> kurssilistat = parser.kasitteleSyote();

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
        InputStream testInput = new ByteArrayInputStream(testiSyote.getBytes());
        System.setIn(testInput);

        Esitieto.Parser parser = new Esitieto.Parser();
        ArrayList<Esitieto.KurssiLista> kurssilistat = parser.kasitteleSyote();

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
        InputStream testInput = new ByteArrayInputStream(testiSyote.getBytes());
        System.setIn(testInput);

        Esitieto.Parser parser = new Esitieto.Parser();
        ArrayList<Esitieto.KurssiLista> kurssilistat = parser.kasitteleSyote();
        Esitieto.KurssiLista kurssiLista = kurssilistat.getFirst();
        ArrayList<Esitieto.Kurssi> kurssit = kurssiLista.getKurssit();
        int expected = 4;
        assertEquals(expected, kurssit.size());
    }


    @Test
    public void testParserShouldCreate5KurssilistatWithInputContainingKaksoispisteKurssiListat() {
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
        InputStream testInput = new ByteArrayInputStream(testiSyote.getBytes());
        System.setIn(testInput);

        Esitieto.Parser parser = new Esitieto.Parser();
        ArrayList<Esitieto.KurssiLista> kurssiListat = parser.kasitteleSyote();
        int expected = 5;
        int actual = kurssiListat.size();
        assertEquals(expected, actual);
    }

    @Test
    public void KatsotaanMitaEsitietojaParsii() {
        String testiSyote = """
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
                                12 Luonnontiede 3: 6 4 2 14 3 0
                                13 Menetelmäopinnot 1: 11 2 7 14 6 15 0
                                14 Numismatiikka 4: 2 6 0
                                15 Ohjelmistotuotanto 4: 14 11 12 0
                                0
                                0
                                0
                                
                """;
        InputStream testInput = new ByteArrayInputStream(testiSyote.getBytes());
        System.setIn(testInput);
        Esitieto.Parser parser = new Esitieto.Parser();
        ArrayList<Esitieto.KurssiLista> kurssiListat = parser.kasitteleSyote();
        int expected = 1;
        int actual = kurssiListat.size();
        Esitieto.KurssiLista kurssiLista = kurssiListat.get(0);
        kurssiLista.tulostaEnnakkotiedoilla();
        assertEquals(expected, actual);
    }

}

