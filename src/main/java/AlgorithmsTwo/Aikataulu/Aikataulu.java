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

        String testiSyote = """
                3 1 2 0
                3 0
                3 1 0
                0
                4 2 5 0 2 4 0 4 2 0 0
                1 2 4 0 1 0 1 3 5 0 4 0 1 4 0 0
                0
                """;

        Aikataulu aikataulu = new Aikataulu();
        aikataulu.kasitteleSyote(testiSyote);
    }
}
