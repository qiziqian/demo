package com.example.qzq.leetcode;

import java.util.ArrayList;

/**
 * @Classname 打家劫舍
 * @Description
 * @Date 2019/10/12 10:18
 * @Created by qiziqian
 */
public class 打家劫舍 {
    public static void main(String[] args) {
        rob(new int[]{1, 2, 3, 1});
    }

    public static int rob(int[] nums) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < nums.length; i = i + 2) {
            list1.add(nums[i]);
        }
        for (int i = 1; i < nums.length; i = i + 2) {
            list2.add(nums[i]);
        }
        int count1 = (int) list1.stream().mapToInt((x) -> x).summaryStatistics().getSum();
        int count2 = (int) list2.stream().mapToInt((x) -> x).summaryStatistics().getSum();
        return Math.max(count1, count2);
    }
}
