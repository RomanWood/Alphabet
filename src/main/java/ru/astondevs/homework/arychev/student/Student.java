package ru.astondevs.homework.arychev.student;

import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class Student implements Serializable {

    @Serial
    private static final long serialVersionUID = 100L;

    @Getter
    private final String fio;
    @Getter
    private final List<Book> books;

    public Student(String fio, List<Book> books) {
        this.fio = fio;
        this.books = books;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fio='" + fio + '\'' +
                '}';
    }
}
