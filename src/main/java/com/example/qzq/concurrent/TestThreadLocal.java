package com.example.qzq.concurrent;

/**
 * @Classname TestThreadLocal
 * @Description
 * @Date 2019/8/19 16:06
 * @Created by qiziqian
 */
public class TestThreadLocal {
    public static void main(String[] args) {
        ThreadLocal<Integer> local = new ThreadLocal<Integer>() {
            @Override
            protected Integer initialValue() {
                return 1;
            }
        };
        local.set(2);
    }
}
