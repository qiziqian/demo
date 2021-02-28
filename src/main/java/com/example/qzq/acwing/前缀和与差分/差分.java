package com.example.qzq.acwing.前缀和与差分;

import java.util.Scanner;

/**
 * @Description
 * @Date 2021/2/27 10:51
 * @Author by qiziqian
 */
public class 差分 {

    /*

    差分和前缀和互为逆操作;
    假设   有两个数组a,b  b是a的前缀和数组,那么称a是b的差分数组;
    差分数组的作用:  计算某一区间[l,r]的加减运算,将O(n)简化成O(1);

    */
    static int[] b;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n + 1];
        b = new int[n + 2];
        for (int i = 1; i <= n; i++) a[i] = sc.nextInt();
        for (int i = 0; i <= n; i++) insert(i, i, a[i]);

        while (m-- > 0) {
            int l = sc.nextInt(), r = sc.nextInt(), c = sc.nextInt();
            insert(l, r, c);
        }
        for (int i = 1; i <= n; i++) {
            b[i] += b[i - 1];
            System.out.print(b[i] + " ");
        }

    }

    public static void insert(int l, int r, int c) {
        b[l] += c;
        b[r + 1] -= c;
    }


}
