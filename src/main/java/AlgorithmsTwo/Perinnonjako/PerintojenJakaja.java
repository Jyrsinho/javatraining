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
            }
            if (perakkaisiaKokonaisLukuja== 4 && Objects.equals(merkkiJono, "0")) {
                break;
            }
        }
    }

    private void tulostaPerinnonJaot() {

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

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.isEmpty()) {
                break;
            }
            syote.append(line).append("\n");
        }

        PerintojenJakaja perintojenJakaja = new PerintojenJakaja(syote.toString());
        perintojenJakaja.jaaPerinnot();

        sc.close();
    }
}

