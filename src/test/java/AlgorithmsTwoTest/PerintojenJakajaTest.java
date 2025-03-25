package AlgorithmsTwoTest;

import AlgorithmsTwo.Perinnonjako.Perinnonjako;
import AlgorithmsTwo.Perinnonjako.PerintojenJakaja;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PerintojenJakajaTest {



    @Test
    public void testShouldAddCorrectDeceased() {
        String input = """
                4 7825349
                -1 Klaara 0 0 -2 Vihtori 0 0
                3 Amalia 0 2
                -4 Bernard 2 1
                5 Cecilia 1 2
                -6
                Erika 0
                0
                7 Ferdinand 6 0
                8 Daniel 0 1 0 1 9 -1 ToinenVainaja 0 0 0 0
                2 syöte_loppui_ennen_tätä_kohtaa 1 0 0 0
                """;
        PerintojenJakaja perintojenJakaja = new PerintojenJakaja(input);
        ArrayList<Perinnonjako> perintojenJaot = perintojenJakaja.getPerinnonjaot();
        perintojenJakaja.jaaPerinnot();
        Perinnonjako perinnonjako = perintojenJaot.get(0);
        assertEquals("Bernard", perinnonjako.getVainaja().getNimi());
    }
}
