package com.example.qzq.leetcode;

/**
 * @ClassName : 反转矩阵的最高得分
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-12-07 10:35
 */
public class 反转矩阵的最高得分 {

    public static void main(String[] args) {
        int[][] A = new int[3][4];
        A[0] = new int[]{0, 0, 1, 1};
        A[1] = new int[]{1, 0, 1, 0};
        A[2] = new int[]{1, 1, 0, 0};

        matrixScore2(A);
    }

    public static int matrixScore2(int[][] A) {
        int column = A.length;
        int row = A[0].length;
        int result = column * (1 << (row - 1));
        for (int j = 1; j < A[0].length; j++) {
            int oneCount = 0;
            for (int i = 0; i < A.length; i++) {
                if (A[i][j] == A[i][0]) oneCount++;
            }
            oneCount = Math.max(oneCount, column - oneCount);
            result += oneCount * (1 << (row - j - 1));
        }
        return result;
    }
}