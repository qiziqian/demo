package com.example.qzq.acwing.搜索与图论.Prim;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName : Prim算法求最小生成树
 * @Author : qiziqian
 * @Description: 类似dijkstra, dijkstra用离起点更近的点来更新后面的点, prim用离集合最近的点更新其他的点
 * @Date: 2021-04-14 11:10
 */
public class Prim算法求最小生成树 {


    static int[][] g;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();

        g = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                g[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            g[u][v] = g[v][u] = Math.min(g[u][v], w);
        }

        int prim = prim();
        if (prim == -1) System.out.println("impossible");
        else System.out.println(prim);

    }

    public static int prim() {
        int[] dist = new int[n + 1];
        boolean[] v = new boolean[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        int res = 0;
        for (int i = 1; i <= n; i++) {
            int t = -1;
            for (int j = 1; j <= n; j++) {
                if (!v[j] && (t == -1 || dist[t] > dist[j])) {
                    t = j;
                }
            }
            if (dist[t] == Integer.MAX_VALUE) return -1;
            res += dist[t];
            for (int j = 1; j <= n; j++) {
                if (!v[t]) dist[j] = Math.min(dist[j], g[t][j]);
            }
            v[t] = true;
        }
        return res;
    }
}