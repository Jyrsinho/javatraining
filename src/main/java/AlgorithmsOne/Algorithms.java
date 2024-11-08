package AlgorithmsOne;

import java.util.ArrayList;

public class Algorithms {


    // Algoritmi, joka laskee kahden kokonaisluvun välisen jakojäännöksen käyttämättä lainkaan jakolaskuja.
     /*
        1. Otetaan kaksi kokonaislukua a ja b
        2. Jos b on 0, palautetaan -1
        3. Niin kauan kuin a on suurempi tai yhtäsuuri kuin b:
            4 vähennetään b a:sta.
        5. Palautetaan a.
      */
    public static int modulo(int a, int b) {
        if (b == 0) {
            return -1;
        }
        while (a >= b) {
            a = a - b;
        }
        return a;
    }


    // algoritmi, joka tutkii, onko merkkijonossa jossain kohtaa kaksi samaa merkkiä peräkkäin.
    /*
        1. otetaan merkkijono s
        2. asetetaan muuttuja n merkitsemään merkkien kokonaismäärää merkkijonossa s.
        3, jos n:n arvo on pienempi kuin 2, palautetaan false.
        4. asetetaan muuttujan a arvoksi 0 ja muuttujan b arvoksi 1.
        5. niin kauan kuin muuttujan b arvo on pienempi kuin muuttujan n arvo:
            6. tarkistetaan onko s:n indeksissä a sama merkki kuin s:n indeksissä b.
                6.1 jos merkit ovat samat:
                    6.1.1 palautetaan funktiosta true.
                6.2 jos merkit ovat eri:
                    6.2.1 lisätään a ja b muuttujien arvoja yhdellä.
        7. palautetaan false.
     */

    public static boolean twoOfTheSame(String s) {
        int n = s.length();
        if (n < 2) return false;
        int a = 0;
        int b = 1;

        while (b < n) {
            if (s.charAt(a) == s.charAt(b)) {
                return true;
            }
            a++;
            b++;
        }
        return false;
    }

    /*

    0. Jos taulukon alkioiden määrä on 0. Palautetaan -1.
    1. Lasketaan kaikki taulukon alkiot yhteen
    2. Jaetaan taulukon alkioiden summa alkioiden määrällä ja tallennetaan se muuttujaan avg
    3. Alustetaan muuttuja amountOfLargerElements nollaksi.
    4. Verrataan jokaista taulukon alkiota yksi kerrallaan muuttujaan avg.
        4.1 jos verrattava alkio on suurempi kuin avg lisätään muuttujan amountOfLargerElements arvoa yhdellä
    5. palautetaan amountOfLargerElements

    Suoritusaika kasvaa lineaarisesti. Jokainen alkio lisää taulukossa tuo yhden operaation lisää kun lasketaan
    taulukon alkioiden summaa. Samoin jokainen lisätty alkio tuo yhden vertailuoperaation lisää askeleeseen 4.

     */

    public static int largerThanAvg(int[] t) {
        if (t.length == 0) return -1;
        int sum = 0;
        int avg = 0;
        int amountOfLargerElements = 0;

        for (int element : t) {
            sum += element;
        }

        avg = sum / t.length;

        for (int element : t) {
            if (element > avg) {
                amountOfLargerElements++;
            }
        }

        return amountOfLargerElements;
    }


    /*
        (b) Taulukossa on lukuja suuruusjärjestyksessä (samansuuruiset luvut peräkkäin).
        Suunnittele algoritmi, joka pakkaa taulukon siten, että kutakin eri lukua jää
        taulukkoon vain yksi kappale. Arvioi, miten suoritusaika riippuu taulukon koosta.

       1. Otetaan taulukko tVanha, joka sisältää suuruusjärjestykseen järjestettyjä kokonaislukuja.
       2. Luodaan uusi taulukko tUusi.
       3. Asetetaan taulukon tVanha ensimmäinen alkio taulukon tUusi ensimmäiseksi alkioksi.
       4. Luodaan muuttuja i ja asetetaan sen arvoksi 0.
       5. Luodaan muuttuja j ja asetetaan sen arvoksi 1.
       6. Niin kauan kuin j on vähemmän kuin taulukon t1 alkioiden määrä:
            6.1 Jos taulukon tVanha indeksissä j on eri arvo kuin taulukon tUusi indeksissä i:
                6.1.1 Lisätään arvo taulukon tVanha indeksistä j taulukon tUusi indeksiin i+1
                6.1.2 Lisätään muuttujien i ja j arvoa yhdellä.
            6.2 Jos taulukon tVanha indeksissä j on sama arvo kuin taulukon tUusi indeksissä i:
                6.2.1 Lisätään muuttujan j arvoa yhdellä.
        7. Palautetaan taulukko tUusi.

        Algoritmin suoritusaika kasvaa lineaarisesti alkioiden lisääntyessä. Jokainen uusi alkio tuo yhden vertailuoperaation
        lisää algoritmiin.
     */
    public static ArrayList<Integer> compressIntArray(int[] t) {

        ArrayList<Integer> arrayNew = new ArrayList<>();
        arrayNew.add(t[0]);
        int i = 0;
        int j = 1;

        while (j < t.length) {
            if (t[j] != arrayNew.get(i)) {
                arrayNew.add(t[j]);
                i++;
                j++;
            } else {
                j++;
            }
        }

        return arrayNew;

    }


    public static int laskeSummaRekursiivisesti(int[] t, int n) {

        if (n <= 1) return t[0];
        else return t[n-1] + laskeSummaRekursiivisesti(t, n - 1);

    }


    public static int etsiSuurinRekursiivisesti(int[] t, int n) {

        return 5;
    }

}

