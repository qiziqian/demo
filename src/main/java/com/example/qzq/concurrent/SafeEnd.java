package com.example.qzq.concurrent;

/**
 * @Classname SafeEnd
 * @Description
 * @Date 2019/8/19 0:50
 * @Created by qiziqian
 */
public class SafeEnd {
    public static void main(String[] args) throws InterruptedException {
        Thread1 thread1 = new Thread1();
        thread1.start();
        Thread.sleep(2000);
        thread1.interrupt();
    }

    public static class Thread1 extends Thread {
        @Override
        public void run() {
            System.out.println("isInterrupted:" + isInterrupted());
            while (!isInterrupted()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // 2019/8/19 0:56  qiziqian   进行资源回收
                    //....
                    e.printStackTrace();
                    interrupt();
                }
                System.out.println("通过继承Thread实现 ");
            }
        }
    }
}
