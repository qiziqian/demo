package com.example.qzq.leetcode.背包九讲;

/**
 * @Description
 * @Date 2021/2/12 14:57
 * @Author by qiziqian
 */
public class O1背包 {

    int res = 0;
    int[] nums;

    public int o1package(int nums[], int v) {
        this.nums = nums;
        recur(0, 0, v);
        return res;
    }

    public void recur(int i, int curr, int v) {
        if (i == nums.length) {
            res = Math.max(res, curr);
        }

        for (int j = i; j < nums.length; j++) {
            recur(i + 1, curr, v);
            recur(i + 1, curr + nums[i], v);
        }
    }

    public int o1package2(int N, int V, int[] v, int[] w) {
        //dp[i][j]表示在 只能选择前i个物品，背包容量为j的情况下，背包中物品的最大价值
        int[][] dp = new int[N + 1][V + 1];

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= V; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= v[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - v[i]] + w[i]);
                }
            }
        }
        return dp[N][V];
    }

    public int o1package3(int N, int V, int[] v, int[] w) {
        //dp[i][j]表示在 只能选择前i个物品，背包容量为j的情况下，背包中物品的最大价值
        int[] dp = new int[V + 1];

        for (int i = 0; i <= N; i++) {
            for (int j = V; j >= v[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - v[i]] + w[i]);
            }
        }
        return dp[V];
    }
}
