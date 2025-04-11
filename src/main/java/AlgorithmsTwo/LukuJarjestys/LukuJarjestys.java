package AlgorithmsTwo.LukuJarjestys;


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

        kalenteri.paivitaKalenteri(tapahtumat);
        Tulostaja tulostaja = new Tulostaja();
        tulostaja.tulostaKalenteri(kalenteri);
    }



    public static void main(String[] args) {
        String testiSyote = """
                Tyhjiä rivejä, rivien alussa ja lopussa tyhjää
                11.12.2023 12-13 lounas
                4.12.2023 11-13 lounas
                11.12.2023 11-12 lounas
                5.12.2023 11-12 lounas
                6.12.2023 11-13 juhlalounas
                8.12.2023 10-11 lounas
                """;

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
        }

         */

        LukuJarjestys lukuJarjestys = new LukuJarjestys(testiSyote);
        lukuJarjestys.teeLuettavaKalenteri();
    }
}


