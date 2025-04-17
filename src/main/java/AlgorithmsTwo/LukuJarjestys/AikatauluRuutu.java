package AlgorithmsTwo.LukuJarjestys;

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
    int toistojenMaara;

    public AikatauluRuutu(int toistojenMaara) {
        this.tapahtumat = new ArrayList<>();
        this.saannollinen = "";
        this.toistojenMaara = toistojenMaara;
    }

    public void lisaa(Tapahtuma tapahtuma) {
        tapahtumat.add(tapahtuma);
        analysoi();
    }

    /**
     * Jakaa aikatauluruudun tapahtumat saannolliseen tapahtumaan ja poikkeuksiin
     */
    public void analysoi() {
        HashMap<String, Integer> tapahtumatJaMaarat = selvitaTapahtumienMaarat(toistojenMaara);

        ArrayList<String> saannolliset = selvitaSaannolliset(tapahtumatJaMaarat);

        if (saannolliset.size() == 1) {
            saannollinen = saannolliset.getFirst();
        } else {
            selvitaSaannollinen(saannolliset);
        }
    }

    private HashMap<String, Integer> selvitaTapahtumienMaarat(int toistojenMaara) {
        HashMap<String, Integer> tapahtumatJaMaarat = new HashMap<>();

        for (Tapahtuma tapahtuma: tapahtumat) {
            tapahtumatJaMaarat.merge(tapahtuma.getNimi(), 1, Integer::sum);
        }

        //lisataan tyhjia tapahtumia
        int tyhjienMaara = toistojenMaara - tapahtumat.size();
        tapahtumatJaMaarat.put("EiTapahtumaa", tyhjienMaara);

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


       // Haetaan Tapahtumat, joilla on sama nimi kuin saannollisilla
        // Haetaan tapahtumista aikaisin
        // tallenetaan aikaisimman tapahtuman nimi saannolliseksi
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
