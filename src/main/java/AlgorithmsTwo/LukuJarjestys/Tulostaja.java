package AlgorithmsTwo.LukuJarjestys;


import java.io.PrintStream;

public class Tulostaja {

    String[] viikonPaivat = {"Maanantai", "Tiistai", "Keskiviikko", "Torstai", "Perjantai"};
    int merkkejaSolussa = 13;
    int ensimmaisenSolunMerkkiMaara= 6;


    public void tulostaKalenteri(Kalenteri kalenteri) {
        PrintStream out = System.out;
        tulostaOtsikkoRivi(out);
        tulostaValiRivi(out);
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
        //tulostetaan ensimmainen solu
        for (int i = 0; i <ensimmaisenSolunMerkkiMaara ; i++) {
            out.print("_");
        }
        out.print("+");

        //tulostetaan viikonpaivien solut
        for (int i = 0; i < viikonPaivat.length; i++) {
            for (int j = 0; j < merkkejaSolussa; j++) {
                out.print("_");
            }
            out.print("+");
        }
    }
}
