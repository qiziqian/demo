package com.example.qzq.深入理解java虚拟机.generics;

/**
 * @Classname StringTest
 * @Description
 * @Date 2020/3/9 11:40
 * @Created by qiziqian
 */
public class StringTest {
    public static void main(String[] args) {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1 == str1.intern());
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2 == str2.intern());
    }
}
