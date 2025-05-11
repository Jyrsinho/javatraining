package AlgorithmsTwo.Esitieto;

import java.io.PrintStream;
import java.util.ArrayList;

public class KurssiLista {
    private ArrayList<Kurssi> kurssit;
    boolean[] vierailtu;
    boolean[] rekursioPino;
    boolean onSilmukka;
    int[] suoritusJarjestys;

    public KurssiLista() {
        kurssit = new ArrayList<>();
    }

    public void lisaaKurssi(Kurssi kurssi) {
        kurssit.add(kurssi);
    }

    public void analysoiKurssilista() {
        onSilmukka = etsiSilmukka();
        if (!onSilmukka) {
            jarjestaKurssit();
        }
    }

    private boolean etsiSilmukka() {
        vierailtu = new boolean[kurssit.size()];

        for (Kurssi kurssi: kurssit) {
                rekursioPino = new boolean[kurssit.size()];
                if (!dfs(kurssi)) {
                    continue;
                } else {
                    return true;
                }
        }
       return false;
    }

    public void jarjestaKurssit() {
        vierailtu = new boolean[kurssit.size()];
        suoritusJarjestys = new int[kurssit.size()];

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
            tulostaSilmukka();
        } else {
            tulostaSuoritusAjankohdat();
        }
    }

    private void tulostaSilmukka() {
        PrintStream out = System.out;
        out.println("Silmukka:");
        for (int i = 1; i <rekursioPino.length ; i++) {
           if (rekursioPino[i] ) {
               Kurssi tulostettava = kurssit.get(i);
               out.printf(("%d %s"), tulostettava.getId(), tulostettava.getNimi());
               out.println();
           }
        }
    }

    public boolean onSilmukka() {
        return onSilmukka;
    }

    private void tulostaSuoritusAjankohdat() {
        PrintStream out = System.out;
        out.println("SuoritusAjankohdat");
    }
}
