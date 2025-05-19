package AlgorithmsTwo.Aikataulu;

import java.util.ArrayList;

public class AikatauluTehtava {

    public void kasitteleSyote() {
        Parser parser = new Parser();
        ArrayList<AikaTaulu> aikaTaulutukset = parser.kasitteleSyote();


        for (AikaTaulu aikaTaulu: aikaTaulutukset) {
            aikaTaulu.jaaAikataulu();
            aikaTaulu.tulostaAikataulu();
        }
    }


    public static void main(String[] args) {

        AikatauluTehtava aikataulu = new AikatauluTehtava();
        aikataulu.kasitteleSyote();

    }
}
