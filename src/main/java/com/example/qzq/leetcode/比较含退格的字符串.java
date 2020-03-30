package com.example.qzq.leetcode;

import java.util.Stack;

/**
 * @Classname 比较含退格的字符串
 * @Description 栈
 * @Date 2019/11/25 10:15
 * @Created by qiziqian
 */
public class 比较含退格的字符串 {
    public static void main(String[] args) {
        backspaceCompare("y#fo##f", "y#f#o##f");
    }

    public static boolean backspaceCompare(String S, String T) {
        char[] chars1 = S.toCharArray();
        char[] chars2 = T.toCharArray();
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        StringBuilder builder1 = new StringBuilder();
        StringBuilder builder2 = new StringBuilder();
        for (char c : chars1) {
            if (c == '#') {
                if (!stack1.isEmpty()) stack1.pop();
            } else {
                stack1.push(c);
            }
        }
        for (char c : chars2) {
            if (c == '#') {
                if (!stack2.isEmpty()) stack2.pop();
            } else {
                stack2.push(c);
            }
        }
        while (!stack1.isEmpty()) {
            builder1.append(stack1.pop());
        }
        while (!stack2.isEmpty()) {
            builder2.append(stack2.pop());
        }
        return builder1.toString().equals(builder2.toString());
    }
}
