package com.example.qzq.sortDemo;

/**
 * 希尔排序
 * 直接插入排序的升级版
 * 时间复杂度:   O(n 2/3) 时间复杂度受增量影响很大
 */
public class ShellsSortDemo {
    public static void main(String[] args) {
        demo1();
    }

    public static void demo1() {
        int[] array = {9, 1, 5, 8, 3, 7, 4, 6, 2};
        //增量
        int increment = array.length;
        int i, j;

        do {
            increment = increment / 3 + 1;
            for (i = increment; i < array.length; i++) {
                if (array[i] < array[i - increment]) {
                    int temp = array[i];
                    for (j = i - increment; j >= 0 && array[j] > temp; j -= increment) {
                        array[j + increment] = array[j];
                        array[j] = temp;
                    }
                }
            }
        } while (increment > 1);

        for (int k = 0; k < array.length; k++) {
            System.out.print(array[k] + " ");
        }
    }

}
