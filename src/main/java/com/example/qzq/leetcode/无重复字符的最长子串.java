package com.example.qzq.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * @Classname 无重复字符的最长子串
 * @Description
 * @Date 2019/12/26 16:56
 * @Created by qiziqian
 */
public class 无重复字符的最长子串 {
    public static void main(String[] args) {
        lengthOfLongestSubstring("abcabcbb");
        List<Object> objects = Arrays.asList();
    }

    public static int lengthOfLongestSubstring(String s) {
        int[] array = new int[128];
        int len = s.length();
        int ans = 0;
        for (int i = 0, j = 0; j < len; j++) {
            i = Math.max(i, array[s.charAt(j)]);
            ans = Math.max(ans, j - i + 1);
            array[s.charAt(j)] = j + 1;
        }
        return ans;
    }


}
