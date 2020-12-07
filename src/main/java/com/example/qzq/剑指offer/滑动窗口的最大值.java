package com.example.qzq.剑指offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName : 滑动窗口的最大值
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-10-30 15:28
 */
public class 滑动窗口的最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList();

        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        result[0] = deque.peekFirst();
        int index = 1;
        for (int i = k; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            result[index++] = deque.peekFirst();
        }
        return result;
    }
}