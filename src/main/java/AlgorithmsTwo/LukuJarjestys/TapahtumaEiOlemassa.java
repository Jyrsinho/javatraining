package AlgorithmsTwo.LukuJarjestys;

import java.time.LocalDate;

public class TapahtumaEiOlemassa extends Tapahtuma{
    public TapahtumaEiOlemassa() {
        super(0,0, LocalDate.MIN, "");
    }
}
