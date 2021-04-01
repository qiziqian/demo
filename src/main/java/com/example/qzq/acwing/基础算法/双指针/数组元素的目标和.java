package com.example.qzq.acwing.基础算法.双指针;

import java.util.Scanner;

/**
 * @Description
 * @Date 2021/2/23 20:52
 * @Author by qiziqian
 */
public class 数组元素的目标和 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner((System.in));
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[] a = new int[m];
        int[] b = new int[n];
        for (int i = 0; i < m; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }

        int r = n - 1;
        for (int i = 0; i < m; i++) {
            while (r > 0 && a[i] + b[r] > x) r--;
            if (a[i] + b[r] == x) System.out.println(i + " " + r);
        }

    }

}
