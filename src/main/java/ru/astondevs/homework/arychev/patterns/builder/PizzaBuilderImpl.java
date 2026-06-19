package ru.astondevs.homework.arychev.patterns.builder;

class PizzaBuilderImpl implements PizzaBuilder {
    private String pizzaType;
    private boolean isExtraCheese;
    private boolean isExtraSauce;

    @Override
    public PizzaBuilder selectPizzaType(String type) {
        this.pizzaType = type;
        return this;
    }

    @Override
    public PizzaBuilder addExtraCheese(boolean isExtraCheese) {
        this.isExtraCheese = isExtraCheese;
        return this;
    }

    @Override
    public PizzaBuilder addExtraSauce(boolean isExtraSauce) {
        this.isExtraSauce = isExtraSauce;
        return this;
    }

    @Override
    public Pizza build() {
        return new Pizza(pizzaType, isExtraCheese, isExtraSauce);
    }
}