package AlgorithmsTwo.LukuJarjestys;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;

public class Kalenteri {
    private Tapahtuma[][] tapahtumaKalenteri;
    private String otsikko;
    private int tapahtumienMaara;
    private LocalDate ensimmaisenTapahtumanPVM;
    private LocalDate viimeisenTapahtumanPVM;


    public Kalenteri(int paivia, int tunteja) {
        this.tapahtumaKalenteri = new Tapahtuma[paivia][tunteja];
        this.otsikko = "";
        this.tapahtumienMaara = 0;
        this.ensimmaisenTapahtumanPVM = LocalDate.MAX;
        this.viimeisenTapahtumanPVM = LocalDate.MIN;
    }


    public void lisaaTapahtuma(Tapahtuma uusiTapahtuma) {
        int paiva = viikonpaiva(uusiTapahtuma.paivamaara);
            if (tapahtumaPaikkaOnTyhja(uusiTapahtuma)) {
                tapahtumaKalenteri[paiva][uusiTapahtuma.ensimmainenAlkavaTunti] = uusiTapahtuma;
                for (int i = uusiTapahtuma.ensimmainenAlkavaTunti +1; i <= uusiTapahtuma.viimeinenAlkavaTunti; i++) {
                    tapahtumaKalenteri[paiva][i] =  new TapahtumaJatkuu(uusiTapahtuma.ensimmainenAlkavaTunti, uusiTapahtuma.viimeinenAlkavaTunti, uusiTapahtuma.paivamaara, uusiTapahtuma.nimi);
                }
                tapahtumienMaara++;
            }
            yhdistaJatkuvat(paiva, uusiTapahtuma);
            paivitaEnsimmaisenTapahtumanPVM(uusiTapahtuma);
            paivitaViimeisenTapahtumaPVM(uusiTapahtuma);
    }

    private void paivitaEnsimmaisenTapahtumanPVM(Tapahtuma uusiTapahtuma) {
        if (uusiTapahtuma.paivamaara.isBefore(ensimmaisenTapahtumanPVM)) {
            ensimmaisenTapahtumanPVM = uusiTapahtuma.getPaivamaara();
        }
    }

    private void paivitaViimeisenTapahtumaPVM(Tapahtuma uusiTapahtuma) {
        if (uusiTapahtuma.paivamaara.isAfter(viimeisenTapahtumanPVM)) {
            viimeisenTapahtumanPVM = uusiTapahtuma.getPaivamaara();
        }
    }



    /**
     * Tarkistaa, että lisattavan tapahtuman tapahtuma-aikana kalenterissa ei jo ole tapahtumaa
     */
    private boolean tapahtumaPaikkaOnTyhja(Tapahtuma uusiTapahtuma) {
        int paiva = viikonpaiva(uusiTapahtuma.paivamaara);

        for (int i = uusiTapahtuma.ensimmainenAlkavaTunti; i <= uusiTapahtuma.viimeinenAlkavaTunti; i++) {
            if (tapahtumaKalenteri[paiva][i] != null) {
                return false;
            }
        }
        return true;
    }

    /**
     * Jos lisatty tapahtuma on samanniminen kuin sitä suoraan edeltävä tapahtuma tai siitä
     * suoraan jatkuva tapahtuma. Yhdistetään ne yhdeksi tapahtumaksi.
     * @return tehtiinko yhdistys
     */
    public boolean yhdistaJatkuvat (int paiva, Tapahtuma uusiTapahtuma) {
        if (uusiTapahtuma.ensimmainenAlkavaTunti > 0) {
        Tapahtuma edellinenTapahtuma = tapahtumaKalenteri[paiva][uusiTapahtuma.ensimmainenAlkavaTunti -1];
        if (edellinenTapahtuma != null) {
            String edellisenTapahtumanNimi = edellinenTapahtuma.getNimi();
            if (edellisenTapahtumanNimi.equals(uusiTapahtuma.nimi)) {
                yhdistaTapahtumaEdelliseen(paiva, uusiTapahtuma);
                return true;
            }
        }
        }
        if (uusiTapahtuma.viimeinenAlkavaTunti < 23) {
            Tapahtuma seuraavaTapahtuma = tapahtumaKalenteri[paiva][uusiTapahtuma.viimeinenAlkavaTunti + 1] ;
            if (seuraavaTapahtuma != null) {
                String seuraavanTapahtumanNimi = seuraavaTapahtuma.getNimi();
                if (seuraavanTapahtumanNimi.equals(uusiTapahtuma.nimi)) {
                    yhdistaTapahtumaSeuraavaan(paiva, uusiTapahtuma);
                    return true;
                }
            }
        }

        return false;
    }

    private void yhdistaTapahtumaEdelliseen(int paiva, Tapahtuma uusiTapahtuma) {
        Tapahtuma edellinenTapahtuma = tapahtumaKalenteri[paiva][uusiTapahtuma.ensimmainenAlkavaTunti -1];

        tapahtumaKalenteri[paiva][uusiTapahtuma.ensimmainenAlkavaTunti] = new TapahtumaJatkuu(edellinenTapahtuma.ensimmainenAlkavaTunti, edellinenTapahtuma.viimeinenAlkavaTunti, edellinenTapahtuma.paivamaara, edellinenTapahtuma.nimi);
    }


    private void yhdistaTapahtumaSeuraavaan(int paiva, Tapahtuma uusiTapahtuma) {
        Tapahtuma seuraavaTapahtuma = tapahtumaKalenteri[paiva][uusiTapahtuma.viimeinenAlkavaTunti + 1];
        tapahtumaKalenteri[paiva][seuraavaTapahtuma.ensimmainenAlkavaTunti] = new TapahtumaJatkuu(uusiTapahtuma.ensimmainenAlkavaTunti, uusiTapahtuma.viimeinenAlkavaTunti, uusiTapahtuma.paivamaara, seuraavaTapahtuma.nimi);
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
               if (tapahtumaKalenteri[i][j] != null && tapahtumaKalenteri[i][j].ensimmainenAlkavaTunti < aikaisinTapahtuma) {
                   aikaisinTapahtuma = tapahtumaKalenteri[i][j].ensimmainenAlkavaTunti;
               }
           }
       }

       return aikaisinTapahtuma;
    }

    /**
     * Palauttaa kalenterin myohaisimman tapahtuman viimeisen alkavan tunnin
     * @return {int} myohaisimman tapahtuman kellonaika. Jos kalenterissa ei ole tapahtumia palauttaa -1
     */
    public int myohaisinTapahtuma() {
       int myohaisinTapahtumanAlkavaTunti = -1;

       for (int i = 0; i < tapahtumaKalenteri.length; i++) {
           for (int j = 0; j < tapahtumaKalenteri[i].length; j++) {
               if (tapahtumaKalenteri [i][j]!= null && j > myohaisinTapahtumanAlkavaTunti) {
                   myohaisinTapahtumanAlkavaTunti =  j ;
               }
           }
       }

        return myohaisinTapahtumanAlkavaTunti;
    }


    /**
     * True jos annetun kellonajan aikana on jo olemassaoleva tapahtuma
     * @param paiva jota tutkitaan
     * @param kellonaika jota tutkitaan
     * @return True jos annetun kellonajan aikana on jo olemassaoleva tapahtuma
     */
    public boolean tapahtumaJatkuu(int paiva, int kellonaika) {
        if (tapahtumaKalenteri[paiva][kellonaika] == null) {
            return false;
        }

        return tapahtumaKalenteri[paiva][kellonaika].getClass().getSimpleName().equals("TapahtumaJatkuu");
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

   public int getTapahtumienMaara() {
        return this.tapahtumienMaara;
    }

   public void setOtsikkoRivi(String otsikko) {
        this.otsikko = otsikko;
   }

   public LocalDate getEnsimmaisenTapahtumanPVM() {
        return ensimmaisenTapahtumanPVM;
   }

   public LocalDate getViimeisenTapahtumanPVM() {
        return viimeisenTapahtumanPVM;
   }
}