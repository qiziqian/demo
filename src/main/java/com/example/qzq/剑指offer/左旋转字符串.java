package com.example.qzq.剑指offer;

/**
 * @ClassName : 左旋转字符串
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-09-27 17:40
 */
public class 左旋转字符串 {
    public static void main(String[] args) {
        System.out.println(reverseLeftWords("qzq123", 2));
    }

    public static String reverseLeftWords(String s, int n) {
        return (s + s).substring(n, s.length() + n);
    }
}