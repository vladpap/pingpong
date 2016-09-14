package ru.sbt.pingpong;

public class PiongPong {
    public static void main(String[] args) {
        TwoThreadByOneString byOneString = new TwoThreadByOneString("Ping", "Pong");
        byOneString.start();

        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        byOneString.terminate();
    }
}