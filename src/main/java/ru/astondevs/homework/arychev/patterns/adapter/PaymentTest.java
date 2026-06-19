package ru.astondevs.homework.arychev.patterns.adapter;

// Использование
public class PaymentTest {

    public static void main(String[] args) {
        PaymentProcessor myPaymentProcessor = new PaymentProcessorImpl();
        myPaymentProcessor.processPayment("12345", 100.00);

        ThirdPartyPayment thirdPartyPayment = new ThirdPartyPaymentImpl();

        PaymentProcessor adapter = new PaymentSystemAdapter(thirdPartyPayment);
        adapter.processPayment("54321", 50.00);
    }
}