package com.example.qzq.leetcode;

import java.util.Stack;

/**
 * @Classname MinStack
 * @Description最小栈
 * @Date 2019/11/22 17:43
 * @Created by qiziqian
 */
public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> stack2;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<>();
    }

    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        stack1.push(1);
        stack2.push(2);

    }

    public void push(int x) {
        stack.push(x);
        if (stack2.isEmpty() || stack2.peek() > x) {
            stack2.push(x);
        } else {
            stack2.push(stack2.peek());
        }
    }

    public void pop() {
        stack.pop();
        stack2.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return stack2.peek();
    }
}
