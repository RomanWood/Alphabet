package ru.astondevs.homework.arychev.patterns.builder;

interface PizzaBuilder {
    PizzaBuilder selectPizzaType(String type);

    PizzaBuilder addExtraCheese(boolean isExtraCheese);

    PizzaBuilder addExtraSauce(boolean isExtraSauce);

    Pizza build();
}