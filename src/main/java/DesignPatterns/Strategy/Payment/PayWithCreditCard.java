package DesignPatterns.Strategy.Payment;

public class PayWithCreditCard implements PaymentStrategy {


    @Override
    public void pay(double amount) {
        System.out.println("Paid with credit card " + amount);
    }
}
