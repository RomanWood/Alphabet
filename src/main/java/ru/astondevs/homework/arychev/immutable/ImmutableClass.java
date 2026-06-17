package ru.astondevs.homework.arychev.immutable;

import lombok.Getter;

public final class ImmutableClass {

    @Getter
    private String data;
    @Getter
    private final MutableClonableClass mutableClonableClass;

    public ImmutableClass(MutableClonableClass mutableClonableClass, String data) {
        this.mutableClonableClass = mutableClonableClass.clone();
        this.data = data;
    }
}
