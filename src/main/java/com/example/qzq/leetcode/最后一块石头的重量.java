package com.example.qzq.leetcode;

import java.util.*;

/**
 * @ClassName : 最后一块石头的重量
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-12-30 10:04
 */
public class 最后一块石头的重量 {
    public static void main(String[] args) {
        System.out.println('w' + " : " + (int) 'w');
        System.out.println('a' + " : " + (int) 'a');
        System.out.println('s' + " : " + (int) 's');
        System.out.println('d' + " : " + (int) 'd');
        System.out.println('q' + " : " + (int) 'q');
        System.out.println('r' + " : " + (int) 'r');
        //  lastStoneWeight(new int[]{2,7,4,1,8,1});
    }

    public static int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);
        int toIndex = stones.length - 1;
        while (toIndex > 0) {
            if (stones[toIndex] > stones[toIndex - 1]) {
                stones[toIndex - 1] = stones[toIndex] - stones[toIndex - 1];
                toIndex--;
            } else if (stones[toIndex] == stones[toIndex - 1]) {
                toIndex -= 2;
            }
            Arrays.sort(stones, 0, toIndex + 1);
        }
        return stones[0];
    }
}