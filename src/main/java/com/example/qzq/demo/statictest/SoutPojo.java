package com.example.qzq.demo.statictest;

/**
 * @Classname SoutPojo
 * @Description
 * @Date 2020/7/6 15:41
 * @Created by qiziqian
 */
public class SoutPojo {
    private String str;

    public SoutPojo(String str) {
        this.str = str;
    }

    public void test() {

        System.out.println(str);
        System.out.println(this);
    }
}
