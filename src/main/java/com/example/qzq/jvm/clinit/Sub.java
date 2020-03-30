package com.example.qzq.jvm.clinit;

/**
 * @Description
 * @Date 2020/2/16 16:42
 * @Author by qiziqian
 */
public class Sub extends Parent {
    static int b = a;

    public static void main(String[] args) {
        System.out.println(b);
    }
}
