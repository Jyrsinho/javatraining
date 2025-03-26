package AlgorithmsTwo.Perinnonjako;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Käsittelee yhden perinnönjaon kerrallaan
 */
public class Perinnonjako {
    private final String input;
    private int perinnonMaara;
    private int vainajanID;
    private int valtionOsuus;
    private Perija vainaja;
    ArrayList<Perija> sukulaiset;
    ArrayList<Perija> perijat;



    public Perinnonjako(String input) {
        this.input = input;
        this.sukulaiset = new ArrayList<>();
        this.valtionOsuus = 0;
        this.perijat = new ArrayList<>();
    }


    public void suoritaPerinnonjako() {
        parsePerinnonJako();
        jaaPerinto();
    }


    /**
     * Parsii saamansa merkkijonon perinnön määrään, vainajaan ja jakoon osallistuviin henkilöihin
     */
    public void parsePerinnonJako() {
        Scanner scanner = new Scanner(input);
        parsePerinnonTiedot(scanner);
        parseSukulaistenTiedot(scanner);
    }

    /**
     * Jos perittävällä on jälkeläisiä elossa, perintö jaetaan heille. Jokainen lapsi joka elää tai
     * jolla on elossa olevia jälkeläisiä saa yhtä suuren osan. Kuolleen lapsen osa jaetaan samalla tavalla
     * hänen jälkeläisilleen.
     */
    public void jaaPerinto() {
        /*ArrayList<Perija> laillisetPerijat = vainaja.laillisetPerijat();

        if (laillisetPerijat.isEmpty()) {
            valtionOsuus = perinnonMaara;
            perinnonMaara = 0;
        }

        int perintoOsuus = perinnonMaara / laillisetPerijat.size();

        for (Perija lapsi: laillisetPerijat){
            lapsi.peri(perintoOsuus);
            perinnonMaara -= perintoOsuus;
        }

         */

    }


    public void parsePerinnonTiedot(Scanner scanner) {
        this.vainajanID = scanner.nextInt();
        this.perinnonMaara = scanner.nextInt();
    }


    public void parseSukulaistenTiedot(Scanner scanner) {

        while (scanner.hasNext()) {
            boolean elossa = true;
            int id = scanner.nextInt();
            if (id < 0) {
                elossa = false;
            }
            String nimi = scanner.next();
            id = Math.abs(id);

            if (id == vainajanID) {
                this.vainaja = new Perija(nimi, elossa, id);
                this.sukulaiset.add(this.vainaja);
            } else {
                Perija lisattavaHenkilo = new Perija(nimi, elossa, id);
                this.sukulaiset.add(lisattavaHenkilo);
            }

            int ensimmaisenVanhemmanId = scanner.nextInt();
            lisaaVanhemmalleLapsi(ensimmaisenVanhemmanId, id);
            int toisenVanhemmanId = scanner.nextInt();
            lisaaVanhemmalleLapsi(toisenVanhemmanId, id);
        }
        scanner.close();
    }


    public void lisaaVanhemmalleLapsi(int vanhemmanId, int lapsenId) {
        Perija vanhempi = etsiHenkiloIdPerusteella(vanhemmanId);
        Perija lapsi = etsiHenkiloIdPerusteella(lapsenId);
        if (!vanhempi.getClass().getSimpleName().equals("HenkiloEiOlemassa")) {
            vanhempi.lisaaLapsi(lapsi);
        }
    }


    public Perija etsiHenkiloIdPerusteella(int id) {
        for (Perija h : sukulaiset) {
            if (h.getId() == id) {
                return h;
            }
        }
        return new HenkiloEiOlemassa("Ei olemassa", false, -1);
    }


    public Perija getVainaja() {
        return vainaja;
    }


    public ArrayList<Perija> getSukulaiset() {
        return sukulaiset;
    }

    public int getPerinnonMaara() {
        return perinnonMaara;
    }

    public int getVainajanID() {
        return vainajanID;
    }


    public int getValtionOsuus() {
        return valtionOsuus;
    }

    public ArrayList<Perija> getPerijat() {
        return perijat;
    }


    public static void main(String[] args) {

}


}
