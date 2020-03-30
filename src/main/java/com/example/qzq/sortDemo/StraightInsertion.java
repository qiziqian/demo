package com.example.qzq.sortDemo;

/**
 * 直接插入排序
 * 时间复杂度:   O(n²)   n²/4
 * 效率高于冒泡和简单选择排序
 */
public class StraightInsertion {
    public static void main(String[] args) {
        //demo1();
        //demo2();
        demo3();
    }

    //网上抄的
    public static void demo1() {
        // int[] array = {7,6,5,2,1,3,6,4,9,8};
        int[] array = {9, 5, 1, 4, 3, 0, 2, 7, 7, 6, 9, 10, 11};
        // 9 5 1 4 3
        int i, j;
        for (i = 1; i < array.length; i++) {
            int temp = array[i];
            for (j = i - 1; j >= 0 && array[j] > temp; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = temp;
        }
        for (int k = 0; k < array.length; k++) {
            System.out.print(array[k] + " ");
        }
    }

    public static void demo2() {
        int[] array = {4, 16, 8, 3, 3, 2, 1};
        int i, j;
        int count = 0;
        for (i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                int temp = array[i];
                for (j = i - 1; j >= 0 && array[j] > temp; j--) {
                    array[j + 1] = array[j];
                    count++;
                }
                array[j + 1] = temp;
            }
        }
        System.out.println(count);
        for (int k = 0; k < array.length; k++) {
            System.out.print(array[k] + " ");
        }
    }

    // 2019/10/28 17:10  qiziqian  练习
    public static void demo3() {
        int[] array = {4, 16, 8, 3, 3, 2, 1};
        int i, j;
        for (i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                int temp = array[i + 1];
                for (j = i; j >= 0 && array[j] > temp; j--) {
                    array[j + 1] = array[j];
                }
                array[j + 1] = temp;
            }
        }
        for (i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
