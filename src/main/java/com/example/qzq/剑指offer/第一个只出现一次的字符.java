package com.example.qzq.剑指offer;

/**
 * @ClassName : 第一个只出现一次的字符
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-09-25 14:43
 */
public class 第一个只出现一次的字符 {
    public char firstUniqChar(String s) {

        int[] array = new int[26];
        for (int i = 0; i < s.length(); i++) {
            array[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (array[s.charAt(i) - 'a'] == 1) return (char) (i + 'a');
        }

        return ' ';
    }
}