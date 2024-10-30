package AlgorithmsOne;

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
            a = a-b;
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

        return true;
    }

}
