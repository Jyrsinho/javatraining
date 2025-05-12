package AlgorithmsTwo.Esitieto;

import java.io.PrintStream;
import java.util.ArrayList;

import static AlgorithmsTwo.Esitieto.Util.laskeUusiperiodi;

public class KurssiLista {
    private ArrayList<Kurssi> kurssit;
    int V; // Solmujen maara
    boolean[] vierailtu;
    boolean[] rekursioPino;
    boolean onSilmukka;

    public KurssiLista() {
        kurssit = new ArrayList<>();
    }

    public void lisaaKurssi(Kurssi kurssi) {
        kurssit.add(kurssi);
    }

    public void analysoiKurssilista() {
        V = kurssit.size();
        onSilmukka = sisaltaaSilmukan();
        if (!onSilmukka) {
            jarjestaKurssit();
        }
    }

    /**
     * Kaydaan jokainen graafin node lapi ja kutsutaan niille rekursiivista metodia, joka
     * tarkistaa onko kyseinen node osa syklia
     * @return true jos graafi sisaltaa silmukan, false jos ei
     */
    private boolean sisaltaaSilmukan() {
        vierailtu = new boolean[V];
        rekursioPino = new boolean[V];

        for (int i = 0; i < kurssit.size(); i++) {
            if (!vierailtu[i] && sisaltaaSilmukanHelper(i)) {
                return true;
            }
        }
       return false;
    }

    private boolean sisaltaaSilmukanHelper(int kurssiID) {
        // Nykyinen node on jo rekursiossa -> cykli havaittu -> lopetetaan dfs
        if (rekursioPino[kurssiID]) {
            return true;
        }
        // Nykyinen node jo vierailtu eika restackissa -> ei osa sykliä -> ei tarvitse enaa vierailla
        if (vierailtu[kurssiID]) {
            return false;
        }
        // Jos vieraillaan nodessa ekaa kertaa, merkataan se vierailluksi ja osaksi stakkiä
        vierailtu[kurssiID]= true;
        rekursioPino[kurssiID] = true;

        // Kaydaan rekursiivisesti kaikissa nykyisen noden esitiedoissa jos ne sisaltavat syklin niin palautetaan true
        ArrayList<Integer> ennakkotiedot = kurssit.get(kurssiID).getEnnakkotiedot();
        for (int ennakkotieto : ennakkotiedot){
            if (sisaltaaSilmukanHelper(ennakkotieto)) {
                return true;
            }
        }

        //Jos syklia ei ole loytynyt niin mennaan takaisin (backtrack) edelliseen nodeen kuitataan etta tasta nodesta
        // ei loytynyt syklia ja poistetaan tama node rekursiopinosta
        rekursioPino[kurssiID] = false;
        return false;
    }

    public void jarjestaKurssit() {
        vierailtu = new boolean[V];

        for (Kurssi kurssi: kurssit) {
            if (!vierailtu[kurssi.getId()]) {
                    dfsjarjestys(kurssi);
            }
        }

        //poistetaan dummy taalla, koska taman jalkeen sita ei enaa tarvita
        // jarjestetaan kurssit myos periodinsa mukaan taalla
        kurssit.removeFirst();
        kurssit.sort(Kurssi::compareTo);
    }

    private void dfsjarjestys(Kurssi kurssi) {
        Kurssi aikaisinEiVierailtu = etsiAikaisinEiVierailtu(kurssi.getEnnakkotiedot());
        while (aikaisinEiVierailtu != null) {
            dfsjarjestys(aikaisinEiVierailtu);
            aikaisinEiVierailtu = etsiAikaisinEiVierailtu(kurssi.getEnnakkotiedot());
        }

        vierailtu[kurssi.getId()] = true;
        // päivitetään kurssille periodi suhteessa sen vanhempiin
        paivitaPeriodi(kurssi);

    }


    private boolean dfs(Kurssi kurssi) {
        vierailtu[kurssi.getId()] = true;
        rekursioPino[kurssi.getId()] = true;

        for (int ennakkotieto: kurssi.getEnnakkotiedot()) {
            if (rekursioPino[ennakkotieto]){
                return true;
            }
            if (!vierailtu[ennakkotieto]) {
               dfs(kurssit.get(ennakkotieto));
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

    /**
     * Annetaan kurssille suoritusperiodi suhteessa sen esitietokursseihin.
     * @param kurssi
     */
    private void paivitaPeriodi(Kurssi kurssi) {
        int esitietojenMyohaisinPeriodi = etsiEnnakkotietojenMyohaisinPeriodi(kurssi.getEnnakkotiedot());
        int uusiperiodi = laskeUusiperiodi(esitietojenMyohaisinPeriodi, kurssi.getPeriodi());

        kurssi.setPeriodi(uusiperiodi);
    }

    private int etsiEnnakkotietojenMyohaisinPeriodi(ArrayList<Integer> ennakkotiedot) {
        int myohaisin = 0;
        for (int ennakkotieto: ennakkotiedot) {
            Kurssi ennakkotietoKurssi = kurssit.get(ennakkotieto);
            if (ennakkotietoKurssi.getPeriodi() > myohaisin) {
                myohaisin = ennakkotietoKurssi.getPeriodi();
            }
        }
        return myohaisin;
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

        // Tämä on nyt ihan puhtaasti testaamista varten taalla
        for (int i = 0; i < kurssit.size(); i++) {
           jarjestys[i] = kurssit.get(i).getId();
        }
        return jarjestys;
    }

    private void tulostaSuoritusAjankohdat() {

        PrintStream out = System.out;
        out.println("SuoritusAjankohdat:");
        for (Kurssi kurssi: kurssit) {
            kurssi.tulosta();
        }

    }
}
