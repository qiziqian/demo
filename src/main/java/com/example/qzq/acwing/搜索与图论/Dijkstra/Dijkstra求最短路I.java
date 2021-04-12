package com.example.qzq.acwing.搜索与图论.Dijkstra;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description
 * @Date 2021/4/10 22:19
 * @Author by qiziqian
 */
public class Dijkstra求最短路I {


    static int n;
    static int[][] g;

    static int maxLength = 10001;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        g = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(g[i], 10001);
        }
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int dis = sc.nextInt();
            g[a][b] = Math.min(g[a][b], dis);

        }

        System.out.println(dijkstra());
    }

    public static int dijkstra() {
        int[] d = new int[n + 1];
        boolean[] st = new boolean[n];
        Arrays.fill(d, maxLength);
        d[1] = 0;
        for (int i = 0; i < n; i++) {

            int t = -1;
            for (int j = 1; j <= n; j++) {
                if (!st[j] && (t == -1 || d[t] > d[j])) {
                    t = j;
                }
            }

            for (int j = 1; j <= n; j++) {
                d[j] = Math.min(d[j], d[t] + g[t][j]);
            }

            st[t] = true;
        }
        return d[n] == maxLength ? -1 : d[n];
    }


}
