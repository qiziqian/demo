package com.example.qzq.剑指offer;

/**
 * @ClassName : 顺时针打印矩阵
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-09-10 15:13
 */
public class 顺时针打印矩阵 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {16, 17, 18, 19, 6},
                {15, 24, 25, 20, 7},
                {14, 23, 22, 21, 8},
                {13, 12, 11, 10, 9}
        };
        int[] ints = spiralOrder(matrix);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + ", ");
        }
    }

    public static int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return new int[0];
        int[] array = new int[matrix.length * matrix[0].length];
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        int index = 0;

        while (true) {
            //从左往右
            for (int i = left; i <= right; i++) {
                array[index++] = matrix[top][i];
            }
            top++;
            if (top > bottom) break;
            //从上往下
            for (int i = top; i <= bottom; i++) {
                array[index++] = matrix[i][right];
            }
            right--;
            if (left > right) break;
            //从右往左
            for (int i = right; i >= left; i--) {
                array[index++] = matrix[bottom][i];
            }
            bottom--;
            if (top > bottom) break;
            //从下往上
            for (int i = bottom; i >= top; i--) {
                array[index++] = matrix[i][left];
            }
            left++;
            if (left > right) break;
        }

        return array;
    }

}