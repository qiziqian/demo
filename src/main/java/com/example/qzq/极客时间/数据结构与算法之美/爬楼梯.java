package com.example.qzq.极客时间.数据结构与算法之美;

import java.util.HashMap;

/**
 * @Classname 爬楼梯
 * @Description
 * @Date 2019/10/11 10:15
 * @Created by qiziqian
 */
public class 爬楼梯 {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    int minDist;

    public static void main(String[] args) {
        System.out.println(climbStairs2(3));
    }

    public static int climbStairs4(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int possible = climbStairs4(n - 1) + climbStairs4(n - 2);
        return possible;
    }

    //    public static int climbStairs(int n) {
//       return climb_Stairs(0, n);
//    }
    public static int climb_Stairs(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n);
    }

    public static int climbStairs2(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int climbStairs(int n) {
        if (n == 2) return 2;
        if (n == 1) return 1;
        int count;
        if (map.containsKey(n)) {
            count = map.get(n);
        } else {
            count = climbStairs(n - 2) + climbStairs(n - 1);
            map.put(n, count);
        }
        return count;
    }

    public void climb(int w[][], int dist, int i, int j, int n) {
        if (i == n && j == n) {
            if (dist < minDist) minDist = dist;
        }
        if (i < n) {
            climb(w, dist + w[i + 1][j], i + 1, j, n);
        }
        if (j < n) {
            climb(w, dist + w[i][j] + 1, i, j + 1, n);
        }

    }

}
