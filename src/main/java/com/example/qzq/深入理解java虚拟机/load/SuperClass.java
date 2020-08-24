package com.example.qzq.深入理解java虚拟机.load;

/**
 * @Description 虚拟机加载时, 被动引用
 * @Date 2020/2/16 9:57
 * @Author by qiziqian
 */
public class SuperClass {
    public static int value = 123;

    static {
        System.out.println("SuperClass init!");
    }
}
