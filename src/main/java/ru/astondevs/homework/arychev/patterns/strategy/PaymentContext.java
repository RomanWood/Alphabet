package ru.astondevs.homework.arychev.patterns.strategy;

public class PaymentContext {
    private PaymentStrategy strategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * payment process
     * @param amount
     */
    public void processPayment(double amount) {
        strategy.pay(amount);
    }
}