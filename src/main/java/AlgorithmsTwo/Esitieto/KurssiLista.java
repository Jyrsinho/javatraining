package AlgorithmsTwo.Esitieto;

import java.util.ArrayList;

public class KurssiLista {
    private ArrayList<Kurssi> kurssit;
    boolean[] vierailtu;
    boolean[] rekursioPino;

    public KurssiLista() {
        kurssit = new ArrayList<>();
    }

    public void lisaaKurssi(Kurssi kurssi) {
        kurssit.add(kurssi);
    }

    public boolean onSilmukka() {
        vierailtu = new boolean[kurssit.size() + 1];

        for (Kurssi kurssi: kurssit) {
                rekursioPino = new boolean[kurssit.size() +1];
                if (!dfs(kurssi)) {
                    continue;
                } else {
                    return true;
                }
        }

       return false;
    }

    private boolean dfs(Kurssi kurssi) {
        vierailtu[kurssi.getId()] = true;
        rekursioPino[kurssi.getId()] = true;

        for (int ennakkotieto: kurssi.getEnnakkotiedot()) {
            if (rekursioPino[ennakkotieto] == true){
                return true;
            }
            if (!vierailtu[ennakkotieto]) {
                dfs(kurssit.get(ennakkotieto));
            }
        }
        return false;
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
