package AlgorithmsTwo.Esitieto;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class KurssiLista {
    private ArrayList<Kurssi> kurssit;
    boolean[] vierailtu;
    boolean[] rekursioPino;
    boolean onSilmukka;
    Queue<Integer> suoritusJarjestys;

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
        suoritusJarjestys = new LinkedList<>();

        for (Kurssi kurssi: kurssit) {
            dfsjarjestys(kurssi);
        }

    }

    private void dfsjarjestys(Kurssi kurssi) {
        for (int ennakkotieto: kurssi.getEnnakkotiedot()) {
            if (!vierailtu[ennakkotieto]) {
                dfsjarjestys(kurssit.get(ennakkotieto));
            }
        }
        vierailtu[kurssi.getId()] = true;
        suoritusJarjestys.add(kurssi.getId());
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

    /**
     * Palautetaan kurssien suoritusjarjestys.
     * @return {int[]}
     */
    public int[] getSuoritusJarjestys() {
        int[] jarjestys = new int[kurssit.size()];

        int index = 0;
        while (!suoritusJarjestys.isEmpty()) {
           jarjestys[index] = suoritusJarjestys.poll();
            index++;
        }
        return jarjestys;
    }

    private void tulostaSuoritusAjankohdat() {
        PrintStream out = System.out;
        out.println("SuoritusAjankohdat");
    }
}
