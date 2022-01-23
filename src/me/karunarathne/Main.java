package me.karunarathne;

public class Main {

    public static void main(String[] args) {
        Thread my = new Thread(new WritingThread('x'));
        my.start();
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
