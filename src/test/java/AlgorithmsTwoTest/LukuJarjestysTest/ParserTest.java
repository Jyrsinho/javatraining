package AlgorithmsTwoTest.LukuJarjestysTest;

import AlgorithmsTwo.LukuJarjestys.Parser;
import AlgorithmsTwo.LukuJarjestys.Tapahtuma;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ParserTest {

    Parser parser;


    @BeforeEach
    public void setUp() {
        parser = new Parser();

    }
    @Test
    public void testShouldReturnArrayListOfTapahtuma() {
        String syote = """ 
                        Otsikko xxx 
                        31.03.2025 10-12 B103 Luento
                        """;
        parser.analysoiSyote(syote);
        ArrayList<Tapahtuma> tapahtumat = parser.annaTapahtumat();
        Tapahtuma tapahtuma = tapahtumat.get(0);
        tapahtuma.tulosta();
        assertEquals("B103 Luento" ,tapahtumat.getFirst().getNimi());
    }

    @Test
    public void testShouldReturnArrayListOfMultipleTapahtuma() {
        String syote = """
                Otsikko xxx
                31.03.2025 10-12 B103 Luento  \n 01.04.2025 12-14 C104 Tentti 
                02.04.2025 13-14 C104 Tentti
                """;
        parser.analysoiSyote(syote);
        ArrayList<Tapahtuma> tapahtumat = parser.annaTapahtumat();
        assertEquals(3, tapahtumat.size());
    }

    @Test
    public void testShouldReturnAnArrayListOfMultipleTapahtumaWhenEmptyRivit() {
        String syote = """
                          
                Otsikko xxx
                             
                02.04.2025 13-14 C104 Tentti
                        
                03.04.2025 13-14 C105 Tentti
                            
                """;
        parser.analysoiSyote(syote);
        ArrayList<Tapahtuma> tapahtumat = parser.annaTapahtumat();
        assertEquals(2, tapahtumat.size());
    }

    @Test
    public void testShouldUpdateParsersOtsikko() {
        String syote = """
                Otsikko xxx
                31.03.2025 10-12 B103 Luento  \n 01.04.2025 12-14 C104 Tentti 
                02.04.2025 13-14 C104 Tentti
                """;
        parser.analysoiSyote(syote);
        String otsikko = parser.getOtsikko();
        ArrayList<Tapahtuma> tapahtumat = parser.annaTapahtumat();
        assertEquals("Otsikko xxx", otsikko);
        assertEquals(3, tapahtumat.size());
        for (Tapahtuma tapahtuma: tapahtumat) {
            tapahtuma.tulosta();
        }
    }
    @Test
    public void testParserShouldCreateThreeTapahtumatEvenWhenLineBreaks() {
        String testiSyote = """
                Tapahtuma 1
                31.03.2025 9-11 B103 Luento
                1.4.2025 14-16 B103 Luento
                2.4.2025 10-12 B103 LuentoAlgoritmeista
                """;
        parser.analysoiSyote(testiSyote);
        String otsikko = parser.getOtsikko();
        ArrayList<Tapahtuma> tapahtumat = parser.annaTapahtumat();
        for (Tapahtuma tapahtuma: tapahtumat) {
            tapahtuma.tulosta();
        }
        assertEquals("Tapahtuma 1", otsikko);
        assertEquals(3, tapahtumat.size());
    }


   @Test
   public void testShouldHandleInputWithoutLineChanges() {
        String syote = """
                TIEA211 Algoritmit 2 Kevät 2023 21.03.2023 10-12 B103 Luento  23.03.2023 14-16 B103 Luento 23.03.2023 16-18 C231.1 Neuvonta
                """;
            parser.analysoiSyote(syote);
            String otsikko = parser.getOtsikko();
            ArrayList<Tapahtuma> tapahtumat = parser.annaTapahtumat();
            assertEquals("TIEA211 Algoritmit 2 Kevät 2023", otsikko);
            assertEquals(3, tapahtumat.size());
   }



    @Test
    public void testShouldParseLocalDateFromStringDMYYYY() {
        String mj = "3.4.2025";
        LocalDate expectedDate = LocalDate.of(2025, 4,3);
        assertEquals(expectedDate, parser.parsiPvmMerkkiJono(mj));
    }

    @Test
    public void testShouldParseLocalDateFromStringDDMMYYYY() {
        String mj = "03.04.2025";
        LocalDate expectedDate = LocalDate.of(2025,4,3);
        assertEquals(expectedDate, parser.parsiPvmMerkkiJono(mj));
    }



    @Test
    public void testParsiTapahtumaMerkkijonostaShouldCreateTapahtumaWithCorrectAlkuJaLoppuAIka() {
        String merkkijono = "     1.4.2025   13  -  15     Tapaaminen  tiimin kanssa ";
        Tapahtuma tapahtuma = parser.parsiTapahtumaMerkkijonosta(merkkijono);
        assertEquals(13, tapahtuma.getAlkuaika());
        assertEquals(15, tapahtuma.getLoppuaika());

    }

    @Test
    public void testOtsikkoJatapahtumatShouldGIveAnArrayOfOtsikkoANdTapahtumat() {
        String syote = """
                TIEA211 Algoritmit 2 Kevät 2023 21.03.2023 10-12 B103 Luento  23.03.2023 14-16 B103 Luento 23.03.2023 16-18 C231.1 Neuvonta
                """;
        String[] otsikkoJatapahtumat = parser.otsikkoJaTapahtumat(syote);
        assertEquals(4, otsikkoJatapahtumat.length);
        assertEquals("TIEA211 Algoritmit 2 Kevät 2023 ", otsikkoJatapahtumat[0]);
    }

    @Test
    public void testTapahtumaRivitShouldSeparateOtsikkoFromTapahtumat() {
        String[] otsikkoJaTapahtumat = {"TIEA211 Algoritmit 2 Kevät 2023", "10-12 B103 Luento",  "14-16 B103 Luento",
                "16-18 C231.1 Neuvonta"};
        String [] tapahtumat = parser.tapahtumaRivit(otsikkoJaTapahtumat);
        assertEquals(3, tapahtumat.length);
        assertEquals("10-12 B103 Luento", tapahtumat[0]);
    }

    @Test
    public void testEtsiPaivaMaaratShouldFindOneDate() {
        String syote = """
                TIEA211 Algoritmit 2 Kevät 2023 21.03.2023 10-12 B103 Luento             
                """;
        ArrayList<String> paivamaarat = parser.etsiPaivaMaaratSyotteesta(syote);
        assertEquals(1, paivamaarat.size());
        assertEquals("21.03.2023" ,paivamaarat.get(0));
    }

    @Test
    public void testShouldFindTwoDatesEvenWhenAttachedToString() {
        String syote = """
                TIEA211 Algoritmit 2 Kevät 2023 21.03.2023 10-12 B103 Luento01.03.2022 B102 Luento            
                """;
        ArrayList<String> paivamaarat = parser.etsiPaivaMaaratSyotteesta(syote);
        assertEquals(2, paivamaarat.size());
        assertEquals("01.03.2022" ,paivamaarat.get(1));
    }

}



/*
    Yksi tapahtuma
5.12.2023 12-13 lounas

 */

