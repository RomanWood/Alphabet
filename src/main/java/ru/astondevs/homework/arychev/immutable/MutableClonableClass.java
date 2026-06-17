package ru.astondevs.homework.arychev.immutable;

import lombok.Getter;
import lombok.Setter;

/**
 * Mutable, есть сеттер поля
 */
public class MutableClonableClass implements Cloneable {

    @Getter
    @Setter
    private String data;

    public MutableClonableClass(String data) {
        this.data = data;
    }

    @Override
    public MutableClonableClass clone() {
        try {
            return (MutableClonableClass) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
