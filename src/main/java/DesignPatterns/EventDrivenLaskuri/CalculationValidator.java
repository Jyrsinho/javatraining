package DesignPatterns.EventDrivenLaskuri;

import java.util.Objects;

public class CalculationValidator implements MyEventListener {
    @Override
    public void onEvent(CalculationEvent event) {
        if (!Objects.equals(event.laskutoimitus, "+") && !Objects.equals(event.laskutoimitus, "-")
                && !Objects.equals(event.laskutoimitus, "*") && !Objects.equals(event.laskutoimitus, "/")) {
            throw new Error("laiton laskutoimitus");
        }
    }
}
