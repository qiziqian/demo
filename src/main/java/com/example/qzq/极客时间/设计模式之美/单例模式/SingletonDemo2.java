package com.example.qzq.极客时间.设计模式之美.单例模式;

/**
 * @ClassName : SingletonDemo2
 * @Author : qiziqian
 * @Description: 懒汉式
 * @Date: 2020-08-26 17:06
 */
public class SingletonDemo2 {

    private static volatile SingletonDemo2 singletonDemo2;

    private Object lock = new Object();

    public SingletonDemo2 getInstance() {
        if (singletonDemo2 == null) {
            synchronized (lock) {
                if (singletonDemo2 == null) {
                    singletonDemo2 = new SingletonDemo2();
                }
            }
        }
        return singletonDemo2;
    }

}