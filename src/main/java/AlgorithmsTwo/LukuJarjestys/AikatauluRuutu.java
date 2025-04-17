package AlgorithmsTwo.LukuJarjestys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AikatauluRuutu {

    HashMap<Tapahtuma, Integer> tapahtumat;
    Tapahtuma saannollinen;
    ArrayList<Tapahtuma> poikkeukset;


    public AikatauluRuutu() {
        this.tapahtumat = new HashMap<>();
    }

    public void lisaa(Tapahtuma tapahtuma) {
        if (tapahtumat.containsKey(tapahtuma)) {
            tapahtumat.put(tapahtuma, tapahtumat.get(tapahtuma) + 1);
        }else {
            tapahtumat.put(tapahtuma, 1);
        }
    }

    /**
     * Jakaa aikatauluruudun tapahtumat saannolliseen tapahtumaan ja poikkeuksiin
     * @param toistojenMaara montako kertaa kyseinen aikatauluruutu esiintyy lukujarjestyksessa
     */
    public void analysoi(int toistojenMaara) {
        // selvitetaan hashmapista useimmin tapahtuva tapahtuma ja asetaan se Aikatauluruudun saannolliseksi tapahtumaksi
        Tapahtuma useimminToistuva = new TapahtumaEiOlemassa();
        int useimminToistuvanToistojenmaara = 0;
        for (Map.Entry<Tapahtuma, Integer> entry : tapahtumat.entrySet()) {
            Tapahtuma tapahtuma = entry.getKey();
            int tapahtumanToistot = entry.getValue();
           if (tapahtumanToistot > useimminToistuvanToistojenmaara ) {
               useimminToistuvanToistojenmaara = tapahtumanToistot;
               useimminToistuva = tapahtuma;
           }
        }

        saannollinen = useimminToistuva;
    }

    public Tapahtuma getSaannollinen() {
        return saannollinen;
    }

    public ArrayList<Tapahtuma> getPoikkeukset() {
        return poikkeukset;
    }
}
