package com.example.qzq.leetcode.并查集;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Date 2021/1/30 10:02
 * @Author by qiziqian
 */
public class 水位上升的泳池中游泳 {

    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        List<int[]> edges = new ArrayList<>();
        int[] len = new int[n * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                len[grid[i][j]] = i * n + j;
            }
        }
        UnionSet unionSet = new UnionSet(n * n);
        for (int i = 0; i < n * n; i++) {
            int x = len[i] / n;
            int y = len[i] % n;
            for (int[] direction : directions) {
                int newX = direction[0] + x;
                int newY = direction[1] + y;
                if (inArea(newX, newY, n) && grid[newX][newY] <= i) {
                    unionSet.union(len[i], newX * n + newY);
                }
                if (unionSet.connect(0, n * n - 1)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean inArea(int x, int y, int n) {
        return x >= 0 && x < n && y >= 0 && y < n;
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

        public boolean connect(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) return true;
            return false;
        }
    }

}
