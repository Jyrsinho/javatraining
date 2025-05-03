package AlgorithmsTwo.Aikataulu;

import java.util.ArrayList;
import java.util.Scanner;

public class Aikataulu {

    public void kasitteleSyote(String syote) {
        Parser parser = new Parser();

        parser.kasitteleSyote(syote);
        ArrayList<AikaTaulutus> aikaTaulutukset= parser.annaTapaukset();

        for (AikaTaulutus aikaTaulutus: aikaTaulutukset) {
            aikaTaulutus.jaaAikataulu();
            int [] tulos = aikaTaulutus.annaAsiakkaidenAjat();
            Tulostaja tulosta = new Tulostaja();
            tulosta.tulostaAikataulutus(tulos);
        }

    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            sb.append(nextLine);
            sb.append("\n");
        }




        Aikataulu aikataulu = new Aikataulu();
       aikataulu.kasitteleSyote(sb.toString());
    }
}
