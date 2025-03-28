package AlgorithmsTwo.Perinnonjako;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class PerintojenJakaja {

    String input;
    ArrayList<Perinnonjako> perinnonjaot;

    public PerintojenJakaja(String input) {
        this.input = input;
        perinnonjaot = new ArrayList<>();
    }

    /**
     * Pilkkoo syotteen eri perinnonjakokokonaisuuksiksi ja luo Perinnonjako luokan olion käsittelemään
     * kunkin perinnonjaon omana kokonaisuutenaan.
     * Perinnonjakotehtava loppuu kahteen nollaan
     * Syote loppuu kahteen nollaan
     */
    public void jaaPerinnot() {
        SyotteenAnalysoija syotteenAnalysoija = new SyotteenAnalysoija();
        ArrayList<String> perinnonjakoSyotteet = syotteenAnalysoija.annaPerinnonjakoSyotteet(input);
        luoPerinnonJaot(perinnonjakoSyotteet);
        suoritaPerinnonJaot();
        tulostaPerinnonJaot();

    }


    public void luoPerinnonJaot(ArrayList<String> perinnonjakoSyotteet) {
        for (String perinnonjakoSyote: perinnonjakoSyotteet) {
            perinnonjaot.add(new Perinnonjako(perinnonjakoSyote));
        }
    }



    private void suoritaPerinnonJaot() {
        for (Perinnonjako perinnonjako: perinnonjaot) {
            perinnonjako.suoritaPerinnonjako();
        }
    }

    private void tulostaPerinnonJaot() {

        for (Perinnonjako perinnonjako : perinnonjaot) {
            // lajitellaan jokaisen perinnonjaon perijalista numerojarjestykseen ID:n perusteella
            Collections.sort(perinnonjako.perijat, Comparator.comparingInt(p -> p.getId()));
        }

        for (Perinnonjako perinnonjako : perinnonjaot) {
            for (Perija perija: perinnonjako.perijat) {
                System.out.println(perija.getNimi() + " saa " + perija.getPerintoaSaatu());
            }
            if (perinnonjako.getValtionOsuus()>0) {
                System.out.println("Valtio saa " + perinnonjako.getValtionOsuus());
            }
            System.out.println("Jakamatta jää " + perinnonjako.getPerinnonMaara());
        }
    }

    /**
     * Palauttaa true jos annetun merkkijonon voi parsia kokonaisluvuksi
     */
    private boolean onKokonaisLuku(String merkkijono) {
     try {
        Integer.parseInt(merkkijono);
        return true;
     } catch (NumberFormatException e) {
        return false;
     }
    }

    public ArrayList<Perinnonjako> getPerinnonjaot() {
        return perinnonjaot;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder syote = new StringBuilder();

        String testString = """
                4 7825349
                1 Klaara 0 0
                2 Vihtori 0 0
                3 Amalia 0 2
                -4 Bernard 2 1
                5 Cecilia 1 2
                -6 Erika 0 0
                7 Ferdinand 6 0
                8 Daniel 0 1
                0
                4 7825349
                -1 Klaara 0 0
                2 Vihtori 0 0
                3 Amalia 0 2
                -4 Bernard 2 1
                5 Cecilia 1 2
                -6 Erika 0 0
                7 Ferdinand 6 0
                8 Daniel 0 1
                0
                4 7825349
                1 Klaara 0 0
                -2 Vihtori 0 0
                3 Amalia 0 2
                -4 Bernard 2 1
                5 Cecilia 1 2
                -6 Erika 0 0
                7 Ferdinand 6 0
                8 Daniel 0 1
                0
                4 7825349
                -1 Klaara 0 0
                -2 Vihtori 0 0
                3 Amalia 0 2
                -4 Bernard 2 1
                5 Cecilia 1 2
                -6 Erika 0 0
                7 Ferdinand 6 0
                8 Daniel 0 1
                0
                4 7825349
                1 Klaara 0 0
                2 Vihtori 0 0
                -3 Amalia 0 2
                -4 Bernard 2 1
                5 Cecilia 1 2
                -6 Erika 0 0
                7 Ferdinand 6 0
                8 Daniel 0 1
                0
                4 7825349
                -1 Klaara 0 0
                2 Vihtori 0 0
                -3 Amalia 0 2
                -4 Bernard 2 1
                5 Cecilia 1 2
                -6 Erika 0 0
                7 Ferdinand 6 0
                8 Daniel 0 1
                0
                4 7825349
                1 Klaara 0 0
                -2 Vihtori 0 0
                -3 Amalia 0 2
                -4 Bernard 2 1
                5 Cecilia 1 2
                -6 Erika 0 0
                7 Ferdinand 6 0
                8 Daniel 0 1
                0
                4 7825349
                -1 Klaara 0 0
                -2 Vihtori 0 0
                -3 Amalia 0 2
                -4 Bernard 2 1
                5 Cecilia 1 2
                -6 Erika 0 0
                7 Ferdinand 6 0
                8 Daniel 0 1
                0
                4 7825349
                1 Klaara 0 0
                2 Vihtori 0 0
                3 Amalia 0 2
                -4 Bernard 2 1
                -5 Cecilia 1 2
                -6 Erika 0 0
                7 Ferdinand 6 0
                8 Daniel 0 1
                0
                4 7825349
                -1 Klaara 0 0
                2 Vihtori 0 0
                3 Amalia 0 2
                -4 Bernard 2 1
                -5 Cecilia 1 2
                -6 Erika 0 0
                7 Ferdinand 6 0
                8 Daniel 0 1
                0
                4 7825349
                1 Klaara 0 0
                -2 Vihtori 0 0
                3 Amalia 0 2
                -4 Bernard 2 1
                -5 Cecilia 1 2
                -6 Erika 0 0
                7 Ferdinand 6 0
                8 Daniel 0 1
                0
                4 7825349
                -1 Klaara 0 0
                -2 Vihtori 0 0
                3 Amalia 0 2
                -4 Bernard 2 1
                -5 Cecilia 1 2
                -6 Erika 0 0
                7 Ferdinand 6 0
                8 Daniel 0 1
                0
                4 7825349
                1 Klaara 0 0
                2 Vihtori 0 0
                -3 Amalia 0 2
                -4 Bernard 2 1
                -5 Cecilia 1 2
                -6 Erika 0 0
                7 Ferdinand 6 0
                8 Daniel 0 1
                0
                4 7825349
                -1 Klaara 0 0
                2 Vihtori 0 0
                -3 Amalia 0 2
                -4 Bernard 2 1
                -5 Cecilia 1 2
                -6 Erika 0 0
                7 Ferdinand 6 0
                8 Daniel 0 1
                0
                4 7825349
                1 Klaara 0 0
                -2 Vihtori 0 0
                -3 Amalia 0 2
                -4 Bernard 2 1
                -5 Cecilia 1 2
                -6 Erika 0 0
                7 Ferdinand 6 0
                8 Daniel 0 1
                0
                4 7825349
                -1 Klaara 0 0
                -2 Vihtori 0 0
                -3 Amalia 0 2
                -4 Bernard 2 1
                -5 Cecilia 1 2
                -6 Erika 0 0
                7 Ferdinand 6 0
                8 Daniel 0 1
                0
                4 7825349
                1 Klaara 0 0
                2 Vihtori 0 0
                3 Amalia 0 2
                -4 Bernard 2 1
                5 Cecilia 1 2
                -6 Erika 0 0
                7 Ferdinand 6 0
                -8 Daniel 0 1
                0
                4 7825349
                -1 Klaara 0 0
                2 Vihtori 0 0
                3 Amalia 0 2
                -4 Bernard 2 1
                5 Cecilia 1 2
                -6 Erika 0 0
                7 Ferdinand 6 0
                -8 Daniel 0 1
                0
                4 7825349
                1 Klaara 0 0
                -2 Vihtori 0 0
                3 Amalia 0 2
                -4 Bernard 2 1
                5 Cecilia 1 2
                -6 Erika 0 0
                7 Ferdinand 6 0
                -8 Daniel 0 1
                0
                4 7825349
                -1 Klaara 0 0
                -2 Vihtori 0 0
                3 Amalia 0 2
                -4 Bernard 2 1
                5 Cecilia 1 2
                -6 Erika 0 0
                7 Ferdinand 6 0
                -8 Daniel 0 1
                0
                4 7825349
                1 Klaara 0 0
                2 Vihtori 0 0
                -3 Amalia 0 2
                -4 Bernard 2 1
                5 Cecilia 1 2
                -6 Erika 0 0
                7 Ferdinand 6 0
                -8 Daniel 0 1
                0
                4 7825349
                -1 Klaara 0 0
                2 Vihtori 0 0
                -3 Amalia 0 2
                -4 Bernard 2 1
                5 Cecilia 1 2
                -6 Erika 0 0
                7 Ferdinand 6 0
                -8 Daniel 0 1
                0
                4 7825349
                1 Klaara 0 0
                -2 Vihtori 0 0
                -3 Amalia 0 2
                -4 Bernard 2 1
                5 Cecilia 1 2
                -6 Erika 0 0
                7 Ferdinand 6 0
                -8 Daniel 0 1
                0
                4 7825349
                -1 Klaara 0 0
                -2 Vihtori 0 0
                -3 Amalia 0 2
                -4 Bernard 2 1
                5 Cecilia 1 2
                -6 Erika 0 0
                7 Ferdinand 6 0
                -8 Daniel 0 1
                0
                4 7825349
                1 Klaara 0 0
                2 Vihtori 0 0
                3 Amalia 0 2
                -4 Bernard 2 1
                -5 Cecilia 1 2
                -6 Erika 0 0
                7 Ferdinand 6 0
                -8 Daniel 0 1
                0
                4 7825349
                -1 Klaara 0 0
                2 Vihtori 0 0
                3 Amalia 0 2
                -4 Bernard 2 1
                -5 Cecilia 1 2
                -6 Erika 0 0
                7 Ferdinand 6 0
                -8 Daniel 0 1
                0
                4 7825349
                1 Klaara 0 0
                -2 Vihtori 0 0
                3 Amalia 0 2
                -4 Bernard 2 1
                -5 Cecilia 1 2
                -6 Erika 0 0
                7 Ferdinand 6 0
                -8 Daniel 0 1
                0
                4 7825349
                -1 Klaara 0 0
                -2 Vihtori 0 0
                3 Amalia 0 2
                -4 Bernard 2 1
                -5 Cecilia 1 2
                -6 Erika 0 0
                7 Ferdinand 6 0
                -8 Daniel 0 1
                0
                4 7825349
                1 Klaara 0 0
                2 Vihtori 0 0
                -3 Amalia 0 2
                -4 Bernard 2 1
                -5 Cecilia 1 2
                -6 Erika 0 0
                7 Ferdinand 6 0
                -8 Daniel 0 1
                0
                4 7825349
                -1 Klaara 0 0
                2 Vihtori 0 0
                -3 Amalia 0 2
                -4 Bernard 2 1
                -5 Cecilia 1 2
                -6 Erika 0 0
                7 Ferdinand 6 0
                -8 Daniel 0 1
                0
                4 7825349
                1 Klaara 0 0
                -2 Vihtori 0 0
                -3 Amalia 0 2
                -4 Bernard 2 1
                -5 Cecilia 1 2
                -6 Erika 0 0
                7 Ferdinand 6 0
                -8 Daniel 0 1
                0
                4 7825349
                -1 Klaara 0 0
                -2 Vihtori 0 0
                -3 Amalia 0 2
                -4 Bernard 2 1
                -5 Cecilia 1 2
                -6 Erika 0 0
                7 Ferdinand 6 0
                -8 Daniel 0 1
                0
                0
                """;
       /*
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.isEmpty()) {
                break;
            }
            syote.append(line).append("\n");
        }


        */
        PerintojenJakaja perintojenJakaja = new PerintojenJakaja(testString);
        perintojenJakaja.jaaPerinnot();

        sc.close();


    }
}

