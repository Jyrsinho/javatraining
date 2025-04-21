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

        boolean samaaTapahtumaa = false;

        while (i < poikkeukset.size() - 1) {
            Tapahtuma ensimmainenPoikkeus = poikkeukset.get(i);
            Tapahtuma verrattavaPoikkeus = poikkeukset.get(j);

            samaaTapahtumaa = ovatSamaaTapahtumaa(ensimmainenPoikkeus, verrattavaPoikkeus);

            if (samaaTapahtumaa) {
                poikkeukset.remove(j);
                poikkeukset.get(i).viimeinenAlkavaTunti++;
            }else {
                i++;
                j++;
            }
        }


        return poikkeukset;
    }


    private boolean ovatSamaaTapahtumaa(Tapahtuma a, Tapahtuma b) {
        if (!a.paivamaara.equals(b.paivamaara)){
            return false;
        }
        if (!a.getNimi().equals(b.getNimi())) {
            return false;
        }
        if (a.getViimeinenAlkavaTunti() + 1 != b.getEnsimmainenAlkavaTunti()) {
            return false;
        }

        return true;
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
