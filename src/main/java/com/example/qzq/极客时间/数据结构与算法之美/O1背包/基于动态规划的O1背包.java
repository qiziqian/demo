package com.example.qzq.极客时间.数据结构与算法之美.O1背包;

/**
 * @ClassName : 基于动态规划的O1背包
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-09-24 16:21
 */
public class 基于动态规划的O1背包 {


    public static void main(String[] args) {
        int[] weight = {2, 2, 4, 6, 3}; // 物品重量
        System.out.println(knapsack2(weight, 5, 9));
    }

    //完整版
    //weight:物品重量，n:物品个数，w:背包可承载重量
    public static int knapsack(int[] weight, int n, int w) {
        boolean[][] state = new boolean[n][w + 1];

        state[0][0] = true;
        if (weight[0] <= w) state[0][weight[0]] = true;
        for (int i = 1; i < weight.length; i++) {
            for (int currWeight = 0; currWeight < w; currWeight++) {
                if (state[i - 1][currWeight]) {
                    state[i][currWeight] = true;
                }
            }
            for (int currWeight = 0; currWeight < w - weight[i]; currWeight++) {
                if (state[i - 1][currWeight]) {
                    if (currWeight + weight[i] <= w) state[i][currWeight + weight[i]] = true;
                }
            }
        }
        for (int i = w; i >= 0; i--) {
            if (state[n - 1][i]) return i;
        }
        return -1;

    }

    //优化版 精简代码
    //weight:物品重量，n:物品个数，w:背包可承载重量
    public static int knapsack2(int[] weight, int n, int w) {
        boolean[] state = new boolean[w + 1];

        state[0] = true;
        if (weight[0] <= w) state[weight[0]] = true;
        for (int i = 1; i < weight.length; i++) {
            for (int currWeight = 0; currWeight < w - weight[i]; currWeight++) {
                if (state[currWeight]) {
                    state[currWeight + weight[i]] = true;
                }
            }

        }
        for (int i = w; i >= 0; i--) {
            if (state[i]) return i;
        }

        return -1;
    }
}