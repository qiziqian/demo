package com.example.qzq.concurrent;

/**
 * volatile  可见性测试
 */
public class VolatileVisibibilityTest {

    static boolean init = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            public void run() {
                while (!init) {
                    //解开下面语句,不用加volatile也可以执行通过
                    // System.out.println("检查中");
                }
                System.out.println("执行完成!");
            }
        }).start();
        Thread.sleep(2000);
        new Thread(new Runnable() {
            public void run() {
                prepareData();
            }
        }).start();


    }

    public static void prepareData() {
        System.out.println("开始准备数据");
        init = true;
        System.out.println("准备完成");
    }
}
