package AlgorithmsTwo.LukuJarjestys;

import java.util.ArrayList;
import java.util.Comparator;

public class Poikkeustaja {

    private Kalenteri kalenteri;

    public Poikkeustaja(Kalenteri kalenteri) {
        this.kalenteri = kalenteri;
    }

    public ArrayList<Tapahtuma> annaPoikkeukset() {

        ArrayList<Tapahtuma> kaikkiPoikkeukset = haePoikkeukset();
        ArrayList<Tapahtuma> uniikitPoikkeukset = poistaDuplikaatit(kaikkiPoikkeukset);
        ArrayList<Tapahtuma> jarjestetytPoikkeukset = jarjestaPoikkeukset(uniikitPoikkeukset);
        return uniikitPoikkeukset;
    }


    private ArrayList<Tapahtuma> haePoikkeukset() {
        ArrayList<Tapahtuma> poikkeukset = new ArrayList<>();
        for (int i = 0; i <kalenteri.getTapahtumaKalenteri().length; i++) {
            for (int j = 0; j < kalenteri.getTapahtumaKalenteri()[i].length; j++) {
                AikatauluRuutu tutkittava = kalenteri.getTapahtumaKalenteri()[i][j];
                ArrayList<Tapahtuma> aikatauluRuudunPoikkeukset = tutkittava.getPoikkeukset();
                poikkeukset.addAll(aikatauluRuudunPoikkeukset);
            }
        }
        return poikkeukset;
    }

    private ArrayList<Tapahtuma> poistaDuplikaatit(ArrayList<Tapahtuma> kaikkiPoikkeukset) {
        ArrayList<Tapahtuma> uniikitPoikkeukset = new ArrayList<>();
        for (Tapahtuma tapahtuma: kaikkiPoikkeukset) {
            if (!uniikitPoikkeukset.contains(tapahtuma)) {
                uniikitPoikkeukset.add(tapahtuma);
            }
        }
        return uniikitPoikkeukset;
    }

    /**
     *     jarjestaa Tapahtumat ensin paivamaaran ja sitten kellonajan mukaan
     */
    private ArrayList<Tapahtuma> jarjestaPoikkeukset(ArrayList<Tapahtuma> poikkeukset) {
        poikkeukset.sort(Comparator.comparing(Tapahtuma::getPaivamaara));
        return poikkeukset;

    }


}
