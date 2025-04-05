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
    private String otsikkorivi;
    private ArrayList<Tapahtuma> tapahtumat;

    public Parser() {
        this.otsikkorivi = "";
        this.tapahtumat = new ArrayList<>();
    }

    public void analysoiSyote(String syote) {
        String[] tapahtumaRivit = pilkoSyote(syote);
        otsikkorivi = tapahtumaRivit[0].trim();
        for (int i = 1; i < tapahtumaRivit.length; i++) {
            Tapahtuma uusiTapahtuma = parsiTapahtumaMerkkijonosta(tapahtumaRivit[i]);
            tapahtumat.add(uusiTapahtuma);
        }
    }


    public String[] pilkoSyote(String syote) {
        return syote.split("(?=\\d{2}\\.\\d{1,2}\\.\\d{4})");
    }


    public Tapahtuma parsiTapahtumaMerkkijonosta(String merkkijono ) {
        Scanner sc = new Scanner(merkkijono);
        String pvm = sc.next();
        String kellonaika = sc.next();
        String[] kellonajat = erotaAlkuJaLoppuAika(kellonaika);
        int alkuaika = Integer.parseInt(kellonajat[0]);
        int loppuaika = Integer.parseInt(kellonajat[1]);

        StringBuilder nimiSB = new StringBuilder();
        while (sc.hasNext()) {
            nimiSB.append(sc.next());
            nimiSB.append(" ");
        }
        String nimi = nimiSB.toString().trim();

        Tapahtuma uusiTapahtuma = new Tapahtuma(alkuaika, loppuaika, parsiPvmMerkkiJono(pvm), nimi);
        return uusiTapahtuma;
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

    /**
     * Tarkistaa onko merkkijonossa 3 pisteellä erotettua osaa
     * @param mj merkkijono joka tarkistetaan
     * @return true jos merkkijono on paivamaara, false jos ei ole
     */
    public boolean onPvm(String mj) {
        String[] osat = mj.split("\\.");
        return (osat.length == 3);
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
