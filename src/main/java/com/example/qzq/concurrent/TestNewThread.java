package com.example.qzq.concurrent;

/**
 * @Classname TestNewThread
 * @Description
 * @Date 2019/8/18 17:31
 * @Created by qiziqian
 */
public class TestNewThread {
    public static void main(String[] args) throws InterruptedException {
        Thread1 thread1 = new Thread1();
        thread1.start();
        Thread.sleep(1000);
        thread1.interrupt();
        // 2019/8/18 17:40  qiziqian   IllegalThreadStateException
        //thread1.start();

//        Thread2 thread2 = new Thread2();
//        new Thread(thread2).start();
    }

    public static class Thread1 extends Thread {
        @Override
        public void run() {
            System.out.println("通过继承Thread实现 ");
        }
    }

    public static class Thread2 implements Runnable {

        @Override
        public void run() {

            System.out.println("通过实现Runnable实现");
        }
    }
}
