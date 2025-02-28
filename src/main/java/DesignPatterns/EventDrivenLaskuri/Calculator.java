package DesignPatterns.EventDrivenLaskuri;

public class Calculator {

    public double count(CalculationEvent event) {
        return switch (event.laskutoimitus) {
            case "+" -> event.luku1 + event.luku2;
            case "-" -> event.luku1 - event.luku2;
            case "*" -> event.luku1 * event.luku2;
            case "/" -> event.luku1 / event.luku2;
            default -> throw new IllegalArgumentException("Invalid laskutoimitus: " + event.laskutoimitus);
        };
    }

}
