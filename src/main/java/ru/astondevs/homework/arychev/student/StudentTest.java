package ru.astondevs.homework.arychev.student;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import static ru.astondevs.homework.arychev.student.StudentPrinter.printStudentBooks;

public class StudentTest extends StudentFileProcessor {

    private static final String FILE_NAME = "students.txt";

    private static void prepare() throws IOException {

        List<Student> students = List.of(
                new Student("Ivanov Ivan", List.of(
                        new Book("book1", "author1", LocalDate.of(1984, 1, 1), 100),
                        new Book("book2", "author2", LocalDate.of(1105, 1, 1), 101),
                        new Book("book3", "author3", LocalDate.of(1999, 1, 1), 102),
                        new Book("book4", "author4", LocalDate.of(2000, 1, 1), 103),
                        new Book("book5", "author5", LocalDate.of(2005, 1, 1), 104))),
                new Student("Petrov Petr", List.of(
                        new Book("book1", "author1", LocalDate.of(1984, 1, 1), 100),
                        new Book("book2", "author2", LocalDate.of(1105, 1, 1), 101),
                        new Book("book3", "author3", LocalDate.of(1999, 1, 1), 102),
                        new Book("book4", "author4", LocalDate.of(2000, 1, 1), 103),
                        new Book("book5", "author5", LocalDate.of(2005, 1, 1), 104))),
                new Student("Maksimov Maksim", List.of(
                        new Book("book1", "author1", LocalDate.of(1984, 1, 1), 100),
                        new Book("book2", "author2", LocalDate.of(1990, 1, 1), 101),
                        new Book("book3", "author3", LocalDate.of(1999, 1, 1), 102),
                        new Book("book4", "author4", LocalDate.of(2000, 1, 1), 999),
                        new Book("book5", "author5", LocalDate.of(2005, 1, 1), 104))),
                new Student("Taranov Taran", List.of(
                        new Book("book1", "author1", LocalDate.of(1984, 1, 1), 111),
                        new Book("book2", "author2", LocalDate.of(1105, 1, 1), 222),
                        new Book("book3", "author3", LocalDate.of(1999, 1, 1), 333),
                        new Book("book4", "author4", LocalDate.of(2000, 1, 1), 444),
                        new Book("book5", "author5", LocalDate.of(2005, 1, 1), 555))),
                new Student("Tatarov Tatar", List.of(
                        new Book("book1", "author1", LocalDate.of(1999, 1, 1), 100),
                        new Book("book1", "author1", LocalDate.of(2000, 1, 1), 100),
                        new Book("book1", "author1", LocalDate.of(2000, 1, 1), 100),
                        new Book("book4", "author4", LocalDate.of(2000, 1, 1), 100),
                        new Book("book5", "author5", LocalDate.of(2005, 1, 1), 100)))
        );

        writeTo(FILE_NAME, students);
    }

    public static void main(String[] args) {

        try {
            prepare();
        }
        catch (IOException e){
            System.out.println("ERR: serialization error - " + e);
        }

        try {
            List<Student> students = readFrom(FILE_NAME);

            printStudentBooks(students, 2000, 2);

            System.out.println();
            printStudentBooks(students, 1900, 5);
        }
        catch (ClassNotFoundException | ClassCastException | IOException e){
            System.out.println("ERR: deserialization error - " + e);
        }
    }
}
