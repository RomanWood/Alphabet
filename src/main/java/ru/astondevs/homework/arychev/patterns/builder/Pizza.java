package ru.astondevs.homework.arychev.patterns.builder;

import lombok.ToString;

@ToString
public class Pizza {
    private String pizzaType;
    private boolean isExtraCheese;
    private boolean isExtraSauce;

    public static class Builder {
        private final Pizza pizza;

        public Builder() {
            this.pizza = new Pizza();
        }

        public Builder selectPizzaType(String type) {
            pizza.pizzaType = type;
            return this;
        }

        public Builder addExtraCheese(boolean isExtraCheese) {
            pizza.isExtraCheese = isExtraCheese;
            return this;
        }

        public Builder addExtraSauce(boolean isExtraSauce) {
            pizza.isExtraSauce = isExtraSauce;
            return this;
        }

        public Pizza build() {
            return pizza;
        }
    }
}