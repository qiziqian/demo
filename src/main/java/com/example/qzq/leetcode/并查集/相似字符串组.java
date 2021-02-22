package com.example.qzq.leetcode.并查集;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @Date 2021/1/31 9:39
 * @Author by qiziqian
 */
public class 相似字符串组 {
    public static void main(String[] args) {
        String[] strs = {"tars", "rats", "arts", "star"};
        // System.out.println(numSimilarGroups(strs));
    }


    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        int len = strs[0].length();
        UnionSet unionSet = new UnionSet(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isSimilarity(strs[i], strs[j], len)) unionSet.union(i, j);
            }
        }
        return unionSet.count;
    }

    //效率高
    public boolean isSimilarity(String a, String b, int len) {
        int num = 0;
        for (int i = 0; i < len; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                num++;
                if (num > 2) {
                    return false;
                }
            }
        }
        return true;
    }

    //效率低
    public boolean isSimilarity2(String a, String b, int len) {
        char[] str1 = a.toCharArray();
        char[] str2 = b.toCharArray();
        int diffCount = 0;

        for (int index = 0; index < len; index++) {
            if (str1[index] != str2[index]) diffCount++;
        }
        return diffCount <= 2;
    }


    public class UnionSet {
        int[] parent;
        int count;

        public UnionSet(int n) {
            this.count = n;
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                this.parent[i] = i;
            }
        }

        public int find(int x) {
            return x == parent[x] ? x : (parent[x] = find(parent[x]));
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) return;
            parent[rootY] = rootX;
            count--;
        }
    }

}
