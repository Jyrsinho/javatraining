package AlgorithmsTwo.LukuJarjestys;



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
        Parser parser = new Parser();
        String otsikkoRivi = parser.annaOtsikkoRivi(syote);
        ArrayList<Tapahtuma> tapahtumat = parser.annaTapahtumat(syote);
        Kalenteri kalenteri = new Kalenteri(5, 24);
        kalenteri.paivitaKalenteri(tapahtumat);
        Tulostaja tulostaja = new Tulostaja();
        tulostaja.tulostaKalenteri(otsikkoRivi, kalenteri);
    }



    public static void main(String[] args) {
        /*String testiSyote = """
                            Tapahtuma 1
                            31.03.2025 9-11 B103 Luento
                            1.4.2025 14-16 B103 Luento
                            """;

         */

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while (sc.hasNextLine()) {
            sb.append(sc.nextLine());
        }

        LukuJarjestys lukuJarjestys = new LukuJarjestys(sb.toString());
        lukuJarjestys.teeLuettavaKalenteri();
    }
}


