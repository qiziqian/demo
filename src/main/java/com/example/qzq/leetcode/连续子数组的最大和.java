package com.example.qzq.leetcode;

/**
 * @ClassName : 连续子数组的最大和
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-10-27 11:07
 */
public class 连续子数组的最大和 {


    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int currMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currMax = Math.max(currMax + nums[i], nums[i]);
            max = Math.max(max, currMax);
        }
        return max;
    }

}