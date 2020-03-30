package com.example.qzq.leetcode;

/**
 * @Classname Excel表列名称
 * @Description
 * @Date 2020/1/2 17:46
 * @Created by qiziqian
 */
public class Excel表列名称 {
    public String convertToTitle(int n) {
        StringBuilder builder = new StringBuilder();
        while (n != 0) {
            int ch = n % 26;
            if (ch == 0) {
                ch = 26;
                n--;
            }
            n = n / 26;
            builder.append((char) ('A' + ch - 1));
        }
        builder.reverse();
        return builder.toString();
    }
}
