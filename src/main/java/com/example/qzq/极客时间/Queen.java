package com.example.qzq.极客时间;

/**
 * Classname Queen
 * Description   回溯算法 求解八皇后问题
 * Date 2019/11/18 10:46
 * Created by qiziqian
 */
public class Queen {
    static int[] result = new int[8];

    public static void cal8queen(int row) {
        if (row == 8) {
            //打印
            print();
            return;
        }
        for (int column = 0; column < 8; ++column) {
            if (isOk(row, column)) {
                result[row] = column;
                cal8queen(row + 1);
            }
        }
    }

    public static boolean isOk(int row, int column) {
        int rightup = column + 1, leftup = column - 1;
        for (int i = row - 1; i >= 0; i--) {
            if (result[i] == column) return false;
            if (rightup <= 8 && result[i] == rightup) return false;
            if (leftup >= 0 && result[i] == leftup) return false;
            rightup++;
            leftup--;
        }
        return true;
    }

    public static void print() {
        for (int row = 0; row < 8; ++row) {
            for (int column = 0; column < 8; ++column) {
                if (result[row] == column) System.out.print("Q ");
                else System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        cal8queen(0);
    }

}
