package ru.sbt.pingpong;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadByString extends Thread {
    private final ReentrantLock locker;
    private volatile boolean isRunning = true;

    public ThreadByString(String name, ReentrantLock locker) {
        this.locker = locker;
        super(name);
    }

    @Override
    public void run() {
        while (isRunning) {
            locker.lock();
            System.out.println(Thread.currentThread().getName());
        }
    }
}