package ru.astondevs.homework.arychev.patterns.adapter;


/**
 * Интерфейс для обработки платежей в нашей системе
 */
public interface PaymentProcessor {
    void processPayment(String orderId, double amount);
}