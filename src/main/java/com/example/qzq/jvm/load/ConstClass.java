package com.example.qzq.jvm.load;

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
