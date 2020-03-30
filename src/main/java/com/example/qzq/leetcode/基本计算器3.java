package com.example.qzq.leetcode;

import java.util.Stack;

/**
 * @Classname 基本计算器3
 * @Description 栈
 * @Date 2019/11/25 10:42
 * @Created by qiziqian
 */
public class 基本计算器3 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Character> stack2 = new Stack<Character>();

    //  + 43    - 45     * 42    / 47    ( 40  )41
    public int calculate(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            //空格跳过
            if (c == ' ') continue;
            //数字
            if (c >= '0' && c <= '9') {
                stack1.push(Integer.valueOf(c));

            } else {
                if (c == '*') {
                    int num = stack1.pop() * (chars[i + 1] - 48);
                    stack1.push(num);
                    continue;
                }
            }

        }
        return 1;
    }
}
