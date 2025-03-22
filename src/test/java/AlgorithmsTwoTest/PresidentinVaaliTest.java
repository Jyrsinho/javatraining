package AlgorithmsTwoTest;

import AlgorithmsTwo.Presidentinvaali.Ehdokas;
import AlgorithmsTwo.Presidentinvaali.PresidentinVaali;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PresidentinVaaliTest {


    PresidentinVaali presidentinVaali;
    String testiSyote;

    @BeforeEach
    public void setUp() {
        testiSyote = "572733 Abraham Ahkera\n" +
                "0 Ei Saanut Ääntä Edes Itseltään!\n" +
                "2912229 Kaisa Kansansuosikki\n" +
                "41 Kelju K. Kojootti\n" +
                "48622 Oskari Oikea-Reunanen\n" +
                "572733 Pirkko Poliitikko\n" +
                "572633 Reetta Vasen-Reunanen\n" +
                "572733 T. Tasaääninen\n" +
                "572733 Toisinajattelija Välilyöntinen";
        presidentinVaali = new PresidentinVaali(testiSyote);

    }
    @Test
    public void testShouldCreateACandidateFromStringWhenCandidateHasTwoNames() {
        PresidentinVaali presidentinVaali1 = new PresidentinVaali();
        Ehdokas ehdokas = presidentinVaali1.luoEhdokasMerkkijonosta("5700 Abraham Ahkera");
        assertEquals("Abraham Ahkera",ehdokas.nimi );
    }

    @Test
    public void testShouldCreateCandidateAVoteCount() {
        PresidentinVaali presidentinVaali1 = new PresidentinVaali();
        Ehdokas ehdokas = presidentinVaali1.luoEhdokasMerkkijonosta("5700 Abraham Ahkera");
        assertEquals(5700,ehdokas.aanimaara );
    }

    @Test
    public void testShouldCreateACandidateFromStringWhenCandidateHasThreeNames() {
        PresidentinVaali presidentinVaali1 = new PresidentinVaali();
        Ehdokas ehdokas = presidentinVaali1.luoEhdokasMerkkijonosta("5700 Abraham Ahkera Holmstrom");
        assertEquals("Abraham Ahkera Holmstrom",ehdokas.nimi);
    }

    @Test
    public void testShouldCreateACandidateFromStringWhenCandidateHasThreeNamesAndExtraSpacing() {
        PresidentinVaali presidentinVaali1 = new PresidentinVaali();
        Ehdokas ehdokas = presidentinVaali1.luoEhdokasMerkkijonosta("5700      Abraham Ahkera       Holmstrom");
        assertEquals("Abraham Ahkera Holmstrom",ehdokas.nimi);
    }

    @Test
    public void testShouldCreateACandidateFromStringWhenCandidateHasThreeNamesAndExtraSpacingAndComma() {
        PresidentinVaali presidentinVaali1 = new PresidentinVaali();
        Ehdokas ehdokas = presidentinVaali1.luoEhdokasMerkkijonosta("5700      Abraham A.       Holmstrom");
        assertEquals("Abraham A. Holmstrom",ehdokas.nimi);
    }

   @Test
    public void testShouldUpdateTheKokonaisAaniMaaraWhenOneCandidate() {
       String testiSyote = "5700 Abraham Ahkera Holmstrom";
        PresidentinVaali presidentinVaali1 = new PresidentinVaali(testiSyote);
        int alkuperainenAanimaara = presidentinVaali1.getKokonaisAaniMaara();
        presidentinVaali1.suoritaAantenLaskenta();
        int uusiAanimaara = presidentinVaali1.getKokonaisAaniMaara();
        assertEquals(5700, uusiAanimaara-alkuperainenAanimaara);
   }

   @Test
    public void testShouldUpdateTheKokonaisAaniMaaraWhenThreeCandidates() {
        String testiSyote = "500 Abraham Ahkera\n" +
                            "21 Ei Saanut Ääntä Edes Itseltään!\n" +
                            "29 Kaisa Kansansuosikki\n" +
                            "40 Kelju K. Kojootti\n" ;
        PresidentinVaali presidentinVaali1 = new PresidentinVaali(testiSyote);
        presidentinVaali1.suoritaAantenLaskenta();
       int aanimaara = presidentinVaali1.getKokonaisAaniMaara();
       int expected = 590;
       assertEquals(expected, aanimaara);
   }


   @Test
   public void testShouldReturnErikoisEhdokasWhenNoWinnerInTheFirstRound() {
        String testiSyote = """
                500 Kalle Kekki\s
                500 Simo Silava\s
                500 Tommi Toomi| 
                """;
       PresidentinVaali presidentinVaali = new PresidentinVaali(testiSyote);
       presidentinVaali.suoritaAantenLaskenta();
       String expected ="ErikoisEhdokas";

       assertEquals(expected,presidentinVaali.ensimmaisenKierroksenVoittaja().getClass().getSimpleName());
   }


   @Test
    public void testShouldReturnSuoraVoittajaWhenEhdokasHasMoreThan50PercentOfTheVOte() {
        String testiSyote = """
                5700 Abraham Ahkera\s
                200 Kalle Kekki\s
                300 Timo Timola
                """;
       PresidentinVaali presidentinVaali1 = new PresidentinVaali(testiSyote);
       presidentinVaali1.suoritaAantenLaskenta();
       assertEquals("Abraham Ahkera" ,presidentinVaali1.ensimmaisenKierroksenVoittaja().nimi);
   }

   @Test
    public void testShouldReturnErikoisEhdokasWhenTwoCandidatesBothHaveHalfOfTheVotes() {
        String testiSyote = """
                500 Abraham Ahkera\s
                500 Kalle Kekki
                """;
       PresidentinVaali presidentinVaali1 = new PresidentinVaali(testiSyote);
       presidentinVaali1.suoritaAantenLaskenta();
       String expected ="ErikoisEhdokas";
       String actual = presidentinVaali1.ensimmaisenKierroksenVoittaja().getClass().getSimpleName();
       assertEquals(expected, actual);
   }

    @Test
    public  void TestShouldReturnArrayOfEhdokkaatWhenNoEhdokasHasMoreThanfiftypercentOfVotes() {
        String testiSyote = """
                500 Abraham Ahkera\s
                500 Kalle Kekki\s
                500 Timo Timola\s
                """;
        PresidentinVaali presidentinVaali1 = new PresidentinVaali(testiSyote);
        presidentinVaali1.suoritaAantenLaskenta();
        ArrayList<Ehdokas> testiToiselleKierrokselleMenijat = presidentinVaali1.toiselleKierrokselleMenijat();
        assertEquals("Abraham Ahkera" ,testiToiselleKierrokselleMenijat.get(0).nimi );
        assertEquals("Kalle Kekki" ,testiToiselleKierrokselleMenijat.get(1).nimi );
        assertEquals("Timo Timola" ,testiToiselleKierrokselleMenijat.get(2).nimi );

    }

    @Test
    public void testShouldReturnSeveralCandidates() {
        presidentinVaali.suoritaAantenLaskenta();
        ArrayList<Ehdokas> testiToiselleKierrokselleMenijat = presidentinVaali.toiselleKierrokselleMenijat();
        for (Ehdokas ehdokas: testiToiselleKierrokselleMenijat) {
            System.out.println(ehdokas.nimi);
        }
        assertEquals("Abraham Ahkera" ,testiToiselleKierrokselleMenijat.get(0).nimi );
        assertEquals("Kaisa Kansansuosikki" ,testiToiselleKierrokselleMenijat.get(1).nimi );
        assertEquals("Pirkko Poliitikko", testiToiselleKierrokselleMenijat.get(2).nimi);
        assertEquals("T. Tasaääninen", testiToiselleKierrokselleMenijat.get(3).nimi);
        assertEquals("Toisinajattelija Välilyöntinen", testiToiselleKierrokselleMenijat.get(4).nimi);

    }

    @Test
    public void testSyote500499() {
        PresidentinVaali testiVaali = new PresidentinVaali("500 voittaja \n 499 haviaja");
        testiVaali.suoritaAantenLaskenta();
        assertEquals("voittaja", testiVaali.ensimmaisenKierroksenVoittaja().nimi);
    }





}
