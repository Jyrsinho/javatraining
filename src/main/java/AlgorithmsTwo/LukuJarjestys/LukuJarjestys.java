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
        if (!tapahtumat.isEmpty()) {
            kalenteri.paivitaKalenteri(tapahtumat);
            kalenteri.paivitaKalenteri(tapahtumat);
        }
        Tulostaja tulostaja = new Tulostaja();
        tulostaja.tulostaKalenteri(kalenteri);
    }



    public static void main(String[] args) {
        String testiSyote = """
                Syöte vailla tapahtumia
                """;
        String testiSyote2 = """
                Yksi tapahtuma
                5.12.2023 12-13 lounas
                """;

        String testiSyote3 = """
                Koodausta koko illan ja yön
                2.04.2024 18-24 koodausta
                03.4.2024 00-7 koodausta
                """;
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
        System.out.println();
        System.out.println("................................................................................................");
        System.out.println();
        LukuJarjestys lukuJarjestys1 = new LukuJarjestys(testiSyote2);
        lukuJarjestys1.teeLuettavaKalenteri();

        System.out.println();
        System.out.println("................................................................................................");
        System.out.println();
        LukuJarjestys lukuJarjestys2 = new LukuJarjestys(testiSyote3);
        lukuJarjestys2.teeLuettavaKalenteri();
    }
}


