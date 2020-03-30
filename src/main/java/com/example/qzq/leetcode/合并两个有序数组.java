package com.example.qzq.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Classname 合并两个有序数组
 * @Description
 * @Date 2019/10/8 14:01
 * @Created by qiziqian
 */
public class 合并两个有序数组 {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 0, 0, 0};
        int[] b = new int[]{1, 2, 3,};
        System.arraycopy(b, 0, a, 3, 3);
        for (int i1 = 0; i1 < a.length; i1++) {
            System.out.println(a[i1]);
        }
    }

    public static void merge4(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int p = m + n - 1;
        while (p1 >= 0 && p2 >= 0) {
            nums1[p--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
        }
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);

    }

    public static void merge3(int[] nums1, int m, int[] nums2, int n) {
        int[] nums_copy = new int[m];
        System.arraycopy(nums1, 0, nums_copy, 0, n);
        int p1 = 0, p2 = 0;
        int p = 0;
        while (p1 < m && p2 < n) {
            nums_copy[p++] = nums_copy[p1] > nums2[p2] ? nums2[p2++] : nums_copy[p1++];
        }
        if (p1 < m) {
            System.arraycopy(nums_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        }
        if (p2 < n) {
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
        }

    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < m - 1 || j < n - 1) {
            if (nums1[i] > nums2[j]) {
                list.add(nums2[j]);
                j = j >= n - 1 ? n - 1 : ++j;
            } else {
                list.add(nums1[i]);
                i = i >= m - 1 ? m - 1 : ++i;
            }

        }
        for (int y : nums1) {
            nums1[y] = list.get(y);
        }
    }

}
