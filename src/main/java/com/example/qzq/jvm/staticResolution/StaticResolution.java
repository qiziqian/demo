package com.example.qzq.jvm.staticResolution;

/**
 * @Description 方法静态解析演示 请查看 Byte Code
 * @Date 2020/2/18 11:09
 * @Author by qiziqian
 */
public class StaticResolution {
    public static void main(String[] args) {
        sayHello();
    }

    public static void sayHello() {
        System.out.println("hello world !");
    }
}
