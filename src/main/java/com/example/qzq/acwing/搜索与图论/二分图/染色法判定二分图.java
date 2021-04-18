package com.example.qzq.acwing.搜索与图论.二分图;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description
 * @Date 2021/4/15 19:32
 * @Author by qiziqian
 */
public class 染色法判定二分图 {

    static int N = 100010;
    static int[] h = new int[N];
    static int[] ne = new int[2 * N];
    static int[] e = new int[2 * N];
    static int[] color = new int[N];
    static int idx = 0;

    public static void main(String[] args) {
        Arrays.fill(h, -1);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            add(u, v);
            add(v, u);
        }
        boolean flag = true;
        for (int i = 1; i <= n; i++) {
            if (color[i] == 0) {
                if (!dfs(i, 1)) {
                    flag = false;
                    break;
                }
            }
        }
        if (flag) System.out.println("Yes");
        else System.out.println("No");

    }

    private static boolean dfs(int n, int c) {
        color[n] = c;

        for (int i = h[n]; i != -1; i = ne[i]) {
            int j = e[i];
            if (color[j] == 0) {
                if (!dfs(j, 3 - c)) return false;
            } else if (color[j] == c) return false;

        }

        return true;
    }

    public static void add(int u, int v) {
        e[idx] = v;
        ne[idx] = h[u];
        h[u] = idx++;
    }
}
