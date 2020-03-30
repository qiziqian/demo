package com.example.qzq.sortDemo;

/**
 * @Classname MergeSortDemo
 * @Description 递推公式:merge_sort(p…r) = merge(merge_sort(p…q), merge_sort(q+1…r))
 * 终止条件:p >= r 不用再继续分解
 * @Date 2019/11/28 17:07
 * @Created by qiziqian
 */
public class MergeSortDemo {
    public static void main(String[] args) {
        int[] array = {21, 5, 32, 54, 74, 68, 110, 654, 315, 4, 3, 0, 57};
        mergeSortStart(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    //起始函数
    public static void mergeSortStart(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    //递归函数
    public static void mergeSort(int[] array, int head, int tail) {
        if (head >= tail) return;
        int mid = (head + tail) / 2;
        mergeSort(array, head, mid);
        mergeSort(array, mid + 1, tail);
        merge(array, head, mid, tail);
    }

    public static void merge(int[] array, int head, int mid, int tail) {
        int i = head;
        int j = mid + 1;
        int k = 0;
        int[] temp = new int[tail - head + 1];
        while (i <= mid && j <= tail) {
            if (array[i] < array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = array[i++];
        }
        while (j <= tail) {
            temp[k++] = array[j++];
        }

        for (int index = 0; index < temp.length; index++) {
            array[index + head] = temp[index];
        }

    }


}
