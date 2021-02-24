package com.example.qzq.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : 字符串的排列
 * @Author : qiziqian
 * @Description:
 * @Date: 2021-02-10 10:09
 */
public class 字符串的排列 {
    public static void main(String[] args) {

        System.out.println(checkInclusion("ab", "eidboaoo"));
        System.out.println(checkInclusion("ab", "eidbaooo"));
        System.out.println(checkInclusion("adc", "dcda"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        int[] a = new int[26];
        for (char c : s1.toCharArray()) {
            a[c - 'a']++;
        }
        int left = 0, right = 0;
        while (right < s2.length()) {
            a[s2.charAt(right) - 'a']--;
            while (a[s2.charAt(right) - 'a'] < 0) {
                a[s2.charAt(left) - 'a']++;
                left++;
            }
            if (right - left + 1 == s1.length()) {
                return true;
            }
            right++;
        }
        return false;
    }

}