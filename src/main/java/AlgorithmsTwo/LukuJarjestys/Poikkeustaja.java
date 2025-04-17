package AlgorithmsTwo.LukuJarjestys;

import java.time.LocalDate;
import java.util.ArrayList;

import static AlgorithmsTwo.LukuJarjestys.Utils.viikonpaiva;

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
    private int[] tapahtumaPaivienMaara;




    public Poikkeustaja() {

        poikkeukset = new ArrayList<>();
        saannolliset = new ArrayList<>();
        kalenteri =  new AikatauluRuutu[paivia][tunteja];
        tapahtumaPaivienMaara = new int[paivia];

    }

    public void lajitteleTapahtumat(ArrayList<Tapahtuma> tapahtumat) {
        laskeTapahtumaPaivienMaara(tapahtumat);
        alustaKalenteri();
        populoiKalenteri(tapahtumat);
        analysoiKalenteri();
    }


    /**
     * Lasketaan montako kertaa lukujarjestyksen aikana kukin viikonpaiva esiintyy
     * @param tapahtumat joista etsitaan esiintymat
     */
    private void laskeTapahtumaPaivienMaara(ArrayList<Tapahtuma> tapahtumat) {
        LocalDate aikaisinTapahtuma = aikaisinTapahtuma(tapahtumat);
        LocalDate myohaisinTapahtuma = myohaisinTapahtuma(tapahtumat);
        LocalDate currentDate = aikaisinTapahtuma;

        while (currentDate.isBefore(myohaisinTapahtuma) || currentDate.isEqual(myohaisinTapahtuma)) {
            int viikonpaiva = viikonpaiva(currentDate);
            if (viikonpaiva > 0) {
                tapahtumaPaivienMaara[viikonpaiva]++;
            }
            currentDate = currentDate.plusDays(1);
        }

    }

    private LocalDate aikaisinTapahtuma (ArrayList<Tapahtuma> tapahtumat) {
        LocalDate aikaisinTapahtuma = LocalDate.MAX;
        for (Tapahtuma tapahtuma: tapahtumat) {
            if (tapahtuma.paivamaara.isBefore(aikaisinTapahtuma)) {
                aikaisinTapahtuma = tapahtuma.paivamaara;
            }
        }
        return aikaisinTapahtuma;
    }

    private LocalDate myohaisinTapahtuma (ArrayList<Tapahtuma> tapahtumat) {
        LocalDate myohaisinTapahtuma = LocalDate.MIN;
        for (Tapahtuma tapahtuma: tapahtumat) {
            if (tapahtuma.paivamaara.isAfter(myohaisinTapahtuma)) {
                myohaisinTapahtuma = tapahtuma.paivamaara;
            }
        }
        return myohaisinTapahtuma;
    }


    private void alustaKalenteri() {
        for (int i = 0; i < paivia; i++) {
            for (int j = 0; j < tunteja; j++) {
                kalenteri[i][j] = new AikatauluRuutu();
            }
        }
    }


    private void populoiKalenteri(ArrayList<Tapahtuma> tapahtumat) {
        for (Tapahtuma tapahtuma: tapahtumat) {
            int tapahtumanPaiva = viikonpaiva(tapahtuma.getPaivamaara());
            int aloittavaTunti = tapahtuma.ensimmainenAlkavaTunti;

            kalenteri[tapahtumanPaiva][aloittavaTunti].lisaa(tapahtuma);
        }
    }


    private void analysoiKalenteri() {
        for (int i = 0; i < paivia; i++) {
            int paiviaKalenterissa = getTapahtumaPaivanMaara(i);
            for (int j = 0; j < tunteja; j++) {
                AikatauluRuutu tutkittava = kalenteri[i][j];
                tutkittava.analysoi(paiviaKalenterissa);
                Tapahtuma saannollinenTapahtuma = tutkittava.getSaannollinen();
                saannolliset.add(saannollinenTapahtuma);
                ArrayList<Tapahtuma> poikkeukset = tutkittava.getPoikkeukset();
            }
        }
    }

    public ArrayList<Tapahtuma> getSaannolliset() {
        return saannolliset;
    }

    public ArrayList<Tapahtuma> getPoikkeukset() {
        return poikkeukset;
    }

    public int getTapahtumaPaivanMaara(int paiva) {
        return tapahtumaPaivienMaara[paiva];
    }


}
