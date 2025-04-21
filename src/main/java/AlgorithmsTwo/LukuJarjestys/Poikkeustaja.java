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
        return jarjestetytPoikkeukset;
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
       uniikitPoikkeukset = yhdistaJatkuvatPoikkeusTapaukset(uniikitPoikkeukset);
        return uniikitPoikkeukset;
    }

    /**
     * Yhdistaa perkkaiset Ei Tapahtumaa- poikkeustapaukset toisiinsa.
     * Kaytetaan hyvaksi sita etta tassa vaiheessa poikkeustapaukset on jarjestetty paivamaaran ja ajan perusteella
     */
    private ArrayList<Tapahtuma> yhdistaJatkuvatPoikkeusTapaukset(ArrayList<Tapahtuma> poikkeukset) {

        int i = 0;
        int j = 1;

        while (i < poikkeukset.size() -1) {
            if (poikkeukset.get(i).getNimi().equals("Ei Tapahtumaa") && poikkeukset.get(j).getNimi().equals("Ei Tapahtumaa")) {
                if (poikkeukset.get(i).getEnsimmainenAlkavaTunti() == poikkeukset.get(j).getEnsimmainenAlkavaTunti()-1 ) {
                    poikkeukset.remove(j);
                    poikkeukset.get(i).viimeinenAlkavaTunti++;
                }
            }

            i++;
            j++;
        }


        return poikkeukset;
    }


    /**
     *     jarjestaa Tapahtumat ensin paivamaaran ja sitten kellonajan mukaan
     */
    private ArrayList<Tapahtuma> jarjestaPoikkeukset(ArrayList<Tapahtuma> poikkeukset) {
        poikkeukset.sort(Comparator.comparing(Tapahtuma::getPaivamaara)
                .thenComparing(Tapahtuma::getEnsimmainenAlkavaTunti)
        );
        return poikkeukset;

    }


}
