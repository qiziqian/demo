package com.example.qzq.leetcode;

import java.util.Stack;

/**
 * @Classname 逆波兰表达式求值
 * @Description 栈
 * @Date 2019/11/25 14:53
 * @Created by qiziqian
 */
public class 逆波兰表达式求值 {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (tokens[i].equals("-")) {
                stack.push(-(stack.pop() - stack.pop()));
            } else if (tokens[i].equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (tokens[i].equals("/")) {
                Integer num1 = stack.pop();
                stack.push(stack.pop() / num1);
            } else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }
}
