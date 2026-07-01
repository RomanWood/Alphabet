package ru.astondevs.homework.arychev.patterns.adapter;


import java.math.BigDecimal;

/**
 * Класс для обработки платежей в нашей системе
 */
public class PaymentProcessorImpl implements PaymentProcessor {
    @Override
    public void processPayment(String orderId, BigDecimal amount) {
        System.out.println("Processing payment for order " + orderId + " with amount $" + amount);
    }
}