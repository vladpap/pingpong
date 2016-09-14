package ru.sbt.pingpong;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class TwoThreadByOneString {
    private final ThreadByString oneThread;
    private final ThreadByString twoThread;
    private final Semaphore semaphoreOne;
    private final Semaphore semaphoreTwo;

    public TwoThreadByOneString(String one, String two) {
        semaphoreOne = new Semaphore(0);
        semaphoreTwo = new Semaphore(1);
        oneThread = new ThreadByString(one, semaphoreOne, semaphoreTwo);
        twoThread = new ThreadByString(two, semaphoreTwo, semaphoreOne);
    }

    public void start() {
        oneThread.start();
        twoThread.start();
    }

    public void terminate() {
        oneThread.terminate();
        twoThread.terminate();
    }
}