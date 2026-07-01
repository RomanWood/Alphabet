package ru.astondevs.homework.arychev.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.LongAdder;

public class TwoThreads {

    static LongAdder longAdder = new LongAdder();
    static volatile AtomicBoolean isFirstNext = new AtomicBoolean(true);
    static volatile AtomicBoolean isSecondNext = new AtomicBoolean(false);

    public static void main(String[] args) {
        try (ExecutorService executorService = Executors.newFixedThreadPool(2)){
            executorService.execute(TwoThreads::print1);
            executorService.execute(TwoThreads::print2);
        }
    }

    private static void print1(){
        while (true) {
            if (isFirstNext.get()){
                longAdder.increment();
                System.out.println(longAdder.longValue() + " - 1");
                isFirstNext.compareAndSet(true, false);
                isSecondNext.compareAndSet(false, true);
            }
        }
    }

    private static void print2(){
        while (true) {
            if (isSecondNext.get()) {
                longAdder.increment();
                System.out.println(longAdder.longValue() + " - 2");
                isFirstNext.compareAndSet(false, true);
                isSecondNext.compareAndSet(true, false);
            }
        }
    }
}
