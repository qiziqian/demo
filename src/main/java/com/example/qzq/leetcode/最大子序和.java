package com.example.qzq.leetcode;

/**
 * @Classname 最大子序和
 * @Description
 * @Date 2019/10/9 17:17
 * @Created by qiziqian
 */
public class 最大子序和 {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{1, -3, 6, -1, 0, 3, 4}));
    }

    // 2019/10/9 17:31  qiziqian   如果一个序列里包含正数,那么他的最大子序列一定是正数
    public static int maxSubArray(int[] nums) {
        int sum1 = nums[0];
        int sum2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum2 > 0) {
                sum2 += nums[i];
            } else {
                sum2 = nums[i];
            }
            sum1 = Math.max(sum1, sum2);
        }
        return sum1;
    }
}
