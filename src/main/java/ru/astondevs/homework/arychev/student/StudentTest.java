package ru.astondevs.homework.arychev.student;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * 1. Создать класс Student, обязательное поле класса Student - List<Book> (минимум по 5 книг у каждого)
 * 2. Создать текстовый файл со студентами и книгами
 * 3. При помощи внутренних фреймворков и библиотек для ввода-вывода информации в Java считать содержимое файла и заполнить List<Student> этими данными (Должен быть реализован механизм заполнения коллекции студентов из текстового файла)
 * 4. При помощи одного (не допускается объявления никаких промежуточных переменных, совсем никаких) стрима:
 * - Вывести в консоль каждого студента (переопределите toString)
 * - Получить для каждого студента список книг
 * - Получить книги
 * - Отсортировать книги по количеству страниц (Не забывайте про условия для сравнения объектов)
 * - Оставить только уникальные книги
 * - Отфильтровать книги, оставив только те, которые были выпущены после 2000 года
 * - Ограничить стрим на 3 элементах
 * - Получить из книг годы выпуска
 * - При помощи методов короткого замыкания (почитайте самостоятельно что это такое) вернуть Optional от года
 *  -При помощи методов получения значения из Optional вывести в консоль год выпуска найденной книги,
 *  либо запись о том, что такая книга отсутствует
 */
public class StudentTest {

    private static final String FILE_NAME = "students.txt";

    private static void prepare() throws IOException {

        List<Student> students = new ArrayList<>() {{
            add(new Student("Ivanov Ivan", new ArrayList<>() {{
                add(new Book("book1", "author1", LocalDate.of(1984, 1, 1), 100));
                add(new Book("book2", "author2", LocalDate.of(1105, 1, 1), 101));
                add(new Book("book3", "author3", LocalDate.of(1999, 1, 1), 102));
                add(new Book("book4", "author4", LocalDate.of(2000, 1, 1), 103));
                add(new Book("book5", "author5", LocalDate.of(2005, 1, 1), 104));
            }}));
            add(new Student("Petrov Petr", new ArrayList<>() {{
                add(new Book("book1", "author1", LocalDate.of(1984, 1, 1), 100));
                add(new Book("book2", "author2", LocalDate.of(1105, 1, 1), 101));
                add(new Book("book3", "author3", LocalDate.of(1999, 1, 1), 102));
                add(new Book("book4", "author4", LocalDate.of(2000, 1, 1), 103));
                add(new Book("book5", "author5", LocalDate.of(2005, 1, 1), 104));
            }}));
            add(new Student("Maksimov Maksim", new ArrayList<>() {{
                add(new Book("book1", "author1", LocalDate.of(1984, 1, 1), 100));
                add(new Book("book2", "author2", LocalDate.of(1990, 1, 1), 101));
                add(new Book("book3", "author3", LocalDate.of(1999, 1, 1), 102));
                add(new Book("book4", "author4", LocalDate.of(2000, 1, 1), 999));
                add(new Book("book5", "author5", LocalDate.of(2005, 1, 1), 104));
            }}));
            add(new Student("Taranov Taran", new ArrayList<>() {{
                add(new Book("book1", "author1", LocalDate.of(1984, 1, 1), 111));
                add(new Book("book2", "author2", LocalDate.of(1105, 1, 1), 222));
                add(new Book("book3", "author3", LocalDate.of(1999, 1, 1), 333));
                add(new Book("book4", "author4", LocalDate.of(2000, 1, 1), 444));
                add(new Book("book5", "author5", LocalDate.of(2005, 1, 1), 555));
            }}));
            add(new Student("Tatarov Tatar", new ArrayList<>() {{
                add(new Book("book1", "author1", LocalDate.of(1999, 1, 1), 100));
                add(new Book("book1", "author1", LocalDate.of(2000, 1, 1), 100));
                add(new Book("book1", "author1", LocalDate.of(2000, 1, 1), 100));
                add(new Book("book4", "author4", LocalDate.of(2000, 1, 1), 100));
                add(new Book("book5", "author5", LocalDate.of(2005, 1, 1), 100));
            }}));
        }};

        try (OutputStream outputStream = Files.newOutputStream(Path.of(FILE_NAME), StandardOpenOption.CREATE_NEW);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)){
            objectOutputStream.writeObject(students);
        }
    }

    private static List<Student> read() throws IOException, ClassNotFoundException {
        try (InputStream inputStream = Files.newInputStream(Path.of(FILE_NAME), StandardOpenOption.DELETE_ON_CLOSE);
             ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)){

            return (List<Student>) objectInputStream.readObject();
        }
    }

    private static void printStudentBooks(List<Student> students,
                                          int yearOfRelease,
                                          int booksLimit) {

        students.stream()
                .peek(System.out::println)
                .map(Student::getBooks)
                .flatMap(List::stream)
                .sorted(Comparator.comparingInt(Book::getTotalPages))
                .distinct()
                .filter(book -> book.getReleaseDate().getYear() >= yearOfRelease)
                .limit(booksLimit)
                .peek(System.out::println)
                .map(book -> book.getReleaseDate().getYear())
                .findFirst()
                .ifPresentOrElse(System.out::println, () -> System.out.println("Book not found"));
    }

    public static void main(String[] args) {

        try {
            prepare();
        }
        catch (IOException e){
            System.out.println("ERR: serialization error - " + e);
        }

        try {
            List<Student> students = read();

            printStudentBooks(students, 2000, 2);

            System.out.println();
            printStudentBooks(students, 1900, 5);
        }
        catch (ClassNotFoundException | ClassCastException | IOException e){
            System.out.println("ERR: deserialization error - " + e);
        }
    }
}
