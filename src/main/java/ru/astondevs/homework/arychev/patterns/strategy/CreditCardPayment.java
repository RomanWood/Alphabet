package ru.astondevs.homework.arychev.patterns.strategy;

class CreditCardPayment implements PaymentStrategy {
    private final String cardNumber;
    private final String expiryDate;

    public CreditCardPayment(String cardNumber, String expiryDate) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
    }

    public void pay(double amount) {
        System.out.println("Оплата с использованием кредитной карты на сумму: $" + amount);
    }
}