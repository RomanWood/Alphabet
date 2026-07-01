package ru.astondevs.homework.arychev.patterns.builder;

class Pizza {
    private final String pizzaType;
    private final boolean isExtraCheese;
    private final boolean isExtraSauce;


    public Pizza(String pizzaType, boolean isExtraCheese, boolean isExtraSauce) {
        this.pizzaType = pizzaType;
        this.isExtraCheese = isExtraCheese;
        this.isExtraSauce = isExtraSauce;
    }

    @Override
    public String toString() {
        return "Pizza Type: " + pizzaType + "\n" +
                "Extra Cheese: " + isExtraCheese + "\n" +
                "Extra Sauce: " + isExtraSauce + "\n";
    }
}