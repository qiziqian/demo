package com.example.qzq.acwing.归并排序;

import java.util.Scanner;

/**
 * @Description
 * @Date 2021/2/22 21:03
 * @Author by qiziqian
 */
public class 逆序对的数量 {

    /*
    1.分成两段
    2.递归划分
    3.合并
    假设我们在归并排序时可以计算出本段内逆序对的数量
    逆序对有三种情况:
    1.两个数字都在左半段  归并排序(l,mid);
    2.两个数字都在右半段  归并排序(mid+1,r);
    3.一个在左一个在右
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] q = new int[n];
        for (int i = 0; i < n; i++) {
            q[i] = scanner.nextInt();
        }
        long l = mergeSort(q, 0, n - 1);
        System.out.println(l);
    }

    public static long mergeSort(int[] q, int l, int r) {
        if (l == r) return 0;
        int mid = l + r >> 1;
        long res = mergeSort(q, l, mid) + mergeSort(q, mid + 1, r);
        int i = l, j = mid + 1, k = 0;
        int[] temp = new int[r - l + 1];
        while (i <= mid && j <= r) {
            if (q[i] > q[j]) {
                temp[k++] = q[j++];
                res += mid - i + 1;
            } else {
                temp[k++] = q[i++];
            }
        }
        while (i <= mid) temp[k++] = q[i++];
        while (j <= r) temp[k++] = q[j++];
        for (i = l, j = 0; i <= r; i++, j++) {
            q[i] = temp[j];
        }
        return res;
    }

}
