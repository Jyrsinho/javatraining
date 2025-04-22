package AlgorithmsTwo.Aikataulu;

import java.util.ArrayList;

public class Aikataulu {

    public void kasitteleSyote(String syote) {
        Parser parser = new Parser();

        parser.kasitteleSyote(syote);
        ArrayList<Tapaus> tapaukset = parser.annaTapaukset();

        for (Tapaus tapaus: tapaukset) {
            ATMatcher matseri = new ATMatcher(tapaus);
            String matsit = matseri.jaaAikataulu();
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
