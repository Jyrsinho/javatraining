package AlgorithmsTwo.Aikataulu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AikatauluTehtava {

    public void kasitteleSyote() {
        Parser parser = new Parser();
        ArrayList<AikaTaulu> aikaTaulutukset = parser.kasitteleSyote();


        for (AikaTaulu aikaTaulu: aikaTaulutukset) {
            aikaTaulu.jaaAikataulu();
            aikaTaulu.tulostaAikataulu();
        }
    }


    public static void main(String[] args) {

        AikatauluTehtava aikataulu = new AikatauluTehtava();
        aikataulu.kasitteleSyote();

    }

    /**
     * Aikataulutus saa parserilta ArrayListin kayttajista ja heidan toiveajoistaan.
     * Aikataulutus palauttaa kayttajien aikatoiveista taulukon, jossa kullekin kayttajalle on annettu aika.
     * Ensimmainen indeksi on 0 ja tyhja. Muissa indekseissa on kayttajia 0...n
     */
    public static class AikaTaulu {

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
                used = new boolean[asiakkaita];
                // kaydaan jokainen asiakas lapi ja kokeillaan parittaa asiakas vapaalle ajalle
                matsaa(i);
            }

            return aikojenAsiakkaat;
        }

        private boolean matsaa(int asikas) {
            if (used[asikas]) {
                return false;
            }

            used[asikas] = true;
            ArrayList<Integer> asiakkaanToiveet = kayttajienToiveet.get(asikas);
            for (int i = 0; i < asiakkaanToiveet.size(); i++) {
                int asiakkaanToive = asiakkaanToiveet.get(i);
                if (aikojenAsiakkaat[asiakkaanToiveet.get(i)] == -1 || matsaa(aikojenAsiakkaat[asiakkaanToive])){
                    aikojenAsiakkaat[asiakkaanToiveet.get(i)] = asikas;
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

    public static class Parser {

        public Parser() {
        }

        public ArrayList<AikaTaulu> kasitteleSyote() {
            ArrayList<AikaTaulu> aikataulut = new ArrayList<>();
            AikaTaulu aikaTaulu = new AikaTaulu();
            ArrayList<Integer> kayttajanToiveet = new ArrayList<>();
            //lisataan aikatauluun aina yksi dummy, etta voidaan kayttaa indekseja ykkosesta
            aikaTaulu.lisaaKayttaja(new ArrayList<>());
            Scanner scanner = new Scanner(System.in);

            int nollienMaara = 0;

            while (scanner.hasNextLine()) {
                int seuraava = scanner.nextInt();

                if (seuraava == 0 ) {
                    nollienMaara++;
                } else {
                    nollienMaara = 0;
                }
                // jos nollienMaara on 0 yhden kayttajan syote  jatkuu
                if (nollienMaara == 0) {
                    kayttajanToiveet.add(seuraava);
                    // jos nollienmaara on 1 yhden kayttajan toiveiden syote loppuu
                } else if (nollienMaara == 1) {
                    aikaTaulu.lisaaKayttaja(kayttajanToiveet);
                    kayttajanToiveet = new ArrayList<>();
                    // jos nollienmaara on 2 yhden aikataulun syote loppuu
                } else if (nollienMaara == 2) {
                    aikataulut.add(aikaTaulu);
                    aikaTaulu = new AikaTaulu();
                    aikaTaulu.lisaaKayttaja(new ArrayList<>());
                    // jos nollinemaara on 3 koko aikataulujen syottaminen loppuu
                } else {
                    break;
                }

            }
            return aikataulut;
        }
    }
}
