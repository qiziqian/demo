package com.example.qzq.leetcode;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

/**
 * @Classname 第三大的数
 * @Description
 * @Date 2019/10/7 20:38
 * @Created by qiziqian
 */
public class 第三大的数 {
    public static void main(String[] args) {
        int[] arr = {1, 2, -2147483648};
        System.out.println(thirdMax(arr));
    }

    public static int thirdMax(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int flag = 0;
        boolean f = true;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == Integer.MIN_VALUE && f) {
                flag++;
                f = false;
            }
            if (nums[i] > max1) {
                flag++;
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            } else if (nums[i] > max2 && nums[i] < max1) {
                flag++;
                max3 = max2;
                max2 = nums[i];
            } else if (nums[i] >= max3 && nums[i] < max2) {
                flag++;
                max3 = nums[i];
            }
        }
        return flag < 3 ? max1 : max3;
    }

    public static int thirdMax2(int[] nums) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (int i = 0; i < nums.length; i++) {
            linkedHashSet.add(nums[i]);
        }
        ArrayList collect = (ArrayList) linkedHashSet.stream().sorted().collect(Collectors.toList());
        System.out.println(collect.toString());
        if (collect.size() - 3 <= 0) {
            return (Integer) collect.get(collect.size() - 1);
        }
        return (Integer) collect.get(collect.size() - 3);
    }
}
