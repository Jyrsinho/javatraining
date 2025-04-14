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

        //Poikkeustaja poikkeustaja = new Poikkeustaja();
        //poikkeustaja.analysoiTapahtumat();

        //ArrayList<String> poikkeukset = poikkeustaja.getPoikkeukset();
        //ArrayList<Tapahtuma> saannollisetTapahtumat = poikkeustaja.getSaannollisetTapahtumat();

        // kalenteri.paivitaKalenteri(saannollisetTapahtumat);
        kalenteri.paivitaKalenteri(tapahtumat);
        Tulostaja tulostaja = new Tulostaja();
        tulostaja.tulostaKalenteri(kalenteri);
        // tulostaja.tulostaKalenteri(kalenteri, poikkeukset);
    }



    public static void main(String[] args) {
        String testiSyote = """
                Sekavia tapahtumia ja poikkeuksia
                3.6.2026 9-10 kaksi
                17.6.2026 8-10 yksi
                4.6.2026 10-12 kolme
                11.6.2026 11-13 neljä
                """;

        // 3.6. ja 17.6 on keskiviikko 4.6 ja 11.6 on torstai

        /*ERROR: Syötteellä numero 3
        ohjelmasi vastasi
        Syöte puuttuu⤶
        Ei tapahtumia⤶
        olisi pitänyt vastata
        Syöte puuttuu⤶

         */

        /*

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while (sc.hasNextLine()) {
            sb.append(sc.nextLine());
            sb.append("\n");
        }

         */

        LukuJarjestys lukuJarjestys = new LukuJarjestys(testiSyote);
        lukuJarjestys.teeLuettavaKalenteri();
    }
}


