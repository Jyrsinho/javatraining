package AlgorithmsTwo.LukuJarjestys;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Lukee kauttajan syotteen.
 * Syötteen ensimmäinen epätyhjä rivi on
 * otsikkorivi. Kukin muu epätyhjä rivi kertoo yhden tapahtuman muodossa v∗ päi-
 * vämäärä v+ kellonaika v∗ - v∗ kellonaika v+ nimi v∗, missä v∗ tarkoittaa nollaa
 * tai useampaa välilyöntiä ja v+ tarkoittaa yhtä tai useampaa välilyöntiä. Päivämää-
 * rä on muotoa pp.kk.vvvv tai p.kk.vvvv tai pp.k.vvvv tai p.k.vvvv. Vuosi on vähin-
 * tään 2000 ja enintään 2099. Kuukausi on vähintään 1 ja enintään 12, ja päivä on
 * vähintään 1 ja enintään kuukauden viimeinen päivä. Kellonaika on vähintään 0
 * ja enintään 24. Jälkimmäinen kellonaika on suurempi kuin ensimmäinen. Nimen
 * sisällä voi olla välilyöntejä, mutta nimen edessä ja perässä mahdollisesti olevat
 * välilyönnit eivät kuulu nimeen.
 *
 */

public class Parser {
    private String otsikkorivi;
    private ArrayList<Tapahtuma> tapahtumat;

    public Parser() {
        this.otsikkorivi = "";
        this.tapahtumat = new ArrayList<>();
    }

    public void analysoiSyote(String syote) {

        Scanner scanner = new Scanner(syote);

        while (scanner.hasNextLine()) {
            String merkkijono = scanner.nextLine();
            if (!merkkijono.trim().isEmpty()) {
                setOtsikko(merkkijono);
                break;
            }
        }
        while (scanner.hasNextLine()) {
           String merkkijono = scanner.nextLine();
           if (!merkkijono.trim().isEmpty()) {
               Tapahtuma uusiTapahtuma = parsiTapahtumaMerkkijonosta(merkkijono);
               tapahtumat.add(uusiTapahtuma);
           }
        }

    }



    public Tapahtuma parsiTapahtumaMerkkijonosta(String merkkijono ) {

        String pvmRegEx = "(\\d{1,2}\\.\\d{1,2}\\.\\d{4})";
        String pvm = getMatchingSubstring(merkkijono, pvmRegEx);
        int alkuaika = -1;
        int loppuaika = -1;
        String kelloRegEx = "(\\d{1,2})\\s*-\\s*(\\d{1,2})";
        String kellonaika = getMatchingSubstring(merkkijono, kelloRegEx);
        if (kellonaika!= null) {
            String[] kellonajat = erotaAlkuJaLoppuAika(kellonaika);
            alkuaika = Integer.parseInt(kellonajat[0]);
            loppuaika = Integer.parseInt(kellonajat[1]);
        }

        String nimi = merkkijono.split(kelloRegEx)[1].trim();

        Tapahtuma uusiTapahtuma = new Tapahtuma(alkuaika, loppuaika, parsiPvmMerkkiJono(pvm), nimi);
        return uusiTapahtuma;
    }

    public static String getMatchingSubstring(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            return matcher.group();
        }

        return null;
    }


    private String[] erotaAlkuJaLoppuAika(String merkkijono) {
        String[]alkuJaLoppuAika = merkkijono.split("-");
        alkuJaLoppuAika[0] = alkuJaLoppuAika[0].trim();
        alkuJaLoppuAika[1] = alkuJaLoppuAika[1].trim();

        return alkuJaLoppuAika;
    }


    /**
     * Päivämäärä on muotoa pp.kk.vvvv tai p.kk.vvvv tai pp.k.vvvv tai p.k.vvvv.
     * @param merkkijono josta LocalDate paivamaara muodostetaan
     * @return {LocalDate} tapahtuman PVM
     */
    public LocalDate parsiPvmMerkkiJono(String merkkijono) {
        String[] eroteltuPVM = merkkijono.split("\\.");

        int paiva = Integer.parseInt(eroteltuPVM[0]);
        int kuukausi = Integer.parseInt(eroteltuPVM[1]);
        int vuosi = Integer.parseInt(eroteltuPVM[2]);

        return LocalDate.of(vuosi, kuukausi, paiva);
    }



    private void setOtsikko(String otsikko) {
        this.otsikkorivi = otsikko;
    }

    public String getOtsikko() {
        return this.otsikkorivi;
    }

    public ArrayList<Tapahtuma> annaTapahtumat() {
        return tapahtumat;
    }
}
