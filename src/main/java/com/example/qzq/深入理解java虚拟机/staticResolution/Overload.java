package com.example.qzq.深入理解java虚拟机.staticResolution;

import java.io.Serializable;

/**
 * @Description 重载方法的优先级
 * @Date 2020/2/19 10:28
 * @Author by qiziqian
 */
public class Overload {

    static void sayHello(Object arg) {
        System.out.println("hello,object");
    }

    static void sayHello(int arg) {
        System.out.println("hello,int");
    }

    static void sayHello(long arg) {
        System.out.println("hello,long");
    }

    static void sayHello(Character arg) {
        System.out.println("hello,Character");
    }

    static void sayHello(char arg) {
        System.out.println("hello,char");
    }

    static void sayHello(char... arg) {
        System.out.println("hello,char...");
    }

    static void sayHello(Serializable arg) {
        System.out.println("hello,Serializable");
    }

    public static void main(String[] args) {
        sayHello('a');
    }
}
