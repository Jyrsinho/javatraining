package AlgorithmsTwo.Aikataulu;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Aikataulutus saa parserilta ArrayListin kayttajista ja heidan toiveajoistaan.
 * Aikataulutus palauttaa kayttajien aikatoiveista taulukon, jossa kullekin kayttajalle on annettu aika.
 * Ensimmainen indeksi on 0 ja tyhja. Muissa indekseissa on kayttajia 0...n
 */
public class AikaTaulu {

    private int asiakkaita;
    private ArrayList<ArrayList<Integer>> kayttajienToiveet;
    private boolean[] used;
    private int[] matching;

    public AikaTaulu() {
        this.kayttajienToiveet = new ArrayList<>();
        this.asiakkaita = 0;


    }

    /**
     * Palauttaa taulukon jossa jaettu maksimikardinaliteetin matsays kokonaislukutaulukon indeksit
     * ovat kayttajia indeksien arvot kullekin kayttajalle annettuja aikoja
     * @return {int [] kauttajienAjat}
     */
    public int [] jaaAikataulu() {
        // asiakkaita + 1 koska halutaan jattaa 0-indeksi tyhjaksi
        this.matching = new int[asiakkaita + 1];
        Arrays.fill(matching, -1);

        for (int i = 0; i < this.asiakkaita; i++) {
            used = new boolean[asiakkaita];
            // kaydaan jokainen asiakas lapi ja kokeillaan parittaa asiakas vapaalle ajalle
            matsaa(i);
        }

        return matching;
    }

    private boolean matsaa(int asikas) {
        if (used[asikas]) {
            return false;
        }
        used[asikas] = true;
        ArrayList<Integer> asiakkaanToiveet = kayttajienToiveet.get(asikas);
        for (int i = 0; i < asiakkaanToiveet.size(); i++) {
            if (matching[asiakkaanToiveet.get(i)] == -1) {
                matching[asiakkaanToiveet.get(i)] = asikas;
                return true;
            }
        }
        return false;
    }

    public void lisaaKayttaja(ArrayList<Integer> kayttajanToiveet){
        kayttajienToiveet.add(kayttajanToiveet);
        asiakkaita++;
    }

    public ArrayList<Integer> getKayttajanToiveet(int kayttajanIndeksi){
        return kayttajienToiveet.get(kayttajanIndeksi);
    }

    public void tulostaAikataulu() {
        for (int i = 0; i < matching.length; i++) {
            System.out.print("Aika: ");
            System.out.print(i + " ");
            System.out.print("Kayttaja: ");
            System.out.print(matching[i] +"   ");
        }

    }


}
