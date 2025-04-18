package AlgorithmsTwo.LukuJarjestys;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static AlgorithmsTwo.LukuJarjestys.Utils.viikonpaiva;

/**
 * Lajittelee sisaltamansa tapahtumat saannolliseen tapahtumaan ja poikkeuksiin
 * Saannollinen tapahtuma Aikatauluruudussa eniten
 * esiintyvä Tapahtuma tai tyhjä, jos tyhjä esiintyy useammin kuin mikään tapahtuma. Jos eniten
 * esiintyvä tapahtuma ei ole yksikäsitteinen, niin saannollinen on se eniten esiintyvä epätyhjä
 * tapahtuma jolla on varhaisin esiintymispäivä.
 */
public class AikatauluRuutu {

    ArrayList<Tapahtuma> tapahtumat;
    String saannollinen;
    ArrayList<Tapahtuma> poikkeukset;
    LocalDate ensimmainenPv;
    LocalDate viimeinenPv;

    int ruudunVkPaiva;



    public AikatauluRuutu(LocalDate kalenterinEnsimmainenPv, LocalDate kalenterinViimeinenPv, int viikonpaiva) {
        this.tapahtumat = new ArrayList<>();
        this.saannollinen = "";
        this.poikkeukset = new ArrayList<>();
        this.ruudunVkPaiva =  viikonpaiva;
        this.ensimmainenPv = ruudunEnsimmainenPV(kalenterinEnsimmainenPv);
        this.viimeinenPv = kalenterinViimeinenPv;

    }


    public void lisaa(Tapahtuma tapahtuma) {
        tapahtumat.add(tapahtuma);
    }

    /**
     * Jakaa aikatauluruudun tapahtumat saannolliseen tapahtumaan ja poikkeuksiin
     */
    public void analysoi() {
        luoTyhjat();
        HashMap<String, Integer> tapahtumatJaMaarat = selvitaTapahtumienMaarat();

        ArrayList<String> saannolliset = selvitaSaannolliset(tapahtumatJaMaarat);

        if (saannolliset.size() == 1) {
            saannollinen = saannolliset.getFirst();
        } else {
            selvitaSaannollinen(saannolliset);
        }

        lisaaPoikkeukset();
    }

    private LocalDate ruudunEnsimmainenPV(LocalDate kalenterinEnsimmainenPv) {
        LocalDate ruudunAloitusPV = kalenterinEnsimmainenPv;
        int kalenterinAloituspaiva = viikonpaiva(kalenterinEnsimmainenPv);

        if (kalenterinAloituspaiva == ruudunVkPaiva) {
            return ruudunAloitusPV;
        }else if (ruudunVkPaiva > kalenterinAloituspaiva) {
            return ruudunAloitusPV.plusDays(kalenterinAloituspaiva - ruudunVkPaiva);
        }else {
            return ruudunAloitusPV.plusDays(+7 - ruudunVkPaiva);
        }
    }


    /**
     * Lisaa EiTapahtumaa objektin niille paiville, joissa Aikatauluruudussa ei ole tapahtumaa
     */
    private void luoTyhjat() {

        LocalDate current = ensimmainenPv;
        while (current.isBefore(viimeinenPv) || current.isEqual(viimeinenPv)) {
            if (!paivalleOnTapahtuma(current)) {
                luoTyhjaTapahtuma(current);
            }
            current = current.plusDays(7);

        }
    }

    private boolean paivalleOnTapahtuma(LocalDate pvm) {

        for (Tapahtuma tapahtuma: tapahtumat){
            if (tapahtuma.paivamaara.equals(pvm)) {
                return true;
            }
        }
        return false;
    }

    private void luoTyhjaTapahtuma(LocalDate pvm) {
        Tapahtuma eiTapahtumaa = new EiTapahtumaa(pvm);
        tapahtumat.add(eiTapahtumaa);
    }

    /**
     * Tapahtumat joiden nimi ei ole sama kuin saannollisen tapahtuman lisataan poikkeuksien listaan
     */
    private void lisaaPoikkeukset() {
        poikkeukset.clear();
        for (Tapahtuma tapahtuma: tapahtumat) {
           String tapahtumanNimi = tapahtuma.getNimi();
           if (!tapahtumanNimi.equals(saannollinen)) {
               poikkeukset.add(tapahtuma);
           }
        }

    }


    private HashMap<String, Integer> selvitaTapahtumienMaarat() {
        HashMap<String, Integer> tapahtumatJaMaarat = new HashMap<>();

        for (Tapahtuma tapahtuma: tapahtumat) {
            tapahtumatJaMaarat.merge(tapahtuma.getNimi(), 1, Integer::sum);
        }

        return tapahtumatJaMaarat;
    }


    private ArrayList<String> selvitaSaannolliset(HashMap<String, Integer> tapahtumienMaarat) {
        ArrayList<String> saannolliset = new ArrayList<>();

        // selvitetaan hashmapista useimmin tapahtuva tapahtuma ja asetaan se Aikatauluruudun saannolliseksi tapahtumaksi
        int useimminToistuvanToistojenmaara = 0;
        for (Map.Entry<String, Integer> entry : tapahtumienMaarat.entrySet()) {
            String tapahtumanNimi = entry.getKey();
            int tapahtumanToistot = entry.getValue();
           if (tapahtumanToistot > useimminToistuvanToistojenmaara ) {
               saannolliset.clear();
               saannolliset.add(tapahtumanNimi);
               useimminToistuvanToistojenmaara = tapahtumanToistot;
           } else if (tapahtumanToistot == useimminToistuvanToistojenmaara) {
               saannolliset.add(tapahtumanNimi);
           }
        }
        return saannolliset;
    }

    private void selvitaSaannollinen(ArrayList<String> saannolliset) {
        // Haetaan Tapahtumat, joilla on sama nimi kuin saannollisill
        ArrayList<Tapahtuma> mahdolliset = new ArrayList<>();
        for (Tapahtuma tapahtuma: tapahtumat) {
            if (saannolliset.contains(tapahtuma.getNimi())) {
                mahdolliset.add(tapahtuma);
            }
        }
        // Haetaan tapahtumista aikaisin
        Tapahtuma aikaisinTapahtuma = mahdolliset.getFirst();
        LocalDate aikaisinPVM = aikaisinTapahtuma.paivamaara;
        for (Tapahtuma mahdollinen: mahdolliset) {
            if (mahdollinen.paivamaara.isBefore(aikaisinPVM)){
                aikaisinPVM = mahdollinen.paivamaara;
                aikaisinTapahtuma = mahdollinen;
            }
        }
        // tallenetaan aikaisimman tapahtuman nimi saannolliseksi
        this.saannollinen = aikaisinTapahtuma.getNimi();
    }


    public String getSaannollinen() {
        return saannollinen;

    }

    public ArrayList<Tapahtuma> getPoikkeukset() {
        return poikkeukset;
    }

    public void tulosta() {
        for (Tapahtuma tapahtuma: tapahtumat) {
            System.out.println(tapahtuma);
        }
    }
}
