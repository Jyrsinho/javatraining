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

    public Kurssi(int id, String nimi, int periodi, int[] testiennakkotiedot) {
        this.ennakkotiedot = new ArrayList<>();
        this.id = id;
        this.nimi = nimi;
        this.periodi = periodi;
        for (int i = 0; i < testiennakkotiedot.length; i++) {
            this.ennakkotiedot.add(testiennakkotiedot[i]);
        }
    }

    public void setPeriodi(int periodi) {
        this.periodi = periodi;
    }

    public int getId() {
        return id;
    }

    public String getNimi() {
        return nimi;
    }

    public ArrayList<Integer> getEnnakkotiedot() {
        return ennakkotiedot;
    }

    public int getPeriodi() {
        return periodi;
    }

    public void tulosta() {
        System.out.printf("%d %s %d ", id, nimi, periodi);
        System.out.print("ennakkotiedot: ");
        for (int ennakkotieto: ennakkotiedot) {
            System.out.print(ennakkotieto + " ");
        }
        System.out.println();
    }
    //  Pitsinnypläys 4: 5 4 8 6 1 10
    //7 3 0

}
