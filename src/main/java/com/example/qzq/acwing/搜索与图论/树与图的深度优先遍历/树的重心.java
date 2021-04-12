package com.example.qzq.acwing.搜索与图论.树与图的深度优先遍历;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName : 树的重心
 * @Author : qiziqian
 * @Description:
 * @Date: 2021-04-09 16:49
 */
public class 树的重心 {

    static int N = 100010;
    static int n;
    static int[] e = new int[2 * N];
    static int[] ne = new int[2 * N];
    static int[] h = new int[N];
    static boolean[] v = new boolean[N];
    static int idx = 0;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Arrays.fill(h, -1);

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 1; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            add(a, b);
            add(b, a);
        }
        dfs(1);
        System.out.println(ans);
    }

    private static int dfs(int node) {
        v[node] = true;
        int sum = 1, size = 0;
        for (int i = h[node]; i != -1; i = ne[i]) {
            if (!v[e[i]]) {
                int count = dfs(e[i]);
                sum += count;
                size = Math.max(size, count);

            }
        }
        int max = Math.max(n - sum, size);
        ans = Math.min(ans, max);
        return sum;
    }

    private static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

}