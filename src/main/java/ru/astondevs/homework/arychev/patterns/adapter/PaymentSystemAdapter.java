package ru.astondevs.homework.arychev.patterns.adapter;


import java.math.BigDecimal;
import java.util.UUID;

/**
 * Адаптер для интеграции какой-то платежной системы с нашей
 */
public class PaymentSystemAdapter implements PaymentProcessor {
    private final ThirdPartyPayment thirdPartyPayment;

    public PaymentSystemAdapter(ThirdPartyPayment thirdPartyPayment) {
        this.thirdPartyPayment = thirdPartyPayment;
    }

    @Override
    public void processPayment(String orderId, BigDecimal amount) {
        thirdPartyPayment.makePayment(generateTransactionId(), amount);
    }

    private String generateTransactionId() {
        return "TRN" + System.currentTimeMillis() + UUID.randomUUID();
    }
}