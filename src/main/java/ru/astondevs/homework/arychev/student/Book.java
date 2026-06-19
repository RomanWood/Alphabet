package ru.astondevs.homework.arychev.student;

import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Book implements Serializable, Comparable<Book> {

    @Serial
    private static final long serialVersionUID = 100L;

    private final String name;
    private final String author;
    @Getter
    private final LocalDate releaseDate;
    @Getter
    private final int totalPages;

    public Book(String name, String author, LocalDate yearOfRelease, int totalPages) {
        this.name = name;
        this.author = author;
        this.releaseDate = yearOfRelease;
        this.totalPages = totalPages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", yearOfRelease=" + releaseDate +
                ", totalPages=" + totalPages +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Проверка на один и тот же объект
        if (obj == null || getClass() != obj.getClass()) return false; // Проверка типа и null
        Book book = (Book) obj;
        return Objects.equals(name, book.name)
                && Objects.equals(author, book.author)
                && Objects.equals(releaseDate, book.releaseDate)
                && Objects.equals(totalPages, book.totalPages); // Сравнение полей
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, author, releaseDate, totalPages);
    }


    @Override
    public int compareTo(Book o) {
        return Integer.compare(this.totalPages, o.getTotalPages());
    }
}
