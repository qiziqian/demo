package com.example.qzq.acwing.搜索与图论.树与图的广度优先遍历;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Description
 * @Date 2021/4/10 11:11
 * @Author by qiziqian
 */
public class 图中点的层次 {


    static int N = 100010;
    static int n;
    static int[] h = new int[N];
    static boolean[] v = new boolean[N];
    static int[] ne = new int[N];
    static int[] e = new int[N];
    static int[] path = new int[N];
    static int idx = 0;

    public static void main(String[] args) {
        Arrays.fill(h, -1);
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            add(a, b);
        }
        System.out.println(bfs());

    }

    private static int bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        v[1] = true;
        path[1] = 0;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (int i = h[poll]; i != -1; i = ne[i]) {
                if (!v[e[i]]) {
                    v[e[i]] = true;
                    path[e[i]] = path[poll] + 1;
                    if (e[i] == n) return path[e[i]];
                    queue.add(e[i]);
                }
            }

        }
        return -1;
    }

    public static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
