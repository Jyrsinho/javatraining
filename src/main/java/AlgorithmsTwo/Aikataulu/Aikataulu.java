package AlgorithmsTwo.Aikataulu;

import java.util.ArrayList;

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

        String testiSyote = """
                3 1 2 0
                3 0
                3 1 0
                0
                4 2 5 0 2 4 0 4 2 0 0
                1 2 4 0 1 0 1 3 5 0 4 0 1 4 0 0
                0
                """;
        /*
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            sb.append(nextLine);
            sb.append("\n");
        }

         */




        Aikataulu aikataulu = new Aikataulu();
       // aikataulu.kasitteleSyote(sb.toString());
        aikataulu.kasitteleSyote(testiSyote);
    }
}
