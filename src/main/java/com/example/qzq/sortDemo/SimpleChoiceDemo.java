package com.example.qzq.sortDemo;

/**
 * 简单选择排序
 * 时间复杂度:   O(n²)  n(n-1)/2
 * 效率略高于冒泡排序
 */
public class SimpleChoiceDemo {
    public static void main(String[] args) {
        demo1();
    }

    public static void demo1() {
        //  int[] array = {9, 5, 1, 3, 4, 2, 7, 6, 8};
        int[] array = {3, 1, 2, 4, 5, 6, 7, 8, 9};
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i; j < array.length; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
                count++;
            }
            if (i != min) {
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");

        }
        System.out.print("简单选择排序    一共循环 : " + count + " 次");
    }

}
