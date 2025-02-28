package DesignPatterns.EventDrivenLaskuri;

import java.util.Scanner;

public class EventDrivenCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EventBroker eventBroker = new EventBroker();
        CalculationValidator validator = new CalculationValidator();
        Calculator calculator = new Calculator();
        ResultDisplayer resultDisplayer = new ResultDisplayer();
        eventBroker.addListener(validator);
        eventBroker.addListener(calculator);
        eventBroker.addListener(resultDisplayer);

        while (true) {
            System.out.print("Syötä luku 1: ");
            double luku1 = scanner.nextDouble();
            System.out.print("Syötä laskutoimitus (+ tai -): ");
            String operaattori = scanner.next();
            System.out.print("Syötä luku 2: ");
            double luku2 = scanner.nextDouble();

            // Luo tapahtuma ja välitä se käsittelijälle
            CalculationEvent event = new CalculationEvent(operaattori, luku1, luku2);
            eventBroker.dispatchEvent(event);
        }
    }
}