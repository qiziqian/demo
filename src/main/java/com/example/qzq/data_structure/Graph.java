package com.example.qzq.data_structure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname Graph
 * @Description java的实现 -> Graph g = new GraphImpl();
 * @Date 2019/11/8 11:19
 * @Created by qiziqian
 */
public class Graph {// 无向图
    //-------------------------------------------------------------------------------------------------------------
    //深度搜索
    boolean found = false; // 全局变量或者类成员变量
    private int v; // 顶点的个数
    private LinkedList<Integer>[] adj; // 邻接表

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);

        graph.addEdge(1, 5);
        graph.addEdge(2, 1);
        graph.addEdge(2, 4);
        graph.addEdge(1, 3);


        graph.addEdge(3, 5);
        graph.addEdge(4, 3);
        // graph.bfs(1, 4);
        // graph.dfs(1, 4);
    }

    public void addEdge(int s, int t) { // 无向图一条边存两次
        adj[s].add(t);
        adj[t].add(s);
    }

    //-------------------------------------------------------------------------------------------------------------
    //广度搜索
    public void bfs(int s, int t) {
        if (s == t) return;
        //布尔类型数组,用于判断节点是否使用过,使用过则置为ture
        boolean[] visited = new boolean[v];
        visited[s] = true;
        //队列,用于存储正在访问的节点
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }
        while (queue.size() != 0) {
            int w = queue.poll();
            for (int i = 0; i < adj[w].size(); ++i) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    if (q == t) {
                        print(prev, s, t);
                        // return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }

    public void bfsTest(int s, int t) {
        boolean[] visit = new boolean[v];
        Queue<Integer> queue = new LinkedList();
        int[] pre = new int[v];
        for (int i : pre) {
            i = -1;
        }
        queue.add(s);
        visit[s] = true;
        while (!queue.isEmpty()) {
            int parent = queue.poll();
            for (int i = 0; i < adj[parent].size(); i++) {
                Integer son = adj[parent].get(i);
                if (!visit[son]) {
                    if (son == t) {
                        pre[son] = parent;
                        print(pre, s, son);
                        return;
                    }
                    visit[son] = true;
                    queue.add(son);
                }
            }
        }
    }

    private void print(int[] prev, int s, int t) { // 递归打印s->t的路径
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }

    public void dfs(int s, int t) {
        found = false;
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }
        recurDfs(s, t, visited, prev);
        print(prev, s, t);
    }

    private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
        if (found == true) return;
        visited[w] = true;
        if (w == t) {
            found = true;
            return;
        }
        for (int i = 0; i < adj[w].size(); ++i) {
            int q = adj[w].get(i);
            if (!visited[q]) {
                prev[q] = w;
                recurDfs(q, t, visited, prev);
            }
        }
    }

    //-------------------------------------------------------------------------------------------------------------

    private void dfsTest(int s, int t) {
        found = false;
        boolean[] visit = new boolean[v];
        int[] pre = new int[v];
        for (int i : pre) {
            i = -1;
        }

        recurDfsTest(s, t, pre, visit);
        print(pre, s, t);
    }

    private void recurDfsTest(int s, int t, int[] pre, boolean[] visit) {
        if (found) return;
        if (s == t) {
            found = true;
            return;
        }
        visit[s] = true;
        for (int i = 0; i < adj[s].size(); i++) {
            Integer son = adj[s].get(i);
            if (!visit[son]) {
                pre[son] = s;
                recurDfsTest(son, t, pre, visit);

            }
        }
    }

    //拓扑排序
    //kahn
    public void topoSortByKahn() {
        int[] degree = new int[10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                Integer w = adj[i].get(j);
                degree[w]++;
            }
        }
        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) queue.add(i);
        }
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (int i = 0; i < adj[poll].size(); i++) {
                Integer k = adj[poll].get(i);
                degree[k]--;
                if (degree[adj[poll].get(i)] == 0) queue.add(k);
            }
        }

    }

    //深度优先搜索的拓扑排序
    public void topoSortByDFS() {
        LinkedList<Integer>[] inverseAdj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                int w = adj[i].get(j);
                inverseAdj[w].add(i);

            }
        }
        boolean[] visited = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                topoSortDfs(i, inverseAdj, visited);
            }
        }
    }

    public void topoSortDfs(int vertex, LinkedList<Integer>[] inverseAdj, boolean[] visited) {
        for (int i = 0; i < inverseAdj[vertex].size(); i++) {
            int w = inverseAdj[vertex].get(i);
            if (visited[w] == true) continue;
            visited[w] = true;
            topoSortDfs(w, inverseAdj, visited);
        }
        System.out.println("->" + vertex);
    }
}
