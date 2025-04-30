package AlgorithmsTwo.Aikataulu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Aikataulutus on vastuussa algoritmin ajamisesta
 */
public class AikaTaulutus {

    private ArrayList<ArrayList<Integer>> kayttajienToiveet;    // kayttajat taulukkoon jossa on kunkin kayttajan indeksissa lista hanen toiveisiinsa
    private boolean[] vierailtu;
    private int[] matsatyt; //merkataan aika kayttajan indeksiin aika


    /**
     * Luodaan uusi aikataulutus Arraylistista joka sisaltaa kayttajat ja heidan aikatoiveensa
     * matriisissa
     * @param kayttajat kaksiulotteinen taulukko kayttajista ja heidan toiveistaan
     */
    public AikaTaulutus(ArrayList<ArrayList<Integer>> kayttajat) {
        this.kayttajienToiveet= kayttajat;
        Map<Integer, Integer> aikaKayttajalle = new HashMap<>(); //aika --> asiakas
        Arrays.fill(matsatyt, -1);
    }


    /**
     * Palauttaa taulukon
     *
     */
    public int[] jaaAikataulu() {
        int asikasluku = kayttajienToiveet.size();
        assignedTimeForCustomer = new int[customerCount];
        Arrays.fill(assignedTimeForCustomer, 0);
        timeAssignedTo.clear();

        return matsatyt;
    }




}
