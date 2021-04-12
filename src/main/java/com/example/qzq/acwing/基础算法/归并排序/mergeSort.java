package com.example.qzq.acwing.基础算法.归并排序;

/**
 * @ClassName : mergeSort
 * @Author : qiziqian
 * @Description:
 * @Date: 2021-02-22 10:14
 */
public class mergeSort {


    /*
        1.找到分界点
        2.递归划分
        3.数组合并
     */
    public static void mergeSort(int[] q, int l, int r) {
        if (l >= r) return;
        int mid = (l + r) >> 1;

        mergeSort(q, l, mid);
        mergeSort(q, mid + 1, r);

        int[] temp = new int[r - l + 1];
        int i = l, j = mid + 1, k = 0;
        while (i <= mid && j <= r) {
            if (q[i] > q[j]) temp[k++] = q[j++];
            else temp[k++] = q[i++];
        }
        while (i <= mid) temp[k++] = q[i++];
        while (j <= r) temp[k++] = q[j++];
        for (i = l, j = 0; i <= r; i++, j++) {
            q[i] = temp[j];
        }
    }


    public static void main(String[] args) {
        mergeSort(new int[]{99, 51, 84, 48, 76, 42, 6, 6, 38, 10}, 0, 9);
    }
}