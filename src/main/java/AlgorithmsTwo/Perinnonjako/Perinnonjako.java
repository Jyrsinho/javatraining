package AlgorithmsTwo.Perinnonjako;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Käsittelee yhden perinnönjaon kerrallaan
 */
public class Perinnonjako {
    private String input;
    private int perinnonMaara;
    private int vainajanID;
    private int valtionOsuus;
    private Perija vainaja;
    ArrayList<Perija> sukulaiset;
    ArrayList<Perija> perijat;

    public Perinnonjako() {

    }



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
     * Jos perittävällä on jälkeläisiä elossa, perintö jaetaan heille. Jokainen lapsi joka elää tai
     * jolla on elossa olevia jälkeläisiä saa yhtä suuren osan. Kuolleen lapsen osa jaetaan samalla tavalla
     * hänen jälkeläisilleen.
     */
    public void jaaPerinto() {
        ArrayList<Perija> elossaTaiPerillisia = vainaja.perivatJalkelaiset();
        // jos ei ole suoria jalkelaisia annetaan perinto vanhemmille
        if (elossaTaiPerillisia.isEmpty()) {
            jaaPerintoVanhemmille();
        } else {
            jaaPerintoALenevassaPolvessa(elossaTaiPerillisia);
        }
        // ollaan yritetty antaa perinto lapsille ja vanhemmille, mutta perijat lista on yhä tyhjä. Joten annetaan
        // perintö valtiolle
        if (perijat.isEmpty()){
            jaaPerintoValtiolle();
        }
    }


    private void jaaPerintoALenevassaPolvessa(ArrayList<Perija> elossaTaiPerillisia) {
        int perintoOsuus = perinnonMaara / elossaTaiPerillisia.size();

        for (Perija perija : elossaTaiPerillisia) {
            perinnonMaara = perija.peri(perinnonMaara, perijat, perintoOsuus);
        }
    }


    private void jaaPerintoVanhemmille() {
        ArrayList<Perija> vainajanVanhemmat = etsiVanhemmat(vainaja);
        ArrayList<Perija> validitPerijatVanhemmista = new ArrayList<>();

        for (Perija vanhempi: vainajanVanhemmat) {
            if (vanhempi.onValidiPerija()) {
                validitPerijatVanhemmista.add(vanhempi);
            }
        }

        if (!validitPerijatVanhemmista.isEmpty()) {
            int perintoOsuus = perinnonMaara / validitPerijatVanhemmista.size();
            for (Perija perija : vainajanVanhemmat) {
                perinnonMaara = perija.peri(perinnonMaara, perijat, perintoOsuus);
            }
        }

    }

    /**
     * Etsitaan henkilon vanhemmat. Jos vanhempia ei löydy, palautetaan -tyhja lista.
     * @param henkilo jonka vanhempia etsitaan
     */
    public ArrayList<Perija> etsiVanhemmat(Perija henkilo) {
        ArrayList<Perija> vanhemmat = new ArrayList<>();
        for (Perija ehdokas : sukulaiset) {
            if (ehdokas.getLapset().contains(henkilo)){
             vanhemmat.add(ehdokas);
            }
        }
        return vanhemmat;
    }


    private void jaaPerintoValtiolle() {
        valtionOsuus = perinnonMaara;
        perinnonMaara = 0;
    }

    /**
     * Parsii saamansa merkkijonon perinnön määrään, vainajaan ja jakoon osallistuviin henkilöihin
     */
    public void parsePerinnonJako() {
        Scanner scanner = new Scanner(input);
        parsePerinnonTiedot(scanner);
        parseSukulaistenTiedot(scanner);
    }


    public void parsePerinnonTiedot(Scanner scanner) {
        this.vainajanID = scanner.nextInt();
        this.perinnonMaara = scanner.nextInt();
    }


    public void parseSukulaistenTiedot(Scanner scanner) {
        boolean elossa = true;

        int sarakkeenNumero = 0;
        int id = 0;

        while (scanner.hasNext()) {
            String merkkijono = scanner.next();

            switch (sarakkeenNumero) {
                case 0:
                    id = Integer.parseInt(merkkijono);
                    if (id < 0) {
                        elossa = false;
                    }
                    sarakkeenNumero++;
                    break;
                case 1:
                    String nimi = merkkijono;
                    id = Math.abs(id);
                    if (id == vainajanID) {
                        this.vainaja = new Perija(nimi, false, id);
                        this.sukulaiset.add(this.vainaja);
                    } else {
                        Perija lisattavaHenkilo = new Perija(nimi, elossa, id);
                        this.sukulaiset.add(lisattavaHenkilo);
                    }
                    sarakkeenNumero++;
                    break;
                case 2:
                    int ensimmaisenVanhemmanId = Integer.parseInt(merkkijono);
                    lisaaVanhemmalleLapsi(ensimmaisenVanhemmanId, id);
                    sarakkeenNumero++;
                    break;
                case 3:
                    int toisenVanhemmanId = Integer.parseInt(merkkijono);
                    lisaaVanhemmalleLapsi(toisenVanhemmanId, id);
                    sarakkeenNumero = 0;
                    elossa = true;
                    break;

            }
        }
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


}
