package com.example.qzq.jvm.load;

/**
 * @Description
 * @Date 2020/2/16 9:58
 * @Author by qiziqian
 */
public class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init!");
    }
}
