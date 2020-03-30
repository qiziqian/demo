package com.example.qzq.jvm.clinit;

/**
 * @Description 非法向前引用演示
 * @Date 2020/2/16 16:40
 * @Author by qiziqian
 */
public class Test1 {
    static int i = 1;

    static {
        i = 0;
        System.out.println(i);
    }
    //static  int i =1;
}
