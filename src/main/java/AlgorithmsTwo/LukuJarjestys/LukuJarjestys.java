package AlgorithmsTwo.LukuJarjestys;


/**
 Lukujärjestykseen tulostetaan kunkin tunnin ja viikonpäivän (paitsi lauantain
 ja sunnuntain) kohdalle niitä vastaava tieto kuitenkin siten, että jos epätyhjä tie-
 to on sama kuin lähinnä ylemmässä lokerossa, niin lokeroita erottava viivanpätkä
 jätetään tulostamatta ja lokero jätetään tyhjäksi. Vaiheessa 1 tuntia ja viikonpäi-
 vää vastaava tieto on syötteessä ensimmäisenä sille tunnille ja viikonpäivälle osu-
 van tapahtuman nimi. Vaiheessa 2 se on tunnin ja viikonpäivän kohdalla eniten
 esiintyvä nimi tai tyhjä, jos tyhjä esiintyy useammin kuin mikään nimi. Jos eniten
 esiintyvä tieto ei ole yksikäsitteinen, niin tulostetaan se eniten esiintyvä epätyhjä
 tieto, jolla on varhaisin esiintymispäivä
 *
 */


import java.util.ArrayList;
import java.util.Scanner;

public class LukuJarjestys {
    Kalenteri kalenteri;
    int PAIVIAVIIKOSSA = 5;
    int TUNTEJAPAIVASSA = 24;
    String syote;



    public LukuJarjestys(String syote) {
        this.syote = syote;
        this.kalenteri = new Kalenteri(PAIVIAVIIKOSSA,  TUNTEJAPAIVASSA);
    }


    public void teeLuettavaKalenteri() {
        Kalenteri kalenteri = new Kalenteri(5, 24);
        Parser parser = new Parser();
        parser.analysoiSyote(syote);


        kalenteri.setOtsikkoRivi(parser.getOtsikko());
        ArrayList<Tapahtuma> tapahtumat = parser.annaTapahtumat();

        kalenteri.paivitaKalenteri(tapahtumat);
        kalenteri.paivitaKalenteri(tapahtumat);
        Tulostaja tulostaja = new Tulostaja();
        tulostaja.tulostaKalenteri(kalenteri);
    }



    public static void main(String[] args) {
        String testiSyote = """
                Vauvauinti
                3.4.2025 17-19 Koodaamista
                10.4.2025 17-19 Koodaamista
                17.4.2025 17-19 Koodaamista
                """;


        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while (sc.hasNextLine()) {
            sb.append(sc.nextLine());
            sb.append("\n");
        }


        LukuJarjestys lukuJarjestys = new LukuJarjestys(testiSyote);
        lukuJarjestys.teeLuettavaKalenteri();
    }
}


