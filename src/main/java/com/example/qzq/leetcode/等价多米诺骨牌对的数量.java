package com.example.qzq.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName : 等价多米诺骨牌对的数量
 * @Author : qiziqian
 * @Description:
 * @Date: 2021-01-26 10:11
 */
public class 等价多米诺骨牌对的数量 {
    public int numEquivDominoPairs(int[][] dominoes) {
        if (dominoes.length == 1) return 0;
        int[] count = new int[100];
        int res = 0;
        for (int[] dominoe : dominoes) {
            int index = 0;
            if (dominoe[0] > dominoe[1]) {
                index = dominoe[1] * 10 + dominoe[0];
            } else {
                index = dominoe[0] * 10 + dominoe[1];
            }
            res += count[index];
            count[index]++;
        }
        return res;
    }
}