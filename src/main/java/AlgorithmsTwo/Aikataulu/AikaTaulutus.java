package AlgorithmsTwo.Aikataulu;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Aikataulutus on vastuussa algoritmin ajamisesta
 */
public class AikaTaulutus {

    private ArrayList<Kayttaja> kayttajat;
    private boolean[] vierailtu;
    private int[] matsatyt; //merkataan aika [aika] = kayttaja


    public AikaTaulutus(ArrayList<Kayttaja> kayttajat) {
        this.kayttajat = kayttajat;
        matsatyt = new int[etsiSuurinAika()+1];
        Arrays.fill(matsatyt, -1);
    }


    /**
     * Palauttaa rivin jossa neljan tyhjan merkin valein kunkin kayttajan saama aika.
     * @return Palauttaa rivin jossa neljan tyhjan merkin valein kunkin kayttajan saama aika.
     */
    public String jaaAikataulu() {
        maksimoiMatsit();

        asetaKayttajilleAjat();
        String tulos = tulkitsetulos();
        return tulos;
    }

    private void maksimoiMatsit() {
        for (Kayttaja kayttaja: kayttajat){
            vierailtu = new boolean[matsatyt.length];
            dfs(kayttaja);
        }
    }

    private boolean dfs(Kayttaja kayttaja) {
        for (int toive: kayttaja.getToiveet()) {
            if (vierailtu[toive]) continue;
            vierailtu[toive] = true;

            //tarkistetaan onko loopissa vuorossa oleva aika vapaa
            if (matsatyt[toive] == -1 || dfs(etsiKayttajaIideenPerusteella(matsatyt[toive]))){
                matsatyt[toive] = kayttaja.getId();
                return true;
            }
        }
        return false;
    }

    private String tulkitsetulos() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < kayttajat.size(); i++) {
            sb.append(kayttajat.get(i).getMatsi());
        }
        return sb.toString();
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

    private int etsiSuurinAika() {
        int suurin = -1;
        for (Kayttaja kayttaja: kayttajat) {
            for (Integer toive: kayttaja.getToiveet()) {
                if (toive > suurin) {
                    suurin = toive;
                }
            }
        }
        return suurin;
    }

    private Kayttaja etsiKayttajaIideenPerusteella(int id) {
        for (Kayttaja kayttaja: kayttajat) {
            if (kayttaja.getId() == id) {
                return kayttaja;
            }
        }
        return null;
    }

}
