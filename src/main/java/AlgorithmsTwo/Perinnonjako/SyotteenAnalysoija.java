package AlgorithmsTwo.Perinnonjako;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class SyotteenAnalysoija {

    /**
     * kolme peräkkäistä kokonaislukua joista kolmas on 0 lopettaa perinnonjaon
     * neljä peräkkäistä kokonaislukua joista kolmas ja neljäs ovat nollia, lopettaa koko syotteen
     * @param input merkkijono jota tutkitaan
     * @return ArrayList jossa input jaoteltuna eri perintoinputeihin
     */
    public ArrayList<String> annaPerinnonjakoSyotteet(String input) {

        ArrayList<String> perinnonjakoSyotteet = new ArrayList<>();
        int perakkaistenKokonaislukujenMaara = 0;
        Scanner sc = new Scanner(input);
        StringBuilder perinnonJako = new StringBuilder();

        while (sc.hasNext()) {
            String merkkijono = sc.next();
            if (onKokonaisluku(merkkijono)) {
                perakkaistenKokonaislukujenMaara++;
            } else {
                perakkaistenKokonaislukujenMaara = 0;
            }
            if (perakkaistenKokonaislukujenMaara == 3  && Objects.equals(merkkijono, "0")) {
                // poistetaan viimeinen valilyonti
                perinnonJako.delete(perinnonJako.length() - 1, perinnonJako.length());
                perinnonjakoSyotteet.add(perinnonJako.toString());
                perinnonJako = new StringBuilder();
                continue;
            }
            if (perakkaistenKokonaislukujenMaara == 4 && Objects.equals(merkkijono, "0")) {
                break;
            }
            perinnonJako.append(merkkijono).append(" ");

        }

        return perinnonjakoSyotteet;
    }

    private boolean onKokonaisluku(String merkkijono) {
        try {
            Integer.parseInt(merkkijono);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


}
