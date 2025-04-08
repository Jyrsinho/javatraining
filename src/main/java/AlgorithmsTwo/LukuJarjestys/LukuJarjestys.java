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
                TIEA211 Algoritmit 2 Kevät 2023
                21.03.2023 10-12 B103 Luento
                23.03.2023 14-16 B103 Luento
                23.03.2023 16-18 C231.1 Neuvonta
                27.03.2023 10-12 B122.1 Neuvonta
                28.03.2023 10-12 B103 Luento
                30.03.2023 14-16 B103 Luento
                30.03.2023 16-18 C231.1 Neuvonta
                11.04.2023 10-12 B103 Luento
                13.04.2023 14-16 B103 Luento
                13.04.2023 16-18 C231.1 Neuvonta
                17.04.2023 10-12 B122.1 Neuvonta
                18.04.2023 10-12 B103 Luento
                20.04.2023 14-16 B103 Luento
                20.04.2023 16-18 C231.1 Neuvonta
                24.04.2023 10-12 B122.1 Neuvonta
                25.04.2023 10-12 B103 Luento
                27.04.2023 14-16 A102 Luento
                27.04.2023 16-18 C231.1 Neuvonta
                02.05.2023 10-12 B103 Luento
                04.05.2023 14-16 B103 Luento
                04.05.2023 16-18 C231.1 Neuvonta
                08.05.2023 10-12 B122.1 Neuvonta
                09.05.2023 10-12 B103 Luento
                11.05.2023 14-16 B103 Luento
                11.05.2023 16-18 C231.1 Neuvonta
                15.05.2023 10-12 B122.1 Neuvonta
                16.05.2023 10-12 B103 Luento
                22.05.2023 10-12 C231.1 Neuvonta
                25.05.2023 14-18 B103 Tentti
                """;

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


