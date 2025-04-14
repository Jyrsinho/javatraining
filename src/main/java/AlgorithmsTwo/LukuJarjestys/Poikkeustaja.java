package AlgorithmsTwo.LukuJarjestys;

import java.util.ArrayList;

/**
 * Poikkeustaja käsittelee kaikki kurssin tapahtumat ja lajittelee ne toistuviin tapahtumiin
 * sekä poikkeuksiin
 * Se laskee kullekin oman kalenterinsa tunnille sen useimmin esiintyvän tapahtuman
 */
public class Poikkeustaja {
    private ArrayList<Tapahtuma> poikkeukset;
    private ArrayList<Tapahtuma> saannolliset;
    private AikatauluRuutu[][] kalenteri;
    private int paivia = 5;
    private int tunteja = 24;




    public Poikkeustaja() {

        poikkeukset = new ArrayList<>();
        saannolliset = new ArrayList<>();
        kalenteri =  new AikatauluRuutu[paivia][tunteja];

    }

    public void lajitteleTapahtumat(ArrayList<Tapahtuma> tapahtumat) {
        populoiKalenteri(tapahtumat);
    }

    private void populoiKalenteri(ArrayList<Tapahtuma> tapahtumat) {
        for (Tapahtuma tapahtuma: tapahtumat) {

        }
    }

    public ArrayList<Tapahtuma> getSaannolliset() {
        return saannolliset;
    }

    public ArrayList<Tapahtuma> getPoikkeukset() {
        return poikkeukset;
    }

}
