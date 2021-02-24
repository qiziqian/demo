package com.example.qzq.acwing.双指针;

import java.util.Scanner;

/**
 * @Description
 * @Date 2021/2/23 21:07
 * @Author by qiziqian
 */
public class 判断子序列 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner((System.in));
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[] a = new int[m];
        int[] b = new int[n];
        for (int i = 0; i < m; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (b[i] == a[j]) j++;
        }
        System.out.println(j == m - 1 ? "Yes" : "No");

    }
}
