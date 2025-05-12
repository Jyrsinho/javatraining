package AlgorithmsTwo.Esitieto;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedList;

import static AlgorithmsTwo.Esitieto.Util.laskeUusiperiodi;

public class KurssiLista {
    private ArrayList<Kurssi> kurssit;
    int V; // Solmujen maara
    boolean[] vierailtu;
    boolean[] rekursioPino;
    boolean onSilmukka;
    LinkedList<Integer> sykli;

    public KurssiLista() {
        kurssit = new ArrayList<>();
    }

    public void lisaaKurssi(Kurssi kurssi) {
        kurssit.add(kurssi);
    }

    public void analysoiKurssilista() {
        V = kurssit.size();
        onSilmukka = sisaltaaSilmukan();
        if (onSilmukka) {
            jarjestaSilmukka();
        }
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
        System.out.println("Vieraillaan Nodessa: " + kurssiID);
        if (rekursioPino[kurssiID]) {
            System.out.println("Node " +kurssiID + " oli rekursiopinossa -> sykli havaittu");
            sykli = new LinkedList<>();
            sykli.add(kurssiID);
            return true;
        }
        // Nykyinen node jo vierailtu eika restackissa -> ei osa sykliä -> ei tarvitse enaa vierailla
        if (vierailtu[kurssiID]) {
            System.out.println("Nodessa on jo vierailtu, palautetaan false");
            return false;
        }
        // Jos vieraillaan nodessa ekaa kertaa, merkataan se vierailluksi ja osaksi stakkiä
        System.out.println("Vieraillaan ekaa kertaa, merkataan rekursiopinoon ja vierailluksi");
        vierailtu[kurssiID]= true;
        System.out.println("Vierailtu- listan tila : ");
        for (int i = 0; i < vierailtu.length; i++) {
           System.out.print(i + ": " + vierailtu[i] + " ") ;
        }
        System.out.println();
        rekursioPino[kurssiID] = true;
        System.out.println("Rekursiopinon tila:");
        for (int i = 0; i < rekursioPino.length; i++) {
            System.out.print(i + ": " + rekursioPino[i] + " ") ;
        }
        System.out.println();

        // Kaydaan rekursiivisesti kaikissa nykyisen noden esitiedoissa jos ne sisaltavat syklin niin palautetaan true
        ArrayList<Integer> ennakkotiedot = kurssit.get(kurssiID).getEnnakkotiedot();
        for (int ennakkotieto : ennakkotiedot){
            System.out.println("Seuraavaksi kurssin: " +kurssiID +" ennakkotieto: " + ennakkotieto);
            if (sisaltaaSilmukanHelper(ennakkotieto)) {
                System.out.println("Sykli löytyi: " +kurssiID +" ->");
                sykli.add(kurssiID);
                return true;
            }
        }

        //Jos syklia ei ole loytynyt niin mennaan takaisin (backtrack) edelliseen nodeen kuitataan etta tasta nodesta
        // ei loytynyt syklia ja poistetaan tama node rekursiopinosta
        System.out.println("Kurssin " +kurssiID +" lapsista ei löytynyt sykliä - palataan... poistetaan kurssi: " + kurssiID + " rekursiopinosta");
        rekursioPino[kurssiID] = false;
        System.out.println("Rekursiopinossa nyt poiston jalkeen");
        for (int i = 0; i < rekursioPino.length; i++) {
            System.out.print(i + ": " + rekursioPino[i] + " ") ;
        }
        System.out.println();
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

    private void jarjestaSilmukka() {
        //eli syklin eka on syklin loppu loppu on FIFO:n alussa
        //otetaan ensin pää talteen
        // käännetään lista
        // poistetaan niin kauan kunnes tulee päätä vastaava arvo vastaan
        int syklinAlkuJaLoppu = sykli.poll();

        sykli = sykli.reversed();

        while (!sykli.isEmpty() && sykli.peek() != syklinAlkuJaLoppu) {
            sykli.poll();
        }
    }
//
    public void tulosta() {
        if (onSilmukka) {
            tulostaSilmukka();
        } else {
            tulostaSuoritusAjankohdat();
        }
    }

    public void tulostaEnnakkotiedoilla() {
        for (Kurssi kurssi: kurssit) {
            kurssi.tulostaKaikki();
        }
    }

    private void tulostaSilmukka() {
        PrintStream out = System.out;
        out.println("Silmukka:");
        while (!sykli.isEmpty()) {
            int kurssiId = sykli.poll();
            Kurssi kurssi = kurssit.get(kurssiId);
            System.out.printf("%d %s", kurssi.getId(), kurssi.getNimi());
            System.out.println();
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
        out.println("Suoritusajankohdat:");
        for (Kurssi kurssi: kurssit) {
            kurssi.tulosta();
        }
    }

}
