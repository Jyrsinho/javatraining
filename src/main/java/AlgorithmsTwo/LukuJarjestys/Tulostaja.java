package AlgorithmsTwo.LukuJarjestys;


import java.io.PrintStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Tulostaja {

    String[] viikonPaivat = {"Maanantai", "Tiistai", "Keskiviikko", "Torstai", "Perjantai"};
    int merkkejaSolussa = 13;
    int ensimmaisenSolunMerkkiMaara= 6;


    /**
     * Lukujärjestykseen tulostetaan rivi jokaiselle tunnille alkaen päivän ensimmäi-
     * sestä tapahtumasta tai tunnista 8–9 sen mukaan kumpi on varhaisempi, ja päättyen
     * päivän viimeiseen tapahtumaan tai tuntiin 15–16 sen mukaan kumpi on myöhäi-
     * sempi.
     * @param kalenteri
     */
    public void tulostaKalenteri(Kalenteri kalenteri) {

        PrintStream out = System.out;

        if (kalenteri.getOtsikko().isEmpty()) {
            kasittelePuuttuvaOtsikko(out, kalenteri);
            return;
        }

        if (kalenteri.getTapahtumienMaara() == 0) {
            out.println(kalenteri.getOtsikko());
            out.println("Ei tapahtumia");
            return;
        }

        out.println(kalenteri.getOtsikko());
        tulostaKalenterinKesto(out, kalenteri);
        tulostaPoikkeukset(kalenteri, out);
        tulostaOtsikkoRivi(out);
        tulostaValiRivi(out);
        tulostaRivit(out, kalenteri);
    }

    public void tulostaPoikkeukset(Kalenteri kalenteri, PrintStream out) {
        Poikkeustaja poikkeustaja = new Poikkeustaja(kalenteri);
        ArrayList<Tapahtuma> poikkeukset = poikkeustaja.annaPoikkeukset();
        out = System.out;
        out.println("Poikkeukset:");
        for (int i = 0; i < poikkeukset.size(); i++) {
            Tapahtuma poikkkeusTapahtuma = poikkeukset.get(i);
            tulostaPoikkeusTapahtumanTiedot(poikkkeusTapahtuma, out);
        }
    }


    private void tulostaPoikkeusTapahtumanTiedot(Tapahtuma poikkeusTapahtuma, PrintStream out) {
        // haluttu output esimerkki: 4.4.2023 10-12 ei tapahtumaa
        String tapahtumanPvm = poikkeusTapahtuma.paivamaara.toString();
        String tapahtumanKellonAIka = String.format("%d-%d", poikkeusTapahtuma.ensimmainenAlkavaTunti, poikkeusTapahtuma.viimeinenAlkavaTunti +1);


        String tapahtumaRivi = String.format("%s %s %s", tapahtumanPvm, tapahtumanKellonAIka, poikkeusTapahtuma.getNimi());
        out.println(tapahtumaRivi);
    }


    /**
     * Jos otsikkoriviä ei saatu,
     * niin pitää tulostaa rivi jossa lukee ”Syöte puuttuu” ja lopettaa. Sitten pitää olla rivi,
     * jossa on kurssin ajanjakso muodossa päivämäärä-päivämäärä tai ”Ei tapahtumia
     * @param out
     */
    private void kasittelePuuttuvaOtsikko(PrintStream out, Kalenteri kalenteri) {
        out.println("Syöte puuttuu");
}


    private void tulostaKalenterinKesto(PrintStream out, Kalenteri kalenteri) {

        LocalDate ensimmainenPaiva = kalenteri.getEnsimmaisenTapahtumanPVM();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");
        String ensimmainenPaivaMJ = ensimmainenPaiva.format(formatter);

        LocalDate viimeinenPaiva = kalenteri.getViimeisenTapahtumanPVM();
        String viimeinenPaivaMJ = viimeinenPaiva.format(formatter);


        out.printf("%s-%s", ensimmainenPaivaMJ, viimeinenPaivaMJ);
        out.println();
    }

    /**
     *
     */
    private void tulostaOtsikkoRivi(PrintStream out) {
        tulostaTyhjaSolu(out);
        tulostaViikonpaivaSolut(out);
        out.println();
    }

    private void tulostaTyhjaSolu(PrintStream out) {
        for (int i = 0; i < ensimmaisenSolunMerkkiMaara; i++) {
            out.print(" ");
        }
        out.print("|");
    }

    private void tulostaViikonpaivaSolut(PrintStream out) {
        //tulostetaan 1 tyhja merkki
        //tulostetaan viikonpaiva
        //tulostetaan tyhjia merkkejaSolussa - viikonpaivanpituus - 1
        //tulostetaan |
        for (String viikonpaiva : viikonPaivat) {
            out.print(" ");
            out.print(viikonpaiva);
            int tyhjiaMerkkeja = merkkejaSolussa - viikonpaiva.length() -1;
            for (int i = 0; i < tyhjiaMerkkeja; i++) {
                out.print(" ");
            }
            out.print("|");
        }
    }


    private void tulostaValiRivi(PrintStream out) {
        tulostaEnsimmaisenSolunAlaviiva(out);
        //tulostetaan viikonpaivien solut
        for (int i = 0; i < viikonPaivat.length; i++) {
            for (int j = 0; j < merkkejaSolussa; j++) {
                out.print("-");
            }
            out.print("+");
        }
        out.println();
    }


    /**
     * Tulostetaan solu kerrallaan jos solun ylempi solu ja alempi solu sisältävät Kalenterissa saman tekstin
     * ei tulostetan solua
     * @param out
     * @param kalenteri
     * @param kellonAika
     */
    private void tulostaValiRivi(PrintStream out, Kalenteri kalenteri, int kellonAika) {
        tulostaEnsimmaisenSolunAlaviiva(out);

        for (int i = 0; i < kalenteri.getTapahtumaKalenteri().length; i++) {
            String tulostettavanNimi = kalenteri.getTapahtumaKalenteri()[i][kellonAika].getSaannollinen();
            String seuraavanNimi = kalenteri.getTapahtumaKalenteri()[i][kellonAika+1].getSaannollinen();

            if (tulostettavanNimi.equals(seuraavanNimi) && !tulostettavanNimi.equals("Ei Tapahtumaa")) {
                for (int j = 0; j < merkkejaSolussa; j++) {
                    out.print(" ");
                }
            } else  {
                for (int k = 0; k < merkkejaSolussa; k++) {
                    out.print("-");
                }
            }
            out.print("+");
        }
        out.println();
    }

    private void tulostaEnsimmaisenSolunAlaviiva(PrintStream out) {
        for (int i = 0; i <ensimmaisenSolunMerkkiMaara ; i++) {
            out.print("-");
        }
        out.print("+");
    }


    private void tulostaRivit(PrintStream out, Kalenteri kalenteri) {
        int ensimmainenAlkavaTunti = kalenteri.aikaisinAlkavaTunti();
        int viimeinenAlkavaTunti = kalenteri.myohaisinAlkavaTunti();
        if (ensimmainenAlkavaTunti > 8) {
            ensimmainenAlkavaTunti = 8;
        }
        if (viimeinenAlkavaTunti < 15) {
            viimeinenAlkavaTunti = 15;
        }
        for (int i = ensimmainenAlkavaTunti; i <= viimeinenAlkavaTunti; i++) {
            tulostaRivi(kalenteri ,i, out);
        }
    }

    private void tulostaRivi(Kalenteri kalenteri, int kellonaika, PrintStream out) {
            tulostaTuntiSolu(out, kellonaika);
            tulostaTapahtumat(out, kellonaika, kalenteri);

    }


    private void tulostaTapahtumat(PrintStream out, int kellonaika, Kalenteri kalenteri) {

        for (int i = 0; i < kalenteri.getTapahtumaKalenteri().length; i++) {
            String tuntiaAiempiKalenteriSolu = kalenteri.getTapahtumaKalenteri()[i][kellonaika-1].getSaannollinen();
            String kalenteriSolu = kalenteri.getTapahtumaKalenteri()[i][kellonaika].getSaannollinen();
            boolean tapahtumaJatkuu = kalenteriSolu.equals(tuntiaAiempiKalenteriSolu);

            String tapahtumanNimi = kalenteri.getTapahtumaKalenteri()[i][kellonaika].getSaannollinen();
            out.print(" ");
            if (tapahtumaJatkuu) {
                tulostaTyhjaTapahtumaSolu(out);
            }else if (tapahtumanNimi.equals("Ei Tapahtumaa")) {
               tulostaTyhjaTapahtumaSolu(out);
            } else {
                tulostaTapahtumanNimi(tapahtumanNimi, out);
            }

            out.print(" ");
            out.print("|");
        }
        out.println();
        tulostaValiRivi(out,kalenteri, kellonaika);
    }

    private void tulostaTapahtumanNimi(String tapahtumanNimi, PrintStream out) {
        // Tulosta tapahtumanNimi
        if (tapahtumanNimi.length() < 11) {
            out.print(tapahtumanNimi);
            for (int j = 0; j < merkkejaSolussa - tapahtumanNimi.length() -2; j++) {
                out.print(" ");
            }
        } else {
            out.print(tapahtumanNimi.substring(0, 11));
        }
    }


    private void tulostaTyhjaTapahtumaSolu(PrintStream out) {
        for (int i = 0; i < merkkejaSolussa -2 ; i++) {
            out.print(" ");

        }
    }


    private void tulostaTuntiSolu(PrintStream out, int kellonaika) {
        if (kellonaika < 9) {
            out.print(" ");
            out.print(kellonaika);
            out.print("-");
            out.print(" ");
            out.print(kellonaika +1);
            out.print(" ");

        } else if (kellonaika == 9) {
            out.print(" ");
            out.print(kellonaika);
            out.print("-");
            out.print(kellonaika +1);
            out.print(" ");
        } else {
            out.print(kellonaika);
            out.print("-");
            out.print(kellonaika +1);
            out.print(" ");
        }
        out.print("|");
    }
}
