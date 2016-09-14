package ru.sbt.pingpong;

public class PiongPong {
    public static void main(String[] args) {
        TwoThreadByOneString byOneString = new TwoThreadByOneString("\nPing", "\nPong");
        byOneString.start();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 100_000; j++) {
                System.out.print(".");
            }
            System.err.println("\n----- " + i + " -----");
        }
    }
}