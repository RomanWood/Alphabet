package ru.astondevs.homework.arychev.patterns.decorator;

import java.math.BigDecimal;

// Конкретные декораторы
public class MilkDecorator extends CoffeeDecorator {

    BigDecimal MILK_EXTRA_COST = BigDecimal.valueOf(0.5);

    public MilkDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(MILK_EXTRA_COST);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", молоко";
    }
}