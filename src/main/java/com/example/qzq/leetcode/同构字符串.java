package com.example.qzq.leetcode;

import java.util.Arrays;

/**
 * @Classname 同构字符串
 * @Description
 * @Date 2020/1/22 13:29
 * @Created by qiziqian
 */
public class 同构字符串 {
    public static void main(String[] args) {
        isIsomorphic("aa", "ab");
    }

    public static boolean isIsomorphic(String s, String t) {
        int[] mapS = new int[128];
        int[] mapT = new int[128];
        for (int i = 0; i < s.length(); i++) {
            char chS = s.charAt(i);
            char chT = t.charAt(i);
            if (mapS[chS] != mapT[chT]) {
                return false;
            } else {
                if (mapS[chS] == 0) {
                    mapS[chS] = i + 1;
                    mapT[chT] = i + 1;
                }
            }
        }
        return false;
    }
}
