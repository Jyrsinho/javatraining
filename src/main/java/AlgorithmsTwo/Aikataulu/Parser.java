package AlgorithmsTwo.Aikataulu;

import java.util.ArrayList;
import java.util.Scanner;

public class Parser {
    ArrayList<Tapaus> tapaukset;

    public Parser() {
        this.tapaukset = new ArrayList<>();
    }

    /**
     * Luodaan syotteesta ArrayList Tapauksista
     */
    public void kasitteleSyote(String syote) {
        Scanner scanner = new Scanner(syote);
        while (scanner.hasNext()) {
            String inputString = scanner.next();
            if (inputString.equals("0")){
                break;
            }
        }
    }

    public ArrayList<Tapaus> annaTapaukset() {
        return null;
    }
}
