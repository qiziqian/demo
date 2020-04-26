package com.example.qzq.jvm.staticResolution;

/**
 * @Description 方法重载与静态分派  根据静态类型进行重载
 * @Date 2020/2/19 10:11
 * @Author by qiziqian
 */
public class StaticDispatch {
    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        StaticDispatch sd = new StaticDispatch();
        sd.sayHello(man);
        sd.sayHello(woman);
    }

    public void sayHello(Human guy) {
        System.out.println("hello,guy");
    }

    public void sayHello(Man guy) {
        System.out.println("hello,gentleman");
    }

    public void sayHello(Woman guy) {
        System.out.println("hello,lady");
    }

    static abstract class Human {
    }

    static class Man extends Human {
    }

    static class Woman extends Human {
    }

}
