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
    private Map<Integer, Integer> aikaAsiakkaalle = new HashMap<>();

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
            annaAika(asiakasNumero);
        }
    }

    private void alustaTulosTaulukko() {
        Arrays.fill(asiakkaidenAjat, 0);
    }

    private boolean annaAika(int asiakasNumero) {
        boolean[] vierailtu = new boolean[1000];
        ArrayList<Integer> asiakkaanToiveet = kayttajienToiveet.get(asiakasNumero);

        for (int aika : asiakkaanToiveet) {
            if (vierailtu[aika]) {
                continue;
            }
            vierailtu[aika] = true;

             if (!aikaAsiakkaalle.containsKey(aika) || annaAika(aikaAsiakkaalle.get(aika))){
                aikaAsiakkaalle.put(aika, asiakasNumero);
                return true;
            }
        }
        return false;
    }

    public int[] annaAsiakkaidenAjat() {
        return asiakkaidenAjat;
    }

    public void tulostaAjat() {
        for (int i = 0; i <asiakkaidenAjat.length; i++) {
            System.out.println(asiakkaidenAjat[i]);
        }
    }


}
