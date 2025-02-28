package DesignPatterns.EventDrivenLaskuri;

public class ResultDisplayer implements MyEventListener{
    @Override
    public void onEvent(CalculationEvent event) {
        System.out.println("Laskutoimituksen " +event.luku1 + " " + event.laskutoimitus + " " + event.luku2 +" tulos on : " +event.tulos);
    }
}
