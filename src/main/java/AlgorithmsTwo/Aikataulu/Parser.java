package AlgorithmsTwo.Aikataulu;

import java.util.ArrayList;
import java.util.Scanner;

public class Parser {

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
                // jos nollinemaara on 3 koko aikataulujen syottaminen loppuu
            } else {
                break;
            }

        }
        return aikataulut;
    }
}


