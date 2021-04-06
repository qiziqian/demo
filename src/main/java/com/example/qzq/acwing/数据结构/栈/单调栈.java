package com.example.qzq.acwing.数据结构.栈;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName : 单调栈
 * @Author : qiziqian
 * @Description:
 * @Date: 2021-03-09 13:48
 */
public class 单调栈 {

    public static void main(String[] args) {
        Stack stack = new Stack();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int idx = 0;
        while (idx < n) {
            int i = sc.nextInt();
            while (!stack.isEmpty() && stack.peek() >= i) {
                stack.pop();
            }
            a[idx++] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static class Stack {
        private int[] e = new int[100010];
        private int idx = -1;

        public void push(int x) {
            e[++idx] = x;
        }

        public int pop() {
            return e[idx--];
        }

        public int peek() {
            return e[idx];
        }

        public boolean isEmpty() {
            return idx == -1;
        }
    }

}