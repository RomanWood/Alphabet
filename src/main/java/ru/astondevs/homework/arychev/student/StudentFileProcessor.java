package ru.astondevs.homework.arychev.student;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class StudentFileProcessor {
    /**
     * Прочитать из файла
     *
     * @param fileName - имя файла
     * @return - Лист объектов из файла
     * @throws IOException            - ошибка IO
     * @throws ClassNotFoundException - ошибка десериализации
     */
    protected static List<Student> readFrom(String fileName) throws IOException, ClassNotFoundException {
        try (InputStream inputStream = Files.newInputStream(Path.of(fileName), StandardOpenOption.DELETE_ON_CLOSE);
             ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {

            //todo спросить на сессии
            return (List<Student>) objectInputStream.readObject();
        }
    }

    /**
     * Дозаписать в файл
     * @param fileName - имя файла
     * @param students - объекты
     * @throws IOException - ошибка IO
     */
    protected static void writeTo(String fileName, List<Student> students) throws IOException {
        try (OutputStream outputStream = Files.newOutputStream(Path.of(fileName), StandardOpenOption.APPEND);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {

            objectOutputStream.writeObject(students);
        }
    }
}
