package ru.astondevs.homework.arychev.patterns.decorator;

import java.math.BigDecimal;

// Конкретный компонент
public class CoffeeImpl implements Coffee {
    BigDecimal STANDARD_COST = BigDecimal.valueOf(1.0);

    @Override
    public BigDecimal getCost() {
        return STANDARD_COST;
    }
    @Override
    public String getDescription() {
        return "Простой кофе";
    }
}
