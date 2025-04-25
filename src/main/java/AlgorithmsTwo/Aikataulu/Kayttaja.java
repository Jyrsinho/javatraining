package AlgorithmsTwo.Aikataulu;

import java.util.ArrayList;

public class Kayttaja {
    int kayttajaID;
    ArrayList<Integer> toiveet;


    public Kayttaja(int kayttajaID, ArrayList<Integer> toiveet) {
        this.kayttajaID = kayttajaID;
        this.toiveet = toiveet;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Kayttaja ID: " + kayttajaID + "\n");
        sb.append("Toiveet: " + toiveet + "\n");
        return sb.toString();
    }

    public ArrayList<Integer> getToiveet() {
        return toiveet;
    }
}
