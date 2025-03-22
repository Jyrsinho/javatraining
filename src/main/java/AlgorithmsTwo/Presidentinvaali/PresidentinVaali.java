package AlgorithmsTwo.Presidentinvaali;

import java.util.ArrayList;
import java.util.Scanner;

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
public class PresidentinVaali {



    private String input;
    private int kokonaisAaniMaara;
    private ArrayList<Ehdokas> tulosLista;


    public PresidentinVaali(){
    }

    public PresidentinVaali(String input) {
        this.input = input;
        kokonaisAaniMaara = 0;
        tulosLista = new ArrayList<>();
    }


    public void suoritaPresidentinVaali(){
        suoritaAantenLaskenta();
        Ehdokas ensimmaisenKierroksenVoittaja = ensimmaisenKierroksenVoittaja();
        if (!ensimmaisenKierroksenVoittaja.getClass().getSimpleName().equals("ErikoisEhdokas")) {
            System.out.println("Onnea presidentti " +ensimmaisenKierroksenVoittaja.nimi + "!");
        }else {
            ArrayList<Ehdokas> toiselleKierrokselleMenijat = toiselleKierrokselleMenijat();
            System.out.println("Toiselle kierrokselle:");
            for (Ehdokas ehdokas: toiselleKierrokselleMenijat) {
                System.out.println(ehdokas.nimi);
            }
        }
    }


    /**
     * Tekee vaalituloksesta olioita ja tallentaa ne ehdokastaulukkoon
     */
    public ArrayList<Ehdokas> suoritaAantenLaskenta() {
        Scanner sc = new Scanner(input);
        while (sc.hasNextLine()) {
            String ehdokasJaTulos = sc.nextLine();
            Ehdokas ehdokas = luoEhdokasMerkkijonosta(ehdokasJaTulos);
            tulosLista.add(ehdokas);
        }

        return tulosLista;
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
        return new Ehdokas(ehdokkaanNimi, ehdokkaanAanimaara);

    }

    /**
     * Jos vaaliin osallistunut ehdokas on saanut yli 50 prosenttia aanista, palautetaan kyseinen ehdokas.
     * Muuten palautetaan
     * @return
     */
    public Ehdokas ensimmaisenKierroksenVoittaja() {
        //TODO
        for (Ehdokas ehdokas: tulosLista){
            if ((double)ehdokas.aanimaara / (double)kokonaisAaniMaara > 0.5){
                return ehdokas;
            }
        }
        return new ErikoisEhdokas("Ei suoraa voittajaa",0, "Ei suoraa voittajaa");
    }

    /**
     * Hakee vaalituloksesta toiselle kierrokselle menijat Ehdokas pääsee toiselle kierrokselle
     * jos ja vain jos korkeintaan yksi ehdokas sai enemmän ääniä kuin hän.
     * @return ArrayList toiselle kierrokselle menevat ehdokkaat
     */
    public ArrayList<Ehdokas> toiselleKierrokselleMenijat() {
        ArrayList<Ehdokas> toiselleKierrokselleMenijat = new ArrayList<>();

        int enemmanAaniaSaaneita = 0;

        for (int i = 0; i < tulosLista.size(); i++) {
            Ehdokas ehdokas = tulosLista.get(i);
            for (int j = 0; j < tulosLista.size(); j++) {
                Ehdokas verrattavaEhdokas = tulosLista.get(j);
                if (verrattavaEhdokas.aanimaara > ehdokas.aanimaara) {
                    enemmanAaniaSaaneita++;
                }
            }
            if (enemmanAaniaSaaneita <= 1){
                toiselleKierrokselleMenijat.add(ehdokas);
            }
            enemmanAaniaSaaneita = 0;
        }
        return toiselleKierrokselleMenijat;
    }

    public void paivitaEhdokkaanAanimaaraKokonaisAaniMaaraan(int ehdokkaanAanimaara) {
        kokonaisAaniMaara += ehdokkaanAanimaara;
    }


    public int getKokonaisAaniMaara() {
        return kokonaisAaniMaara;
    }


    public static void main(String[] args) {

        Scanner syote = new Scanner(System.in);
        StringBuilder tulosSyote = new StringBuilder();

        while (syote.hasNextLine()) {
            String line = syote.nextLine();
            if (line.isEmpty()) {
                break;
            }
            tulosSyote.append(line).append("\n");
        }

        PresidentinVaali presidentinVaali = new PresidentinVaali(tulosSyote.toString().trim());
        presidentinVaali.suoritaPresidentinVaali();

        syote.close();
    }
}

