package ru.sbt.pingpong;

import java.util.concurrent.locks.ReentrantLock;

public class TwoThreadByOneString {
    private final String oneString;
    private final String twoString;
    private final ReentrantLock locker;

    public TwoThreadByOneString(String one, String two) {
        locker = new ReentrantLock(true);
        this.oneString = one;
        this.twoString = two;
    }

    public void start() {
        ThreadByString oneThread = new ThreadByString(oneString, locker);
        ThreadByString twoThread = new ThreadByString(twoString, locker);
        oneThread.start();
        twoThread.start();
    }

}