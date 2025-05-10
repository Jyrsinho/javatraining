package AlgorithmsTwo.Esitieto;

import java.util.ArrayList;

public class KurssiLista {
    private ArrayList<Kurssi> kurssit;

    public KurssiLista() {
        kurssit = new ArrayList<>();
    }

    public void lisaaKurssi(Kurssi kurssi) {
        kurssit.add(kurssi);
    }

    public ArrayList<Kurssi> getKurssit() {
        return kurssit;
    }

    public void tulostaKurssit() {
        for (Kurssi kurssi : kurssit) {
            kurssi.tulosta();
            System.out.println();
        }
    }
}
