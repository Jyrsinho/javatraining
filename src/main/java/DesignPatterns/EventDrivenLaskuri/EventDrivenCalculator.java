package DesignPatterns.EventDrivenLaskuri;

import java.util.Scanner;

public class EventDrivenCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EventBroker eventBroker = new EventBroker();
        Calculator calculator = new Calculator();
        eventBroker.addListener(calculator);

        while (true) {
            System.out.print("Syötä luku 1: ");
            double luku1 = scanner.nextDouble();
            System.out.print("Syötä laskutoimitus (+ tai -): ");
            String operaattori = scanner.next();
            System.out.print("Syötä luku 2: ");
            double luku2 = scanner.nextDouble();

            // Luo tapahtuma ja välitä se käsittelijälle
            CalculationEvent event = new CalculationEvent(operaattori, luku1, luku2);
            dispatcher.dispatchEvent(event);
        }
    }
}