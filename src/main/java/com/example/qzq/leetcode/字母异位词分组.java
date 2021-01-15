package com.example.qzq.leetcode;

import java.util.*;

/**
 * @ClassName : 字母异位词分组
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-12-14 10:14
 */
public class 字母异位词分组 {

    public static void main(String[] args) {
        findAnagrams("cbaebabacd", "abc");

    }


    //效率极低,应用滑动窗口可改善
    public static List<Integer> findAnagrams(String s, String p) {
        if (s.length() == 0 || s.length() < p.length()) return new ArrayList<>();
        int[] array = new int[26];
        int[] window = new int[26];
        for (int i = 0; i < p.length(); i++) {
            array[p.charAt(i) - 'a']++;
            window[s.charAt(i) - 'a']++;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length() - p.length(); i++) {
            for (int j = 0; j < 26; j++) {
                if (array[j] != window[j]) break;
                if (j == 25) result.add(i);
            }
            window[s.charAt(i + p.length()) - 'a']++;
            window[s.charAt(i) - 'a']--;
        }
        return result;

    }


}