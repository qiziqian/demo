package com.example.qzq.leetcode;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Classname 验证外星语词典
 * @Description
 * @Date 2019/10/10 10:50
 * @Created by qiziqian
 */
public class 验证外星语词典 {
    public static void main(String[] args) {
        isAlienSorted(new String[]{"apple", "app"}, "abcdefghijklmnopqrstuvwxyz");
    }

    public static boolean isAlienSorted(String[] words, String order) {
        List<Character> collect = order.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        for (int i = 0; i < words.length - 1; i++) {
            int length = Math.min(words[i].length(), words[i + 1].length());
            for (int j = 0; j < length; j++) {
                if (collect.indexOf(words[i].charAt(j)) > collect.indexOf(words[i + 1].charAt(j))) {
                    return false;
                } else if (collect.indexOf(words[i].charAt(j)) < collect.indexOf(words[i + 1].charAt(j))) {
                    break;
                }
                if (j == length - 1 && words[i].length() > words[i + 1].length()) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isAlienSorted2(String[] words, String order) {
        int[] index = new int[26];
        for (int i = 0; i < order.length(); i++) {
            index[order.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < words.length - 1; i++) {
            int length = Math.min(words[i].length(), words[i + 1].length());
            for (int j = 0; j < length; j++) {
                if (words[i].charAt(j) != words[i + 1].charAt(j)) {
                    if (index[words[i].charAt(j) - 'a'] > index[words[i + 1].charAt(j) - 'a']) {
                        return false;
                    }
                    break;
                }
                if (j == length - 1 && words[i].length() > words[i + 1].length()) {
                    return false;
                }
            }
        }
        return true;
    }
}
