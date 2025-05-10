package AlgorithmsTwo.Esitieto;

import java.util.ArrayList;

public class Kurssi {
    private int id;
    private String nimi;
    private int periodi;
    private ArrayList<Integer> ennakkotiedot;

    public Kurssi(int id, String nimi, int periodi, ArrayList<Integer> ennakkotiedot) {
        this.id = id;
        this.nimi = nimi;
        this.periodi = periodi;
        this.ennakkotiedot = ennakkotiedot;
    }

    public void tulosta() {
        System.out.printf("%d %s %d ", id, nimi, periodi);
        System.out.print("ennakkotiedot: ");
        for (int ennakkotieto: ennakkotiedot) {
            System.out.print(ennakkotieto + " ");
        }
    }

    //  Pitsinnypläys 4: 5 4 8 6 1 10
    //7 3 0

}
