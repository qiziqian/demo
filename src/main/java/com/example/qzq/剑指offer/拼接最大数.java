package com.example.qzq.剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName : 拼接最大数
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-12-02 11:23
 */
public class 拼接最大数 {
    public static void main(String[] args) {
        int[] nums1 = {6, 7};
        int[] nums2 = {6, 0, 4};
        maxNumber(nums1, nums2, 5);
    }

    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] result = new int[0];
        for (int i = Math.min(nums1.length, k); i >= 0 && k - i <= nums2.length; i--) {
            int[] temp1 = getKLargestNum(nums1, i);
            int[] temp2 = getKLargestNum(nums2, k - i);
            int[] merge = merge(temp1, temp2);
            result = getMax(merge, result);
        }
        return result;

    }

    private static int[] getKLargestNum(int[] nums, int k) {
        if (k == 0) return new int[0];
        LinkedList<Integer> stack = new LinkedList<>();
        int popCount = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && stack.peekFirst() < nums[i] && popCount < nums.length - k) {
                stack.pollFirst();
                popCount++;
            }
            stack.push(nums[i]);
        }
        int[] array = new int[k];
        for (int i = 0; i < array.length; i++) {
            array[i] = stack.pollLast();
        }
        return array;
    }

    private static int[] merge(int[] temp1, int[] temp2) {
        if (temp1.length < 1) return temp2;
        if (temp2.length < 1) return temp1;

        int[] array = new int[temp1.length + temp2.length];
        int cur = 0, p1 = 0, p2 = 0;
        while (cur < temp1.length + temp2.length) {
            if (compare(temp1, p1, temp2, p2)) {
                array[cur++] = temp1[p1++];
            } else {
                array[cur++] = temp2[p2++];
            }
        }
        return array;
    }

    private static boolean compare(int[] temp1, int p1, int[] temp2, int p2) {
        if (p2 >= temp2.length) return true;
        if (p1 >= temp1.length) return false;
        if (temp1[p1] > temp2[p2]) return true;
        if (temp1[p1] < temp2[p2]) return false;
        return compare(temp1, p1 + 1, temp2, p2 + 1);
    }

    private static int[] getMax(int[] merge, int[] result) {
        if (merge.length > result.length) return merge;
        else if (merge.length < result.length) return result;

        for (int i = 0; i < merge.length; i++) {
            if (merge[i] > result[i]) return merge;
            else if (merge[i] < result[i]) return result;
        }
        return result;
    }


}