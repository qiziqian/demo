package com.example.qzq.acwing.前缀和与差分;

import java.util.Scanner;

/**
 * @Description
 * @Date 2021/2/27 9:01
 * @Author by qiziqian
 */
public class 前缀和 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int[] s = getpreSumArray(a);
        while (m-- > 0) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            int num = s[r] - s[l - 1];
            System.out.println(num);

        }
    }

    private static int[] getpreSumArray(int[] a) {
        int n = a.length;
        int[] s = new int[n + 1];
        s[0] = 0;
        for (int i = 1; i < s.length; i++) {
            s[i] += s[i - 1] + a[i - 1];
        }
        return s;
    }

    private static int getNum(int[] a, int l, int r) {
        int res = 0;
        while (l <= r) {
            res += a[l++];
        }
        return res;
    }
}
