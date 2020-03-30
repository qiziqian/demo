package com.example.qzq.jvm.staticResolution;

/**
 * @Description 方法动态分派演示
 * @Date 2020/2/19 13:45
 * @Author by qiziqian
 */
public class OverRide {

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        man.sayHello();
        woman.sayHello();
        man = new Woman();
        man.sayHello();
    }

    static abstract class Human {
        protected abstract void sayHello();
    }

    static class Man extends Human {
        @Override
        public void sayHello() {
            System.out.println("hello,gentleman");
        }
    }

    static class Woman extends Human {
        @Override
        public void sayHello() {
            System.out.println("hello,lady");
        }
    }
}
