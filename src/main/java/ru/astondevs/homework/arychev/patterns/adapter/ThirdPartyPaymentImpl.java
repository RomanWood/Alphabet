package ru.astondevs.homework.arychev.patterns.adapter;


import java.math.BigDecimal;

/**
 * Сторонняя платежная система
 */
public class ThirdPartyPaymentImpl implements ThirdPartyPayment {
    @Override
    public void makePayment(String transactionId, BigDecimal paymentAmount) {
        System.out.println("Making payment with transaction ID " + transactionId
                + " for amount $" + paymentAmount);
    }
}