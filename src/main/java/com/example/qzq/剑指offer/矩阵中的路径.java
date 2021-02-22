package com.example.qzq.剑指offer;

import java.util.Arrays;

/**
 * @Description
 * @Date 2020/10/2 16:38
 * @Author by qiziqian
 */
public class 矩阵中的路径 {

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCESEEEFS";
        System.out.println(exist(board, word));
        boolean[][] isPassed = new boolean[board.length][board[0].length];
        isPassed[0][3] = true;

    }

    public static boolean exist(char[][] board, String word) {
        if (null == word || " ".equals(word)) return false;

        boolean[][] isPassed = new boolean[board.length][board[0].length];
        char c = word.charAt(0);

        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                if (recur(board, word, 0, row, column)) return true;
            }
        }
        return false;
    }

    public static boolean recur(char[][] board, String word, int index, int row, int column) {
        if (row >= board.length || row < 0) return false;
        if (column >= board[0].length || column < 0) return false;
        if (board[row][column] != word.charAt(index)) return false;
        if (index == word.length() - 1) return true;
        char temp = board[row][column];
        board[row][column] = '/';
        boolean up = recur(board, word, index + 1, row - 1, column);
        boolean down = recur(board, word, index + 1, row + 1, column);
        boolean left = recur(board, word, index + 1, row, column - 1);
        boolean right = recur(board, word, index + 1, row, column + 1);
        board[row][column] = temp;
        return down || up || left || right;
    }


}
