package AlgorithmsTwo.Esitieto;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Stack;

import static AlgorithmsTwo.Esitieto.Util.laskeUusiperiodi;

public class KurssiLista {
    private ArrayList<Kurssi> kurssit;
    int V; // Solmujen maara
    boolean[] vierailtu;
    boolean[] rekursioPino;
    boolean onSilmukka;
    Stack<Kurssi> vastaus;
    Stack<Kurssi> silmukka;

    public KurssiLista() {
        kurssit = new ArrayList<>();
        vastaus = new Stack<>();
        silmukka = new Stack<>();
    }

    public void lisaaKurssi(Kurssi kurssi) {
        kurssit.add(kurssi);
    }

    public void analysoiKurssilista() {
        V = kurssit.size();
        onSilmukka = sisaltaaSilmukan();

       tulosta();
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
            if (!vierailtu[i] && jarjestaGraafiHelper(i) < 0) {
                return true;
            }
        }
       return false;
    }

    /**
     * Päivittää oman suoritusajankohtansa ennaakotietojensa mukaan ja palauttaa sitten oman suoritusaikansa
     * @param kurssiID kurssi jossa vieraillaan
     * @return vierailtavan kurssin suoritusajankohta
     */
    private int jarjestaGraafiHelper(int kurssiID) {
        Kurssi kurssi = kurssit.get(kurssiID);
        int myohaisinEsitieto = 0;

        //jos kurssissa on jo vierailtu palautetaan sen periodi.
        if (vierailtu[kurssiID]){
            System.out.printf("Palautetaan kurssin %d periodi", kurssiID);
            return kurssi.getPeriodi();
        }

        //jos kurssilla on vierailemattomia lapsia, vieraillaan niissa ja palautetaan niistä niiden periodit
        ArrayList<Integer> esitiedot = kurssi.getEnnakkotiedot();
        for (Integer esitieto: esitiedot) {
            // jos kurssin lapsi on jo rekursiopinossa, looppi on löytynyt palautetaan -1
            if (rekursioPino[esitieto]) {
                //silmukka.add(kurssi);
                return -1;
            }else {
                int esitiedonPeriodi = jarjestaGraafiHelper(esitieto);
                if (esitiedonPeriodi < 0) {
                    silmukka.add(kurssi);
                    return -1;
                }
                if (esitiedonPeriodi > myohaisinEsitieto) {
                    myohaisinEsitieto = esitiedonPeriodi;
                }
            }
        }

        // jos vieraillaan ensimmaista kertaa lasketaan kurssin periodi suhteessa kurssin lasten periodeihin
        int kurssinPeriodi = laskeUusiperiodi(myohaisinEsitieto, kurssi.getPeriodi());
        kurssi.setPeriodi(kurssinPeriodi);
        // merkataan kurssi vierailluksi ja rekursiopinoon
        vierailtu[kurssiID] = true;
        rekursioPino[kurssiID] = true;
        vastaus.push(kurssi);

        return kurssi.getPeriodi();
    }


    public ArrayList<Kurssi> getKurssit() {
        return kurssit;
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
        //Tulosta Silmukka voi tulostaa silmukan suoraan rekursiopinosta
        PrintStream out = System.out;
        out.println("Silmukka:");
        for (Kurssi kurssi: silmukka) {
            kurssi.tulosta();
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

        for (Kurssi kurssi: vastaus) {
            if (kurssi.getNimi() != "dummy") {
                kurssi.tulostaKaikki();
            }
        }
    }

}
