package com.example.qzq.leetcode;

import com.example.qzq.data_structure.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class 每日一题 {

    static Map<String, Map<String, Boolean>> map = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(isScramble("hobobyrqd", "hbyorqdbo"));
    }

    public static boolean isScramble(String s1, String s2) {
        if (map.containsKey(s1) && map.get(s1).containsKey(s2)) return map.get(s1).get(s2);
        if (s1.equals(s2)) {
            map.computeIfAbsent(s1, z -> new HashMap<>()).put(s2, true);
            return true;
        }
        if (!same(s1, s2)) {
            map.computeIfAbsent(s1, z -> new HashMap<>()).put(s2, false);
            return false;
        }
        int n = s1.length();

        for (int i = 1; i < n; i++) {
            int finalI = i;
            if (isScramble(s1.substring(0, i), s2.substring(0, i))
                    && isScramble(s1.substring(i, n), s2.substring(i, n))) {
                map.computeIfAbsent(s1, z -> new HashMap<>()).put(s2, true);
                return true;
            }

            if (isScramble(s1.substring(0, i), s2.substring(n - i, n))
                    && isScramble(s1.substring(i, n), s2.substring(0, n - i))) {
                map.computeIfAbsent(s1, z -> new HashMap<>()).put(s2, true);
                return true;
            }
        }
        map.computeIfAbsent(s1, z -> new HashMap<>()).put(s2, false);
        return false;
    }

    public static boolean same(String s1, String s2) {
        int[] a = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            a[s1.charAt(i) - 'a']++;
            a[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) return false;
        }
        return true;
    }
}