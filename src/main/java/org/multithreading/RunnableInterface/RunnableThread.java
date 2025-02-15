package org.multithreading.RunnableInterface;

public class RunnableThread  {

    public static void main(String[] args) {

        Thread one = new Thread(new Thread1());
        Thread two = new Thread(new Thread2());

        Thread threadOne = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("From thread 1 " + i);
            }
        });

        Thread threadTwo = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("From thread 2 " + i);
            }
        });

        threadOne.start();
        threadTwo.start();
    }
}

class Thread1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("From thread 1 "+ i);
        }
    }
}


class Thread2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("From thread 2 "+ i);
        }
    }
}