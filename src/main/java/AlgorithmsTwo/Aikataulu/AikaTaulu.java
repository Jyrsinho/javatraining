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
    private int[] aikojenAsiakkaat; //träkkää mitkä ajat on annettu kenellekin asiakkaalle. Ajat ovat indekseja asiakkaat arvoja

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
        // pitaa loytaa suurin aika kayttajientoiveista tai sitten vaan tehda 1000 alkioinen taulukko suoraan
        this.aikojenAsiakkaat = new int[etsiSuurinAika() + 1 ];
        Arrays.fill(aikojenAsiakkaat, -1);

        for (int i = 0; i < this.asiakkaita; i++) {
            System.out.printf("PARITETAAN ASIAKAS %d :", i);
            System.out.println();
            used = new boolean[asiakkaita];
            System.out.println("Alustetaan Used - taulukko: " + Arrays.toString(this.used));
            // kaydaan jokainen asiakas lapi ja kokeillaan parittaa asiakas vapaalle ajalle
            matsaa(i);
        }

        return aikojenAsiakkaat;
    }

    private boolean matsaa(int asikas) {
        if (used[asikas]) {
            System.out.printf("Asiakas %d oli jo yritetty parittaa tällä kierroksella. Palautan false \n", asikas);
            return false;
        }

        //TODO: tahan pitaa tehda rekursiivinen tarkistus voidaanko
        used[asikas] = true;
        System.out.printf("Merkataan asikas: %d vierailluksi \n" , asikas);
        System.out.println(Arrays.toString(used));
        ArrayList<Integer> asiakkaanToiveet = kayttajienToiveet.get(asikas);
        System.out.printf("Käydään löpi asiakkaan %d jokainen toive \n", asikas);
        for (int i = 0; i < asiakkaanToiveet.size(); i++) {
            int asiakkaanToive = asiakkaanToiveet.get(i);
            if (aikojenAsiakkaat[asiakkaanToiveet.get(i)] == -1 || matsaa(aikojenAsiakkaat[asiakkaanToive])){
                System.out.printf("Asiakkaan toive %d oli vapaa. Annetaan asiakkaalle %d aika %d \n", asiakkaanToive, asikas, asiakkaanToive);
                aikojenAsiakkaat[asiakkaanToiveet.get(i)] = asikas;
                System.out.println("Matchingin tila: "+ Arrays.toString(aikojenAsiakkaat));
                return true;
            }else {
                System.out.printf("Asiakkaan %d toive %d oli varattu eika sille annettua asikasta voida siirtaa toiselle ajalle\n ", asikas, asiakkaanToive);
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

    /**
     * Tulostuksen tulkitsemisen helpottamiseksi kukin aika tai 0 kannattaa (mutta
     * ei ole pakko) tulostaa 4 merkkiä leveän kentän oikeaan reunaan. Kullekin riville
     * kannattaa tulostaa 10 aikaa tai nollaa, paitsi viimeinen rivi saa jäädä vajaaksi.
     * Myös viimeisen rivin loppuun kannattaa tulostaa rivinsiirto, vaikka se olisi vajaa.
     *
     * Skipataan ensimmainen indeksi, koska se on aina tyhja, koska nolla-aikaa ei ole olemassa.
     */
    public void tulostaAikataulu() {
        int [] asiakkaidenAjat = new int[asiakkaita];
        for (int i = 0; i < aikojenAsiakkaat.length; i++) {
            if (aikojenAsiakkaat[i] > 0) {
                asiakkaidenAjat[aikojenAsiakkaat[i]] = i;
            }
        }
        for (int i = 1; i < asiakkaidenAjat.length; i++) {
            System.out.print("    ");
            System.out.print(asiakkaidenAjat[i]);

            if (i % 10 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    private int etsiSuurinAika() {
        int suurin = Integer.MIN_VALUE;

        for (ArrayList<Integer> kayttajantoive : kayttajienToiveet) {
            for (int toive: kayttajantoive) {
                if (toive > suurin) {
                    suurin = toive;
                }
            }
        }
        return suurin;
    }
}
