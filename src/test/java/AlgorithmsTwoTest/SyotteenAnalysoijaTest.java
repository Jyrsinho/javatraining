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
        System.out.println(actual);
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
        String ensimmainenPerinnonjako = perinnonJakoSyotteet.get(0);
        String toinenPerinnonJako = perinnonJakoSyotteet.get(1);
        System.out.println(ensimmainenPerinnonjako);
        System.out.println(toinenPerinnonJako);
        String expected = "1 3000 -1 Simo 0 0 2 Heikki 1 0";
        assertEquals(expected, toinenPerinnonJako);
        assertEquals(2, perinnonJakoSyotteet.size());
    }

    @Test
    public void testShouldAddTwoPerinnonJakoWhenNamesAreIntegers(){
        String input = """
                1 3000
                -1 5600 0 0
                2 2200 1 0 0
                2 2000
                1 2200 0 0
                -2 3400 0 0
                -3 3300 0 0 0  0
                5 3200  2   4
                """;
        SyotteenAnalysoija sa = new SyotteenAnalysoija();
        ArrayList<String> perinnonJakoSyotteet = sa.annaPerinnonjakoSyotteet(input);
        assertEquals(2, perinnonJakoSyotteet.size());
    }


}
