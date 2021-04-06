package com.example.qzq.acwing.数据结构.并查集;

import java.util.Scanner;

/**
 * @ClassName : 食物链
 * @Author : qiziqian
 * @Description:
 * @Date: 2021-03-23 14:02
 */
public class 食物链 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        UnionSet set = new UnionSet(50010);
        int res = 0;
        while (k-- > 0) {
            int o = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (x > n || y > n) {
                res++;
                continue;
            }
            if (o == 1) {
                if (!set.same(x, y)) res++;
            } else if (o == 2) {
                if (!set.eat(x, y)) res++;
            }
        }
        System.out.println(res);
    }

    public static class UnionSet {

        private int[] parent;
        private int[] distance;

        public UnionSet(int n) {
            this.parent = new int[n + 1];
            this.distance = new int[n + 1];
            for (int i = 0; i < n + 1; i++) {
                parent[i] = i;
            }
        }

        public boolean same(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) return distance[x] % 3 == distance[y] % 3;

            parent[rootX] = rootY;
            distance[rootX] = (distance[y] - distance[x] + 3) % 3;
            return true;
        }

        public boolean eat(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) return distance[x] % 3 == (distance[y] - 1) % 3;

            parent[rootX] = rootY;
            distance[rootX] = (distance[y] - distance[x] + 1 + 3) % 3;
            return true;
        }

        public int find(int x) {
            if (x != parent[x]) {
                int p = find(parent[x]);
                distance[x] += distance[parent[x]];
                parent[x] = p;
            }
            return parent[x];
        }
    }
}