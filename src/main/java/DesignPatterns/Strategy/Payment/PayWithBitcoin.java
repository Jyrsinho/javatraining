package DesignPatterns.Strategy.Payment;

public class PayWithBitcoin implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println("Paid with bitcoin " + amount);
    }
}
