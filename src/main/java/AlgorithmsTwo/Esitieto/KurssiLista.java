package AlgorithmsTwo.Esitieto;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class KurssiLista {
    private ArrayList<Kurssi> kurssit;
    int V; // Solmujen maara
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
        V = kurssit.size();
        onSilmukka = etsiSilmukka();
        if (!onSilmukka) {
            jarjestaKurssit();
        }
    }

    private boolean etsiSilmukka() {
        vierailtu = new boolean[V];

        for (Kurssi kurssi: kurssit) {
                rekursioPino = new boolean[V];
                if (!dfs(kurssi)) {
                    continue;
                } else {
                    return true;
                }
        }
       return false;
    }

    public void jarjestaKurssit() {
        vierailtu = new boolean[V];
        suoritusJarjestys = new LinkedList<>();

        for (Kurssi kurssi: kurssit) {
            if (!vierailtu[kurssi.getId()]) {
                    dfsjarjestys(kurssi);
            }
        }

    }

    private void dfsjarjestys(Kurssi kurssi) {
        Kurssi aikaisinEiVierailtu = etsiAikaisinEiVierailtu(kurssi.getEnnakkotiedot());
        while (aikaisinEiVierailtu != null) {
            dfsjarjestys(aikaisinEiVierailtu);
            aikaisinEiVierailtu = etsiAikaisinEiVierailtu(kurssi.getEnnakkotiedot());
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


    private Kurssi etsiAikaisinEiVierailtu(ArrayList<Integer> ennakkotiedot) {
       Kurssi aikaisin = null;

       for (int ennakkotieto: ennakkotiedot) {
           if (!vierailtu[ennakkotieto]) {
               if (aikaisin == null) {
                   aikaisin = kurssit.get(ennakkotieto);
               } if (aikaisin.getPeriodi() > kurssit.get(ennakkotieto).getPeriodi()){
                    aikaisin = kurssit.get(ennakkotieto);
               }
           }
       }

       return aikaisin;
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
     * Palautetaan kurssien suoritusjarjestys. Poistetaan 0-indeksin dummyKurssi
     * @return {int[]}
     */
    public int[] getSuoritusJarjestys() {
        int[] jarjestys = new int[V - 1];
        //poistetaan dummy
        suoritusJarjestys.poll();
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
