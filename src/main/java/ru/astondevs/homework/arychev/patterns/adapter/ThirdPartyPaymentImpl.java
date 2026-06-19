package ru.astondevs.homework.arychev.patterns.adapter;


/**
 * Сторонняя платежная система
 */
public class ThirdPartyPaymentImpl implements ThirdPartyPayment {
    @Override
    public void makePayment(String transactionId, double paymentAmount) {
        System.out.println("Making payment with transaction ID " + transactionId
                + " for amount $" + paymentAmount);
    }
}