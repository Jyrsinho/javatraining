package AlgorithmsTwo.LukuJarjestys;

import java.util.ArrayList;

public class Poikkeustaja {

    private Kalenteri kalenteri;

    public Poikkeustaja(Kalenteri kalenteri) {
        this.kalenteri = kalenteri;
    }

    public ArrayList<Tapahtuma> annaPoikkeukset() {
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
}
