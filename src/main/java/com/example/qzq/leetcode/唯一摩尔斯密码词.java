package com.example.qzq.leetcode;

import java.util.HashSet;

/**
 * @Classname 唯一摩尔斯密码词
 * @Description
 * @Date 2019/10/7 19:47
 * @Created by qiziqian
 */
public class 唯一摩尔斯密码词 {
    static String[] str = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};


    public static void main(String[] args) {
        uniqueMorseRepresentations(new String[]{"a", "b", "c"});
    }

    public static int uniqueMorseRepresentations(String[] words) {
        HashSet set = new HashSet();
        for (int i = 0; i < words.length; i++) {
            char[] chars = words[i].toCharArray();
            String s = "";
            for (int i1 = 0; i1 < chars.length; i1++) {
                s += str[chars[i1] - 'a'];
            }
            set.add(s);
        }
        return set.size();
    }
}
