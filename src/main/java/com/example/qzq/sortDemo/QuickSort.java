package com.example.qzq.sortDemo;

/**
 * 快速排序
 * 直接插入排序的升级版
 * 时间复杂度:   O ( n b g n )
 * <p>
 * 可以优化的地方:
 * 1.中间枢轴
 * 2.用替换来代替交换
 * 3.优化小数组时的交换(如果数组长度大于某个值,就用直接插入排序)
 * 4.优化递归
 */
public class QuickSort {
    public static void main(String[] args) {
        int arr[] = {3, 7, 5, 2, 1, 6, 9, 8};
        Qsort1(arr, 0, arr.length - 1);
        //swap(arr,0,1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    //排序入口
    public static void Qsort1(int[] arr, int low, int high) {
        int pivot;
        if (low < high) {
            pivot = Partition1(arr, low, high);
            Qsort1(arr, low, pivot - 1);
            Qsort1(arr, pivot + 1, high);
        }

    }

    //优化递归操作和小数组时的操作
    public static void Qsort2(int[] arr, int low, int high) {
        int pivot;
//        if(high-low<=3){
        while (low < high) {//迭代来控制枢纽右边的数组排序
            pivot = Partition3(arr, low, high);
            //递归来控制枢纽左边的数组排序
            Qsort2(arr, low, pivot - 1);
            low = pivot + 1;
        }
//        }else{
//           // StraightInsertion.demo2(arr);
//        }
    }

    //寻找枢纽
    private static int Partition1(int[] arr, int low, int high) {
        //把索引最小的值作为枢纽
        int pivot = arr[low];
        while (low < high) {
            while (low < high && pivot <= arr[high]) {
                high--;
            }
            if (pivot > arr[high]) {
                swap(arr, low, high);
            }

            while (low < high && pivot >= arr[low]) {
                low++;
            }
            if (pivot < arr[low]) {
                swap(arr, low, high);
            }

        }
        return low;
    }


    //优化寻找枢纽方法
    private static int Partition2(int[] arr, int low, int high) {
        //把最小值作为枢纽
        int index = (high + low) / 2;
        if (arr[low] > arr[high]) {
            swap(arr, low, high);
        }

        if (arr[index] > arr[high]) {
            swap(arr, high, index);
        }

        if (arr[index] < arr[low]) {
            swap(arr, index, high);
        }

        int pivot = arr[low];

        while (low < high) {
            while (low < high && pivot <= arr[high]) {
                high--;
            }
            if (pivot > arr[high]) {
                swap(arr, low, high);
            }
            while (low < high && pivot >= arr[low]) {
                low++;
            }
            if (pivot < arr[low]) {
                swap(arr, low, high);
            }
        }
        return low;
    }

    //用替换代替交换
    private static int Partition3(int[] arr, int low, int high) {
        //把最小值作为枢纽
        int index = (high + low) / 2;
        if (arr[low] > arr[high]) {
            swap(arr, low, high);
        }

        if (arr[index] > arr[high]) {
            swap(arr, high, index);
        }

        if (arr[index] < arr[low]) {
            swap(arr, index, high);
        }

        int pivot = arr[low];

        while (low < high) {
            while (low < high && pivot <= arr[high]) {
                high--;
            }
            if (pivot > arr[high]) {
                arr[low] = arr[high];
            }
            while (low < high && pivot >= arr[low]) {
                low++;
            }
            if (pivot < arr[low]) {
                arr[high] = arr[low];
            }

        }
        //将枢纽放在正确的位置
        arr[low] = pivot;
        return low;
    }

    //交换位置
    // 2019/9/12 12:35  qiziqian    抑或  相同为0  不同为1
    //  a^a=0   a^0=a   a^b=b^a  a^b^b=a
    public static void swap(int[] arr, int index1, int index2) {
        arr[index1] = arr[index1] ^ arr[index2];
        arr[index2] = arr[index1] ^ arr[index2];
        arr[index1] = arr[index1] ^ arr[index2];
    }
}
