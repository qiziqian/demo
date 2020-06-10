package com.example.qzq.jvm.load;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Classname LockTest
 * @Description 看不懂的锁的问题, 暂时记下来
 * @Date 2020/5/22 18:07
 * @Created by qiziqian
 */
public class LockTest {
    public static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        new Thread(() -> {
            lock.lock();
            // lock.lock();
            lock.unlock();
        }).start();
        new Thread(() -> {
            lock.lock();
            lock.unlock();
        }).start();
    }
}
