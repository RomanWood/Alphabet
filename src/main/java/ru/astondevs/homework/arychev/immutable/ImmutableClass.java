package ru.astondevs.homework.arychev.immutable;

import lombok.Getter;
import lombok.NonNull;

public final class ImmutableClass {
    @Getter
    private String data = "someData";
    @Getter
    private final MutableClass mutableClass;

    public ImmutableClass(@NonNull MutableClass mutableClass, String data) {
        this.mutableClass = mutableClass.clone();
        this.data = data;
    }
}
