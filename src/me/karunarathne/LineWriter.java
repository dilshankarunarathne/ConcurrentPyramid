package me.karunarathne;

import static me.karunarathne.ThreadColor.* ;

public class LineWriter implements Runnable {
    char dot = '*';
    int numberOfDots = 5;
    String color = ANSI_RESET;

    LineWriter (char dot, String color) {
        this.dot = dot;
        this.color = color;
    }

    @Override
    public void run () {
//        System.out.println(ANSI_RED + "Hello from MyRunnable");
        for (int i=0; i<numberOfDots; i++) {
            System.out.println(color + dot);
        }
    }

}