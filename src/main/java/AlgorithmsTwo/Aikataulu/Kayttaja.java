package AlgorithmsTwo.Aikataulu;

import java.util.ArrayList;

public class Kayttaja {
    private int kayttajaID;
    private ArrayList<Integer> toiveet;
    private int matsi;


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

    public int getMatsi() {
        return matsi;
    }

    public ArrayList<Integer> getToiveet() {
        return toiveet;
    }

    public  void setMatsi(int matsi) {
        this.matsi = matsi;
    }

    public int getId() {
        return kayttajaID;
    }



}
