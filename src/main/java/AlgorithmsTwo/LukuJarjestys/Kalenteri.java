package AlgorithmsTwo.LukuJarjestys;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

import static AlgorithmsTwo.LukuJarjestys.Utils.viikonpaiva;

public class Kalenteri {
    private  AikatauluRuutu[][] tapahtumaKalenteri;
    private String otsikko;
    private int tapahtumienMaara;
    private LocalDate ensimmaisenTapahtumanPVM;
    private LocalDate viimeisenTapahtumanPVM;



    public Kalenteri(int paivia, int tunteja) {
        this.tapahtumaKalenteri = new AikatauluRuutu[paivia][tunteja];
        this.otsikko = "";
        this.ensimmaisenTapahtumanPVM = LocalDate.MAX;
        this.viimeisenTapahtumanPVM = LocalDate.MIN;
        this.tapahtumienMaara = 0;

    }


    public void paivitaKalenteri(ArrayList<Tapahtuma> tapahtumat) {
        paivitaKalenterinEnsimmainenJaViimeinenPaiva(tapahtumat);
        // lisataan aikatauluruutu kaikille tunneille joilla on tapahtumia
        lisaaTapahtumat(tapahtumat);
        // kaydaan lapi aikatauluruudut ja asetetaan nille oikeat arvot poikkeuksiin ja saannollisiin tapahtumiin
        analysoiAikatauluRuudut();

    }

    public void lisaaTapahtuma(Tapahtuma uusiTapahtuma) {
        int paiva = viikonpaiva(uusiTapahtuma.paivamaara);

        for (int i = uusiTapahtuma.ensimmainenAlkavaTunti; i <= uusiTapahtuma.viimeinenAlkavaTunti ; i++) {
            if (tapahtumaKalenteri [paiva][i] != null) {
                tapahtumaKalenteri[paiva][i].lisaa(uusiTapahtuma);
            } else {
                tapahtumaKalenteri[paiva][i] = new AikatauluRuutu(ensimmaisenTapahtumanPVM, viimeisenTapahtumanPVM, paiva);
            }
            tapahtumienMaara++;

        }

    }



    private void analysoiAikatauluRuudut() {
        for (int i = 0; i < tapahtumaKalenteri.length; i++) {
            for (int j = 0; j < tapahtumaKalenteri[i].length; j++) {
                if (tapahtumaKalenteri[i][j] != null) {
                    tapahtumaKalenteri[i][j].analysoi();
                }
            }
        }
    }

    private void lisaaTapahtumat(ArrayList<Tapahtuma> tapahtumat) {
        for (Tapahtuma tapahtuma: tapahtumat) {
            lisaaTapahtuma(tapahtuma);
        }
    }


    private void paivitaKalenterinEnsimmainenJaViimeinenPaiva(ArrayList<Tapahtuma> tapahtumat) {
        for (Tapahtuma tapahtuma: tapahtumat) {
            if (tapahtuma.paivamaara.isBefore(ensimmaisenTapahtumanPVM)) {
                ensimmaisenTapahtumanPVM = tapahtuma.paivamaara;
            }
            if (tapahtuma.paivamaara.isAfter(viimeisenTapahtumanPVM)){
                viimeisenTapahtumanPVM = tapahtuma.paivamaara;
            }
        }
    }






    /**
     * Palauttaa parametrina annettua paivaa ja tuntia vastaavan saannollisen tapahtuman kalenterista, jos siella sellainen on.
     * Jos ei ole saannollista tapahtumaa, palautetaan tyhja merkkijono
     * Maanantain indeksi on 0, perjantain 4.
     * Jos kyseisessä aikaikkunassa ei ole tapahtumaa palautetaan PoikkeusTapahtuma
     * @param paiva jolloin tapahtuma tapahtuu
     * @param tunti jolloin tapahtuma tapahtuu
     * @return Tapahtuma
     */
    public String getTapahtuma(int paiva, int tunti) {
        AikatauluRuutu valittu = tapahtumaKalenteri[paiva][tunti];

        return valittu.getSaannollinen();
    }


    /**
     * Palauttaa kalenterin aikaisimman tapahtuman kellonajan
     * @return {int} aikaisimman tapahtuman kellonaika. Jos kalenterissa ei ole tapahtumia palauttaa 25
     */
   public int aikaisinAlkavaTunti() {
       int aikaisinTapahtuma = 25;

       for (int i = 0; i < tapahtumaKalenteri.length; i++) {
           for (int j = 0; j < tapahtumaKalenteri[i].length; j++) {
               if (tapahtumaKalenteri[i][j] != null) {
                   if (!Objects.equals(tapahtumaKalenteri[i][j].getSaannollinen(), "") && j < aikaisinTapahtuma) {
                       aikaisinTapahtuma = j;
                   }
               }
           }
       }

       return aikaisinTapahtuma;
    }

    /**
     * Palauttaa kalenterin myohaisimman tapahtuman viimeisen alkavan tunnin
     * @return {int} myohaisimman tapahtuman kellonaika. Jos kalenterissa ei ole tapahtumia palauttaa -1
     */
    public int myohaisinAlkavaTunti() {
       int myohaisinTapahtumanAlkavaTunti = -1;

       for (int i = 0; i < tapahtumaKalenteri.length; i++) {
           for (int j = 0; j < tapahtumaKalenteri[i].length; j++) {
               if (tapahtumaKalenteri[i][j] != null) {
                   if (!Objects.equals(tapahtumaKalenteri[i][j].saannollinen, "") && j > myohaisinTapahtumanAlkavaTunti) {
                       myohaisinTapahtumanAlkavaTunti = j;
                   }
               }
           }
       }

        return myohaisinTapahtumanAlkavaTunti;
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

   public AikatauluRuutu[][] getTapahtumaKalenteri() {
        return tapahtumaKalenteri;
   }


   public ArrayList<Tapahtuma> getPoikkeukset() {
        ArrayList<Tapahtuma> poikkeukset = new ArrayList<>();
        for (int i = 0; i < tapahtumaKalenteri.length; i++) {
            for (int j = 0; j < tapahtumaKalenteri[i].length; j++) {
                if (tapahtumaKalenteri[i][j] != null) {
                    ArrayList<Tapahtuma> ruudunPoikkeukset = tapahtumaKalenteri[i][j].poikkeukset;
                    poikkeukset.addAll(ruudunPoikkeukset);
                }
            }
        }
        return poikkeukset;
   }

   public String getOtsikko() {
        return this.otsikko;
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

   public int getTapahtumienMaara (){
        return tapahtumienMaara;
   }
}