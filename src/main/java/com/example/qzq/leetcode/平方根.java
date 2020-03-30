package com.example.qzq.leetcode;

/**
 * @Classname 平方根
 * @Description
 * @Date 2019/10/11 17:37
 * @Created by qiziqian
 */
public class 平方根 {
    public static void main(String[] args) {
        System.out.println(mySqrt1(4));
    }

    //二分法
    public static int mySqrt1(int x) {
        if (x <= 1) return x;
        long high = x;
        long low = 0;
        while (low < high) {
            long mid = (int) (low + (high - low) / 2);
            if (mid * mid > x) high = mid;
            if (mid * mid < x) low = mid;
            if (mid * mid <= x && (mid + 1) * (mid + 1) > x) return (int) mid;
        }
        return -1;
    }


}
