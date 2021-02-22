package com.example.qzq.acwing.快速排序;


/**
 * @Description
 * @Date 2021/2/16 8:56
 * @Author by qiziqian
 */
public class QuickSort {

    /*
      基于分治算法
      第一步: 确定分界点:
        1.q[l];
        2.q[(l+r)/2];
        3.q[randow]
      第二步:
        调整范围,把所有小于分界点的数放到他左边,大于分界点的数放到他右边
      第三步:
        递归/迭代处理左右两段
     */

    public static void quickSort(int q[], int l, int r) {
        if (l >= r) return;
        int x = q[l + r >> 1], i = l - 1, j = r + 1;
        while (i < j) {
            while (q[++i] < x) ;
            while (q[--j] > x) ;
            if (i < j) swap(q, i, j);
        }
        quickSort(q, l, j);
        quickSort(q, j + 1, r);
    }

    public static void swap(int[] arr, int index1, int index2) {
        arr[index1] = arr[index1] ^ arr[index2];
        arr[index2] = arr[index1] ^ arr[index2];
        arr[index1] = arr[index1] ^ arr[index2];
    }
}
