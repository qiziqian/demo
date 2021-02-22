package com.example.qzq.剑指offer;

/**
 * @Description
 * @Date 2020/10/2 18:01
 * @Author by qiziqian
 */
public class 不同路径 {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
    }

    public static int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) return 1;
        int[][] pathCount = new int[m][n];
        pathCount[0][0] = 0;
        for (int i = 1; i < m; i++) {
            pathCount[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            pathCount[0][i] = 1;
        }

        for (int row = 1; row < m; row++) {
            for (int column = 1; column < n; column++) {
                pathCount[row][column] = pathCount[row - 1][column] + pathCount[row][column - 1];
            }
        }
        return pathCount[m - 1][n - 1];
    }
}
