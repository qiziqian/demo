package com.example.qzq.demo;

/**
 * @Classname RandomTest
 * @Description
 * @Date 2020/3/30 11:18
 * @Created by qiziqian
 */
public class RandomTest {
    public static void main(String[] args) {

        double min = 0;//最小值
        double max = 30;//总和
        int scl =  1;//小数最大位数
        int pow = (int) Math.pow(10, scl);//指定小数位
        for (int i = 0; i < 100; i++) {
            double one = Math.floor((Math.random() * max ) * pow) / pow;
            System.out.println(one);
        }

    }

    public static String getNull() {
        return null;
    }
}
