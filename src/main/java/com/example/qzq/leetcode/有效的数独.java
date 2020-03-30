package com.example.qzq.leetcode;

/**
 * @Classname 有效的数独
 * @Description
 * @Date 2019/12/20 16:42
 * @Created by qiziqian
 */
public class 有效的数独 {
    public static void main(String[] args) {
        char[][] board = new char[9][9];
        board[0] = new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'};
        board[1] = new char[]{'6', '.', '9', '.', '.', '8', '.', '.', '.'};
        board[2] = new char[]{'.', '.', '.', '4', '.', '6', '.', '.', '.'};
        board[3] = new char[]{'.', '.', '.', '.', '.', '.', '.', '1', '.'};
        board[4] = new char[]{'.', '.', '.', '.', '2', '.', '.', '3', '.'};
        board[5] = new char[]{'.', '4', '.', '.', '.', '.', '.', '.', '4'};
        board[6] = new char[]{'5', '.', '.', '6', '.', '.', '.', '.', '.'};
        board[7] = new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'};
        board[8] = new char[]{'.', '.', '.', '.', '7', '.', '6', '.', '.'};
        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        int length = 9;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (board[i][j] == '.') continue;
                if (!ifExist(board, i, j, length)) return false;
            }
        }
        return true;
    }

    public static boolean ifExist(char[][] board, int index1, int index2, int length) {
        char ch = board[index1][index2];
        //验证竖线
        for (int i = index1 + 1; i < length; i++) {
            if (ch == board[i][index2]) return false;
        }
        //验证横线
        for (int i = index2 + 1; i < length; i++) {
            if (ch == board[index1][i]) return false;
        }
        //验证正方形区域
        int area1 = (index1) / 3 * 3;
        int area2 = (index2) / 3 * 3;
        for (int i = area1; i < area1 + 3; i++) {
            for (int j = area2; j < area2 + 3; j++) {
                if (i == index1 && j == index2) continue;
                if (ch == board[i][j]) return false;
            }
        }

        return true;
    }
}
