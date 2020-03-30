package com.example.qzq.geekbang;

/**
 * @Classname 棋盘最短路径
 * @Description 动态规划练习
 * @Date 2019/11/21 10:59
 * @Created by qiziqian
 */
public class 棋盘最短路径 {
    //通过回溯找到最短路径
    private int minDist = Integer.MAX_VALUE;
    private int[][] w = new int[3][3];
    //动态规划-状态转移方程法
    private int[][] matrix = {{1, 3, 5, 9}, {2, 1, 3, 4}, {5, 2, 6, 7}, {6, 8, 4, 3}};
    private int[][] mem = new int[4][4];

    public void minDistBT(int i, int j, int dist, int w[][], int n) {
        if (i == n && j == n) {
            if (dist < minDist) minDist = dist;
            return;
        }
        if (i < n) {
            minDistBT(i + 1, j, dist + w[i + 1][j], w, n);
        }
        if (i < j) {
            minDistBT(i, j + 1, dist + w[i][j + 1], w, n);
        }
    }

    //动态规划-状态转移表法
    public int setMinDistBT2(int martix[][], int n) {
        int[][] states = new int[n][n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += martix[i][0];
            states[i][0] += sum;
        }
        sum = 0;
        for (int i = 0; i < n; i++) {
            sum += martix[0][i];
            states[0][i] += martix[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                states[i][j] = martix[i][j] + Math.min(states[i - 1][j], states[i][j - 1]);
            }
        }
        return states[n - 1][n - 1];
    }

    public int minDistBT3(int i, int j) {
        if (i == 0 && j == 0) return matrix[0][0];
        if (mem[i][j] != 0) return mem[i][j];
        int minUp = Integer.MAX_VALUE;
        if (i >= 1) {
            minUp = minDistBT3(i - 1, j);
        }
        int minLeft = Integer.MAX_VALUE;
        if (j >= 1) {
            minLeft = minDistBT3(i, j - 1);
        }
        int curr = matrix[i][j] + Math.min(minLeft, minUp);
        mem[i][j] = curr;
        return curr;
    }
}
