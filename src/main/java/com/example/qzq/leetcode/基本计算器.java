package com.example.qzq.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Classname 基本计算器
 * @Description
 * @Date 2019/11/25 15:08
 * @Created by qiziqian
 */
public class 基本计算器 {
    public int calculate(String s) {
        Stack<String> stack = new Stack<>();
        Queue<String> queue = new LinkedList<>();

        // 中序表达式转化为后续表达式
        // 1. 符号优先级大于栈顶元素，则入栈，否则将栈顶优先级高或相等的元素全部出栈，然后入栈
        // 2. 左括号优先级最高，直接入栈
        // 3. 右括号优先级最低，需要将栈顶元素出栈，直到遇到左括号（左括号也需要出栈）
        for (int i = 0; i < s.length(); i++) {
            String c = String.valueOf(s.charAt(i));

            if (c.equals(" ")) continue;
            if (c.equals("(")) stack.push("(");
            else if (c.equals(")")) {
                while (!stack.peek().equals("(")) queue.offer(stack.pop()); // 左括号前的所有元素出栈
                stack.pop(); // 右括号出栈
            } else if (c.equals("+") || c.equals("-")) {
                if (!stack.isEmpty() && !stack.peek().equals("(")) { // 优先级相等或较高，出栈
                    queue.offer(stack.pop());
                }
                stack.push(c);
            } else {
                int num = s.charAt(i) - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num = (num * 10 + s.charAt(i + 1) - '0');
                    i++;
                }
                queue.offer(String.valueOf(num));
            }
        }
        while (!stack.isEmpty()) queue.offer(stack.pop());

        // 逆波兰求解
        Stack<Integer> stack2 = new Stack<>();
        while (!queue.isEmpty()) {
            String token = queue.poll();
            if (token.equals("+")) {
                stack2.push(stack2.pop() + stack2.pop());
            } else if (token.equals("-")) {
                stack2.push(-stack2.pop() + stack2.pop());
            } else {
                stack2.push(Integer.valueOf(token));
            }
        }
        return stack2.pop();
    }


}
