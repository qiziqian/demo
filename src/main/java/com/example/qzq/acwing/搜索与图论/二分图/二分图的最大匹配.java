package com.example.qzq.acwing.搜索与图论.二分图;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description 匈牙利算法
 * @Date 2021/4/15 21:22
 * @Author by qiziqian
 */
public class 二分图的最大匹配 {


    static int N = 100010;
    static int M = 510;
    static int[] h = new int[M];
    static int[] ne = new int[N];
    static int[] e = new int[N];
    static boolean[] st = new boolean[N];
    static int[] match = new int[N];
    static int idx = 0;

    public static void main(String[] args) {
        Arrays.fill(h, -1);
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            add(u, v);
        }

        int res = 0;
        for (int i = 1; i <= n1; i++) {
            Arrays.fill(st, false);
            if (find(i)) res++;
        }
        System.out.println(res);
    }

    private static boolean find(int x) {
        for (int i = h[x]; i != -1; i = ne[i]) {
            int j = e[i];
            if (!st[j]) {
                st[j] = true;
                if (match[j] == 0 || find(match[j])) {
                    match[j] = x;
                    return true;
                }
            }
        }
        return false;
    }


    public static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
