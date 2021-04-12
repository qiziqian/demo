package com.example.qzq.acwing.数据结构.KMP;

import java.io.*;

/**
 * @ClassName : KMP
 * @Author : qiziqian
 * @Description: 先匹配自己 再匹配字符串
 * @Date: 2021-03-16 10:14
 */
public class KMP {

    //String s = "abacababac";
    //String p = "abac";

    //String s = "abababab";
    //String p = "abab";
    public static void main(String[] args) throws IOException {
        int N = 1000010;
        int[] ne = new int[N];

        String s = "abacababac";
        String p = "abac";
        int n = p.length();
        int m = s.length();

        //匹配自己,从1开始
        for (int i = 1, j = 0; i < n; i++) {
            while (j != 0 && p.charAt(i) != p.charAt(j)) j = ne[j - 1];
            if (p.charAt(i) == p.charAt(j)) j++;
            ne[i] = j;
        }

        //与长字符串匹配,从0开始
        for (int i = 0, j = 0; i < m; i++) {
            while (j != 0 && s.charAt(i) != p.charAt(j)) j = ne[j - 1];
            if (s.charAt(i) == p.charAt(j)) j++;
            if (j == n) {
                j = ne[n - 1];
                System.out.println(i - n + 1 + " ");
            }
        }
    }


    public void test() {
        int n = 100;
        int[] ne = new int[n];
        String s = "abacababac";
        String p = "abac";
        for (int i = 1, j = 0; i < p.length(); i++) {
            while (j != 0 && p.charAt(i) != p.charAt(j)) j = ne[j - 1];
            if (p.charAt(i) == p.charAt(j)) j++;
            ne[i] = j;
        }
        for (int i = 0, j = 0; i < s.length(); i++) {
            while (j != 0 && s.charAt(i) != p.charAt(j)) j = ne[j - 1];
            if (s.charAt(i) == p.charAt(j)) j++;
            if (j == n) {
                j = ne[n - 1];
                System.out.println(i - n + 1 + " ");
            }
        }
    }

}