package com.example.qzq.深入理解java虚拟机.clinit;

/**
 * @Description
 * @Date 2020/2/16 16:54
 * @Author by qiziqian
 */
public class TestDeadLoop {
    public static void main(String[] args) {
        Runnable thread = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + " start ");
                DeadLoopClass dlc = new DeadLoopClass();
                System.out.println(Thread.currentThread() + " run over ");
            }
        };
        Thread thread1 = new Thread(thread);
        Thread thread2 = new Thread(thread);
        thread1.start();
        thread2.start();
    }
}
