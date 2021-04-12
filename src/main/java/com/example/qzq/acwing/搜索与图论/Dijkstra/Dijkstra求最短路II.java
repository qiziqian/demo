package com.example.qzq.acwing.搜索与图论.Dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @ClassName : Dijkstra求最短路II
 * @Author : qiziqian
 * @Description: 邻接表/堆优化版,适合于稀疏图
 * @Date: 2021-04-12 11:25
 */
public class Dijkstra求最短路II {
    static int n = 0;
    static int m = 0;
    static int N = 1000010;

    static int[] h = new int[N];
    static int[] ne = new int[N];
    static int[] e = new int[N];
    static int[] w = new int[N];
    static int idx = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String[] params = buf.readLine().split(" ");
        n = Integer.parseInt(params[0]);
        m = Integer.parseInt(params[1]);
        Arrays.fill(h, -1);
        for (int i = 1; i <= m; ++i) {
            String[] info = buf.readLine().split(" ");
            int a = Integer.parseInt(info[0]);
            int b = Integer.parseInt(info[1]);
            int c = Integer.parseInt(info[2]);
            add(a, b, c);
        }
        System.out.print(dijkstra());
    }

    static int dijkstra() {
        boolean[] v = new boolean[N];
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        q.offer(new int[]{1, 0});
        while (!q.isEmpty()) {
            int[] a = q.poll();
            int t = a[0], distance = a[1];
            if (v[t]) continue;

            for (int i = h[t]; i != -1; i = ne[i]) {
                int j = e[i];
                if (dist[j] > distance + w[i]) {
                    dist[j] = distance + w[i];
                    q.offer(new int[]{j, dist[j]});
                }
            }
            v[t] = true;
        }
        return dist[n] == Integer.MAX_VALUE ? -1 : dist[n];
    }


    static void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }


}