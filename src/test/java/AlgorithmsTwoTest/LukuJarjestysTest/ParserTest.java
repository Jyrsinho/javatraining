package AlgorithmsTwoTest.LukuJarjestysTest;

import AlgorithmsTwo.LukuJarjestys.Kalenteri;
import AlgorithmsTwo.LukuJarjestys.Parser;
import AlgorithmsTwo.LukuJarjestys.Tapahtuma;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
                        31.03.2025 10-12 B103 Luento
                        """;
        ArrayList<Tapahtuma> tapahtumat = parser.annaTapahtumat(syote);
        assertEquals("B103 Luento" ,tapahtumat.getFirst().getNimi());

    }
}
