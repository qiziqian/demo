package com.example.qzq.acwing.二分;

import java.util.Scanner;

/**
 * @ClassName : 数的范围
 * @Author : qiziqian
 * @Description:
 * @Date: 2021-02-24 11:09
 */
public class 数的范围 {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), q = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[q];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < q; i++) {
            int num = scanner.nextInt();
            int ints1 = binarySearch1(a, num);
            int ints2 = binarySearch2(a, num);
            System.out.print(ints1 + " " + ints2);
            System.out.println();
        }
    }

    public static int binarySearch1(int[] a, int k) {
        int l = 0, r = a.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (a[mid] >= k) r = mid;
            else l = mid + 1;
        }
        return a[l] == k ? l : -1;
    }


    public static int binarySearch2(int[] a, int k) {
        int l = 0, r = a.length - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (a[mid] > k) r = mid - 1;
            else l = mid;
        }
        return a[l] == k ? l : -1;
    }

}