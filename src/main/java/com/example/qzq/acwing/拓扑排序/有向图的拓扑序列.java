package com.example.qzq.acwing.拓扑排序;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Description
 * @Date 2021/4/10 20:42
 * @Author by qiziqian
 */
public class 有向图的拓扑序列 {

    /*

    拓扑序列是针对有向图的

    1.拿到所有入度为0的节点,放入队列
    2.循环上部操作

     */


    static int[] h = new int[100010];
    static int[] e = new int[100010];
    static boolean[] v = new boolean[100010];
    static int[] ne = new int[100010];
    static int idx = 0;
    static int n;


    static int[] q = new int[100010];
    static int[] d = new int[100010];

    public static void main(String[] args) {
        Arrays.fill(h, -1);
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            add(a, b);
            d[b]++;
        }


        if (!bfs()) System.out.println(-1);
        else {
            for (int i = 0; i < n; i++) {
                System.out.print(q[i]);
            }
        }
    }


    public static boolean bfs() {
        int hh = 0, tt = -1;
        for (int i = 1; i <= n; i++) {
            if (d[i] == 0) {
                q[++tt] = i;
            }
        }
        while (hh <= tt) {
            int poll = q[hh++];
            for (int i = h[poll]; i != -1; i = ne[i]) {
                d[e[i]]--;
                if (d[e[i]] == 0) {
                    q[++tt] = e[i];
                }
            }
        }

        return tt == n - 1;

    }

    public static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
