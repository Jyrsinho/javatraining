package AlgorithmsTwoTest;

import AlgorithmsTwo.Perinnonjako.PerintojenJakaja;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PerintojenJakajaTest {

    @Test
    public void testShouldCreateAnInstanceOfPerinnonjako() {
        String input = """
                1 3000
                -1 Simo 0 0
                2 Heikki 1 0 0
                """;
        PerintojenJakaja perintojenJakaja = new PerintojenJakaja(input);
        perintojenJakaja.jaaPerinnot();
        int perinnonJakojenMaara = perintojenJakaja.getPerinnonjaot().size();
        assertEquals(1, perinnonJakojenMaara);

    }

    @Test
    public void testShouldCreateTwoInstancesOfPerinnonjako() {
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
        perintojenJakaja.jaaPerinnot();
        int perinnonJakojenMaara = perintojenJakaja.getPerinnonjaot().size();
        assertEquals(2, perinnonJakojenMaara);
    }
}
