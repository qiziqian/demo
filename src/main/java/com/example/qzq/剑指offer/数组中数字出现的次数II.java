package com.example.qzq.剑指offer;

/**
 * @ClassName : 数组中数字出现的次数II
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-09-27 11:19
 */
public class 数组中数字出现的次数II {
    public static int singleNumber(int[] nums) {
        int[] bitSum = new int[32];

        for (int num : nums) {
            int bit = 1;
            for (int i = bitSum.length; i > 0; i--) {
                if ((num & bit) != 0) {
                    bitSum[i]++;
                }
                bit <<= 1;
            }
        }

        for (int i = 0; i <= bitSum.length; i++) {
            bitSum[i] = bitSum[i] % 3;
        }
        int target = 0;
        int offset = 0;
        for (int i = bitSum.length; i >= 0; i--) {
            target += bitSum[i] << offset;
            offset++;
        }

        return target;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{5, 5, 5, 8}));
    }
}