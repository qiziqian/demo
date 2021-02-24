package com.example.qzq.leetcode.并查集;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName : 找到最小生成树里的关键边和伪关键边
 * @Author : qiziqian
 * @Description:
 * @Date: 2021-01-21 10:29
 */
public class 找到最小生成树里的关键边和伪关键边 {
    public static List<List<Integer>> findCriticalAndPseudoCriticalEdges2(int n, int[][] edges) {
        int m = edges.length;
        int[][] newEdges = new int[m][4];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                newEdges[i][j] = edges[i][j];
            }
            newEdges[i][3] = i;
        }

        Arrays.sort(newEdges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });


        int minValue = 0;
        UnionSet minUnionSet = new UnionSet(n);
        for (int i = 0; i < m; i++) {
            if (minUnionSet.union(newEdges[i][0], newEdges[i][1])) {
                minValue += newEdges[i][2];
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        result.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            UnionSet currSet = new UnionSet(n);
            int currValue = 0;
            for (int j = 0; j < m; j++) {
                if (i == j) continue;
                if (currSet.union(newEdges[j][0], newEdges[j][1])) {
                    currValue += newEdges[j][2];
                }
            }
            if (currSet.setCount > 1 || currValue > minValue) {
                result.get(0).add(newEdges[i][3]);
                continue;
            }

            currSet = new UnionSet(n);
            currSet.union(newEdges[i][0], newEdges[i][1]);
            currValue = newEdges[i][2];
            for (int j = 0; j < m; j++) {
                if (i == j) continue;
                if (currSet.union(newEdges[j][0], newEdges[j][1])) {
                    currValue += newEdges[j][2];
                }
            }
            if (currSet.setCount == 1 && currValue == minValue) {
                result.get(1).add(newEdges[i][3]);
            }

        }
        return result;
    }

    public static void main(String[] args) {
        findCriticalAndPseudoCriticalEdges2(5, new int[][]{{0, 1, 1}, {1, 2, 1}, {2, 3, 2}, {0, 3, 2}, {0, 4, 3}, {3, 4, 3}, {1, 4, 6}});
    }

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int m = edges.length;
        int[][] newEdges = new int[m][4];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < 3; ++j) {
                newEdges[i][j] = edges[i][j];
            }
            newEdges[i][3] = i;
        }
        Arrays.sort(newEdges, new Comparator<int[]>() {
            public int compare(int[] u, int[] v) {
                return u[2] - v[2];
            }
        });

        // 计算 value
        UnionSet ufStd = new UnionSet(n);
        int value = 0;
        for (int i = 0; i < m; ++i) {
            if (ufStd.union(newEdges[i][0], newEdges[i][1])) {
                value += newEdges[i][2];
            }
        }

        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (int i = 0; i < 2; ++i) {
            ans.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; ++i) {
            // 判断是否是关键边
            UnionSet uf = new UnionSet(n);
            int v = 0;
            for (int j = 0; j < m; ++j) {
                if (i != j && uf.union(newEdges[j][0], newEdges[j][1])) {
                    v += newEdges[j][2];
                }
            }
            if (uf.setCount != 1 || (uf.setCount == 1 && v > value)) {
                ans.get(0).add(newEdges[i][3]);
                continue;
            }

            // 判断是否是伪关键边
            uf = new UnionSet(n);
            uf.union(newEdges[i][0], newEdges[i][1]);
            v = newEdges[i][2];
            for (int j = 0; j < m; ++j) {
                if (i != j && uf.union(newEdges[j][0], newEdges[j][1])) {
                    v += newEdges[j][2];
                }
            }
            if (v == value) {
                ans.get(1).add(newEdges[i][3]);
            }
        }

        return ans;
    }

    public static class UnionSet {
        int[] parent;
        int[] rank;
        int setCount;

        public UnionSet(int n) {
            this.parent = new int[n];
            this.rank = new int[n];
            this.setCount = n;
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
            setCount--;
            return true;
        }
    }

}
