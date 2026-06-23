package ru.astondevs.homework.arychev.student;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
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
    protected static List<Student> read(String fileName) throws IOException, ClassNotFoundException {
        try (InputStream inputStream = Files.newInputStream(Path.of(fileName), StandardOpenOption.DELETE_ON_CLOSE);
             ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {

            //todo спросить на сессии
            return (List<Student>) objectInputStream.readObject();
        }
    }
}
