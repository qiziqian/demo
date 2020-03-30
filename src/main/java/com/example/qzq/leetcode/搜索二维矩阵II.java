package com.example.qzq.leetcode;

/**
 * @Classname 搜索二维矩阵II
 * @Description
 * @Date 2019/11/29 12:29
 * @Created by qiziqian
 */
public class 搜索二维矩阵II {
    public static void main(String[] args) {

        int[][] matrix = new int[5][5];
        matrix[0] = new int[]{1, 4, 7, 11, 15};
        matrix[1] = new int[]{2, 5, 8, 12, 19};
        matrix[2] = new int[]{3, 6, 9, 16, 22};
        matrix[3] = new int[]{10, 13, 14, 17, 24};
        matrix[4] = new int[]{18, 21, 23, 26, 30};

        System.out.println(searchMatrix(matrix, 5));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] > target) continue;
            int high = matrix[i].length - 1;
            int low = 0;
            while (low <= high) {
                int mid = high + (low - high) / 2;
                if (target > matrix[i][mid]) {
                    low = mid + 1;
                } else if (target < matrix[i][mid]) {
                    high = mid - 1;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
//    public static boolean searchMatrix(int[][] matrix, int target) {
//        int high = matrix.length;
//        int low = 0;
//        while (low < high) {
//            int mid = high + (low - high) / 2;
//            if (target > matrix[mid][0]) {
//                low = mid + 1;
//                if (target < matrix[mid + 1][0]) {
//                    return binarySearch(matrix[mid], target);
//                }
//            } else if (target < matrix[mid][0]) {
//                if (target > matrix[mid - 1][0]) {
//                    return binarySearch(matrix[mid - 1], target);
//                }
//                high = mid - 1;
//            } else if (target == matrix[mid][0]) {
//                return true;
//            }
//        }
//        return false;
//    }

    public static boolean binarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        while (low < high) {
            int mid = low + (low - high) / 2;
            if (target > mid) {
                low = mid + 1;
            } else if (target < mid) {
                high = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
