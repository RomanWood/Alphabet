package ru.astondevs.homework.arychev.student;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public record Student(String fio, List<Book> books) implements Serializable {

    @Serial
    private static final long serialVersionUID = 100L;

}
