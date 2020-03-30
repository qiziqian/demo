package com.example.qzq.leetcode;

/**
 * @Classname 最小路径和
 * @Description
 * @Date 2019/12/23 14:59
 * @Created by qiziqian
 */
public class 最小路径和 {

    public static void main(String[] args) {
        int[][] grid = new int[2][3];
        grid[0] = new int[]{1, 2, 5};
        grid[1] = new int[]{3, 2, 1};
        //  grid[2] = new int []{4,2,1};
        minPathSum(grid);
    }

    public static int minPathSum(int[][] grid) {
        //状态表转移法
        int length1 = grid.length;
        int length2 = grid[0].length;
        int[][] minLength = new int[length1][length2];
        //初始化第一个格子
        minLength[0][0] = grid[0][0];
        //初始化第一列
        for (int i = 1; i < length1; i++) {
            minLength[i][0] = minLength[i - 1][0] + grid[i][0];
        }
        //初始化第一行
        for (int i = 1; i < length2; i++) {
            minLength[0][i] = minLength[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < length1; i++) {
            for (int j = 1; j < length2; j++) {
                System.out.println(i + " " + j);
                minLength[i][j] = Math.min(minLength[i][j - 1], minLength[i - 1][j]) + grid[i][j];
            }
        }
        return minLength[length1 - 1][length2 - 1];
    }
}
