package com.example.qzq.leetcode;

/**
 * @ClassName : 最小的k个数
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-10-26 17:19
 */
public class 最小的k个数 {

    public static void main(String[] args) {
        getLeastNumbers(new int[]{1, 2, 3}, 2);
    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        if (k <= 0 || arr.length == 0) return new int[0];
        int[] array = new int[10000];
        for (int i = 0; i < arr.length; i++) {
            array[arr[i]]++;
        }
        int[] result = new int[k];
        int index = 0;
        sdadsa:
        for (int i = 0; i < array.length; i++) {
            while (array[i] != 0) {
                array[i]--;
                result[index] = i;
                index++;
                if (index >= k) break sdadsa;
            }
        }
        return result;
    }

}