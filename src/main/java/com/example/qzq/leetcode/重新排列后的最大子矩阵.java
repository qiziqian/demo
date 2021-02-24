package com.example.qzq.leetcode;

import java.util.Arrays;

/**
 * @ClassName : 重新排列后的最大子矩阵
 * @Author : qiziqian
 * @Description:
 * @Date: 2021-01-19 17:02
 */
public class 重新排列后的最大子矩阵 {

    public static void main(String[] args) {
        largestSubmatrix(new int[][]{{0, 0, 1}, {1, 1, 1}, {1, 0, 1}});
    }

    public static int largestSubmatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) matrix[i][j] += matrix[i - 1][j];
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            Arrays.sort(matrix[i]);
            for (int j = m - 1; j >= 0; j--) {
                if (matrix[i][j] == 0) break;
                int height = matrix[i][j];
                res = Math.max(res, height * (m - j));
            }
        }

        return res;
    }

}