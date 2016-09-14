package ru.sbt.pingpong;

import java.util.concurrent.Semaphore;

public class ThreadByString extends Thread {
    private final Semaphore semaphoreOne, semaphoreTwo;
    private volatile boolean isRunning = true;

    public ThreadByString(String name, Semaphore semaphoreOne, Semaphore semaphoreTwo) {
        super(name);
        this.semaphoreOne = semaphoreOne;
        this.semaphoreTwo = semaphoreTwo;
    }

    @Override
    public void run() {
        while (isRunning) {
            try {
                semaphoreOne.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName());
            semaphoreTwo.release();
        }
    }

    public void terminate() {
        isRunning = false;
    }
}