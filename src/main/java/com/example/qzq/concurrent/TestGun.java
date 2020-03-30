package com.example.qzq.concurrent;

import java.util.LinkedList;

/**
 * @Classname TestGun
 * @Description 子弹上膛与发射
 * @Date 2019/8/20 16:42
 * @Created by qiziqian
 */
public class TestGun {
    public final int boreOfaGunSize = 20;
    public LinkedList<Integer> list = new LinkedList<>();
    public volatile int boreOfaGun = 0;

    public TestGun() {
        for (int i = 0; i < boreOfaGunSize; i++) {
            list.addLast(1);
        }
    }

    public static void main(String[] args) {
        TestGun gun = new TestGun();
        new Thread(new Product(gun), "生产者").start();
        new Thread(new Consumer(gun), "消费者").start();

    }

    public synchronized void beLoaded() {
        try {
            while (list.size() == boreOfaGunSize) {
                System.out.println("枪膛已满,无需上弹 当前还剩子弹 " + list.size() + " 发");
                wait();
            }
            list.addLast(1);
            System.out.println("上弹中....当前还剩子弹 " + list.size() + " 发");
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public synchronized void fire() {
        try {
            while (list.size() == 0) {
                System.out.println("没有子弹,需要上弹  当前还剩子弹 " + list.size() + " 发");
                wait();

            }
            list.removeFirst();
            System.out.println(" biu biu biu ~  当前还剩子弹 " + list.size() + " 发");
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static class Product implements Runnable {
        TestGun gun;

        public Product(TestGun gun) {
            this.gun = gun;
        }

        @Override
        public void run() {
            while (true) {
                gun.beLoaded();
//                try {
//                    TimeUnit.MILLISECONDS.sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }

        }
    }

    public static class Consumer implements Runnable {
        TestGun gun;

        public Consumer(TestGun gun) {
            this.gun = gun;
        }

        @Override
        public void run() {
            while (true) {
                gun.fire();
//                try {
//                    TimeUnit.MILLISECONDS.sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }

        }
    }
}
