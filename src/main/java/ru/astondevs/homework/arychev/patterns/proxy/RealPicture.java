package ru.astondevs.homework.arychev.patterns.proxy;

// Реальный объект
public class RealPicture implements Picture {
    private final String fileName;

    public RealPicture(String fileName) {
        this.fileName = fileName;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Загрузка изображения: " + fileName);
    }

    @Override
    public void display() {
        System.out.println("Отображение изображения: " + fileName);
    }
}