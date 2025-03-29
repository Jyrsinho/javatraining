package AlgorithmsTwoTest;

import AlgorithmsTwo.Perinnonjako.Perija;
import AlgorithmsTwo.Perinnonjako.Perinnonjako;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PerinnonjakoTest {

    @Test
    public void testShouldParseAmountOfInHeritanceFromInput() {
        String input = """
                4 1000
                -1 Klaara 0 0
                """;
        Perinnonjako perinnonjako = new Perinnonjako(input);
        perinnonjako.parsePerinnonJako();
        assertEquals(1000, perinnonjako.getPerinnonMaara());
    }

    @Test
    public void testShouldParseAmountOfInHeritanceFromInputWhenNoLineBreaks() {
        String input = """
                4 1000 -1 Klaara 0 0
                """;
        Perinnonjako perinnonjako = new Perinnonjako(input);
        perinnonjako.parsePerinnonJako();
        assertEquals(1000, perinnonjako.getPerinnonMaara());
    }


    @Test
    public void testShouldParseDeceasedIdFromInput() {
        String input = """
                4 1000
                -1 Klaara 0 0
                """;
        Perinnonjako perinnonjako = new Perinnonjako(input);
        perinnonjako.parsePerinnonJako();
        assertEquals(4, perinnonjako.getVainajanID());
    }

    @Test
    public void testShouldParseDeceasedFromInput() {
        String input = """
                4 1000
                -4 Klaara 0 0
                """;
        Perinnonjako perinnonjako = new Perinnonjako(input);
        perinnonjako.parsePerinnonJako();
        assertEquals(4, perinnonjako.getVainaja().getId());
        assertEquals("Klaara", perinnonjako.getVainaja().getNimi());
    }

    @Test
    public void testShouldParseSingleFamilyMemberFromInput() {
        String input = """
                4 7825349
                -1 Klaara 0 0
                """;
        Perinnonjako perinnonjako = new Perinnonjako(input);
        perinnonjako.parsePerinnonJako();
        assertEquals("Klaara", perinnonjako.getSukulaiset().getFirst().getNimi());
    }

    @Test
    public void testShouldParseSingleFamilyMembersIDFromInput() {
        String input = """
                4 7825349
                -1 Klaara 0 0
                """;
        Perinnonjako perinnonjako = new Perinnonjako(input);
        perinnonjako.parsePerinnonJako();
        assertEquals(1, perinnonjako.getSukulaiset().get(0).getId());
    }

    @Test
    public void testShouldParseSingleFamilyMembersElossaStatusFromInput() {
        String input = """
                4 7825349
                -1 Klaara 0 0
                """;
        Perinnonjako perinnonjako = new Perinnonjako(input);
        perinnonjako.parsePerinnonJako();
        assertEquals(false, perinnonjako.getSukulaiset().get(0).onElossa());
    }

    @Test
    public void testShouldParseTwoFamilyMembersFromInput() {
        String input = """
                3 2000
                -1 Klaara 0 0
                -2 Saara 0 0
                """;
        Perinnonjako perinnonjako = new Perinnonjako(input);
        perinnonjako.parsePerinnonJako();
        assertEquals("Saara", perinnonjako.getSukulaiset().get(1).getNimi());
    }

    @Test
    public void testShouldParseSeveralFamilyMembersFromInput() {
        String input = """
                3 2000
                -1 Klaara 0 0
                -2 Saara 0 0
                3 Taneli 0 0
                4 Heikki 0 0
                """;
        Perinnonjako perinnonjako = new Perinnonjako(input);
        perinnonjako.parsePerinnonJako();
        assertEquals("Heikki", perinnonjako.getSukulaiset().get(3).getNimi());
    }

    @Test
    public void testShouldFindHenkiloFromGivenID() {
        String input = """
                3 2000
                -1 Klaara 0 0
                -2 Saara 0 0
                """;
        Perinnonjako perinnonjako = new Perinnonjako(input);
        perinnonjako.parsePerinnonJako();
        String expected = "Saara";
        Perija actual = perinnonjako.etsiHenkiloIdPerusteella(2);
        assertEquals(expected, actual.getNimi());
    }

    @Test
    public void testShouldAddChildToDeceased() {
        String input = """
                1 2000
                -1 Klaara 0 0
                2 Saara 0 1
                """;
        Perinnonjako perinnonjako = new Perinnonjako(input);
        perinnonjako.parsePerinnonJako();
        assertEquals("Saara", perinnonjako.getVainaja().getLapset().get(0).getNimi());
    }

    @Test
    public void testShouldAddChildrenChildrenToDeceased() {
        String input = """
                1 2000
                -1 Klaara 0 0
                2 Saara 0 1
                3 Timo 0 2
                """;
        Perinnonjako perinnonjako = new Perinnonjako(input);
        perinnonjako.parsePerinnonJako();
        assertEquals("Timo", perinnonjako.getVainaja().getLapset().get(0).getLapset().get(0).getNimi());

    }

    @Test
    public void testShouldGiveAllTheMoneyToOnlyChild() {
        String input = """
                1 2000
                -1 Klaara 0 0
                2 Saara 0 1
                """;
        Perinnonjako perinnonjako = new Perinnonjako(input);
        perinnonjako.suoritaPerinnonjako();
        Perija saara = perinnonjako.etsiHenkiloIdPerusteella(2);
        assertEquals(2000, saara.getPerintoaSaatu());
    }

    @Test
    public void testShouldGiveHalfOfMoneyToFirstAndHalfToSecondChild() {
        String input = """
                1 2000
                -1 Klaara 0 0
                2 Saara 0 1
                3 Jaana 0 1
                """;
        Perinnonjako perinnonjako = new Perinnonjako(input);
        perinnonjako.suoritaPerinnonjako();
        Perija saara = perinnonjako.etsiHenkiloIdPerusteella(2);
        Perija jaana = perinnonjako.etsiHenkiloIdPerusteella(3);
        assertEquals(1000, saara.getPerintoaSaatu());
        assertEquals(1000, jaana.getPerintoaSaatu());
        assertEquals(0, perinnonjako.getPerinnonMaara());
    }

    @Test
    public void testShouldGiveHalfOfMoneyToFirstAndHalfToSecondChildAndWhatsLeftToState() {
        String input = """
                1 2001
                -1 Klaara 0 0
                2 Saara 0 1
                3 Jaana 0 1
                """;
        Perinnonjako perinnonjako = new Perinnonjako(input);
        perinnonjako.suoritaPerinnonjako();
        Perija saara = perinnonjako.etsiHenkiloIdPerusteella(2);
        Perija jaana = perinnonjako.etsiHenkiloIdPerusteella(3);
        assertEquals(1000, saara.getPerintoaSaatu());
        assertEquals(1000, jaana.getPerintoaSaatu());
        assertEquals(1, perinnonjako.getPerinnonMaara());
    }

    @Test
    public void testShouldGiveAllTheInheritanceToStateIfNoLivingOffspring() {
        String input = """
                   1 2001
                -1 Klaara 0 0
                -2 Saara 0 1
                -3 Jaana 0 1
                """;
        Perinnonjako perinnonjako = new Perinnonjako(input);
        perinnonjako.suoritaPerinnonjako();
        assertEquals(2001, perinnonjako.getValtionOsuus());

    }

    public Perinnonjako luoTestCase(String input) {
        return new Perinnonjako(input);
    }

    @Test
    public void testShouldAddChildrenToTheListOfHeirs() {
        String input = """
                   1 2001
                -1 Klaara 0 0
                2 Saara 0 1
                3 Jaana 0 1
                """;
        Perinnonjako perinnonjako = new Perinnonjako(input);
        perinnonjako.suoritaPerinnonjako();
        ArrayList<Perija> perijat = perinnonjako.getPerijat();
        assertEquals(2, perijat.size());
        assertEquals("Saara", perijat.get(0).getNimi());
        assertEquals("Jaana", perijat.get(1).getNimi());
    }

    @Test
    public void testShouldNotAddDeadChildrenToTheListOfHeirs() {
        String input = """
                   1 2001
                -1 Klaara 0 0
                -2 Saara 0 1
                -3 Jaana 0 1
                """;
        Perinnonjako perinnonjako = new Perinnonjako(input);
        perinnonjako.suoritaPerinnonjako();
        ArrayList<Perija> perijat = perinnonjako.getPerijat();
        assertEquals(0, perijat.size());
        assertEquals(2001, perinnonjako.getValtionOsuus());
    }

    @Test
    public void testShouldGiveMoneyToGrandChildrenIfChildIsDead() {
        //TODO
        String input = """
                1 2000
                -1 Klaara 0 0
                -2 Saara 0 1
                3 Jaana 0 1
                4 Timo 2 0
                5 Heikki 2 0
                """;
        Perinnonjako perinnonjako = new Perinnonjako(input);
        perinnonjako.suoritaPerinnonjako();
        ArrayList<Perija> perijat = perinnonjako.getPerijat();
        assertEquals(3, perijat.size());
        assertEquals(500, perijat.getFirst().getPerintoaSaatu());

    }

    @Test
    public void testShouldLeaveOneMoneyUndividedWhenSumEvenOneLivingHeirAndSecondDeadWithTwoChildre() {
        String input = """
                1 10
                -1 Klaara 0 0
                -2 Saara 0 1
                3 Jaana 0 1
                4 Timo 2 0
                5 Heikki 2 0
                """;
        Perinnonjako perinnonjako = new Perinnonjako(input);
        perinnonjako.suoritaPerinnonjako();
        assertEquals(1, perinnonjako.getPerinnonMaara());

    }

    @Test
    public void testShouldGetVainajasParents() {
        String input = """
                3 10
                1 Klaara 0 0
                2 Saara 0 0
                -3 Jaana 2 1
                -4 Timo 3 0
                -5 Heikki 3 0
                """;
    Perinnonjako perinnonjako = new Perinnonjako(input);
    perinnonjako.parsePerinnonJako();
    Perija vainaja = perinnonjako.getVainaja();
    ArrayList<Perija> vainajanVanhemmat = perinnonjako.etsiVanhemmat(vainaja);
    assertEquals(2, vainajanVanhemmat.size());
    assertEquals("Klaara",vainajanVanhemmat.getFirst().getNimi());
    assertEquals("Saara",vainajanVanhemmat.get(1).getNimi());

}


    @Test
    public void testShouldGiveInHeritanceToParentsWhenNoLivingOffSpring() {
        String input = """
                3 10
                1 Klaara 0 0
                2 Saara 0 0
                -3 Jaana 2 1
                -4 Timo 3 0
                -5 Heikki 3 0
                """;
        Perinnonjako perinnonjako = new Perinnonjako(input);
        perinnonjako.suoritaPerinnonjako();
        ArrayList<Perija> perijat = perinnonjako.getPerijat();
        assertEquals("Klaara",perijat.getFirst().getNimi());
        assertEquals("Saara",perijat.get(1).getNimi());
    }

    @Test
    public void testShouldGiveInHeritanceToParentsChildrensChildrenWhenTheyAreOnlyLivingRelatives() {
        String input = """
                3 10
                -1 Klaara 0 0
                -2 Saara 0 0
                -3 Jaana 2 1
                -4 Timo 3 0
                -5 Heikki 3 0
                -6 Janina 2 0
                7 Samina 6 0
                
                """;
        Perinnonjako perinnonjako = new Perinnonjako(input);
        perinnonjako.suoritaPerinnonjako();
        ArrayList<Perija> perijat = perinnonjako.getPerijat();
        assertEquals("Samina",perijat.getFirst().getNimi());
    }

    @Test
    public void testShouldGiveInheritanceToValtioIfNoLivingRelatives() {
        String input = """
                3 10
                -1 Klaara 0 0
                -2 Saara 0 0
                -3 Jaana 2 1
                -4 Timo 3 0
                -5 Heikki 3 0
                -6 Janina 2 0
                -7 Samina 6 0
              
                """;
        Perinnonjako perinnonjako = new Perinnonjako(input);
        perinnonjako.suoritaPerinnonjako();
        ArrayList<Perija> perijat = perinnonjako.getPerijat();
        assertEquals(true, perinnonjako.getPerijat().isEmpty());
        assertEquals(10, perinnonjako.getValtionOsuus());
    }

    @Test
    public void testShouldGiveInheritanceFromBothParentsToAChild() {
        String input = """
                3 10
                -1 Klaara 0 0
                -2 Rami 0 0
                -3 Joakim 1 2
                4 Siiri 1 2
                5 Timo 1 0
                """;
        Perinnonjako perinnonjako = new Perinnonjako(input);
        perinnonjako.suoritaPerinnonjako();
        ArrayList<Perija> perijat = perinnonjako.getPerijat();
        assertEquals(2, perinnonjako.getPerijat().size());
        assertEquals(7, perijat.getFirst().getPerintoaSaatu());
        assertEquals(2, perijat.get(1).getPerintoaSaatu());
    }

    @Test
    public void testShouldDivideInheritanceWhenHeirsAreNumbers() {
        String input = """
                3 10
                -1 2020 0 0
                -2 2022 0 0
                .3 2025 0 0
                4 3300 1 2
                5 4300 1 0
                """;
        Perinnonjako perinnonjako = new Perinnonjako(input);
        perinnonjako.suoritaPerinnonjako();
        ArrayList<Perija> perijat = perinnonjako.getPerijat();
        assertEquals(2, perinnonjako.getPerijat().size());
        assertEquals("3300", perijat.getFirst().getNimi());
        assertEquals("4300", perijat.get(1).getNimi());
    }
}
