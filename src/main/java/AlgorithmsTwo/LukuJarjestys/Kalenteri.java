package AlgorithmsTwo.LukuJarjestys;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

import static AlgorithmsTwo.LukuJarjestys.Utils.*;

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

        alustaKalenteri();
        lisaaTapahtumat(tapahtumat);
        analysoiRuudut();
    }

   public ArrayList<Tapahtuma> poikkeukset() {
        ArrayList<Tapahtuma> poikkeukset = new ArrayList<>();
        return poikkeukset;
   }

   private void analysoiRuudut() {
       for (int i = 0; i < tapahtumaKalenteri.length; i++) {
           for (int j = 0; j < tapahtumaKalenteri[i].length; j++) {
               tapahtumaKalenteri[i][j].analysoi();
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



   private void lisaaTapahtuma(Tapahtuma uusiTapahtuma) {
        int paiva = viikonpaiva(uusiTapahtuma.paivamaara);

        for (int i = uusiTapahtuma.ensimmainenAlkavaTunti; i <= uusiTapahtuma.viimeinenAlkavaTunti ; i++) {
            tapahtumaKalenteri[paiva][i].lisaa(uusiTapahtuma);
            tapahtumienMaara++;
        }

    }


    private void alustaKalenteri() {
        for (int i = 0; i < tapahtumaKalenteri.length; i++) {
            LocalDate paivanEnsimmainenToisto = etsiPaivanSeuraavaToisto(ensimmaisenTapahtumanPVM, i);
            LocalDate paivanViimeinenToisto = etsiPaivanEdellinenToisto(viimeisenTapahtumanPVM, i);
            for (int j = 0; j < tapahtumaKalenteri[i].length; j++) {
                //TODO: TÄMÄ KORJATTAVA NIIN, ETTÄ KALENTERI ANTAA AIKATAULURUUDULLE SEN ENSIMMÄISEN PÄIVÄN JA VIIMEISEN PAIVAN sekä tunnin
                tapahtumaKalenteri[i][j] = new AikatauluRuutu(paivanEnsimmainenToisto, paivanViimeinenToisto, j);
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
               if (!Objects.equals(tapahtumaKalenteri[i][j].getSaannollinen(), "EiTapahtumaa") && j < aikaisinTapahtuma) {
                   aikaisinTapahtuma = j;
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
               if (!Objects.equals(tapahtumaKalenteri[i][j].saannollinen, "EiTapahtumaa") && j > myohaisinTapahtumanAlkavaTunti) {
                   myohaisinTapahtumanAlkavaTunti =  j ;
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