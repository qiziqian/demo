package com.example.qzq.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname 用队列实现栈
 * @Description
 * @Date 2019/11/25 14:01
 * @Created by qiziqian
 */
public class 用队列实现栈 {
    static Queue<Integer> queue1 = new LinkedList<>();


    /**
     * Push element x onto stack.
     */
    public static void push(int x) {
        queue1.add(x);
        int size = queue1.size();
        while (size > 1) {
            queue1.add(queue1.remove());
            size--;
        }

    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public static int pop() {
        return queue1.remove();
    }

    /**
     * Get the top element.
     */
    public static int top() {
        return queue1.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public static boolean empty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        push(1);
        push(2);
        System.out.println(top());
        System.out.println(pop());
    }
}
