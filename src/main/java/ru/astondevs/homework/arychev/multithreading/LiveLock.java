package ru.astondevs.homework.arychev.multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LiveLock {

    private static final Lock lock1 = new ReentrantLock(true);
    private static final Lock lock2 = new ReentrantLock(true);

    public static void operation1()  {
        while (true) {

            try {
                if (lock1.tryLock(500, TimeUnit.MILLISECONDS)) {
                    System.out.println("lock1 acquired, trying to acquire lock2.");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            try {
                if (lock2.tryLock(500, TimeUnit.MILLISECONDS)) {
                    System.out.println("lock2 acquired.");
                } else {
                    System.out.println("cannot acquire lock2, releasing lock1.");
                    lock1.unlock();
                    continue;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("executing first operation.");
            break;
        }
        lock2.unlock();
        lock1.unlock();
    }

    public static void operation2() {
        while (true) {
            try {
                if (lock2.tryLock(500, TimeUnit.MILLISECONDS)){
                System.out.println("lock2 acquired, trying to acquire lock1.");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            try {
                if (lock1.tryLock(500, TimeUnit.MILLISECONDS)) {
                    System.out.println("lock1 acquired.");
                } else {
                    System.out.println("cannot acquire lock1, releasing lock2.");
                    lock2.unlock();
                    continue;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("executing second operation.");
            break;
        }
        lock1.unlock();
        lock2.unlock();
    }
}
