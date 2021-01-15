package com.example.qzq.concurrent;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName : SecKill
 * @Author : qiziqian
 * @Description:
 * @Date: 2021-01-04 15:43
 */
public class SecKill {
    static Queue<Integer> queue1 = new ArrayBlockingQueue(10000);
    static Queue<Integer> queue2 = new ArrayDeque<>();
    static AtomicInteger count1 = new AtomicInteger();
    static int count2 = 0;

    public static void main(String[] args) throws InterruptedException {
        new Thread(new AtmicTest()).start();
        new Thread(new AtmicTest()).start();
        new Thread(new AtmicTest()).start();
        new Thread(new AtmicTest()).start();
        new Thread(new AtmicTest()).start();


        while (true) {
            Thread.sleep(3000);
            System.out.println("自增" + queue1.size());
            System.out.println("queue Size" + queue2.size());
        }
    }

    public static class AtmicTest implements Runnable {
        @Override
        public void run() {
            while (true) {
                if (!queue1.offer(1)) {
                    break;
                }

            }
        }
    }

    public static class QueueSizeTest implements Runnable {
        @Override
        public void run() {
            while (true) {
                if (queue2.size() < 100000) {
                    queue2.offer(1);
                } else {
                    break;
                }
            }
        }
    }
}