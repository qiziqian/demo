package com.example.qzq.leetcode;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * @Classname 删除排序数组中的重复项
 * @Description
 * @Date 2019/10/25 15:10
 * @Created by qiziqian
 */
public class 删除排序数组中的重复项 {
    public static void main(String[] args) {
        System.out.println(removeDuplicates2(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }

    public static int removeDuplicates2(int[] nums) {
        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[i] != nums[j]) nums[++i] = nums[j];
            j++;
        }
        return i + 1;
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length < 1) return 0;
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int[] ints = set.stream().mapToInt(Integer::intValue).toArray();
        for (int i = 0; i < ints.length; i++) {
            nums[i] = ints[i];
        }
        return (int) Arrays.stream(nums).distinct().count();
    }
}
