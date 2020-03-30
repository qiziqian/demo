package com.example.qzq.concurrent;

/**
 * @Classname TestJoin
 * @Description
 * @Date 2019/8/19 1:35
 * @Created by qiziqian
 */
public class TestJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread mainThread = Thread.currentThread();
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        thread1.start();
        thread2.start();
        thread2.join();
        System.out.println("主线程执行完毕");
    }

    public static class Thread1 extends Thread {

        @Override
        public void run() {
            System.out.println("Thread1  执行");
        }
    }

    public static class Thread2 extends Thread {

        @Override
        public void run() {
            System.out.println("Thread2  执行");
        }
    }
}
