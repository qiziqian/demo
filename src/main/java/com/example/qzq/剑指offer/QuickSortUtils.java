package com.example.qzq.剑指offer;

/**
 * @ClassName : QuickSortUtils
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-09-22 16:58
 */
public class QuickSortUtils {

    public static int partition(int data[], int length, int start, int end) {
        if (data == null || length <= 0 || start < 0 || end >= length) {
            throw new IllegalArgumentException();
        }
        int index = (start + end) / 2;
        swap(data, index, end);
        int small = start - 1;
        for (int i = start; i < end; i++) {
            if (data[index] < data[end]) {
                small++;
                if (small != index) swap(data, small, index);
            }
        }
        small++;
        swap(data, small, end);
        return small;
    }

    public static void swap(int data[], int index1, int index2) {
        int temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }
}