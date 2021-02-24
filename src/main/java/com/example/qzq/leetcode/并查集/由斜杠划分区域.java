package com.example.qzq.leetcode.并查集;

/**
 * @ClassName : 由斜杠划分区域
 * @Author : qiziqian
 * @Description:
 * @Date: 2021-01-25 10:21
 */
public class 由斜杠划分区域 {

    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        UnionSet unionSet = new UnionSet(n * n * 4);
        for (int i = 0; i < n; i++) {
            char[] chars = grid[i].toCharArray();
            for (int j = 0; j < n; j++) {
                int index = 4 * (i * n + j);
                if (chars[j] == ' ') {
                    unionSet.union(index, index + 1);
                    unionSet.union(index + 1, index + 2);
                    unionSet.union(index + 2, index + 3);
                } else if (chars[j] == '/') {
                    unionSet.union(index, index + 3);
                    unionSet.union(index + 1, index + 2);
                } else if (chars[j] == '\\') {
                    unionSet.union(index, index + 1);
                    unionSet.union(index + 2, index + 3);
                }

                if (i + 1 < n) {
                    unionSet.union(index + 2, 4 * ((i + 1) * n + j));
                }
                if (j + 1 < n) {
                    unionSet.union(index + 1, 4 * (i * n + j + 1) + 3);
                }
            }
        }

        return unionSet.count;
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
                parent[i] = i;
                rank[i] = 1;
            }

        }

        public int find(int x) {
            return parent[x] == x ? x : (parent[x] = find(parent[x]));
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) return;
            if (rank[rootX] == rank[rootY]) {
                parent[rootY] = rootX;
                rank[rootX]++;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootX] = rootY;
            }
            count--;
        }
    }
}