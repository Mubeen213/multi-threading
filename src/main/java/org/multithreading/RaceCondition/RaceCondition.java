package org.multithreading.RaceCondition;

public class RaceCondition {

    private static int counter = 0;

    public static void raceConditionDemo() throws InterruptedException {
        Thread one = new Thread(RaceCondition::runLoop);
        Thread two = new Thread(RaceCondition::runLoop);

        one.start();
        two.start();

        one.join();
        two.join();

        System.out.println(counter);
    }

    public static void main(String[] args) throws InterruptedException {
        raceConditionDemo();
    }

    private synchronized static void runLoop(){
        for (int i = 0; i < 10000; i++) {
            counter++;
        }
    }
}
