package ru.astondevs.homework.arychev.patterns.strategy;

/**
 * СБП Payment implementation class
 */
class SBPPayment implements PaymentStrategy {
    private String email;

    public SBPPayment(String email) {
        this.email = email;
    }

    public void pay(double amount) {
        System.out.println("Перевод СБП на сумму: RUR " + amount);
    }
}