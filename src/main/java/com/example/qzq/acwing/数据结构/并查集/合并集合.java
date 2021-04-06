package com.example.qzq.acwing.数据结构.并查集;

import java.util.Scanner;

/**
 * @ClassName : 合并集合
 * @Author : qiziqian
 * @Description:
 * @Date: 2021-03-23 11:29
 */
public class 合并集合 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        UnionSet set = new UnionSet(100010);

        while (m > 0) {
            String s = sc.next();
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (s.equals("M")) {
                set.union(a, b);
            } else {
                int i = set.find(a);
                int j = set.find(b);
                System.out.println(i == j ? "YES" : "NO");
            }
            m--;
        }
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