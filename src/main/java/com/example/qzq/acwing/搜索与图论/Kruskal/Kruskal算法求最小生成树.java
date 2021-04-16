package com.example.qzq.acwing.搜索与图论.Kruskal;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @ClassName : Kruskal算法求最小生成树
 * @Author : qiziqian
 * @Description:
 * @Date: 2021-04-15 10:41
 */
public class Kruskal算法求最小生成树 {


    static int m;
    static int n;
    static int[][] edges;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        edges = new int[m][3];
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            edges[i] = new int[]{u, v, w};
        }
        int kruskal = kruskal();
        if (kruskal == -1) System.out.println("impossible");
        else System.out.println(kruskal);
    }

    public static int kruskal() {
        Arrays.sort(edges, Comparator.comparingInt(e -> e[2]));
        UnionSet unionSet = new UnionSet(n + 1);

        int edgeNum = 0;
        int res = 0;
        for (int i = 0; i < m; i++) {
            int[] edge = edges[i];
            int a = edge[0];
            int b = edge[1];
            int w = edge[2];
            int rootA = unionSet.find(a);
            int rootB = unionSet.find(b);
            if (rootA != rootB) {
                res += w;
                edgeNum++;
                unionSet.union(a, b);
            }
        }
        if (edgeNum < n - 1) return -1;
        return res;
    }

    public static class UnionSet {

        public int count;
        private int[] parent;
        private int[] rank;

        public UnionSet(int n) {
            this.count = n;
            this.parent = new int[n];
            this.rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return false;
            }
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootX] = rootY;
                rank[rootY]++;
            }
            count--;
            return true;
        }

        public int find(int x) {
            return x == parent[x] ? x : (parent[x] = find(parent[x]));
        }
    }

}