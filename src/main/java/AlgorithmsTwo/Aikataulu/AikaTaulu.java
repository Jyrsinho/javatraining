package AlgorithmsTwo.Aikataulu;

import java.util.ArrayList;

/**
 * Aikataulutus saa parserilta ArrayListin kayttajista ja heidan toiveajoistaan.
 * Aikataulutus palauttaa kayttajien aikatoiveista taulukon, jossa kullekin kayttajalle on annettu aika.
 * Ensimmainen indeksi on 0
 */
public class AikaTaulu {

    private final int asiakkaita;
    private ArrayList<ArrayList<Integer>> kayttajienToiveet;

    public AikaTaulu() {
        this.kayttajienToiveet = new ArrayList<>();
        this.asiakkaita = kayttajienToiveet.size();
    }

    public int [] jaaAikataulu() {
        // return new int[asiakkaita];
        return new int[0];
    }

    public void lisaaKayttaja(ArrayList<Integer> kayttajanToiveet){
        kayttajienToiveet.add(kayttajanToiveet);
    }

    public ArrayList<Integer> getKayttajanToiveet(int kayttajanIndeksi){
        return kayttajienToiveet.get(kayttajanIndeksi);
    }

    public void tulostaAikataulu() {
        System.out.println("Tulostetaan aikataulu");
        System.out.println("...kunhan osataan");
    }


}
