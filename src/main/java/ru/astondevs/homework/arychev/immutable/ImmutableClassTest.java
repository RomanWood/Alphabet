package ru.astondevs.homework.arychev.immutable;

public class ImmutableClassTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        String mutableData = "MutableClonableClass";
        MutableClonableClass mutableClonableClass = new MutableClonableClass(mutableData);
        System.out.println("1. Создали мутабельный с данными = "
                + mutableClonableClass.getData());

        ImmutableClass immutableClass = new ImmutableClass(mutableClonableClass, "ImmutableClass");
        System.out.println("2. Создали иммутабельный с данными мутабельного = "
                + immutableClass.getMutableClonableClass().getData());

        mutableClonableClass.setData("mutate");
        System.out.println("3. Изменили данные мутабельного по ссылке на:"
                + mutableClonableClass.getData());

        //ссылки поменялись
        System.out.println("4. Сравнили объекты класса иммутабельного и изменённого: "
                + immutableClass.getMutableClonableClass().equals(mutableClonableClass));
        //значения внутри поля не равны
        System.out.println("5. Сравнили данные поля объекта иммутабельного класса с изменёнными: "
                + immutableClass.getMutableClonableClass().getData().equals(mutableClonableClass.getData()));

        System.out.println("6. В иммутабельном без изменений: " + immutableClass.getMutableClonableClass().getData());
    }
}
