package com.example.qzq.剑指offer;

/**
 * @ClassName : 打家劫舍
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-12-02 16:36
 */
public class 打家劫舍 {
    public static void main(String[] args) {
        rob(new int[]{1, 2, 3, 1});
    }

    public static int rob(int[] nums) {
        int length = nums.length;
        if (length < 3) return Math.max(nums[0], nums[1]);
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[0] + nums[2];
        for (int i = 3; i < length; i++) {
            dp[i] = nums[i] + Math.max(nums[i - 2], nums[i - 3]);
        }
        return Math.max(dp[length - 1], dp[length - 2]);
    }
}