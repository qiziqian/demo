package com.example.qzq.leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * @Classname 下一个更大元素I
 * @Description
 * @Date 2019/11/25 16:38
 * @Created by qiziqian
 */
public class 下一个更大元素I {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i : nums2) {
            while (!stack.isEmpty() && stack.peek() < i) {
                map.put(stack.pop(), i);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }
        int[] nums = new int[nums1.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = map.get(nums1[i]);
        }
        return nums;
    }
}
