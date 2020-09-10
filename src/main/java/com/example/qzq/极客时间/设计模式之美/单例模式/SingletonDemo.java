package com.example.qzq.极客时间.设计模式之美.单例模式;

/**
 * @ClassName : Singleton
 * @Author : qiziqian
 * @Description: 饿汉式
 * @Date: 2020-08-26 16:59
 */
public class SingletonDemo {

    private static SingletonDemo singletonDemo = new SingletonDemo();

    public static SingletonDemo getInstance() {
        return singletonDemo;
    }
}