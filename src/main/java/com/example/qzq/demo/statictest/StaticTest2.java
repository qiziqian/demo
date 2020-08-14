package com.example.qzq.demo.statictest;

/**
 * @Classname StaticTest2
 * @Description
 * @Date 2020/7/6 15:43
 * @Created by qiziqian
 */
public class StaticTest2 {
    private static final SoutPojo soutPojo = new SoutPojo("222222222");

    public StaticTest2() {
    }

    public void test() {
        soutPojo.test();
    }
}
