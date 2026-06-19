package ru.astondevs.homework.arychev.patterns.proxy;

// Использование
public class ProxyTest {

    public static void main(String[] args) {

        Picture image = new RealPicture("image.png");
        image.display();


        // реальное изображение не загружается
        Picture picture1 = new ProxyPicture("image1.jpg");
        Picture picture2 = new ProxyPicture("image2.jpg");

        // Изображение будет загружено только при вызове display()
        picture1.display();

        // Изображение уже загружено, повторная загрузка не требуется
        picture1.display();

        // Изображение 2 загружается только в этот момент
        picture2.display();
    }
}