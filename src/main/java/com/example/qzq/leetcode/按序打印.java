package com.example.qzq.leetcode;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * @Classname 按序打印
 * @Description
 * @Date 2019/10/18 13:31
 * @Created by qiziqian
 */
public class 按序打印 {
    public static void main(String[] args) {

    }

    class Foo3 {
        Semaphore spa, spb;

        public Foo3() {
            spa = new Semaphore(0);
            spb = new Semaphore(0);
        }

        public void first(Runnable printFirst) throws InterruptedException {
            printFirst.run();
            spa.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            spa.acquire();
            printSecond.run();
            spb.release();
        }

        public void third(Runnable printThird) throws InterruptedException {
            spb.acquire();
            printThird.run();
            // spb.release();
        }
    }

    class Foo2 {
        Object object = new Object();
        volatile int state = 1;

        public Foo2() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            synchronized (object) {
                // printFirst.run() outputs "first". Do not change or remove this line.
                if (state != 1) {
                    object.wait();
                }
                printFirst.run();
                state = 2;
            }
            object.notifyAll();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            synchronized (object) {
                // printSecond.run() outputs "second". Do not change or remove this line.
                if (state != 2) {
                    object.wait();
                }
                printSecond.run();
                state = 3;
            }
            object.notifyAll();
        }

        public void third(Runnable printThird) throws InterruptedException {
            synchronized (object) {
                // printThird.run() outputs "third". Do not change or remove this line.
                if (state != 3) {
                    object.wait();
                }
                printThird.run();
            }
            object.notifyAll();
        }
    }

    class Foo {
        CountDownLatch countDownLatchA;
        CountDownLatch countDownLatchB;

        public Foo() {
            CountDownLatch countDownLatchA = new CountDownLatch(1);
            CountDownLatch countDownLatchB = new CountDownLatch(1);
        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            countDownLatchA.countDown();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            countDownLatchA.await();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            countDownLatchB.countDown();
        }

        public void third(Runnable printThird) throws InterruptedException {
            countDownLatchB.await();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}
