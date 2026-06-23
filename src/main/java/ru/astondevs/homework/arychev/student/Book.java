package ru.astondevs.homework.arychev.student;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

public record Book(String name, String author, LocalDate releaseDate,
                   int totalPages) implements Serializable, Comparable<Book> {

    @Serial
    private static final long serialVersionUID = 100L;

    @Override
    public int compareTo(Book o) {
        return Integer.compare(this.totalPages, o.totalPages());
    }
}
