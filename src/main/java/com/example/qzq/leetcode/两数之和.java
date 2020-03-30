package com.example.qzq.leetcode;

import java.util.HashMap;

/**
 * @Classname 两数之和
 * @Description
 * @Date 2019/10/7 21:14
 * @Created by qiziqian
 */
public class 两数之和 {
    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{3, 2, 4}, 6);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    public static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);

        }
        return new int[]{0, 0};
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0};
    }
}
