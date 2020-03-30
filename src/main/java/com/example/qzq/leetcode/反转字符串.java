package com.example.qzq.leetcode;

import java.util.Arrays;

/**
 * @Classname 反转字符串
 * @Description
 * @Date 2019/12/18 15:29
 * @Created by qiziqian
 */
public class 反转字符串 {

    public static void main(String[] args) {
        Character[] chars = {'h', 'e', 'l', 'l', 'o'};
        reverseString(chars);
        Arrays.stream(chars).forEach(System.out::println);
    }

    public static void reverseString(Character[] s) {
        for (int index = 0; index < s.length / 2; index++) {
            swap(s, index, s.length - index - 1);
        }
    }

    public static void swap(Character[] s, int index1, int index2) {
        s[index1] = (char) (s[index1] ^ s[index2]);
        s[index2] = (char) (s[index1] ^ s[index2]);
        s[index1] = (char) (s[index1] ^ s[index2]);
    }
}
