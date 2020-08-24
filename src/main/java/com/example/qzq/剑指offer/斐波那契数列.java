package com.example.qzq.剑指offer;

/**
 * @ClassName : 斐波那契数列
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-08-19 11:51
 */
public class 斐波那契数列 {

    public static void main(String[] args) {

    }

    public static int fibonacci1(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci1(n - 1) + fibonacci1(n - 2);
    }

    public static int fibonacci2(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int fibonaci1 = 0;
        int fibonaci2 = 1;
        int fibonaciN = 0;
        for (int i = 2; i < n; i++) {
            fibonaciN = fibonaci2 + fibonaci1;
            fibonaci1 = fibonaci2;
            fibonaci2 = fibonaciN;
        }
        return fibonaciN;
    }

}