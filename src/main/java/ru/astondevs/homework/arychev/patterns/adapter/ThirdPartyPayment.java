package ru.astondevs.homework.arychev.patterns.adapter;


/**
 * Интерфейс какой-то платежной системы
 */
public interface ThirdPartyPayment {
    void makePayment(String transactionId, double paymentAmount);
}
