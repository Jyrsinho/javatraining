package AlgorithmsTwo.Perinnonjako;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        suoritaPerinnonJaot();
        tulostaPerinnonJaot();

    }

    public void kasitteleSyote() {

        String perintojenJakoSyoteIlmanHantaa = siivoaSyotteenHantaPois();
        ArrayList<String> perinnonJakoSyotteet = erottelePerinnonJaot(perintojenJakoSyoteIlmanHantaa);

        for (String perinnonJakoSyote: perinnonJakoSyotteet) {
            Perinnonjako perinnonjako = new Perinnonjako(perinnonJakoSyote);
            perinnonjaot.add(perinnonjako);
        }

    }

    private String siivoaSyotteenHantaPois() {
        String limiterOsa;
        String regexSyotteenLoppu = "\\d+\\s\\d+\\s0\\s0";
        Pattern loppuPattern = Pattern.compile(regexSyotteenLoppu);
        Matcher loppuMatcher = loppuPattern.matcher(input);

        if (loppuMatcher.find()){
            String match = loppuMatcher.group();
            limiterOsa = match;
        } else limiterOsa = "";

        String[] alkuJaLoppu = input.split(regexSyotteenLoppu);
        StringBuilder sb = new StringBuilder();
        sb.append(alkuJaLoppu[0]).append(limiterOsa);


        return sb.toString();
    }


    private ArrayList<String> erottelePerinnonJaot(String perinnonJaot) {
        ArrayList<String> perinnonJakoSyotteet = new ArrayList<>();

        // Regex pattern to detect "three consecutive integers"
        String regex = "\\d+\\s\\d+\\s0+";

        // Compile pattern
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(perinnonJaot);

        int lastIndex = 0;

        // Find matches
        while (matcher.find()) {
            // Extract substring up to the match
            String substring = perinnonJaot.substring(lastIndex, matcher.start()).trim();
            if (!substring.isEmpty()) {
                perinnonJakoSyotteet.add(substring);
            }
            lastIndex = matcher.start(); // Include the match in the next part
        }

        // Add the remaining part
        if (lastIndex < perinnonJaot.length()) {
            perinnonJakoSyotteet.add(perinnonJaot.substring(lastIndex).trim());
        }

        return perinnonJakoSyotteet;
    }


    private void luoUusiPerinnonJako(String syote) {
        Perinnonjako perinnonjako = new Perinnonjako(syote);
        perinnonjaot.add(perinnonjako);
    }


    private void suoritaPerinnonJaot() {
        for (Perinnonjako perinnonjako: perinnonjaot) {
            perinnonjako.suoritaPerinnonjako();
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

