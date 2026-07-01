package ru.astondevs.homework.arychev.patterns.proxy;

public class ProxyPicture implements Picture {
    private RealPicture realPicture;
    private final String fileName;

    public ProxyPicture(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realPicture == null) {
            realPicture = new RealPicture(fileName);
        }
        realPicture.display();
    }
}