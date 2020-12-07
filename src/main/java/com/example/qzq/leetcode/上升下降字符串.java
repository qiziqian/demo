package com.example.qzq.leetcode;

/**
 * @ClassName : 上升下降字符串
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-11-25 14:37
 */
public class 上升下降字符串 {
    public static void main(String[] args) {
        System.out.println(sortString("aaaabbbbcccc"));
    }

    public static String sortString(String s) {
        int[] array = new int[26];
        for (int i = 0; i < s.length(); i++) {
            array[s.charAt(i) - 'a']++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int count = s.length();
        while (stringBuilder.length() < s.length()) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] != 0) {
                    stringBuilder.append((char) (i + 'a'));
                    array[i]--;
                }
            }
            for (int i = array.length - 1; i >= 0; i--) {
                if (array[i] != 0) {
                    stringBuilder.append((char) (i + 'a'));
                    array[i]--;
                }
            }

        }

        return stringBuilder.toString();
    }

}