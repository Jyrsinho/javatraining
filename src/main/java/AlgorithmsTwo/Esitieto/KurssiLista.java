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

        // aloitetaan ykkosesta koska 0 indeksissa on dummy
        for (int i = 1; i < kurssit.size(); i++) {
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

        // lisätään kurssi rekursiopinoon
        rekursioPino[kurssiID] = true;

        //jos kurssilla on vierailemattomia lapsia, vieraillaan niissa ja palautetaan niistä niiden periodit
        ArrayList<Integer> esitiedot = kurssi.getEnnakkotiedot();
        for (Integer esitieto: esitiedot) {
            // jos kurssin lapsi on jo rekursiopinossa, looppi on löytynyt palautetaan -1
            if (rekursioPino[esitieto]) {
                //silmukka.add(kurssi);
                return -1;
            }else if (!vierailtu[esitieto]) {
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
        vastaus.push(kurssi);
        // Backtrack: palautetaan kurssin periodi ja poistetaan kurssi rekursiopinosta
        rekursioPino[kurssiID] = false;
        return kurssi.getPeriodi();
    }


    public ArrayList<Kurssi> getKurssit() {
        return kurssit;
    }


    public int[] getSuoritusJarjestys() {
        int [] suoritusJarjestys = new int[V - 1];
        int index = 0;

        for (Kurssi kurssi: vastaus) {
            suoritusJarjestys[index] = kurssi.getId();
            index++;
        }

        return suoritusJarjestys;
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



    private void tulostaSuoritusAjankohdat() {

        PrintStream out = System.out;
        out.println("Suoritusajankohdat:");

        for (Kurssi kurssi: vastaus) {
                kurssi.tulostaKaikki();
        }
    }

}
