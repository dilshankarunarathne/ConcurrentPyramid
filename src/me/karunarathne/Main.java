package me.karunarathne;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(new WritingThread('@'));
//        t1.start();
        Thread t2 = new Thread(new WritingThread('#'));
//        t2.start();
        t1.run();
        t2.run();

    }
}

class WritingThread implements Runnable {
    public static int currentLine = 1;
    public static int totalLines = 5;
    char c = '*';

    public WritingThread(char c) {
        this.c = c;
    }

    @Override
    public void run() {
        while(currentLine <= totalLines) {
            for (int s = 0; s < totalLines - currentLine; s++) {
                System.out.print(" ");
            }
            for (int i = 1; i < currentLine * 2; i++) {
                System.out.print(c);
            }
            currentLine++;
            System.out.print("\n");
        }
    }
}
