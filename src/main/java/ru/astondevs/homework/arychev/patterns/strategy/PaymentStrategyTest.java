package ru.astondevs.homework.arychev.patterns.strategy;

public class PaymentStrategyTest {

    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        PaymentStrategy creditCardPayment = new CreditCardPayment("1234-5678-9012-3456", "12/30");
        context.setPaymentStrategy(creditCardPayment);
        context.processPayment(100.0);

        PaymentStrategy sbpPayment = new SBPPayment("user@example.com");
        context.setPaymentStrategy(sbpPayment);
        context.processPayment(50.0);
    }
}

