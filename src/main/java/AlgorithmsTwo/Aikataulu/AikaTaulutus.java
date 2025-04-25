package AlgorithmsTwo.Aikataulu;

import java.util.ArrayList;

public class AikaTaulutus {

    ArrayList<Kayttaja> kayttajat;

    public AikaTaulutus(ArrayList<Kayttaja> kayttajat) {
        this.kayttajat = kayttajat;
    }


    public void lisaaKayttaja(Kayttaja uusiKayttaja) {
        kayttajat.add(uusiKayttaja);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Kayttaja kayttaja: kayttajat) {
            sb.append(kayttaja.toString());
        }
        return sb.toString();
    }

    public ArrayList<Kayttaja> getKayttajat() {
        return kayttajat;
    }
}
