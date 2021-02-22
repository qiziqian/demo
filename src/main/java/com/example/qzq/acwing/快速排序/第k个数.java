package com.example.qzq.acwing.快速排序;

import java.util.*;

public class 第k个数 {
    private static int N = 100010;
    private static int[] a = new int[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int l = 0, r = n - 1;
        //传入参数为下标k-1
        System.out.println(quickSort(a, l, r, k));
    }

    public static int quickSort(int q[], int l, int r, int k) {
        if (l == r) return q[l];
        int x = q[l + r >> 1], i = l - 1, j = r + 1;
        while (i < j) {
            while (q[++i] < x) ;
            while (q[--j] > x) ;
            if (i < j) swap(q, i, j);
        }
        if (k <= j - l + 1) return quickSort(q, l, j, k);
        return quickSort(q, j + 1, r, k - (j - l + 1));
    }

    public static void swap(int[] arr, int index1, int index2) {
        arr[index1] = arr[index1] ^ arr[index2];
        arr[index2] = arr[index1] ^ arr[index2];
        arr[index1] = arr[index1] ^ arr[index2];
    }
}