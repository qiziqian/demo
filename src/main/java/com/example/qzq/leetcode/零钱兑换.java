package com.example.qzq.leetcode;

/**
 * @Classname 零钱兑换
 * @Description
 * @Date 2019/12/23 15:34
 * @Created by qiziqian
 */
public class 零钱兑换 {
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
    }

    public static int coinChange(int[] coins, int amount) {
        helper(coins, amount, 1, amount);
        return min;
    }

    public static void helper(int[] coins, int amount, int currCoinNum, int exist) {
        if (exist < 0) return;
        if (exist == 0) {
            min = Math.min(currCoinNum, min);
            return;
        }
        for (int i = 0; i < coins.length; i++) {
            helper(coins, amount, ++currCoinNum, amount - coins[i]);
        }
    }
}
