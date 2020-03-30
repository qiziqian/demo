package com.example.qzq.concurrent;

/**
 * @Classname TestConcurrent
 * @Description
 * @Date 2019/8/19 14:51
 * @Created by qiziqian
 */
public class TestConcurrent {
    public final static Object object = new Object();
    public volatile static int i = 0;

    public static void increase() {
        synchronized (object) {
            i++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestThread testThread = new TestThread();
        TestThread testThread2 = new TestThread();
        testThread.start();
        testThread2.start();
        testThread.join();
        System.out.println(i);
    }

    public static class TestThread extends Thread {
        @Override
        public void run() {
            for (int j = 0; j < 1000; j++) {
                increase();
            }
        }
    }
}
