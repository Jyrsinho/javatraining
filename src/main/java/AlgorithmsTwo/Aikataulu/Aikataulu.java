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

        String testiSyote2 = """
                21 0
                6 0
                48 0
                29 37 0
                6 11 27 50 0
                6 36 0
                23 51 0
                26 27 0
                28 34 38 0
                28 45 0
                6 0
                14 19 53 0
                5 0
                8 13 15 51 53 0
                15 0
                21 0
                8 0
                5 11 16 17 52 0
                8 17 0
                29 0
                8 11 21 34 0
                30 0
                14 26 41 0
                17 50 0
                1 17 19 48 0
                16 0
                42 0
                37 44 0
                41 44 0
                40 0
                11 41 46 0
                1 11 0
                5 37 0
                2 13 25 0
                53 0
                27 28 0
                25 44 0
                12 24 48 0
                15 26 27 33 49 0
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
