package com.example.qzq.leetcode;

import java.util.Stack;

/**
 * @Classname 去除重复字母
 * @Description
 * @Date 2019/10/30 14:14
 * @Created by qiziqian
 */
public class 去除重复字母 {
    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("qwertaafqw"));
        System.out.println("abccabc".indexOf('a', 2));
    }

    public static String removeDuplicateLetters(String s) {
        //长度为26的数组,记录了每个字母出现的次数
        int[] array = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            array[chars[i] - 97]++;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (stack.contains(ch)) {
                continue;
            }
            while (!stack.empty() && s.charAt(i) < stack.peek() && s.indexOf(stack.peek(), i) != -1) {
                stack.pop();
            }
            stack.push(ch);
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }


    //判断重复的字母与他后面的字母的大小,谁小,谁留下,留出现在最前面的,字典序小的那个
    //没法写
    @Deprecated
    public static String removeDuplicateLetters2(String s) {
        //长度为26的数组,记录了每个字母出现的次数
        int[] array = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            array[chars[i] - 97]++;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (array[chars[i] - 97] == 1) {
                builder.append(chars[i]);
            } else {
                char ch;
                int j = i;
                for (; j < chars.length; j++) {
                    if (array[chars[j]] == 1) {
                        ch = chars[j];
                    }
                }
                while (array[chars[i] - 97] > 1) {
                    if (chars[i] <= chars[i + 1]) {
                        builder.append(chars[i]);
                        array[chars[i] - 97] = -1;
                    } else {
                        array[chars[i] - 97]--;
                    }
                }
            }
        }
        return builder.toString();
    }
}
