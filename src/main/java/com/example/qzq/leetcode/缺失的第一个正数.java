package com.example.qzq.leetcode;

import java.util.Arrays;

/**
 * @Classname 缺失的第一个正数
 * @Description
 * @Date 2019/12/17 11:15
 * @Created by qiziqian
 */
public class 缺失的第一个正数 {
    //思路:将数组当成桶,把它包含的数字放在对应的下标下
    public static int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < nums.length; i++) {
            while (i + 1 != nums[i]) {
                if (nums[i] > len || nums[i] <= 0) break;
                swap(nums, nums[i] - 1, i);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 != nums[i]) return i + 1;
        }
        return 0;
    }

    public static void swap(int[] array, int a, int b) {
        array[a] = array[a] ^ array[b];
        array[b] = array[a] ^ array[b];
        array[a] = array[a] ^ array[b];
    }

    public static void main(String[] args) {
        firstMissingPositive(new int[]{3, 4, 2, 5, -1});
    }
}
