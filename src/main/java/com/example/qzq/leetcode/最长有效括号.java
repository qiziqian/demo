package com.example.qzq.leetcode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Classname 最长有效括号
 * @Description
 * @Date 2019/12/17 15:29
 * @Created by qiziqian
 */
public class 最长有效括号 {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses("()()()"));
    }

    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        int count = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty()) {
                    Integer pop = stack.pop();
                    int vaild = i - pop;
                    count = Math.max(vaild, count) + 1;
                }

            }
        }

        return count;
    }
}
