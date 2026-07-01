package ru.astondevs.homework.arychev.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLock {

    private static final Lock lock1 = new ReentrantLock(true);
    private static final Lock lock2 = new ReentrantLock(true);

    public static void operation1() {
        lock1.lock();
        System.out.println("lock1 acquired, waiting to acquire lock2.");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        lock2.lock();
        System.out.println("lock2 acquired");

        System.out.println("executing first operation.");

        lock2.unlock();
        lock1.unlock();
    }

    public static void operation2() {
        lock2.lock();
        System.out.println("lock2 acquired, waiting to acquire lock1.");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        lock1.lock();
        System.out.println("lock1 acquired");

        System.out.println("executing second operation.");

        lock1.unlock();
        lock2.unlock();
    }
}

