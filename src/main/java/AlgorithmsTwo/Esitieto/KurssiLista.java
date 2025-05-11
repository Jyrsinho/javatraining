package AlgorithmsTwo.Esitieto;

import java.util.ArrayList;

public class KurssiLista {
    private ArrayList<Kurssi> kurssit;
    boolean[] vierailtu;
    boolean[] rekursioPino;
    boolean onSilmukka;

    public KurssiLista() {
        kurssit = new ArrayList<>();
    }

    public void lisaaKurssi(Kurssi kurssi) {
        kurssit.add(kurssi);
    }

    public boolean onSilmukka() {
        vierailtu = new boolean[kurssit.size()];

        for (Kurssi kurssi: kurssit) {
                rekursioPino = new boolean[kurssit.size()];
                if (!dfs(kurssi)) {
                    continue;
                } else {
                    onSilmukka = true;
                    return true;
                }
        }
        onSilmukka = false;
       return false;
    }

    private boolean dfs(Kurssi kurssi) {
        vierailtu[kurssi.getId()] = true;
        rekursioPino[kurssi.getId()] = true;

        for (int ennakkotieto: kurssi.getEnnakkotiedot()) {
            if (rekursioPino[ennakkotieto]){
                return true;
            }
            if (!vierailtu[ennakkotieto]) {
               return dfs(kurssit.get(ennakkotieto));
            }
        }
        return false;
    }


    public ArrayList<Kurssi> getKurssit() {
        return kurssit;
    }

    public void tulosta() {
       if (onSilmukka) {
           for (int i = 1; i < rekursioPino.length; i++) {
              if (rekursioPino[i]) {
                  Kurssi tulostettava = kurssit.get(i);
                  tulostettava.tulosta();
              }
           }
       }
    }
}
