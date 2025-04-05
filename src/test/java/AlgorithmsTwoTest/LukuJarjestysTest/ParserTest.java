package AlgorithmsTwoTest.LukuJarjestysTest;

import AlgorithmsTwo.LukuJarjestys.Kalenteri;
import AlgorithmsTwo.LukuJarjestys.Parser;
import AlgorithmsTwo.LukuJarjestys.Tapahtuma;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest {

    Parser parser;


    @BeforeEach
    public void setUp() {
        Kalenteri kalenteri = new Kalenteri(5, 24);
        parser = new Parser();

    }
    @Test
    public void testShouldReturnArrayListOfTapahtuma() {
        String syote = """ 
                        Otsikko xxx 
                        31.03.2025 10-12 B103 Luento
                        """;
        ArrayList<Tapahtuma> tapahtumat = parser.annaTapahtumat(syote);
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
        ArrayList<Tapahtuma> tapahtumat = parser.annaTapahtumat(syote);
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
}
