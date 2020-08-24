package com.example.qzq.深入理解java虚拟机.generics;

import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @Date 2020/2/21 10:14
 * @Author by qiziqian
 */
public class 自动装箱 {
    public static void test2() {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c == (a + b));
        System.out.println(c.equals(a + b));
        System.out.println(g == (a + b));
        System.out.println(g.equals(a + b));
    }

    public static void main(String[] args) {
        test2();
    }

    public void test1() {
        //请查看class文件,泛型擦除后的效果
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        System.out.println(sum);
    }
}
