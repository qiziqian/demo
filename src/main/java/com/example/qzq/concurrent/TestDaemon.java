package com.example.qzq.concurrent;

/**
 * @Classname TestDaemon
 * @Description 守护线程
 * @Date 2019/8/19 14:44
 * @Created by qiziqian
 */
public class TestDaemon {
    public static void main(String[] args) throws InterruptedException {
        Thread1 thread1 = new Thread1();
        thread1.setDaemon(true);
        thread1.start();
        Thread.sleep(2000);
        // thread1.interrupt();
    }

    public static class Thread1 extends Thread {
        @Override
        public void run() {
            System.out.println("isInterrupted:" + isInterrupted());
            while (!isInterrupted()) {
                try {
                    System.out.println("线程持续运行中");
                } finally {
                    System.out.println("线程完整结束");
                }
            }
        }
    }
}
