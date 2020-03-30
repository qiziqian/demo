package com.example.qzq.sortDemo;

/**
 * @Classname QuickSortDemo
 * @Description
 * @Date 2019/9/12 15:31
 * @Created by qiziqian
 */
public class QuickSortDemo {
    private static final int INSERTION_SORT_THRESHOLD = 47;

    public static void main(String[] args) {
        int arr[] = {4, 2, 1, 3, 564, 2123, 78, 31, 554, 675, 32, 56, 541, 23, 8, 64};
        Qsort(arr, 0, arr.length - 1);
        //swap(arr,0,1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void Qsort(int[] arr, int low, int high) {
        int pivot;
        //数组长度小于47,走直接插入排序,跟jdk的做法一致
        if (high - low > INSERTION_SORT_THRESHOLD) {
            //递归代替循环,减少一半的递归量
            while (low < high) {//迭代来控制枢纽右边的数组排序
                pivot = Partition(arr, low, high);
                //递归来控制枢纽左边的数组排序
                Qsort(arr, low, pivot - 1);
                low = pivot + 1;
            }
        } else {
            straightInsertion(arr);
        }
    }

    private static int Partition(int[] arr, int low, int high) {
        //三值取中法,尽量保证枢纽在中间
        int index = (high + low) / 2;
        if (arr[low] > arr[high]) {
            swap(arr, low, high);
        }

        if (arr[index] > arr[high]) {
            swap(arr, high, index);
        }

        if (arr[index] > arr[low]) {
            swap(arr, index, high);
        }

        int pivot = arr[low];

        while (low < high) {
            while (low < high && pivot <= arr[high]) {
                high--;
            }
            //用替换代替交换
            arr[low] = arr[high];
            //swap(arr, low, high);
            while (low < high && pivot >= arr[low]) {
                low++;
            }
            //用替换代替交换
            arr[high] = arr[low];
            //  swap(arr, low, high);

        }
        arr[low] = pivot;
        return low;
    }

    public static void straightInsertion(int[] array) {
        int i, j;
        for (i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                int temp = array[i];
                for (j = i - 1; j >= 0 && array[j] > temp; j--) {
                    array[j + 1] = array[j];
                }
                array[j + 1] = temp;
            }
        }
    }

    public static void swap(int[] arr, int index1, int index2) {
        arr[index1] = arr[index1] ^ arr[index2];
        arr[index2] = arr[index1] ^ arr[index2];
        arr[index1] = arr[index1] ^ arr[index2];
    }
}
