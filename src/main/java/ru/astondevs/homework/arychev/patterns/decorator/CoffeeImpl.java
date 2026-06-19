package ru.astondevs.homework.arychev.patterns.decorator;

// Конкретный компонент
class CoffeeImpl implements Coffee {

    @Override
    public double getCost() {
        return 1.0;
    }
    @Override
    public String getDescription() {
        return "Простой кофе";
    }
}