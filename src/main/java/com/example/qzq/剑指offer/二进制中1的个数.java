package com.example.qzq.剑指offer;

/**
 * @ClassName : 二进制中1的个数
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-08-19 14:17
 */
public class 二进制中1的个数 {

    public static void main(String[] args) {

    }

    public static int getCountOfOne(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }
}