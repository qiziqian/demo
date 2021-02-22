package com.example.qzq.leetcode.并查集;

/**
 * @Description
 * @Date 2021/1/23 10:00
 * @Author by qiziqian
 */
public class 连通网络的操作次数 {
    public int makeConnected(int n, int[][] connections) {
        int stringCount = connections.length;
        if (stringCount < n - 1) return -1;
        UnionSet unionSet = new UnionSet(n);
        for (int[] connection : connections) {
            unionSet.union(connection[0], connection[1]);
        }

        int res = 0;
        if (unionSet.count == 1) return res;
        return unionSet.count - 1;

    }

    public class UnionSet {
        int[] parent;
        int[] rank;
        int count;

        public UnionSet(int n) {
            this.parent = new int[n];
            this.rank = new int[n];
            this.count = n;
            for (int i = 0; i < n; i++) {
                rank[i] = 1;
                parent[i] = i;
            }
        }

        public int find(int x) {
            return x == parent[x] ? x : (parent[x] = find(parent[x]));
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) return;
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootX] = rootY;
                rank[rootY]++;
            }
            count--;
        }
    }
}
