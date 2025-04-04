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
        assertEquals("Otsikko xxx", otsikko);
    }

   @Test
   public void testShouldHandleInputWithoutLineChanges() {
        String syote = """
                TIEA211 Algoritmit 2 Kevät 2023 21.03.2023 10-12 B103 Luento 23.03.2023 14-16 B103 Luento 23.03.2023 16-18 C231.1 Neuvonta
                """;
            parser.analysoiSyote(syote);
            String otsikko = parser.getOtsikko();
            ArrayList<Tapahtuma> tapahtumat = parser.annaTapahtumat();
            assertEquals("TIEA211 Algoritmit 2 Kevät 2023", otsikko);
            assertEquals(3, tapahtumat.size());
   }

   @Test
   public void testShouldReturnTrueForPaivaMaaraDMYYYY() {
        String mj = "4.3.2025";
        assertTrue(parser.onPvm(mj));
   }

   @Test
   public void testOnPvmShouldReturnFalseForKissa() {
        String mj = "kissa";
        assertFalse(parser.onPvm(mj));
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
    public void testPilkoSyoteShouldSplitSyoteIntoStringArray() {
        String syote = """
                Otsikko xxx 31.03.2025 10-12 B103 Luento   01.04.2025 12-14 C104 Tentti 02.04.2025 13-14 C104 Tentti
                """;
        String[] pilkottuSyote = parser.pilkoSyote(syote);
        for (int i = 0; i < pilkottuSyote.length; i++) {
            System.out.println(pilkottuSyote[i]);
        }
        assertEquals(4, pilkottuSyote.length);
    }
/*
    Yksi tapahtuma
5.12.2023 12-13 lounas

 */
}
