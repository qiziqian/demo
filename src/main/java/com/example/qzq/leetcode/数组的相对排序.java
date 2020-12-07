package com.example.qzq.leetcode;

import java.util.Arrays;

/**
 * @ClassName : 数组的相对排序
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-11-16 10:33
 */
public class 数组的相对排序 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] hashArray = new int[1001];
        int[] result = new int[arr1.length];
        int index = 0;
        for (int num : arr1) {
            hashArray[num]++;
        }
        for (int num : arr2) {
            for (int i = 0; i <= hashArray[num]; i++) {
                result[index++] = num;
            }
            hashArray[num] = 0;
        }
        int beginIndex = index;
        for (int i = 0; i < hashArray.length; i++) {
            for (int j = 0; j <= hashArray[i]; j++) {
                result[index++] = i;
            }
        }
        Arrays.sort(result, beginIndex, hashArray.length);
        return result;
    }
}