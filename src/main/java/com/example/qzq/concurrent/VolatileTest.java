package com.example.qzq.concurrent;


// volatile  不满足原子性的demo
public class VolatileTest {
    static volatile int num = 1;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Runnable() {
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        increase();
                    }

                }
            });
            threads[i].start();

        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();

        }

        System.out.println(num);
    }

    static void increase() {
        num++;
    }

    static synchronized void increaseWithSynchronized() {
        num++;
    }
}
