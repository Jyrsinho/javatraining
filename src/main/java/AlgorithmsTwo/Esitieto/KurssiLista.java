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
}
