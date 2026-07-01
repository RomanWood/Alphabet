package ru.astondevs.homework.arychev.patterns;

import ru.astondevs.homework.arychev.patterns.adapter.*;
import ru.astondevs.homework.arychev.patterns.builder.Pizza;
import ru.astondevs.homework.arychev.patterns.chainofresponsibility.*;
import ru.astondevs.homework.arychev.patterns.decorator.Coffee;
import ru.astondevs.homework.arychev.patterns.decorator.CoffeeImpl;
import ru.astondevs.homework.arychev.patterns.decorator.MilkDecorator;
import ru.astondevs.homework.arychev.patterns.decorator.SugarDecorator;
import ru.astondevs.homework.arychev.patterns.proxy.Picture;
import ru.astondevs.homework.arychev.patterns.proxy.ProxyPicture;
import ru.astondevs.homework.arychev.patterns.proxy.RealPicture;
import ru.astondevs.homework.arychev.patterns.strategy.CreditCardPayment;
import ru.astondevs.homework.arychev.patterns.strategy.PaymentContext;
import ru.astondevs.homework.arychev.patterns.strategy.PaymentStrategy;
import ru.astondevs.homework.arychev.patterns.strategy.SBPPayment;

import java.math.BigDecimal;

public class PatternsDemo {

    public static void main(String[] args) {
        paymentAdapterDemo();
        pizzaBuilderDemo();
        chainOfResponsibilityDemo();
        coffeeDecoratorDemo();
        proxyPictureDemo();
        paymentStrategyDemo();
    }

    private static void paymentAdapterDemo() {
        PaymentProcessor myPaymentProcessor = new PaymentProcessorImpl();
        myPaymentProcessor.processPayment("12345", BigDecimal.valueOf(100.00));

        ThirdPartyPayment thirdPartyPayment = new ThirdPartyPaymentImpl();

        PaymentProcessor adapter = new PaymentSystemAdapter(thirdPartyPayment);
        adapter.processPayment("54321", BigDecimal.valueOf(50.00));
    }

    private static void pizzaBuilderDemo() {
        Pizza pizza = new Pizza.Builder()
                .selectPizzaType("4cheese")
                .addExtraCheese(true)
                .addExtraSauce(false)
                .build();

        System.out.println("Pizza :\n" + pizza.toString());
    }

    public static void chainOfResponsibilityDemo() {
        RequestHandler handler1 = new ConcreteHandler1();
        RequestHandler handler2 = new ConcreteHandler2();
        RequestHandler handler3 = new ConcreteHandler3();

        handler1.setNextHandler(handler2);
        handler2.setNextHandler(handler3);

        Request request1 = new Request(RequestType.TYPE1);
        Request request2 = new Request(RequestType.TYPE2);
        Request request3 = new Request(RequestType.TYPE3);

        handler1.handleRequest(request1);
        handler1.handleRequest(request2);
        handler1.handleRequest(request3);

        handler2.handleRequest(request1);
        handler2.handleRequest(request2);
        handler2.handleRequest(request3);

        handler3.handleRequest(request1);
        handler3.handleRequest(request2);
        handler3.handleRequest(request3);
    }

    public static void coffeeDecoratorDemo() {

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

    public static void proxyPictureDemo() {
        Picture image = new RealPicture("image.png");
        image.display();

        // реальное изображение не загружается
        Picture picture1 = new ProxyPicture("image1.jpg");
        Picture picture2 = new ProxyPicture("image2.jpg");

        // Изображение будет загружено только при вызове display()
        picture1.display();

        // Изображение уже загружено, повторная загрузка не требуется
        picture1.display();

        // Изображение 2 загружается только в этот момент
        picture2.display();
    }

    public static void paymentStrategyDemo() {
        PaymentContext context = new PaymentContext();

        PaymentStrategy creditCardPayment = new CreditCardPayment("1234-5678-9012-3456", "12/30");
        context.setPaymentStrategy(creditCardPayment);
        context.processPayment(100.0);

        PaymentStrategy sbpPayment = new SBPPayment("user@example.com");
        context.setPaymentStrategy(sbpPayment);
        context.processPayment(50.0);
    }
}
