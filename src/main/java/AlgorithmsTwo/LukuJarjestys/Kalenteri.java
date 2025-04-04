package AlgorithmsTwo.LukuJarjestys;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Kalenteri {
    private Tapahtuma[][] tapahtumaKalenteri;
    private String otsikko;

    public Kalenteri(int paivia, int tunteja) {
        this.tapahtumaKalenteri = new Tapahtuma[paivia][tunteja];
        this.otsikko = "";
    }


    public void lisaaTapahtuma(Tapahtuma uusiTapahtuma) {
        int paiva = viikonpaiva(uusiTapahtuma.paivamaara);
            if (tapahtumaKalenteri[paiva][uusiTapahtuma.alkuaika] == null) {
                tapahtumaKalenteri[paiva][uusiTapahtuma.alkuaika] = uusiTapahtuma;
            }
    }


    public void paivitaKalenteri(ArrayList<Tapahtuma> tapahtumat) {
       for (Tapahtuma tapahtuma: tapahtumat) {
           lisaaTapahtuma(tapahtuma);
       }
    }


    /**
     * Palauttaa parametrina annettua paivaa ja tuntia vastaavan tapahtuman kalenterista, jos siella sellainen on.
     * Maanantain indeksi on 0, perjantain 4.
     * Jos kyseisessä aikaikkunassa ei ole tapahtumaa palautetaan PoikkeusTapahtuma
     * @param paiva jolloin tapahtuma tapahtuu
     * @param tunti jolloin tapahtuma tapahtuu
     * @return Tapahtuma
     */
    public Tapahtuma getTapahtuma(int paiva, int tunti) {
        if (tapahtumaKalenteri[paiva][tunti] != null) {
            return tapahtumaKalenteri[paiva][tunti];
        }else {
            return new TapahtumaEiOlemassa();
        }
    }

    /**
     * Palauttaa tapahtuman paivamaaraa vastaavan viikonpaivan.
     * @param pvm {String} jolle haetaan viikonpaiva
     * @return viikonpaivan jarjestysnumero. Maanantai on 0, perjantai 5 ja vkloput -1.
     */
   public int viikonpaiva(LocalDate pvm) {

      DayOfWeek dayOfWeek = pvm.getDayOfWeek();
       return switch (dayOfWeek) {
           case MONDAY -> 0;
           case TUESDAY -> 1;
           case WEDNESDAY -> 2;
           case THURSDAY -> 3;
           case FRIDAY -> 4;
           default -> -1;
       };
   }

    /**
     * Palauttaa kalenterin aikaisimman tapahtuman kellonajan
     * @return {int} aikaisimman tapahtuman kellonaika. Jos kalenterissa ei ole tapahtumia palauttaa 25
     */
   public int aikaisinTapahtuma() {
       int aikaisinTapahtuma = 25;

       for (int i = 0; i < tapahtumaKalenteri.length; i++) {
           for (int j = 0; j < tapahtumaKalenteri[i].length; j++) {
               if (tapahtumaKalenteri[i][j] != null && tapahtumaKalenteri[i][j].alkuaika < aikaisinTapahtuma) {
                   aikaisinTapahtuma = tapahtumaKalenteri[i][j].alkuaika;
               }
           }
       }

       return aikaisinTapahtuma;
    }

    /**
     * Palauttaa kalenterin myohaisimman tapahtuman kellonajan
     * @return {int} myohaisimman tapahtuman kellonaika. Jos kalenterissa ei ole tapahtumia palauttaa -1
     */
    public int myohaisinTapahtuma() {
       int myohaisinTapahtuma = -1;

        for (int i = 0; i < tapahtumaKalenteri.length; i++) {
            for (int j = 0; j < tapahtumaKalenteri[i].length; j++) {
                if (tapahtumaKalenteri[i][j] != null && tapahtumaKalenteri[i][j].alkuaika > myohaisinTapahtuma) {
                    myohaisinTapahtuma = tapahtumaKalenteri[i][j].alkuaika;
                }
            }
        }
        return myohaisinTapahtuma;
    }

    public boolean tapahtumaJatkuu(int paiva, int kellonaika) {
        Tapahtuma aiempiTapahtuma = new TapahtumaEiOlemassa();
        int aiemmanTapahtumanAlkamisAika = kellonaika;

        while (aiempiTapahtuma.getClass().getSimpleName().equals("TapahtumaEiOlemassa") && aiemmanTapahtumanAlkamisAika >= 0){
            if (tapahtumaKalenteri[paiva][aiemmanTapahtumanAlkamisAika] != null) {
                aiempiTapahtuma = tapahtumaKalenteri[paiva][aiemmanTapahtumanAlkamisAika];
            }

            aiemmanTapahtumanAlkamisAika--;
        }

        return aiempiTapahtuma.loppuaika > kellonaika && kellonaika != aiempiTapahtuma.alkuaika;
    }


    public String ensimmaisenTapahtumanPV() {
        LocalDate aikaisinTapahtuma = LocalDate.now();
        for (int i = 0; i < tapahtumaKalenteri.length; i++) {
            for (int j = 0; j < tapahtumaKalenteri[i].length; j++) {
                if (tapahtumaKalenteri[i][j] != null) {
                    LocalDate ehdokas = tapahtumaKalenteri[i][j].paivamaara;
                    if (onAikaisempiKuin(ehdokas, aikaisinTapahtuma)) {
                        aikaisinTapahtuma = ehdokas;
                    }
                }
            }
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");
        String formattedDate = aikaisinTapahtuma.format(formatter);
        return formattedDate;
    }


    public String viimeisenTapahtumanPV() {
        LocalDate viimeisinTapahtuma = LocalDate.MIN;
        for (int i = 0; i < tapahtumaKalenteri.length; i++) {
            for (int j = 0; j < tapahtumaKalenteri[i].length; j++) {
                if (tapahtumaKalenteri[i][j] != null) {
                    LocalDate ehdokas = tapahtumaKalenteri[i][j].paivamaara;
                    if (!onAikaisempiKuin(ehdokas, viimeisinTapahtuma)) {
                        viimeisinTapahtuma = ehdokas;
                    }
                }
            }
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");
        String formattedDate = viimeisinTapahtuma.format(formatter);
        return formattedDate;
    }

    private boolean onAikaisempiKuin(LocalDate ehdokas, LocalDate verrattava) {
        return ehdokas.isBefore(verrattava);
    }



   public void tulosta () {
       for (int i = 0; i < tapahtumaKalenteri.length; i++) {
           System.out.println("Päivä " + i);
           for (int j = 0; j < tapahtumaKalenteri[i].length; j++) {
               if (tapahtumaKalenteri[i][j] != null) {
                   tapahtumaKalenteri[i][j].tulosta();

               }
           }
       }
   }

   public Tapahtuma[][] getTapahtumaKalenteri() {
        return tapahtumaKalenteri;
   }

   public String getOtsikko() {
        return this.otsikko;
   }

   public void setOtsikkoRivi(String otsikko) {
        this.otsikko = otsikko;
   }
}