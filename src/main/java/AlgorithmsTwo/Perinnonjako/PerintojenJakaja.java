package AlgorithmsTwo.Perinnonjako;

import java.util.ArrayList;
import java.util.Objects;
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
        kasitteleSyote();
        tulostaPerinnonJaot();

    }

    private void kasitteleSyote() {
        Scanner sc = new Scanner(input);

        //jos syotteessa on perakkain 3 kokonaislukua, joista kolmas on 0, Perinnonjako loppuu.
        // jos syotteessa on perakkain 4 kokonaislukua Syote loppuu.

        StringBuilder sb = new StringBuilder();
        int perakkaisiaKokonaisLukuja = 0;

        while (sc.hasNext()) {
            String merkkiJono = sc.next();
            if (onKokonaisLuku(merkkiJono)){
                perakkaisiaKokonaisLukuja++;
            } else {
                perakkaisiaKokonaisLukuja = 0;
            }
            if (perakkaisiaKokonaisLukuja == 3 && Objects.equals(merkkiJono, "0")) {
                Perinnonjako perinnonjako = new Perinnonjako(sb.toString());
                perinnonjaot.add(perinnonjako);
                sb.delete(0, sb.length());
            }
            if (perakkaisiaKokonaisLukuja== 4 && Objects.equals(merkkiJono, "0")) {
                break;
            }
            sb.append(merkkiJono);
        }
    }

    private void tulostaPerinnonJaot() {
        /*
        Esimerkkituloste:
                            Amalia saa 1956337
                            Cecilia saa 3912674
                            Daniel saa 1956337
                            Jakamatta jää 1
                            Valtio saa 9
                            Jakamatta jää 0
         */

        for (Perinnonjako perinnonjako : perinnonjaot) {
            for (Perija perija: perinnonjako.perijat) {
                System.out.println(perija.getNimi() + "saa " + perija.getPerintoaSaatu());
            }
            System.out.println("Jakamatta jaa " + perinnonjako.getPerinnonMaara());
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
        /*Scanner sc = new Scanner(System.in);
        StringBuilder syote = new StringBuilder();

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.isEmpty()) {
                break;
            }
            syote.append(line).append("\n");
        }

         */


        //PerintojenJakaja perintojenJakaja = new PerintojenJakaja(syote.toString());
        String testiSyote = """
                4 7825349
                -1 Klaara 0 0 -2 Vihtori 0 0
                3 Amalia 0 2
                -4 Bernard 2 1
                5 Cecilia 1 2
                -6
                Erika 0
                0
                7 Ferdinand 6 0
                8 Daniel 0 1 0 1 9 -1 ToinenVainaja 0 0 0 0
                2 syöte_loppui_ennen_tätä_kohtaa 1 0 0 0
                """;
        PerintojenJakaja perintojenJakaja = new PerintojenJakaja(testiSyote);
        perintojenJakaja.jaaPerinnot();

        /*
        sc.close();

         */
    }
}

