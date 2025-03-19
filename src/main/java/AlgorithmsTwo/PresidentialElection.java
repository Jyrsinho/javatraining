package AlgorithmsTwo;

import java.util.ArrayList;
import java.util.Scanner;

public class PresidentialElection {

    private String input;
    private int kokonaisAaniMaara;


    public PresidentialElection(){
    }

    public PresidentialElection(String input) {
        this.input = input;
        kokonaisAaniMaara = 0;
    }


    /**
     * Jos joku ehdokas saa enemmän kuin puolet kaikista äänistä, tulee ohjelman
     * tulostaa ”Onnea presidentti nimi!”. Moniosaisen nimen osien väliin pitää tulostaa
     * täsmälleen yksi välilyönti. Yllä olevalla syötteellä ohjelman pitää tulostaa
     * Onnea presidentti Kaisa Kansansuosikki!
     * Muussa tapauksessa ohjelman tulee tulostaa ensin rivi ”Toiselle kierroksel-
     * le:” ja sen jälkeen jokaisesta toiselle kierrokselle päässeestä rivi, jossa on hänen
     * nimensä eikä mitään muuta. Toiselle kierrokselle päässeet tulee tulostaa siinä jär-
     * jestyksessä, kuin he esiintyivät syötteessä. Ehdokas pääsee toiselle kierrokselle
     * jos ja vain jos korkeintaan yksi ehdokas sai enemmän ääniä kuin hän.
     */
    public void suoritaAantenLaskenta() {
        ArrayList<Ehdokas> tulos = parseTulos();
        Ehdokas suoraVoittaja = selvitaOnkoSuoraVoittaja();
        if (suoraVoittaja != null) {
                System.out.println("Onneksi olkoon " + suoraVoittaja.nimi);
        } else {
            ArrayList<Ehdokas> toiselleKierrokselleMenijat = selvitaToiselleKierrokselleMenijat();
            tulostaToiselleKierrokselleMenijat();
        }
    }


    /**
     * Tekee vaalituloksesta olioita ja tallentaa ne ehdokastaulukkoon
     */
    public ArrayList<Ehdokas> parseTulos() {
        ArrayList<Ehdokas> tulos = new ArrayList<>();

        Scanner sc = new Scanner(input);
        while (sc.hasNextLine()) {
            String ehdokasJaTulos = sc.nextLine();
            Ehdokas ehdokas = luoEhdokasMerkkijonosta(ehdokasJaTulos);
            tulos.add(ehdokas);
        }

        return tulos;
    }

    /**
     * Luo annetusta merkkijonosta Ehdokas olion
     * @param line merkkijono
     * @return Ehdokas
     */
    public Ehdokas luoEhdokasMerkkijonosta(String line) {
        Scanner scanner = new Scanner(line);
        int ehdokkaanAanimaara = scanner.nextInt();
        paivitaEhdokkaanAanimaaraKokonaisAaniMaaraan(ehdokkaanAanimaara);

        StringBuilder sb = new StringBuilder();
        while(scanner.hasNext()){
            sb.append(scanner.next());
            sb.append(" ");
        }

        String ehdokkaanNimi = sb.toString().trim();
        Ehdokas ehdokas = new Ehdokas(ehdokkaanNimi, ehdokkaanAanimaara);

        return ehdokas;
    }

    public Ehdokas selvitaOnkoSuoraVoittaja () {
        //TODO
        return null;
    }

    public ArrayList<Ehdokas> selvitaToiselleKierrokselleMenijat() {
        return null;
    }

    public void tulostaToiselleKierrokselleMenijat() {
        //TODO
        System.out.println(" ");
    }




    public void paivitaEhdokkaanAanimaaraKokonaisAaniMaaraan(int ehdokkaanAanimaara) {
        kokonaisAaniMaara += ehdokkaanAanimaara;
    }

    public int getKokonaisAaniMaara() {
        return kokonaisAaniMaara;
    }

}

