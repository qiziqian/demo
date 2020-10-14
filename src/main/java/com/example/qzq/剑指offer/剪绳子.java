package com.example.qzq.剑指offer;

import java.util.Date;

/**
 * @ClassName : 剪绳子
 * @Author : qiziqian
 * @Description: 剪绳子/整数拆分
 * @Date: 2020-10-10 10:53
 */
public class 剪绳子 {
    public static void main(String[] args) {
        System.out.println(1603173069534L);
        System.out.println(System.currentTimeMillis());
        System.out.println(new Date(1603173069534L));
    }

    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i < n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(i * (i - j), i * dp[i - j]));
            }
        }
        return dp[n];
    }

}