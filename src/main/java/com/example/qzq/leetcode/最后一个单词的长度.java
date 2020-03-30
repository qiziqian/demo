package com.example.qzq.leetcode;

/**
 * @Classname 最后一个单词的长度
 * @Description
 * @Date 2019/10/9 17:36
 * @Created by qiziqian
 */
public class 最后一个单词的长度 {
    public static void main(String[] args) {
        String s = "sda sadfed htr fger ";
        System.out.println(s.trim());
    }

    public int lengthOfLastWord1(String s) {
        String[] s1 = s.split(" ");
        return s1.length > 0 ? s1[s1.length - 1].length() : 0;
    }

    public int lengthOfLastWord2(String s) {
        String S = s.trim();
        if (S.length() == 0) return 0;

        StringBuffer sb = new StringBuffer();
        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) == ' ') {
                break;
            }
            sb.append(S.charAt(i));
        }
        return sb.toString().length();
    }

}
