package com.example.qzq.剑指offer;

import java.util.PriorityQueue;

/**
 * @ClassName : 数组中的逆序对
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-10-28 17:30
 */
public class 数组中的逆序对 {
    public int reversePairs(int[] nums) {
        if (nums.length < 2) return 0;
        int length = nums.length;
        int[] copy = new int[length];
        for (int i = 0; i < length; i++) {
            copy[i] = nums[i];
        }
        int[] temp = new int[length];
        return reversePairs(copy, 0, length - 1, temp);
    }

    private int reversePairs(int[] nums, int left, int right, int[] temp) {
        if (left == right) return 0;

        int mid = left + (right - left) / 2;
        int leftCount = reversePairs(nums, left, mid, temp);
        int rightCount = reversePairs(nums, mid + 1, right, temp);

        if (nums[mid] <= nums[mid + 1]) {
            return leftCount + rightCount;
        }
        int mergeCount = mergeAndCount(nums, left, mid, right, temp);
        return leftCount + rightCount + mergeCount;
    }

    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
        int i = left;
        int j = mid + 1;
        int count = 0;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                nums[k] = temp[j++];
            } else if (j == right + 1) {
                nums[k] = temp[i++];
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i++];
            } else {
                nums[k] = temp[j++];
                count += (mid - i + 1);
            }
        }

        return count;
    }

}