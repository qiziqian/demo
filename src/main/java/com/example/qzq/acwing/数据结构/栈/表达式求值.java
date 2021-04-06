package com.example.qzq.acwing.数据结构.栈;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * @ClassName : 表达式求值
 * @Author : qiziqian
 * @Description:
 * @Date: 2021-03-15 16:50
 */
public class 表达式求值 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(calculate(str));
    }

    static int calculate(String str) {
        Map<Character, Integer> pr = new HashMap<Character, Integer>() {{
            put('+', 1);
            put('-', 1);
            put('*', 2);
            put('(', 0);
            put(')', 0);
            put('/', 2);
        }};


        Stack<Integer> num = new Stack<>();
        Stack<Character> op = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                int j = i, x = 0;
                while (j < str.length() && Character.isDigit(str.charAt(j)))
                    x = x * 10 + str.charAt(j++) - '0';
                num.push(x);
                i = j - 1;
            } else if (c == '(') op.push(c);
            else if (c == ')') {
                while (op.peek() != '(') eval(num, op);
                op.pop();
            } else {
                while (!op.isEmpty() && pr.get(op.peek()) >= pr.get(c)) eval(num, op);
                op.push(c);
            }
        }
        while (!op.isEmpty()) eval(num, op);
        return num.peek();
    }

    static void eval(Stack<Integer> num, Stack<Character> op) {
        int b = num.pop();
        int a = num.pop();
        char c = op.pop();
        int x;
        if (c == '+') x = a + b;
        else if (c == '-') x = a - b;
        else if (c == '*') x = a * b;
        else x = a / b;
        num.push(x);
    }
}