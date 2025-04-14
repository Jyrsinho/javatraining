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
}
