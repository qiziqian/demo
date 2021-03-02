package com.example.qzq.leetcode;

import java.util.*;

/**
 * @ClassName : 字符串的排列
 * @Author : qiziqian
 * @Description:
 * @Date: 2021-02-10 10:09
 */
public class 字符串的排列 {
    public static void main(String[] args) {

//        System.out.println(checkInclusion("ab", "eidboaoo"));
//        System.out.println(checkInclusion("ab", "eidbaooo"));
//        System.out.println(checkInclusion("adc", "dcda"));
        String s = "abca";
        int mask = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            mask |= (1 << c - 'a');
        }
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


    public static List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> frequency = new HashMap<Integer, Integer>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            int mask = 0;
            for (int j = 0; j < words[i].length(); j++) {
                mask |= 1 << words[i].charAt(j) - 'a';
            }
            frequency.put(mask, frequency.getOrDefault(mask, 0) + 1);
        }

        for (int i = 0; i < puzzles.length; i++) {
            int target = 0;
            for (int j = 0; j < puzzles[i].length(); j++) {
                target |= 1 << puzzles[i].charAt(j) - 'a';
            }
            int cnt = 0;
            int first = 1 << puzzles[i].charAt(0) - 'a';
            for (int j = target; j != 0; j = target & (j - 1)) {
                if ((j & first) != 0) cnt += frequency.getOrDefault(j, 0);
            }
            list.add(cnt);
        }
        return list;
    }

}