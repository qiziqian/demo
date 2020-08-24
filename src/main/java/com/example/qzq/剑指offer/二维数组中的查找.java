package com.example.qzq.剑指offer;

/**
 * @ClassName : 二维数组的查找
 * @Author : qiziqian
 * @Description: 二维数组从左到右依次增大, 从上到下依次增大, 查找二维数组中有没有指定的值
 * @Date: 2020-08-18 14:07
 */
public class 二维数组中的查找 {
    private static int matrix[][] = {
            {1, 2, 8, 9},
            {2, 4, 9, 12},
            {4, 7, 10, 13},
            {6, 8, 11, 15}
    };

    public static void main(String[] args) {
        System.out.println(find(matrix, 4, 4, 66));
    }

    public static boolean find(int[][] matrix, int rows, int columns, int num) {
        if (matrix == null || rows == 0 || columns == 0) {
            return false;
        }
        int row = 0;
        int column = columns - 1;
        while (row < rows && column >= 0) {
            if (num > matrix[row][column]) {
                row++;
            } else if (num == matrix[row][column]) {
                return true;
            } else if (num < matrix[row][column]) {
                column--;
            }
        }
        return false;
    }

}