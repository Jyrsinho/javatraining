package DesignPatterns.EventDrivenLaskuri;


public class Calculator implements MyEventListener {

    @Override
    public void onEvent(CalculationEvent event) {
        switch (event.laskutoimitus) {
            case "+":
                event.tulos = event.luku1 + event.luku2;
                break;
            case "-":
                event.tulos = event.luku1 - event.luku2;
                break;
            case "*":
                event.tulos = event.luku1 * event.luku2;
                break;
            case "/":
                event.tulos = event.luku1 / event.luku2;
                break;
            default:
                throw new IllegalArgumentException("Invalid laskutoimitus: " + event.laskutoimitus);

        }
    }
}
