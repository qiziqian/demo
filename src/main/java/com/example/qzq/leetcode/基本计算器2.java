package com.example.qzq.leetcode;

import java.util.Stack;

/**
 * @Classname 基本计算器2
 * @Description
 * @Date 2019/11/25 15:15
 * @Created by qiziqian
 */
public class 基本计算器2 {

    public static int calculate(String s) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') continue;
            if (chars[i] >= '0' && chars[i] <= '9') {
                stack1.push(Integer.parseInt(chars[i] + ""));
            } else {
                if (chars[i] == '*' || chars[i] == '/') {
                    char ch = chars[i];
                    while (!(chars[i] >= '0' && chars[i] <= '9')) {
                        i++;
                    }
                    stack1.push(ch == '*' ? stack1.pop() * Integer.parseInt(chars[i] + "") : stack1.pop() / Integer.parseInt(chars[i] + ""));
                } else {
                    stack2.push(chars[i]);
                }
            }
        }
        while (!stack2.isEmpty()) {
            Character pop = stack2.pop();
            if (pop == '+') {
                stack1.push(stack1.pop() + stack1.pop());
            } else if (pop == '-') {
                stack1.push(-stack1.pop() + stack1.pop());
            }
        }
        return stack1.pop();
    }

    public static void main(String[] args) {
        System.out.println(calculate(" 42"));
    }

}
