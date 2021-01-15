package com.example.qzq.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName : 较大分组的位置
 * @Author : qiziqian
 * @Description:
 * @Date: 2021-01-05 10:38
 */
public class 较大分组的位置 {
    public static void main(String[] args) {
        System.out.println(largeGroupPositions("abbxxxxzyy"));
    }

    public static List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList();
        for (int i = 0; i < s.length(); ) {
            int j = i + 1;
            while (j < s.length() && s.charAt(i) == s.charAt(j)) j++;
            if (j - i >= 3) result.add(Arrays.asList(i, j));
            i = j;
        }
        return result;
    }

}