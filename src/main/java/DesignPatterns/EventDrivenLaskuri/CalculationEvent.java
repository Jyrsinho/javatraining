package DesignPatterns.EventDrivenLaskuri;

public class CalculationEvent {

    public String laskutoimitus;
    public double luku1;
    public double luku2;
    public double tulos;

    public CalculationEvent(String laskutoimitus, double luku1, double luku2) {
        this.laskutoimitus = laskutoimitus;
        this.luku1 = luku1;
        this.luku2 = luku2;
    }

}
