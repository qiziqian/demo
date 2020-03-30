package com.example.qzq.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Classname 最长回文子串
 * @Description
 * @Date 2019/10/17 9:39
 * @Created by qiziqian
 */
public class 最长回文子串 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaabaaaa"));
        System.out.println(ifPalindrome("qqqaqqq", 0, 6));
        System.out.println("12345".substring(0, 5));
    }

    //  i=3  i
    //  bbcbb
    //  bbccbb
    public static String longestPalindrome2(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int s1 = expendFromCenter(s, i, i);
            int s2 = expendFromCenter(s, i, i + 1);
            int length = Math.max(s1, s2);
            if (length > end - start) {
                start = i - (length - 1) / 2;
                end = i + length / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public static int expendFromCenter(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }

    //执行用时 :
    //259 ms
    //, 在所有 java 提交中击败了
    //14.23%
    //的用户
    //内存消耗 :
    //324.3 MB
    //, 在所有 java 提交中击败了
    //8.72%
    //的用户
    public static String longestPalindrome(String s) {
        int maxlength = 0;
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i);
            for (int j = s.length() - 1; j >= i && (j - i + 1 > maxlength); j--) {
                char ch2 = s.charAt(j);
                if (ch1 == ch2) {
                    boolean b = ifPalindrome(s, i, j);
                    maxlength = b && maxlength < j - i + 1 ? j - i + 1 : maxlength;
                    if (b) list.add(s.substring(i, j + 1));
                }
            }
        }
        final int maxlength2 = maxlength;
        List<String> collect = list.stream().filter(a -> a.length() == maxlength2).collect(Collectors.toList());
        return collect.size() > 0 ? collect.get(collect.size() - 1) : "";
    }

    public static boolean ifPalindrome(String s, int i, int j) {
        for (; i <= j; i++, j--) {
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);
            if (ch1 != ch2) {
                return false;
            }
        }
        return true;
    }
}
