package com.example.qzq.leetcode;

/**
 * @Classname 翻转字符串里的单词
 * @Description
 * @Date 2019/12/18 15:58
 * @Created by qiziqian
 */
public class 翻转字符串里的单词 {
    public static void main(String[] args) {
        System.out.println(reverseWords("a good   example"));
    }

    public static String reverseWords(String s) {
        String[] strings = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            if (strings[i].equals("")) continue;
            builder.append(strings[i]);
            builder.append(" ");
        }
        return builder.toString().trim();
    }
}
