package com.example.qzq.leetcode;

import java.util.*;

/**
 * @Classname 重复的数
 * @Description
 * @Date 2019/10/25 13:54
 * @Created by qiziqian
 */
public class 重复的数 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 2, 3, 4};
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            if (set.contains(arr2[i])) set2.add(arr2[i]);
            set.add(arr2[i]);
        }
        int[] ints = new int[set2.size()];
        int idx = 0;
        for (Integer integer : set2) {
            ints[idx++] = integer;
        }
    }

}