package com.example.qzq.acwing.搜索与图论.BFS;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

/**
 * @ClassName : 走迷宫
 * @Author : qiziqian
 * @Description:
 * @Date: 2021-04-09 11:03
 */
public class 走迷宫 {


    static int[][] path;
    static boolean[][] pass;
    static int[][] maze;
    static int n;
    static int m;
    static int[][] direction = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        path = new int[n + 1][m + 1];
        maze = new int[n + 1][m + 1];
        pass = new boolean[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                maze[i][j] = sc.nextInt();
            }
        }
        bfs();
        System.out.println(path[n][m]);
    }

    public static void bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{1, 1});
        pass[1][1] = true;
        path[1][1] = 0;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            for (int i = 0; i < direction.length; i++) {
                int x = curr[0] + direction[i][0];
                int y = curr[1] + direction[i][1];
                if (x >= 1 && x <= n && y >= 1 && y <= m && maze[x][y] != 1 && !pass[x][y]) {
                    pass[x][y] = true;
                    path[x][y] = path[curr[0]][curr[1]] + 1;
                    queue.add(new int[]{x, y});
                }
            }
        }
    }
}