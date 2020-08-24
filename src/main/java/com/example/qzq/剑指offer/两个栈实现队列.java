package com.example.qzq.剑指offer;


import java.util.Stack;

/**
 * @ClassName : 两个栈实现队列
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-08-18 15:58
 */
public class 两个栈实现队列 {
    static Stack<Integer> stack1 = new Stack();
    static Stack<Integer> stack2 = new Stack();

    public static void main(String[] args) {
        push(1);
        push(2);
        push(3);
        push(4);
        push(5);
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
    }

    public static void push(int i) {
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(i);
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
    }

    public static int pop() {
        if (stack1.empty()) return -1;
        return stack1.pop();
    }
}