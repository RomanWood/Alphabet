package ru.astondevs.homework.arychev.immutable;

import lombok.Getter;
import lombok.Setter;

/**
 * Mutable, есть сеттер поля
 */
public class MutableClass implements Cloneable {
    @Getter
    @Setter
    private String data;

    public MutableClass(String data) {
        this.data = data;
    }

    @Override
    public MutableClass clone() {
        try {
            return (MutableClass) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
