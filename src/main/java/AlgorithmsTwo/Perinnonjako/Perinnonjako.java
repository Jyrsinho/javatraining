package AlgorithmsTwo.Perinnonjako;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Käsittelee yhden perinnönjaon kerrallaan
 */
public class Perinnonjako {
    private String input;
    private int perinnonMaara;
    private int vainajanID;
    private Henkilo vainaja;
    ArrayList<Henkilo> jakoonOsallistuvat;


    public Perinnonjako(String input) {
        this.input = input;
        this.jakoonOsallistuvat = new ArrayList<>();
    }

    /**
     * Parsii saamansa merkkijonon perinnön määrään, vainajaan ja jakoon osallistuviin henkilöihin
     */
    public void parsePerinnonJako() {
        Scanner scanner = new Scanner(input);
        String vainajanTiedot = scanner.nextLine();
        parsePerinnonTiedot(vainajanTiedot);


        while (scanner.hasNext()) {
            boolean elossa = true;
            int id = scanner.nextInt();
            if (id < 0) {
                elossa = false;
            }
            String nimi = scanner.next();
            id = Math.abs(id);

            if (id == vainajanID) {
                this.vainaja = new Henkilo(nimi, elossa, id);
            } else {
                System.out.println("Ei tämä olekaan kuollut");
            }

        }

    }

    public void parsePerinnonTiedot(String vainajanTiedot) {
        Scanner scanner = new Scanner(vainajanTiedot);
        this.vainajanID = scanner.nextInt();
        this.perinnonMaara = scanner.nextInt();
    }



    public Henkilo getVainaja() {
        return vainaja;
    }


    public ArrayList<Henkilo> getJakoonOsallistuvat() {
        return jakoonOsallistuvat;
    }

    public int getPerinnonMaara() {
        return perinnonMaara;
    }

    public int getVainajanID() {
        return vainajanID;
    }


    public static void main(String[] args) {

}


}
