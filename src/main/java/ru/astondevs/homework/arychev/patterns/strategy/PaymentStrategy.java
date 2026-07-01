package ru.astondevs.homework.arychev.patterns.strategy;

/**
 * Интерфейс стратегии для выбора платежной системы
 */
public interface PaymentStrategy {

    /**
     * Логика для оплаты
     * @param amount  - сумма денег
     */
    void pay(double amount);
}