package com.example.qzq.demo;

import java.io.Serializable;

/**
 * @Classname Father
 * @Description 静态分派演示
 * @Date 2020/2/28 11:33
 * @Created by qiziqian
 */
public class Father {

    static void test1(char ch) {

    }

    static void test1(Character ch) {

    }

    static void test1(long ch) {

    }

    static void test1(int ch) {

    }

    static void test1(Serializable ch) {

    }

    static void test1(Object ch) {

    }

    public static void main(String[] args) {
        test1('q');
    }
}
