package com.example.qzq.深入理解java虚拟机.load;

/**
 * @Description
 * @Date 2020/2/16 10:22
 * @Author by qiziqian
 */
public class ConstClass {
    public static final String HELLOWORLD = " hello world";

    static {
        System.out.println("ConstClass init!");
    }
}
