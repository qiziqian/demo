package com.example.qzq.leetcode;

/**
 * @Classname 验证回文串
 * @Description
 * @Date 2019/12/24 13:57
 * @Created by qiziqian
 */
public class 验证回文串 {
    public static void main(String[] args) {
        System.out.println((int) 'a');
        System.out.println((int) 'z');
        System.out.println((int) 'A');
        System.out.println((int) 'Z');
        System.out.println((int) '0');
        System.out.println((int) '9');
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    public static boolean isPalindrome(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9' || s.charAt(i) >= 'a' && s.charAt(i) <= 'z' || s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                builder.append(s.charAt(i));
            }
        }
        String str = builder.toString().toLowerCase();
        int i = 0;
        int length = builder.toString().length();
        while (i < length) {
            if (str.charAt(i) != str.charAt(length - 1)) return false;
            i++;
            length--;
        }
        return true;
    }
}
