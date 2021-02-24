package com.example.qzq.leetcode.并查集;

import java.util.*;

/**
 * @ClassName : 连接所有点的最小费用
 * @Author : qiziqian
 * @Description:
 * @Date: 2021-01-19 10:36
 */
public class 连接所有点的最小费用 {
    public int minCostConnectPoints2(int[][] points) {
        int[][] graph = generateGraph(points);
        return prim(graph);
    }

    public int[][] generateGraph(int[][] points) {
        int n = points.length;
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            int[] curr = points[i];
            for (int j = i + 1; j < n; j++) {
                if (i == j) continue;
                int dist = Math.abs(curr[0] - points[j][0]) + Math.abs(curr[1] - points[j][1]);
                graph[i][j] = dist;
                graph[j][i] = dist;
            }
        }
        return graph;
    }

    public int prim(int[][] graph) {
        int n = graph.length;
        int[] minDistance = new int[n];
        Set<Integer> visit = new HashSet<>();
        visit.add(0);
        for (int i = 1; i < n; i++) {
            minDistance[i] = graph[i][0];
        }

        int result = 0;
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int j = 1; j < n; j++) {
                if (!visit.contains(j) && minDistance[j] < min) {
                    min = minDistance[j];
                    minIndex = j;
                }
            }
            visit.add(minIndex);
            result += min;

            for (int j = 1; j < n; j++) {
                if (!visit.contains(j) && graph[j][min] < minDistance[j]) {
                    minDistance[j] = graph[j][min];
                }
            }

        }
        return result;
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<Edge> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                list.add(new Edge(dist(points, i, j), i, j));
            }
        }
        UnionSet unionSet = new UnionSet(n);
        Collections.sort(list, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.len - o2.len;
            }
        });
        int count = 0;
        int min = 0;
        for (Edge edge : list) {
            if (unionSet.union(edge.x, edge.y)) {
                min += edge.len;
                count++;
                if (count == n - 1) break;
            }
        }
        return min;
    }

    public int dist(int[][] points, int x, int y) {
        return Math.abs(points[x][0] - points[y][0]) + Math.abs(points[x][1] - points[y][1]);
    }

    class UnionSet {
        int[] parent;
        int[] rank;

        public UnionSet(int n) {
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
            if (rootX == rootY) return false;
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootX] = rootY;
                rank[rootY]++;
            }
            return true;
        }

        public int find(int x) {
            return x == parent[x] ? x : (parent[x] = find(parent[x]));
        }
    }


    class Edge {
        int len, x, y;

        public Edge(int len, int x, int y) {
            this.len = len;
            this.x = x;
            this.y = y;
        }
    }
}


//    public static void main(String[] args) {
//        int[][] points = new int[][]{{0,0},{2,2},{3,10},{5,2},{7,0}};
//        minCostConnectPoints(points);
//    }
//    static int result = Integer.MAX_VALUE;
//    static int n = 0;
//
//    public  static int minCostConnectPoints(int[][] points) {
//        if (points.length == 1) return 0;
//        if (points.length == 2) return Math.abs(points[0][0] - points[1][0]) + Math.abs(points[0][1] - points[1][1]);
//        n = points.length;
//        int[][] graph = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            int[] curr = points[i];
//            for (int j = 0; j < n; j++) {
//                if (i == j) continue;
//                graph[i][j] = Math.abs(curr[0] - points[j][0]) + Math.abs(curr[1] - points[j][1]);
//            }
//        }
//        boolean[] visit = new boolean[n];
//        visit[0] = true;
//        for (int j = 1; j < n; j++) {
//            visit[j]=true;
//            dfs(graph, j,graph[0][j], 1, visit);
//            visit[j]=false;
//        }
//        return  result;
//    }
//
//    public static void dfs(int[][] graph, int curr,int cost, int depth, boolean[] visit) {
//        if (depth == n-1) {
//            result = Math.min(result, cost);
//            return;
//        }
//        for (int i = 0; i < n; i++) {
//            if(curr==i)continue;
//            if(visit[i])continue;
//            if(cost+graph[curr][i]>result)continue;
//            visit[i]=true;
//            dfs(graph,i,cost + graph[curr][i],depth+1,visit);
//            visit[i]=false;
//        }
//    }


