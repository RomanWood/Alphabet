package ru.astondevs.homework.arychev.patterns.adapter;


import java.math.BigDecimal;

/**
 * Интерфейс какой-то платежной системы
 */
public interface ThirdPartyPayment {
    void makePayment(String transactionId, BigDecimal paymentAmount);
}
