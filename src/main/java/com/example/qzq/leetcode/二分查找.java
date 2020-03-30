package com.example.qzq.leetcode;

/**
 * @Classname 二分查找
 * @Description
 * @Date 2019/10/30 10:19
 * @Created by qiziqian
 */
public class 二分查找 {
    public static void main(String[] args) {
        System.out.println(bsearch1(new int[]{1, 2, 5, 7, 9, 10, 12, 15, 19, 20, 21}, 11, 9));
    }

    //二分法的三个优化位置 专栏上的写法
    public static int bsearch1(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] > value) high = mid - 1;
            if (a[mid] < value) low = mid + 1;
            if (a[mid] == value) return mid;
        }
        return -1;
    }

    public static int bsearch2(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (a[mid] > value) high = mid;
            if (a[mid] < value) low = mid;
            if (a[mid] == value) return mid;
        }
        return -1;
    }

    public static int bsearch3(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low < high) {
            int mid = low + (high - low) >> 1;
            if (a[mid] > value) {
                high = mid;
            } else {
                if (mid == n - 1 || a[mid + 1] > value) return mid;
                else low = mid;
            }

        }
        return -1;
    }
}
