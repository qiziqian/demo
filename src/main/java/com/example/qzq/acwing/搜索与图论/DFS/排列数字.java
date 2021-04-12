package com.example.qzq.acwing.搜索与图论.DFS;

import java.util.*;

/**
 * @ClassName : 排列数字
 * @Author : qiziqian
 * @Description:
 * @Date: 2021-04-08 15:34
 */
public class 排列数字 {
/*

    用一棵树来模拟,比较容易理解


    顺序,搜索的顺序是理解的关键
 */

    static int[] set;
    static int[] path;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        set = new int[n + 1];
        path = new int[n];
        dfs(0);
    }

    public static void dfs(int index) {
        if (index == n) {
            for (int i : path) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (set[i] == 0) {
                set[i] = 1;
                path[index] = i;
                dfs(index + 1);
                set[i] = 0;
            }
        }
    }
}