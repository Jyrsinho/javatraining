package AlgorithmsTwo.Aikataulu;

import java.util.ArrayList;

public class Aikataulu {

    public void kasitteleSyote(String syote) {
        Parser parser = new Parser();

        parser.kasitteleSyote(syote);
        ArrayList<AikaTaulutus> aikaTaulutukset= parser.annaTapaukset();

        for (AikaTaulutus aikaTaulutus: aikaTaulutukset) {

            //aikaTaulutus.jaaAikataulu();
            // int [] tulos = aikaTaulutus.annaAsiakkaidenAjat();
            Tulostaja tulosta = new Tulostaja();
            // tulosta.tulostaAikataulutus(tulos);
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

        String testiSyote2 = """
        20 21 22 23 25 26 0
        1 2 13 0
        8 9 10 11 12 3 4 5 6 7 20 21 22 23 0
        25 26 0
        20 29 30 31 32 0
        8 9 10 11 12 0
        25 26 0
        3 4 5 6 7 0
        13 27 0
        20 29 30 31 32 16 17 18 0
        13 20 29 30 31 32 0
        19 20 21 22 23 0
        20 29 30 31 32 24 0
        13 8 9 10 11 12 0
        3 4 5 6 7 24 0
        13 19 0
        20 21 22 23 20 29 30 31 32 0
        8 9 10 11 12 20 29 30 31 32 24 0
        1 2 20 29 30 31 32 0
        3 4 5 6 7 14 15 20 29 30 31 32 24 16 17 18 25 26 0
        16 17 18 0
        1 2 19 14 15 0
        1 2 3 4 5 6 7 20 21 22 23 0
        13 27 3 4 5 6 7 16 17 18 25 26 0
        8 9 10 11 12 25 26 0
        19 27 14 15 20 29 30 31 32 0
        1 2 0
        27 20 29 30 31 32 0
        27 0
        20 21 22 23 16 17 18 0
        20 29 30 31 32 0
        20 21 22 23 0
        0
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
        System.out.println();
        aikataulu.kasitteleSyote(testiSyote2);
    }
}
