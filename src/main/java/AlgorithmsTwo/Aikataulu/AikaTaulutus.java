package AlgorithmsTwo.Aikataulu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Aikataulutus on vastuussa algoritmin ajamisesta
 */
public class AikaTaulutus {

    private ArrayList<ArrayList<Integer>> kayttajienToiveet;    // kayttajat taulukkoon jossa on kunkin kayttajan indeksissa lista hanen toiveisiinsa
    private int[] asiakkaidenAjat; //merkataan kayttajan aika kayttajan indeksiin
    private int asiakkaidenMaara;
    private Map<Integer, Integer> aikaAsiakasMap = new HashMap<>();

    /**
     * Luodaan uusi aikataulutus Arraylistista joka sisaltaa kayttajat ja heidan aikatoiveensa
     * matriisissa
     * @param kayttajat kaksiulotteinen taulukko kayttajista ja heidan toiveistaan
     */
    public AikaTaulutus(ArrayList<ArrayList<Integer>> kayttajat) {
        this.kayttajienToiveet= kayttajat;
        asiakkaidenMaara = kayttajat.size();
        asiakkaidenAjat = new int[asiakkaidenMaara];

    }


    /**
     * Palauttaa taulukon
     *
     */
    public void jaaAikataulu() {
        alustaTulosTaulukko();


        for (int asiakasNumero = 0; asiakasNumero < asiakkaidenMaara; asiakasNumero++) {
            boolean[] vierailtuAsiakas = new boolean[asiakkaidenMaara];
            annaAika(asiakasNumero, vierailtuAsiakas);
        }

        taytaTulosTaulukko();
    }

    private void alustaTulosTaulukko() {
        Arrays.fill(asiakkaidenAjat, 0);
    }

    private boolean annaAika(int asiakasNumero, boolean []vierailtuasiakas) {
        if (vierailtuasiakas[asiakasNumero] == true) return false;
        vierailtuasiakas[asiakasNumero] = true;
        ArrayList<Integer> asiakkaanToiveet = kayttajienToiveet.get(asiakasNumero);

        for (int aika : asiakkaanToiveet) {
             if (!aikaAsiakasMap.containsKey(aika) || annaAika(aikaAsiakasMap.get(aika), vierailtuasiakas)) {
                aikaAsiakasMap.put(aika, asiakasNumero);
                return true;
            }
        }
        return false;
    }

    public int[] annaAsiakkaidenAjat() {
        return asiakkaidenAjat;
    }

    private void taytaTulosTaulukko() {
        for (Map.Entry<Integer, Integer> entry : aikaAsiakasMap.entrySet()) {
            int aika = entry.getKey();
            int customer = entry.getValue();
            asiakkaidenAjat[customer] = aika;
        }
    }

    public void tulostaAjat() {
        for (int i = 0; i <asiakkaidenAjat.length; i++) {
            System.out.println(asiakkaidenAjat[i]);
        }
    }


}
