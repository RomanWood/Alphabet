package ru.astondevs.homework.arychev.immutable;

public class ImmutableClassTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        String mutableData = "MutableClonableClass";
        MutableClass mutableClass = new MutableClass(mutableData);
        System.out.println("1. Создали мутабельный с данными = "
                + mutableClass.getData());

        ImmutableClass immutableClass = new ImmutableClass(mutableClass, "ImmutableClass");
        System.out.println("2. Создали иммутабельный с данными мутабельного = "
                + immutableClass.getMutableClass().getData());

        mutableClass.setData("mutate");
        System.out.println("3. Изменили данные мутабельного по ссылке на:"
                + mutableClass.getData());

        System.out.println("4. Сравнили объекты класса иммутабельного и изменённого: "
                + immutableClass.getMutableClass().equals(mutableClass));

        System.out.println("5. Сравнили данные поля объекта иммутабельного класса с изменёнными: "
                + immutableClass.getMutableClass().getData().equals(mutableClass.getData()));

        System.out.println("6. В иммутабельном без изменений: " + immutableClass.getMutableClass().getData());
    }
}
