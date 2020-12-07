package com.example.qzq.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Stack;

/**
 * @ClassName : 最接近原点的K个点
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-11-09 10:33
 */
public class 最接近原点的K个点 {

    Stack<Integer> stack = new Stack<>();

    public int[][] kClosest(int[][] points, int K) {

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0] * o1[0] + o1[1] * o1[1] - o2[0] * o2[0] + o2[1] * o2[1]);
            }
        });

        return Arrays.copyOfRange(points, 0, K);
    }
}