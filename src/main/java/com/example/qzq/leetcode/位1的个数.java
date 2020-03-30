package com.example.qzq.leetcode;

/**
 * @Classname 位1的个数
 * @Description
 * @Date 2019/12/30 17:27
 * @Created by qiziqian
 */
public class 位1的个数 {
    public static void main(String[] args) {
        int n = 00000000000000000000000000001011;
        int count = 0;
        while (n != 0) {
            if (n % 10 == 1) count++;
            n = n / 10;
        }

    }

}
