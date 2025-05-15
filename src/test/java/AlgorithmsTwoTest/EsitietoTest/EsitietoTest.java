package AlgorithmsTwoTest.EsitietoTest;

import AlgorithmsTwo.Esitieto.Esitieto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class EsitietoTest {


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
    public void testEsitieto() {
        String testiSyote = """
                           
                           1 Salibandy 1 : 0
               
                2 Heittaminen 1: 0
                
                3 Sipulinsyominen 2: 1 0 0 0
                """;

        // 3. Redirect System.in to our test input
        InputStream testInput = new ByteArrayInputStream(testiSyote.getBytes());
        System.setIn(testInput);
        Esitieto esitieto = new Esitieto();
        esitieto.kasitteleSyote();
    }
}
