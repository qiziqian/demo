package com.example.qzq.leetcode.并查集;

/**
 * @Description
 * @Date 2021/1/27 14:31
 * @Author by qiziqian
 */
public class 保证图可完全遍历 {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int ans = 0;
        UnionSet unionSetA = new UnionSet(n);
        UnionSet unionSetB = new UnionSet(n);
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                if (unionSetA.union(edge[1], edge[2])) {
                    unionSetB.union(edge[1], edge[2]);
                } else {
                    ans++;
                }
            }
        }
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                if (!unionSetA.union(edge[1], edge[2])) {
                    ans++;
                }
            } else if (edge[0] == 2) {
                if (!unionSetB.union(edge[1], edge[2])) {
                    ans++;
                }
            }
        }

        if (unionSetA.count != 1 || unionSetB.count != 1) return -1;
        return ans;
    }

    public class UnionSet {
        int[] parent;
        int[] rank;
        int count;

        public UnionSet(int n) {
            parent = new int[n];
            rank = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            return x == parent[x] ? x : (parent[x] = find(parent[x]));
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) return false;
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
    }

}
