package com.example.qzq.sortDemo;

/**
 * 冒泡排序
 * 时间复杂度:   O(n²)   n(n-1)/2
 */

public class BubbleSortDemo {
    public static void main(String[] args) {
//        demo1();
//        demo2();
        demo3();
        //      demo4();
    }

    //最简单的交换排序,效率低,每次都将该关键词与剩余关键词做比较,对其他关键词的排序没有帮助
    public static void demo1() {
        //  int[] array = {9,1,5,8,3,7,4,6,2};
        int[] array = {3, 1, 2, 4, 5, 6, 7, 8, 9};
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;

                }
                count++;
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("交换排序    一共循环 : " + count + " 次");
    }

    //正宗冒泡排序,两两比较,对其他关键词也有帮助
    public static void demo2() {
        //  int[] array = {9,1,5,8,3,7,4,6,2};
        int[] array = {3, 1, 2, 4, 5, 6, 7, 8, 9};
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                }
                count++;
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("冒泡排序    一共循环 : " + count + " 次");

    }

    //优化后的冒泡排序,避免无意义的比较
    public static void demo3() {
        //  int[] array = {9,1,5,8,3,7,4,6,2};
        //int[] array = {3, 1, 2, 4, 5, 6, 7, 8, 9};
        int[] array = {4, 16, 8, 3, 3, 2, 1};
        //   20   25  21
        //让他能进循环,必须设置为true
        Boolean flag = true;
        int count = 0;
        for (int i = 0; i < array.length && flag; i++) {
            //初始化为false
            flag = false;
            for (int j = 0; j <= array.length - i - 2; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    //有交换则说明需要比较,设置为true
                    flag = true;

                }
                count++;
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("优化后的冒泡排序    一共循环 : " + count + " 次");
    }

    // 2019/10/28 17:02  qiziqian    练习
    public static void demo4() {
        int[] arr = {4, 16, 8, 3, 3, 2, 1};
        boolean flag = true;
        for (int i = 0; i < arr.length && flag; i++) {
            flag = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
