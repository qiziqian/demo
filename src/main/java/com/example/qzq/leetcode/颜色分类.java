package com.example.qzq.leetcode;

/**
 * @Classname 颜色分类
 * @Description
 * @Date 2019/10/11 10:46
 * @Created by qiziqian
 */
public class 颜色分类 {
    public static void main(String[] args) {
        sortColors(new int[]{2});
    }

    // 1021012 -> 1021012 -> 0121012 --> 0121012 --> 0111022 --> 0011122
    public static void sortColors(int[] nums) {
        int curr = 0, p0 = 0, p2 = nums.length - 1;
        while (curr <= p2) {
            if (nums[curr] == 0) {
                swap(nums, curr, p0);
                p0++;
                curr++;
            } else if (nums[curr] == 2) {
                swap(nums, curr, p2);
                p2--;
            } else curr++;
        }
    }

    public static void swap(int[] num, int idx1, int idx2) {
        if (num[idx1] == num[idx2]) return;
        num[idx1] = num[idx1] ^ num[idx2];
        num[idx2] = num[idx1] ^ num[idx2];
        num[idx1] = num[idx1] ^ num[idx2];
    }
}
