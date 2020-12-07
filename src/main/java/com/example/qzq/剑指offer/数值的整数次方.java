package com.example.qzq.剑指offer;

/**
 * @ClassName : 数值的整数次方
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-10-19 11:26
 */
public class 数值的整数次方 {
    public static void main(String[] args) {
        myPow(3.0, 5);
    }

    public static double myPow(double x, int n) {
        if (x == 0) return 0;
        long b = n;
        double res = 1.0;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }


}