package com.example.qzq.leetcode;

import java.util.Arrays;

/**
 * @ClassName : 根据数字二进制下一的数目排序
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-11-06 10:52
 */
public class 根据数字二进制下一的数目排序 {
    public static void main(String[] args) {
        System.out.println(100_00);
    }

    public int[] sortByBits(int[] arr) {
        int length = arr.length;

        for (int i = 0; i < length; i++) {
            arr[i] = Integer.bitCount(arr[i]) * 100_000 + arr[i];
        }

        Arrays.sort(arr);
        for (int i = 0; i < length; i++) {
            arr[i] %= 100_000;
        }
        return arr;
    }
}