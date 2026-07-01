package ru.astondevs.homework.arychev.patterns.decorator;

import java.math.BigDecimal;

public class SugarDecorator extends CoffeeDecorator {

    BigDecimal SUGAR_EXTRA_COST = BigDecimal.valueOf(0.2);

    public SugarDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(SUGAR_EXTRA_COST);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", сахар";
    }
}