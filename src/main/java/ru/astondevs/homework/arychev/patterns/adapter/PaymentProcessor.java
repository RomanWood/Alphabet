package ru.astondevs.homework.arychev.patterns.adapter;


import java.math.BigDecimal;

/**
 * Интерфейс для обработки платежей в нашей системе
 */
public interface PaymentProcessor {
    void processPayment(String orderId, BigDecimal amount);
}