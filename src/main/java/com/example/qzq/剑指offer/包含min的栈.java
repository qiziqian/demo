package com.example.qzq.剑指offer;

import java.util.Stack;

/**
 * @ClassName : 包含min的栈
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-09-11 10:19
 */
public class 包含min的栈 {
    Stack<Integer> mainStack;
    Stack<Integer> subStack;

    /**
     * initialize your data structure here.
     */
    public 包含min的栈() {
        mainStack = new Stack();
        subStack = new Stack();
    }

    public void push(int x) {
        mainStack.push(x);
        if (subStack.empty() || subStack.peek() >= x) {
            subStack.push(x);
        }
    }

    public void pop() {
        Integer pop = mainStack.pop();
        if (pop.equals(subStack.peek())) {
            subStack.pop();
        }

    }

    public int top() {
        return mainStack.pop();
    }

    public int min() {
        return subStack.pop();
    }

}