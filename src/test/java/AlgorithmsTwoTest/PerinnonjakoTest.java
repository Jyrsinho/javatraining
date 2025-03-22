package AlgorithmsTwoTest;

import AlgorithmsTwo.Perinnonjako.Perinnonjako;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PerinnonjakoTest {

    @Test
    public void testShouldParseAmountOfInHeritanceFromInput(){
        String input =  """
                4 1000
                -1 Klaara 0 0
                """;
        Perinnonjako perinnonjako = new Perinnonjako(input);
        perinnonjako.parsePerinnonJako();
        assertEquals(1000 ,perinnonjako.getPerinnonMaara());
    }

    @Test
    public void testShouldParseDeceasedIdFromInput(){
        String input =  """
                4 1000
                -1 Klaara 0 0
                """;
        Perinnonjako perinnonjako = new Perinnonjako(input);
        perinnonjako.parsePerinnonJako();
        assertEquals(4, perinnonjako.getVainajanID());
    }

    @Test
    public void testShouldParseDeceasedFromInput(){
        String input = """
                4 1000
                -4 Klaara 0 0
                """;
        Perinnonjako perinnonjako = new Perinnonjako(input);
        perinnonjako.parsePerinnonJako();
        assertEquals(4, perinnonjako.getVainaja().getId());
        assertEquals("Klaara", perinnonjako.getVainaja().getNimi());
    }

    @Disabled
    public void testShouldParseSingleFamilyMemberFromInput() {
        String input = """
                4 7825349
                -1 Klaara 0 0
                """;
        Perinnonjako perinnonjako = new Perinnonjako(input);
        perinnonjako.parsePerinnonJako();
        assertEquals("Klaara", perinnonjako.getJakoonOsallistuvat().getFirst().getNimi());
    }

    @Disabled
    public void testShouldParseSingleFamilyMembersIDFromInput() {
        String input = """
                4 7825349
                -1 Klaara 0 0
                """;
        Perinnonjako perinnonjako = new Perinnonjako(input);
        perinnonjako.parsePerinnonJako();
        assertEquals(1, perinnonjako.getJakoonOsallistuvat().get(0).getId());
    }

    @Disabled
    public void testShouldParseSingleFamilyMembersElossaStatusFromInput() {
        String input = """
                4 7825349
                -1 Klaara 0 0
                """;
        Perinnonjako perinnonjako = new Perinnonjako(input);
        perinnonjako.parsePerinnonJako();
        assertEquals(false, perinnonjako.getJakoonOsallistuvat().get(0).onElossa());
    }



    @Disabled
    public void testShouldParseSumOfInheritanceFromInput() {

    }

    public Perinnonjako luoTestCase(String input) {
         return new Perinnonjako(input);
    }
}
