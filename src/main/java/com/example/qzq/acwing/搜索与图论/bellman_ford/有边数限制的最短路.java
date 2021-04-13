package com.example.qzq.acwing.搜索与图论.bellman_ford;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName : 有边数限制的最短路
 * @Author : qiziqian
 * @Description:
 * @Date: 2021-04-13 10:48
 */
public class 有边数限制的最短路 {


    static int N = 10000010;
    static int m;
    static int n;
    static int k;
    static Edge[] edges;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        edges = new Edge[m];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int w = sc.nextInt();
            edges[i] = new Edge(a, b, w);
        }
        int i = bellman_ford();
        System.out.println(i == -1 ? "impossible" : i);

    }

    public static int bellman_ford() {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, N);
        dist[1] = 0;
        for (int i = 0; i < k; i++) {
            int[] currDist = Arrays.copyOf(dist, dist.length);
            for (int j = 0; j < m; j++) {
                Edge e = edges[j];
                dist[e.b] = Math.min(dist[e.b], currDist[e.a] + e.w);
            }
        }

        return dist[n] >= N / 2 ? -1 : dist[n];
    }

    public static class Edge {
        public int a;
        public int b;
        public int w;

        public Edge(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }

    }
}