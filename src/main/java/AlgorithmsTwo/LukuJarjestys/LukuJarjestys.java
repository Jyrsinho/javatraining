package AlgorithmsTwo.LukuJarjestys;

/*
Vaiheessa 1 tuotetaan vain lukujärjestys, käyttäen kunkin tunnin ja viikonpäi-

vän kohdalla syötteessä ensin esiintynyttä tapahtumaa. Pois jää kunkin tunnin ja
viikonpäivän eniten esiintyvän vaihtoehdon (jokin tapahtuma tai ei tapahtumaa)
tunnistaminen ja muut vaihtoehdot esittävän poikkeusten luettelon tuottaminen.
*/

/* EsimerkkiSyote
TIEA211 Algoritmit 2 Kevät 2023
21.03.2023 10-12 B103 Luento
23.03.2023 14-16 B103 Luento
23.03.2023 16-18 C231.1 Neuvonta
 */

/*
1. Täytetään kalenteri syotteen  otsikolla ja luennolla.
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
        Parser parser = new Parser();
        ArrayList<Tapahtuma> tapahtumat = parser.annaTapahtumat(syote);
        Kalenteri kalenteri = new Kalenteri(5, 24);
        kalenteri.paivitaKalenteri(tapahtumat);
        Tulostaja tulostaja = new Tulostaja();
        tulostaja.tulostaKalenteri(kalenteri);
    }



    public static void main(String[] args) {
        String testiSyote = "31.03.2025 9-11 B103 Luento\n" +
                            "01.04.2025 14-16 B103 Luento";

        LukuJarjestys lukuJarjestys = new LukuJarjestys(testiSyote);
        lukuJarjestys.teeLuettavaKalenteri();
    }
}


