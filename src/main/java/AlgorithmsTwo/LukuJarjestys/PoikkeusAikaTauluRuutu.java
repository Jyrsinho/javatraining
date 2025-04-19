package AlgorithmsTwo.LukuJarjestys;

import java.time.LocalDate;

public class PoikkeusAikaTauluRuutu extends AikatauluRuutu{
    public PoikkeusAikaTauluRuutu() {
        super(LocalDate.MIN, LocalDate.MAX, -1);
    }
}
