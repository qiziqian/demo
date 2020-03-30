package com.example.qzq.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname 滑动窗口最大值
 * @Description
 * @Date 2019/12/17 16:44
 * @Created by qiziqian
 */
public class 滑动窗口最大值 {
    public static void main(String[] args) {

    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        Queue<Integer> queue = new LinkedList();
        int[] maxes = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }
        Integer max = queue.stream().max(Integer::compare).get();
        maxes[0] = max;
        int j = 1;
        for (int i = k; i < nums.length; i++) {
            queue.poll();
            queue.add(nums[i]);
            max = queue.stream().max(Integer::compare).get();
            maxes[j] = max;
            j++;
        }
        return maxes;
    }

    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        int[] maxes = new int[nums.length - k + 1];
        int i, j;
        int maxPos = -1;
        for (i = 0; i <= nums.length - k; ++i) {
            j = i + k - 1;
            if (maxPos != -1 && nums[j] >= nums[maxPos]) {
                maxPos = j;
                maxes[i] = nums[maxPos];
            } else if (i <= maxPos) {
                maxes[i] = nums[maxPos];
            } else {
                int maxWindow = Integer.MIN_VALUE;
                int maxPosWindow = 0;
                for (int z = i; z <= j; ++z) {
                    if (nums[z] > maxWindow) {
                        maxPosWindow = z;
                        maxWindow = nums[z];
                    }
                }
                maxPos = maxPosWindow;
                maxes[i] = nums[maxPos];
            }
        }
        return maxes;
    }
}
