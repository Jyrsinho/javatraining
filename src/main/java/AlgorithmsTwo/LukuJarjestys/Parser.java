package AlgorithmsTwo.LukuJarjestys;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

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



    public ArrayList<Tapahtuma> annaTapahtumat(String syote) {

        ArrayList<Tapahtuma> tapahtumat = new ArrayList<>();

        Scanner sc = new Scanner(syote);
        //skipataaan otsikkorivi
        sc.nextLine();
        while (sc.hasNextLine()) {
            String tapahtumaRivi = sc.nextLine();
            Tapahtuma uusiTapahtuma = parsiTapahtuma(tapahtumaRivi);
            tapahtumat.add(uusiTapahtuma);
        }
        return tapahtumat;
    }


    public String annaOtsikkoRivi(String syote) {
        Scanner sc = new Scanner(syote);
        return sc.nextLine();
    }

    private Tapahtuma parsiTapahtuma(String tapahtumaRivi) {

        Scanner sc = new Scanner(tapahtumaRivi);
        int elementinNumero = 0;
        LocalDate paivamaara = LocalDate.now();
        int alkuaika = 0;
        int loppuaika = 0;
        String nimi = "";

        while (sc.hasNext()) {

            String merkkijono = sc.next();
            if (elementinNumero == 0) {
                paivamaara = parsiPvmMerkkiJono(merkkijono);
                elementinNumero++;
            } else if (elementinNumero == 1) {
                elementinNumero++;
                String[] alkuJaLoppuAika = erotaAlkuJaLoppuAika(merkkijono);
                alkuaika = Integer.parseInt(alkuJaLoppuAika[0]);
                loppuaika = Integer.parseInt(alkuJaLoppuAika[1]);
            } else if (elementinNumero == 2) {
                nimi = erotaTapahtumanNimi(sc, merkkijono);
                elementinNumero = 0;

            }
        }
      return new Tapahtuma(alkuaika, loppuaika, paivamaara, nimi);
    }

    private String[] erotaAlkuJaLoppuAika(String merkkijono) {
        String[]alkuJaLoppuAika = merkkijono.split("-");

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


    private String erotaTapahtumanNimi(Scanner sc, String merkkijono) {
        StringBuilder sb = new StringBuilder();
        sb.append(merkkijono);
        while (sc.hasNext()) {
            sb.append(" ");
            sb.append(sc.next());
        }
        return sb.toString();
    }
}
