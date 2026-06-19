package ru.astondevs.homework.arychev.patterns.builder;

public class PizzaBuilderTest {

    public static void main(String[] args) {
        PizzaBuilder pizzaBuilder = new PizzaBuilderImpl();
        Pizza pizza = pizzaBuilder
                .selectPizzaType("4cheese")
                .addExtraCheese(true)
                .addExtraSauce(false)
                .build();

        System.out.println("Pizza :\n" + pizza.toString());
    }
}