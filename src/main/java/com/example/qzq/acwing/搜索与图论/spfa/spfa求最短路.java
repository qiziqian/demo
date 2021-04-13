package com.example.qzq.acwing.搜索与图论.spfa;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

/**
 * @ClassName : spfa求最短路
 * @Author : qiziqian
 * @Description: bellman-ford算法的优化,有点类似dijkstra
 * @Date: 2021-04-13 12:43
 */
public class spfa求最短路 {

    static int N = 100010;
    static int[] h = new int[N];
    static int[] ne = new int[N];
    static int[] e = new int[N];
    static int[] w = new int[N];
    static int idx = 0;
    static int n;

    public static void main(String[] args) {
        Arrays.fill(h, -1);
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            add(x, y, z);
        }

        int spfa = spfa();
        if (spfa == -1) System.out.println("impossible");
        else System.out.println(spfa);
    }

    /*
    这里队列的作用是判断点是不是在队列里,避免重复添加影响效率
     */
    public static int spfa() {
        boolean[] inQueue = new boolean[n + 1];
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        inQueue[1] = true;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            inQueue[poll] = false;
            for (int i = h[poll]; i != -1; i = ne[i]) {
                if (dist[e[i]] > dist[poll] + w[i]) {
                    dist[e[i]] = dist[poll] + w[i];
                    if (!inQueue[e[i]]) {
                        queue.add(e[i]);
                        inQueue[e[i]] = true;
                    }
                }
            }
        }
        return dist[n] == Integer.MAX_VALUE ? -1 : dist[n];
    }

    public static void add(int x, int y, int z) {
        e[idx] = y;
        ne[idx] = h[x];
        w[idx] = z;
        h[x] = idx++;
    }
}