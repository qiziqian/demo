package com.example.qzq.剑指offer;

/**
 * @ClassName : 数组中数字出现的次数
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-09-27 10:34
 */
public class 数组中数字出现的次数 {

    public static void main(String[] args) {
        System.out.println(8 << 1);
    }

    public int[] singleNumbers(int[] nums) {
        int ret = 0;
        for (int num : nums) {
            ret ^= num;
        }
        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;
        }
        int a = 0, b = 0;
        for (int num : nums) {
            if ((num & div) != 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }
}