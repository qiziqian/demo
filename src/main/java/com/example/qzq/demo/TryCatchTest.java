package com.example.qzq.demo;

/**
 * @Classname TryCatchTest
 * @Description
 * @Date 2020/3/30 11:18
 * @Created by qiziqian
 */
public class TryCatchTest {
    public static void main(String[] args) {
        String s = getNull();
        if (s == null) {
            throw new RuntimeException("123");
        }
        System.out.println("q123456");

        System.out.println("after");
    }

    public static String getNull() {
        return null;
    }
}
