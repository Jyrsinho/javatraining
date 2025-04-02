package AlgorithmsTwo.LukuJarjestys;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Kalenteri {
    String[][] tapahtumaKalenteri;

    public Kalenteri(int paivia, int tunteja) {
        this.tapahtumaKalenteri = new String[paivia][tunteja];
    }


    public void lisaaTapahtuma(Tapahtuma uusiTapahtuma) {
        int paiva = viikonpaiva(uusiTapahtuma.paivamaara);

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
        return new TapahtumaEiOlemassa();
    }

    /**
     * Palauttaa tapahtuman paivamaaraa vastaavan viikonpaivan.
     * @param pvm {String} jolle haetaan viikonpaiva
     * @return viikonpaivan jarjestysnumero. Maanantai on 0, perjantai 5 ja vkloput -1.
     */
   public int viikonpaiva(String pvm) {
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
       LocalDate date = LocalDate.parse(pvm, formatter);
      DayOfWeek dayOfWeek = date.getDayOfWeek();
       return switch (dayOfWeek) {
           case MONDAY -> 0;
           case TUESDAY -> 1;
           case WEDNESDAY -> 2;
           case THURSDAY -> 3;
           case FRIDAY -> 4;
           default -> -1;
       };
   }
}
