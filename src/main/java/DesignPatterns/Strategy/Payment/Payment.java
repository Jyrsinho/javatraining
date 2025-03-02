package DesignPatterns.Strategy.Payment;

public class Payment {

    PaymentStrategy strategy;

    public Payment(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void pay(double amount) {
        this.strategy.pay(amount);
    }

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }
}
