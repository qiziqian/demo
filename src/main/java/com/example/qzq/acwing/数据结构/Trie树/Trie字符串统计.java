package com.example.qzq.acwing.数据结构.Trie树;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName : Trie字符串统计
 * @Author : qiziqian
 * @Description:
 * @Date: 2021-03-22 13:26
 */
public class Trie字符串统计 {
    //高效存储和查找字符串集合的结构
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Trie trie = new Trie();
        while (n > 0) {
            String op = sc.next();
            if (op.equals("I")) {
                String str = sc.next();
                trie.insert(str);
            } else if (op.equals("Q")) {
                String str = sc.next();
                System.out.println(trie.query(str));
            }
            n--;
        }
    }

    public static class Trie {
        int[][] son = new int[26 * 2 * 10000][26];
        int[] cnt = new int[26 * 2 * 10000];
        int idx = 0;

        public void insert(String s) {
            int p = 0;
            for (int i = 0; i < s.length(); i++) {
                int u = s.charAt(i) - 'a';
                if (son[p][u] == 0) son[p][u] = ++idx;
                p = son[p][u];
            }
            cnt[p]++;
        }

        public int query(String s) {
            int p = 0;
            for (int i = 0; i < s.length(); i++) {
                int u = s.charAt(i) - 'a';
                if (son[p][u] == 0) return 0;
                p = son[p][u];
            }
            return cnt[p];
        }
    }
}