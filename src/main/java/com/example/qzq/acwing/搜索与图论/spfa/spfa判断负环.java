package com.example.qzq.acwing.搜索与图论.spfa;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

/**
 * @ClassName : spfa判断负环
 * @Author : qiziqian
 * @Description:
 * @Date: 2021-04-13 14:55
 */
public class spfa判断负环 {

    static int n;
    static int m;
    static int[] h;
    static int[] ne;
    static int[] e;
    static int[] w;
    static int idx = 0;


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        h = new int[n + 1];
        ne = new int[m + 1];
        e = new int[m + 1];
        w = new int[m + 1];
        Arrays.fill(h, -1);
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            add(x, y, z);
        }
        System.out.println(spfa() ? "Yes" : "No");
    }

    public static boolean spfa() {

        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] inQueue = new boolean[n + 1];
        int[] dist = new int[n + 1];
        int[] cnt = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            queue.add(i);
            inQueue[i] = true;
        }
        while (!queue.isEmpty()) {
            Integer p = queue.poll();
            inQueue[p] = false;
            for (int i = h[p]; i != -1; i = ne[i]) {
                int j = e[i];
                if (dist[j] > dist[p] + w[i]) {
                    dist[j] = dist[p] + w[i];
                    cnt[j] = cnt[p] + 1;
                    if (cnt[j] >= n) return true;
                    if (!inQueue[j]) {
                        inQueue[j] = true;
                        queue.add(j);
                    }
                }
            }

        }
        return false;
    }

    public static void add(int x, int y, int z) {
        e[idx] = y;
        ne[idx] = h[x];
        w[idx] = z;
        h[x] = idx++;
    }

}