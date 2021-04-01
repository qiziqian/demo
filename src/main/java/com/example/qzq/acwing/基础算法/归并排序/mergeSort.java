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

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int n = customers.length;
        int min = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) min += customers[i];
        }
        int increase = 0;
        for (int i = 0; i < X; i++) {
            if (grumpy[i] == 1) increase += customers[i];
        }
        int maxIncrease = increase;
        for (int i = X; i < n; i++) {
            if (grumpy[i] == 1) increase += customers[i];
            if (grumpy[i - X] == 1) increase -= customers[i];
            maxIncrease = Math.max(maxIncrease, increase);
        }

        return min + maxIncrease;
    }

}