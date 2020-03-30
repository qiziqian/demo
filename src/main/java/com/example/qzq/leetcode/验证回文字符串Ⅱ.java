package com.example.qzq.leetcode;

/**
 * @Classname 验证回文字符串Ⅱ
 * @Description
 * @Date 2019/12/24 14:09
 * @Created by qiziqian
 */
public class 验证回文字符串Ⅱ {
    public static void main(String[] args) {
        System.out.println(validPalindrome("eeccccbebaeeabebccceea"));
    }

    public static boolean validPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return validPalindrome(s, i + 1, j) || validPalindrome(s, i, j - 1);
            }
        }
        return true;
    }

    public static boolean validPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
