package ru.astondevs.homework.arychev.multithreading;

import static java.lang.Thread.sleep;

public class LockTest {

    public static void main(String[] args) {
        deadLockDemo();
        liveLockDemo();
    }

    private static void liveLockDemo() {
        new Thread(LiveLock::operation1, "T1").start();
        new Thread(LiveLock::operation2, "T2").start();

        try {
            sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.exit(0);
    }

    private static void deadLockDemo() {
        new Thread(DeadLock::operation1, "T1").start();
        new Thread(DeadLock::operation2, "T2").start();
    }
}
