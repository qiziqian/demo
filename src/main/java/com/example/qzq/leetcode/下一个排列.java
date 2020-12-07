package com.example.qzq.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName : 下一个排列
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-11-10 10:39
 */
public class 下一个排列 {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{1, 2, 3, 4, 8, 7, 5, 6};
        String[] strarray = new String[]{"1,2,3,4,8,7,5,6"};
        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 1;
            }
        });

    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }


    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }

    }

}