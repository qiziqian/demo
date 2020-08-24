package com.example.qzq.剑指offer;

/**
 * @ClassName : 数值的整数平方
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-08-19 15:32
 */
public class 数值的整数平方 {

    public static void main(String[] args) {

    }

    public static double getExponent(double base, int exponent) {
        if (base == 0) return 0;
        if (exponent == 0) return 1;
        if (exponent == 1) return base;

        double result = getExponent(base, exponent >> 2);
        result *= result;
        if (exponent % 2 == 1) {
            result *= base;
        }

        return result;
    }
}