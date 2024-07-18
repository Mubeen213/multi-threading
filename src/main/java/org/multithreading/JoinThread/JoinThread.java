package org.multithreading.JoinThread;

public class JoinThread {

    public static void main(String[] args) throws InterruptedException {

        Thread one  = new Thread(() -> {
            runLoop("Thread 1");
        });
        Thread two  = new Thread(() -> {
            runLoop("Thread 2");
        });
        System.out.println("Before starting threads");
        one.start();
        two.start();
        one.join();
        two.join();
        System.out.println("Done executing threads");
    }

    private static void runLoop(String thread){
        for (int i = 0; i < 10; i++) {
            System.out.println("From " + thread + " " + i);
        }
    }
}


