package com.example.qzq.acwing.数据结构.Trie树;

import java.util.Scanner;

/**
 * @ClassName : 最大异或对
 * @Author : qiziqian
 * @Description:
 * @Date: 2021-03-22 15:53
 */
public class 最大异或对 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        Trie trie = new Trie();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            trie.insert(a[i]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, trie.query(a[i]));
        }
        System.out.println(res);
    }

    public static class Trie {
        private int[][] son = new int[3200000][32];
        private int idx = 0;

        public void insert(int x) {
            int p = 0;
            for (int i = 30; i >= 0; i--) {
                int u = x >> i & 1;
                if (son[p][u] == 0) son[p][u] = ++idx;
                p = son[p][u];
            }
        }

        public int query(int x) {
            int p = 0;
            int res = 0;
            for (int i = 30; i >= 0; i--) {
                int u = x >> i & 1;
                if (son[p][1 - u] == 0) {
                    p = son[p][1 - u];
                    res += 1 << i;
                } else {
                    p = son[p][u];
                }
            }
            return res;
        }
    }
}