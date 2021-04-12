package com.example.qzq.acwing.搜索与图论.DFS;

import java.util.Scanner;

/**
 * @ClassName : n皇后问题
 * @Author : qiziqian
 * @Description:
 * @Date: 2021-04-08 16:27
 */
public class n皇后问题 {


    static int res = 0;
    static int n;
    static boolean[][] a;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new boolean[n][n];
        dfs(0);
    }

    public static void dfs(int index) {
        if (index == n) {
            res++;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(a[i][j] ? "Q" : ".");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            if (canPut(index, i)) {
                a[index][i] = true;
                dfs(index + 1);
                a[index][i] = false;
            }
        }

    }

    public static boolean canPut(int x, int y) {
        for (int i = 0; i < x; i++) {
            if (a[i][y]) return false;
        }
        for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
            if (a[i][j]) return false;
        }
        for (int i = x - 1, j = y + 1; i >= 0 && j < n; i--, j++) {
            if (a[i][j]) return false;
        }
        return true;
    }


}