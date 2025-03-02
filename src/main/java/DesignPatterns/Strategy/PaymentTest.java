package DesignPatterns.Strategy;

public class PaymentTest {

    public static void main(String[] args) {
        double price = 20.00;
        PayWithBitcoin payWithBitcoin = new PayWithBitcoin();

        Payment payment = new Payment(payWithBitcoin);
        payment.pay(price);
        PayWithCreditCard payWithCreditCard = new PayWithCreditCard();
        payment.setPaymentStrategy(payWithCreditCard);
        payment.pay(price);

    }
}
