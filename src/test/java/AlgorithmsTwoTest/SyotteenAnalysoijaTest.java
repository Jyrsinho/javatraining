package AlgorithmsTwoTest;

import AlgorithmsTwo.Perinnonjako.SyotteenAnalysoija;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SyotteenAnalysoijaTest {

    @Test
    public void testShouldCleanTheEndOfInput() {
        String input = """
                 1 3000
                -1 Simo 0 0
                2 Heikki 1 0 0 0
                5 Heikkimowitz 1 0 0
                """;
        SyotteenAnalysoija sa = new SyotteenAnalysoija();
        String actual = sa.annaPerinnonjakoSyotteet(input).get(0);
        String expected = "1 3000 -1 Simo 0 0 2 Heikki 1 0";
        assertEquals(expected, actual);
    }

    @Test
    public void testShouldAddTwoStringInputs() {
        String input = """
                 1 3000
                -1 Simo 0 0
                2 Heikki 1 0 0
                1 3000 -1 Simo 0 0 2 Heikki 1 0 0 0
                """;
        SyotteenAnalysoija sa = new SyotteenAnalysoija();
        ArrayList<String> perinnonJakoSyotteet = sa.annaPerinnonjakoSyotteet(input);
        String toinenPerinnonJako = perinnonJakoSyotteet.get(1);
        String expected = "1 3000 -1 Simo 0 0 2 Heikki 1 0";
        assertEquals(expected, toinenPerinnonJako);
        assertEquals(2, perinnonJakoSyotteet.size());
    }
}
