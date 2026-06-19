package ru.astondevs.homework.arychev.patterns.decorator;

public class CoffeeDecoratorTest {

    public static void main(String[] args) {

        // Создаем простой кофе
        Coffee coffee = new CoffeeImpl();
        System.out.println("Простой кофе: " + coffee.getDescription() + ", стоимость: $" + coffee.getCost());

        // Добавляем молоко
        coffee = new MilkDecorator(coffee);
        System.out.println("Кофе с молоком: " + coffee.getDescription() + ", стоимость: $" + coffee.getCost());

        // Добавляем сахар
        coffee = new SugarDecorator(coffee);
        System.out.println("Кофе с молоком и сахаром: " + coffee.getDescription() + ", стоимость: $" + coffee.getCost());
    }
}