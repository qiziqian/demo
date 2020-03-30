package com.example.qzq.concurrent;

/**
 * @Classname TestSynchronized
 * @Description
 * @Date 2019/8/19 15:29
 * @Created by qiziqian
 */
public class TestSynchronized {

    public static synchronized void test1() {
        try {
            Thread.sleep(1000);
            System.out.println("普通方法开始输出..........");
            Thread.sleep(1000);
            System.out.println("普通方法结束输出..........");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // 2019/8/19 15:48  qiziqian    锁在静态方法上,锁的对象是class
//        TestThread testThread = new TestThread();
//        TestThread testThread2 = new TestThread();
//        testThread.start();
//        testThread2.start();

        // 2019/8/19 15:49  qiziqian  锁在普通方法上,锁的对象是类的实例
        TestSynchronized testSynchronized = new TestSynchronized();
        TestSynchronized testSynchronized2 = new TestSynchronized();
        Thread thread = new TestThread2(testSynchronized);
        Thread thread2 = new TestThread2(testSynchronized);
        thread.start();
        thread2.start();
    }

    public synchronized void test2() {
        try {
            Thread.sleep(1000);
            System.out.println("静态方法开始输出..........");
            Thread.sleep(1000);
            System.out.println("静态方法结束输出..........");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static class TestThread extends Thread {
        @Override
        public void run() {
            test1();
        }
    }

    public static class TestThread2 extends Thread {
        private TestSynchronized testSynchronized;

        public TestThread2(TestSynchronized testSynchronized) {
            this.testSynchronized = testSynchronized;
        }

        @Override
        public void run() {
            testSynchronized.test2();
        }
    }
}
