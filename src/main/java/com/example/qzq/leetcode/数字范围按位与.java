package com.example.qzq.leetcode;

/**
 * @Classname 数字范围按位与
 * @Description
 * @Date 2020/1/3 10:08
 * @Created by qiziqian
 */
public class 数字范围按位与 {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE - 1);
        System.out.println(rangeBitwiseAnd(5, 7));

    }

    public static int rangeBitwiseAnd(int m, int n) {
        if (m == n) return m;
        int num = m & (m + 1);
        m++;
        while (m < n) {
            num = num & (m + 1);
            m++;
        }
        return num;
    }
}
