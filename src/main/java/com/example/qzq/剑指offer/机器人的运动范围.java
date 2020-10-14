package com.example.qzq.剑指offer;

/**
 * @ClassName : 机器人的运动范围
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-10-09 13:14
 */
public class 机器人的运动范围 {
    static boolean[][] visited = new boolean[1][1];

    public static void main(String[] args) {
        System.out.println(movingCount(3, 2, 17));

    }

    public static int movingCount(int m, int n, int k) {
        visited = new boolean[m][n];
        return move(0, 0, m, n, k);
    }

    public static int move(int currRow, int currColumn, int m, int n, int k) {
        if (currRow >= m || currColumn >= n || visited[currRow][currColumn] || !couldMove(currRow, currColumn, k))
            return 0;
        visited[currRow][currColumn] = true;
        int right = move(currRow, currColumn + 1, m, n, k);
        int down = move(currRow + 1, currColumn, m, n, k);
        return right + down + 1;
    }

    public static boolean couldMove(int currRow, int currColumn, int k) {
        int threshold = 0;
        while (currRow > 0) {
            threshold += currRow % 10;
            currRow /= 10;
        }
        while (currColumn > 0) {
            threshold += currColumn % 10;
            currColumn /= 10;
        }
        return threshold <= k;
    }
}