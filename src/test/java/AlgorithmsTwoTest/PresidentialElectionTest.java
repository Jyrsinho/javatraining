package AlgorithmsTwoTest;

import AlgorithmsTwo.Ehdokas;
import AlgorithmsTwo.PresidentialElection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PresidentialElectionTest {

    /*
    Tässä on esimerkki syötteestä:
572733 Abraham Ahkera
0 Ei Saanut Ääntä Edes Itseltään!
2912229 Kaisa Kansansuosikki
41 Kelju K. Kojootti
48622 Oskari Oikea-Reunanen
572733 Pirkko Poliitikko
572633 Reetta Vasen-Reunanen
572733 T. Tasaääninen
572733 Toisinajattelija Välilyöntinen
     */

    PresidentialElection presidentialElection;
    String testiSyote;

    @BeforeEach
    public void setUp() {
        presidentialElection = new PresidentialElection();
        testiSyote = "572733 Abraham Ahkera\n" +
                "0 Ei Saanut Ääntä Edes Itseltään!\n" +
                "2912229 Kaisa Kansansuosikki\n" +
                "41 Kelju K. Kojootti\n" +
                "48622 Oskari Oikea-Reunanen\n" +
                "572733 Pirkko Poliitikko\n" +
                "572633 Reetta Vasen-Reunanen\n" +
                "572733 T. Tasaääninen\n" +
                "572733 Toisinajattelija Välilyöntinen";

    }
    @Test
    public void testShouldCreateACandidateFromStringWhenCandidateHasTwoNames() {
        PresidentialElection presidentialElection1 = new PresidentialElection();
        Ehdokas ehdokas = presidentialElection1.luoEhdokasMerkkijonosta("5700 Abraham Ahkera");
        assertEquals("Abraham Ahkera",ehdokas.nimi );
    }

    @Test
    public void testShouldCreateCandidateAVoteCount() {
        PresidentialElection presidentialElection1 = new PresidentialElection();
        Ehdokas ehdokas = presidentialElection1.luoEhdokasMerkkijonosta("5700 Abraham Ahkera");
        assertEquals(5700,ehdokas.aanimaara );
    }

    @Test
    public void testShouldCreateACandidateFromStringWhenCandidateHasThreeNames() {
        PresidentialElection presidentialElection1 = new PresidentialElection();
        Ehdokas ehdokas = presidentialElection1.luoEhdokasMerkkijonosta("5700 Abraham Ahkera Holmstrom");
        assertEquals("Abraham Ahkera Holmstrom",ehdokas.nimi);
    }

    @Test
    public void testShouldCreateACandidateFromStringWhenCandidateHasThreeNamesAndExtraSpacing() {
        PresidentialElection presidentialElection1 = new PresidentialElection();
        Ehdokas ehdokas = presidentialElection1.luoEhdokasMerkkijonosta("5700      Abraham Ahkera       Holmstrom");
        assertEquals("Abraham Ahkera Holmstrom",ehdokas.nimi);
    }

    @Test
    public void testShouldCreateACandidateFromStringWhenCandidateHasThreeNamesAndExtraSpacingAndComma() {
        PresidentialElection presidentialElection1 = new PresidentialElection();
        Ehdokas ehdokas = presidentialElection1.luoEhdokasMerkkijonosta("5700      Abraham A.       Holmstrom");
        assertEquals("Abraham A. Holmstrom",ehdokas.nimi);
    }

   @Test
    public void testShouldUpdateTheKokonaisAaniMaaraWhenOneCandidate() {
       String testiSyote = "5700 Abraham Ahkera Holmstrom";
        PresidentialElection presidentialElection1 = new PresidentialElection(testiSyote);
        int alkuperainenAanimaara = presidentialElection1.getKokonaisAaniMaara();
        presidentialElection1.suoritaAantenLaskenta();
        int uusiAanimaara = presidentialElection1.getKokonaisAaniMaara();
        assertEquals(5700, uusiAanimaara-alkuperainenAanimaara);
   }

   @Test
    public void testShouldUpdateTheKokonaisAaniMaaraWhenThreeCandidates() {
        String testiSyote = "500 Abraham Ahkera\n" +
                            "21 Ei Saanut Ääntä Edes Itseltään!\n" +
                            "29 Kaisa Kansansuosikki\n" +
                            "40 Kelju K. Kojootti\n" ;
        PresidentialElection presidentialElection1 = new PresidentialElection(testiSyote);
        presidentialElection1.suoritaAantenLaskenta();
       int aanimaara = presidentialElection1.getKokonaisAaniMaara();
       int expected = 590;
       assertEquals(expected, aanimaara);
   }







}
