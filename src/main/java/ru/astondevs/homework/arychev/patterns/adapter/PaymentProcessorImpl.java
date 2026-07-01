package ru.astondevs.homework.arychev.patterns.adapter;


/**
 * Класс для обработки платежей в нашей системе
 */
public class PaymentProcessorImpl implements PaymentProcessor {
    @Override
    public void processPayment(String orderId, double amount) {
        System.out.println("Processing payment for order " + orderId + " with amount $" + amount);
    }
}