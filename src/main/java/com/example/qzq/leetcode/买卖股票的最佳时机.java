package com.example.qzq.leetcode;

/**
 * @Classname 买卖股票的最佳时机
 * @Description
 * @Date 2019/12/23 16:17
 * @Created by qiziqian
 */
public class 买卖股票的最佳时机 {
    public static void main(String[] args) {

    }

    public int maxProfit1(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i; j < prices.length; j++) {
                max = Math.max(max, prices[j] - prices[i]);
            }
        }
        return max;
    }

    public int maxProfit2(int[] prices) {
        int max = 0;
        int min = 0;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }

        return max;
    }
}
