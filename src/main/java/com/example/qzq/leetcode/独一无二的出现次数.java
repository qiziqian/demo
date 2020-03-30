package com.example.qzq.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


/**
 * @Classname 独一无二的出现次数
 * @Description
 * @Date 2019/10/7 11:53
 * @Created by qiziqian
 */
public class 独一无二的出现次数 {
    public static void main(String[] args) {
        int[] arr = {1, 2};
        System.out.println(uniqueOccurrences(arr));
    }

    //思路1:用map存储每个出现数字的出现次数
    //思路2:排序,记录索引
    public static boolean uniqueOccurrences(int[] arr) {
        Arrays.sort(arr);
        ArrayList<Integer> list = new ArrayList<>();
        int index = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[j] != arr[j - 1]) {
                list.add(j - index);
                index = j;
            }
        }
        list.add(arr.length - index);
        Collections.sort(list);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).equals(list.get(i + 1))) {
                return false;
            }
        }
        return true;
    }
}
