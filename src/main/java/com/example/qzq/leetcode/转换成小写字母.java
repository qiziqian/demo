package com.example.qzq.leetcode;

/**
 * @Classname 转换成小写字母
 * @Description
 * @Date 2019/10/7 20:12
 * @Created by qiziqian
 */
public class 转换成小写字母 {
    public static void main(String[] args) {
        toLowerCase("qqQ");
    }

    public static String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        String s = "";
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] < 97 && chars[i] > 64) {
                chars[i] = (char) (chars[i] + 32);
            }
            s += chars[i];
        }
        return s;
    }
}
