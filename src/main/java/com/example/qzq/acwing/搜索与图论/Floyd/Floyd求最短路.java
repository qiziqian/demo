package com.example.qzq.acwing.搜索与图论.Floyd;

import java.util.Scanner;

/**
 * @Description 用来求多源最短路, 本质上是一种动态规划
 * @Date 2021/4/13 22:31
 * @Author by qiziqian
 */
public class Floyd求最短路 {

    static int[][] dist;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        dist = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                dist[i][j] = 0x3f3f3f;
            }
        }


        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int w = sc.nextInt();
            dist[a][b] = Math.min(dist[a][b], w);
        }

        floyd();

        for (int i = 0; i < k; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (dist[a][b] >= 0x3f3f3f / 2) System.out.println("impossible");
            else System.out.println(dist[a][b]);
        }

    }

    public static void floyd() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }
}
