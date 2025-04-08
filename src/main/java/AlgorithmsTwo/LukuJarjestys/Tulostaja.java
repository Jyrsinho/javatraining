package AlgorithmsTwo.LukuJarjestys;


import java.io.PrintStream;

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
        tulostaOtsikkoRivi(out);
        tulostaRivit(out, kalenteri);
        tulostaValiRivi(out);
    }


    /**
     * Jos otsikkoriviä ei saatu,
     * niin pitää tulostaa rivi jossa lukee ”Syöte puuttuu” ja lopettaa. Sitten pitää olla rivi,
     * jossa on kurssin ajanjakso muodossa päivämäärä-päivämäärä tai ”Ei tapahtumia
     * @param out
     */
    private void kasittelePuuttuvaOtsikko(PrintStream out, Kalenteri kalenteri) {
        out.println("Syöte puuttuu");
        if (kalenteri.getTapahtumienMaara() == 0) {
            out.println("Ei tapahtumia");
        } else {
            tulostaKalenterinKesto(out, kalenteri);
        }
}


    private void tulostaKalenterinKesto(PrintStream out, Kalenteri kalenteri) {
        String ensimmainenPaiva = kalenteri.ensimmaisenTapahtumanPV();
        String viimeinenPaiva = kalenteri.viimeisenTapahtumanPV();

        out.printf("%s-%s", ensimmainenPaiva, viimeinenPaiva);
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


    private void tulostaValiRivi(PrintStream out, Kalenteri kalenteri, int kellonAika) {
        tulostaEnsimmaisenSolunAlaviiva(out);

        for (int i = 0; i < kalenteri.getTapahtumaKalenteri().length; i++) {

            if (kalenteri.tapahtumaJatkuu(i, kellonAika  )) {
                for (int j = 0; j < merkkejaSolussa; j++) {
                    out.print(" ");
                }
            }else {
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
        int ensimmainenAlkavaTunti = kalenteri.aikaisinTapahtuma();
        int viimeinenAlkavaTunti = kalenteri.myohaisinTapahtuma();
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
            tulostaValiRivi(out,kalenteri, kellonaika);
            tulostaTuntiSolu(out, kellonaika);
            tulostaTapahtumat(out, kellonaika, kalenteri);
            out.println();

    }


    private void tulostaTapahtumat(PrintStream out, int kellonaika, Kalenteri kalenteri) {

        for (int i = 0; i < kalenteri.getTapahtumaKalenteri().length; i++) {

            if (kalenteri.getTapahtumaKalenteri()[i][kellonaika] != null) {
                String tapahtumanNimi = kalenteri.getTapahtumaKalenteri()[i][kellonaika].getNimi();
                out.print(" ");
                if (tapahtumanNimi.length() < 11) {
                    out.print(tapahtumanNimi);
                    for (int j = 0; j < merkkejaSolussa - tapahtumanNimi.length() -2; j++) {
                        out.print(" ");
                    }
                } else {
                    out.print(tapahtumanNimi.substring(0, 11));
                }
                out.print(" ");
            } else {
                for (int j = 0; j < merkkejaSolussa; j++) {
                    out.print(" ");

                }
            }
            out.print("|");
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
