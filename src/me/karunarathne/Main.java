package me.karunarathne;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
//	    Thread writer1 = new Thread(new LineWriter('x', ThreadColor.ANSI_RED));
//        Thread writer2 = new Thread(new LineWriter('y', ThreadColor.ANSI_BLUE));
//        writer1.start();
//        writer2.start();
//
//        Synced synced = new Synced();
//        synced.doCountdown();

        WritePyramid message = new WritePyramid();
        new Thread(new Writer(message)).start();
        new Thread(new Writer2(message)).start();
    }
}

class Writer implements Runnable {
    private WritePyramid message;
    public Writer (WritePyramid message) {
        this.message = message;
    }
    public void run() {
            message.writeT1('*');
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // not handling it
            }
//        message.writeT1("Finished");
    }
}
class Writer2 implements Runnable {
    private WritePyramid message2;
    public Writer2 (WritePyramid message) {
        this.message2 = message;
    }
    public void run() {
        message2.writeT2('@');
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // not handling it
        }
//        message.writeT1("Finished");
    }
}

class WritePyramid {
    private boolean done = true;

    private int lines = 5;
    private int currentLine = 1;
    private char symbol1 = '*';
    private char symbol2 = '@';

    public synchronized void writeT1 (char symbol1) {
        while (!done) {
            try {
                wait();
            } catch (InterruptedException e) {
                // not handling
            }
        }
        done = false;
        for (int i=0; i<calcDots(); i++) {
            System.out.println(ThreadColor.ANSI_BLUE + symbol1);
        }
        currentLine++ ;
//        this.message = message;
        notifyAll();
    }

    private int calcDots () {
        return (currentLine*2) ;
    }

    public synchronized void writeT2 (char symbol2) {
        while (done) {
            try {
                wait();
            } catch (InterruptedException e) {
                // not handling
            }
        }
        done = true;
        for (int i=0; i<calcDots(); i++) {
            System.out.print(ThreadColor.ANSI_RED + symbol2);
        }
        System.out.print("\n");
        currentLine++ ;
//        this.message = message;
        notifyAll();
    }

}
