package AlgorithmsTwo.LukuJarjestys;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Utils {

    /**
     * Palauttaa tapahtuman paivamaaraa vastaavan viikonpaivan.
     * @param pvm {String} jolle haetaan viikonpaiva
     * @return viikonpaivan jarjestysnumero. Maanantai on 0, perjantai 5 ja vkloput -1.
     */
    public static int viikonpaiva(LocalDate pvm) {

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
     * Selvittaa kalenterin ensimmaisesta paivasta, milloin annetun viikonpaivan ensimmainen esiintyma on
     * kalenterissa
     * @return annetun viikonpaivan ensimmainen esiintyma kalenterissa
     */
    public static LocalDate etsiPaivanSeuraavaToisto(LocalDate paiva, int vkpaivanIndeksi) {
        int offset = 0;
        int lahtoPaivanIndeksi = viikonpaiva(paiva);
        if (vkpaivanIndeksi > lahtoPaivanIndeksi) {
           offset = vkpaivanIndeksi - lahtoPaivanIndeksi;
        } else {
            offset = 7 - (lahtoPaivanIndeksi - vkpaivanIndeksi);
        }

        return paiva.plusDays(offset);
    }

    public static LocalDate etsiPaivanEdellinenToisto(LocalDate paiva, int vkpaivanIndeksi) {
        int offset = 0;
        int lahtoPaivanIndeksi = viikonpaiva(paiva);

        if (vkpaivanIndeksi < lahtoPaivanIndeksi) {
            offset = lahtoPaivanIndeksi - vkpaivanIndeksi;
        } else {
            offset = 7 - (vkpaivanIndeksi - lahtoPaivanIndeksi);
        }

        return paiva.minusDays(offset);
    }
}
