package com.javarush.task.task16.task1632;

public class My2 extends Thread {

    @Override
    public void run() {
        try {
            Thread.sleep(0);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }
    }
}
