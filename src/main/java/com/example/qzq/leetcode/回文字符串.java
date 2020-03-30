package com.example.qzq.leetcode;

import java.util.LinkedList;

/**
 * @Classname 回文字符串
 * @Description
 * @Date 2019/10/23 10:53
 * @Created by qiziqian
 */
public class 回文字符串 {
    public static void main(String[] args) {
        String s = "qzqaaqzq";
        System.out.println(str(s));
        LinkedList linkedList = new LinkedList();

    }

    public static boolean str(String s) {
        int length = s.length() - 1;
        for (int i = 0; i < s.toCharArray().length && i < length - i; i++) {
            if (!(s.charAt(i) == s.charAt(length - i))) return false;
        }
        return true;
    }
}
