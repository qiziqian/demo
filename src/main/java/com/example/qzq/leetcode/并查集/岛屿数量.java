package com.example.qzq.leetcode.并查集;

import java.util.HashSet;

/**
 * @Description
 * @Date 2021/2/12 19:48
 * @Author by qiziqian
 */
public class 岛屿数量 {


    public static void main(String[] args) {
        //  System.out.println(numIslands(new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}}));
        System.out.println(numIslands(new char[][]{{'1', '0', '1', '1', '1'}, {'1', '0', '1', '0', '1'}, {'1', '1', '1', '0', '1'}}));
    }

    public static int numIslands(char[][] grid) {
        int column = grid.length;
        int row = grid[0].length;
        UnionSet unionSet = new UnionSet(column * row);
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                if (grid[i][j] == '0') continue;
                if (i > 0 && grid[i - 1][j] == '1') {
                    unionSet.union(getIndex(i - 1, j, row), getIndex(i, j, row));
                }
                if (j > 0 && grid[i][j - 1] == '1') {
                    unionSet.union(getIndex(i, j - 1, row), getIndex(i, j, row));
                }
            }
        }
        HashSet<Integer> set = new HashSet();
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                if (grid[i][j] == '1') {
                    set.add(unionSet.find(getIndex(i, j, row)));
                }
            }
        }
        return set.size();
    }

    public static int getIndex(int x, int y, int row) {
        return x * row + y;
    }

    public static class UnionSet {

        private int[] parent;
        private int[] rank;

        public UnionSet(int n) {
            this.parent = new int[n];
            this.rank = new int[n];
            for (int i = 0; i < n; i++) {
                this.parent[i] = i;
                this.rank[i] = 1;
            }
        }

        public int find(int x) {
            return parent[x] == x ? x : (parent[x] = find(parent[x]));
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) return;
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootY] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }


    class UnionFind {
        int count;
        int[] parent;
        int[] rank;

        public UnionFind(char[][] grid) {
            count = 0;
            int m = grid.length;
            int n = grid[0].length;
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (grid[i][j] == '1') {
                        parent[i * n + j] = i * n + j;
                        ++count;
                    }
                    rank[i * n + j] = 0;
                }
            }
        }

        public int find(int i) {
            if (parent[i] != i) parent[i] = find(parent[i]);
            return parent[i];
        }

        public void union(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);
            if (rootx != rooty) {
                if (rank[rootx] > rank[rooty]) {
                    parent[rooty] = rootx;
                } else if (rank[rootx] < rank[rooty]) {
                    parent[rootx] = rooty;
                } else {
                    parent[rooty] = rootx;
                    rank[rootx] += 1;
                }
                --count;
            }
        }

        public int getCount() {
            return count;
        }
    }

}
