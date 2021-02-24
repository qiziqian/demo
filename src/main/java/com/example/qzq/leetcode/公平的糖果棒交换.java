package com.example.qzq.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName : 公平的糖果棒交换
 * @Author : qiziqian
 * @Description:
 * @Date: 2021-02-01 10:12
 */
public class 公平的糖果棒交换 {
    public int[] fairCandySwap(int[] A, int[] B) {
        int maxA = 0;
        int maxB = 0;
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < A.length; i++) {
            maxA += A[i];
            set.add(A[i]);
        }
        for (int i = 0; i < B.length; i++) {
            maxB += B[i];
        }
        int delta = (maxA - maxB) / 2;
        for (int y : B) {
            int x = y + delta;
            if (set.contains(x)) {
                return new int[]{x, y};
            }
        }
        return new int[2];
    }
}