package AlgorithmsTwo.LukuJarjestys;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
    LocalDate ensimmainenPaiva;
    LocalDate viimeinenPaiva;
    int tunti;


    public AikatauluRuutu(LocalDate ensimmainenPaiva, LocalDate viimeinenPaiva, int tunti) {
        this.tapahtumat = new ArrayList<>();
        this.saannollinen = "";
        this.poikkeukset = new ArrayList<>();
        this.ensimmainenPaiva = ensimmainenPaiva;
        this.viimeinenPaiva = viimeinenPaiva;
        this.tunti = tunti;
    }


    public void lisaa(Tapahtuma tapahtuma) {
        tapahtumat.add(tapahtuma);
    }


    /**
     * Jakaa aikatauluruudun tapahtumat saannolliseen tapahtumaan ja poikkeuksiin
     */
    public void analysoi() {
        lisaaOlemattomatTapahtumat();
        HashMap<String, Integer> tapahtumatJaMaarat = selvitaTapahtumienMaarat();

        ArrayList<String> saannolliset = selvitaSaannolliset(tapahtumatJaMaarat);

        if (saannolliset.size() == 1) {
            saannollinen = saannolliset.getFirst();
        } else {
            selvitaSaannollinen(saannolliset);
        }

        lisaaPoikkeukset();
    }


    /**
     * Kaydaan lapi kaikki AikatauluRuudun sisaltamat paivamaarat ja lisataan tyhja tapahtuma jos
     * kyseiselle paivamaaralle ei ole lisatty tapahtumaa
     */
    private void lisaaOlemattomatTapahtumat(){
        LocalDate current = ensimmainenPaiva;

        while (current.isBefore(viimeinenPaiva)) {
            (!kyseisellePaivalleOnTapahtuma) {
                luoTyhjaTapahtuma(current);
            }
            current.plusDays(7);
        }
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
