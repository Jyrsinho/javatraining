package AlgorithmsTwo.Aikataulu;

import java.util.ArrayList;

public class Aikataulu {

    public void kasitteleSyote(String syote) {
        Parser parser = new Parser();

        parser.kasitteleSyote(syote);
        ArrayList<AikaTaulutus> tapaukset = parser.annaTapaukset();

        for (AikaTaulutus tapaus: tapaukset) {
            String matsit = tapaus.jaaAikataulu();
            System.out.println(matsit);
        }

    }


    public static void main(String[] args) {


        String testiSyote1 = """
                3 1 2 0
                3 0
                3 1 0
                0
                4 2 5 0 2 4 0 4 2 0 0
                1 2 4 0 1 0 1 3 5 0 4 0 1 4 0 0
                0
                """;


        String testiSyote2 = """
                3 7 0
                4 6 7 9 0
                9 0
                10 0
                1 0
                2 5 0
                11 0
                9 0
                0
                0
                """;
        /*
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            sb.append(nextLine);
        }

         */

        Aikataulu aikataulu = new Aikataulu();
        aikataulu.kasitteleSyote(testiSyote1);
        System.out.println();
        System.out.println("------------------------------------------------------------------------------------------------");
        aikataulu.kasitteleSyote(testiSyote2);
    }
}
