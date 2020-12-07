package com.example.qzq.剑指offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : 打印从1到最大的n位数
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-10-19 14:45
 */
public class 打印从1到最大的n位数 {

    public static void main(String[] args) {
        printNumbers(12346);
    }

    public static void printNumbers(int n) {
        int[] array = new int[n];
        List<String> list = new ArrayList<>();
        recur(array, list, 0, n);
        System.out.println(list);
    }

    public static void recur(int[] array, List<String> list, int currLength, int length) {
        if (currLength >= length) {
            list.add(toString(array));
            return;
        }
        for (int i = 0; i <= 9; i++) {
            array[currLength] = i;
            recur(array, list, currLength + 1, length);
        }
    }

    public static String toString(int[] chArray) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean isFirst = true;
        for (int c : chArray) {
            if (isFirst && c == 0) {
                continue;
            } else {
                isFirst = false;
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }
}