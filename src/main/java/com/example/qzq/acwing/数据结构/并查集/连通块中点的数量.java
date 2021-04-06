package com.example.qzq.acwing.数据结构.并查集;

import java.util.Scanner;

/**
 * @ClassName : 连通块中点的数量
 * @Author : qiziqian
 * @Description:
 * @Date: 2021-03-23 13:44
 */
public class 连通块中点的数量 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();


        UnionSet unionSet = new UnionSet(100010);
        while (m > 0) {
            String s = sc.next();
            if (s.equals("C")) {
                int i = sc.nextInt();
                int j = sc.nextInt();
                unionSet.union(i, j);
            } else if (s.equals("Q1")) {
                int i = sc.nextInt();
                int j = sc.nextInt();
                int i1 = unionSet.find(i);
                int i2 = unionSet.find(j);
                System.out.println(i1 == i2 ? "Yes" : "No");
            } else if (s.equals("Q2")) {
                int i = sc.nextInt();
                System.out.println(unionSet.count[unionSet.find(i)]);
            }

            m--;
        }
    }

    public static class UnionSet {
        public int[] count;
        private int[] parent;
        private int[] rank;

        public UnionSet(int n) {
            this.count = new int[n];
            this.parent = new int[n];
            this.rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
                count[i] = 1;
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
            count[rootX] += count[rootY];
            count[rootY] = count[rootX];
            return true;
        }

        public int find(int x) {
            return x == parent[x] ? x : (parent[x] = find(parent[x]));
        }
    }
}