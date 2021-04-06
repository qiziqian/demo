package com.example.qzq.acwing.数据结构.队列;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName : 滑动窗口_单调队列
 * @Author : qiziqian
 * @Description:
 * @Date: 2021-03-09 14:19
 */
public class 滑动窗口_单调队列 {


    public static void main(String[] args) throws IOException {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{-7, -8, 7, 5, 7, 1, 6, 0}, 4)));
    }


    public static int[] maxSlidingWindow(int[] a, int k) {
        int n = a.length;
        if (a.length == 0) return new int[0];
        int[] maxRes = new int[n - k + 1];
        Queue max = new Queue();
        int resIdx = 1;
        for (int i = 0; i < k; i++) {
            while (!max.isEmpty() && max.peek() < a[i]) {
                max.pop();
            }
            max.push(a[i]);
        }
        maxRes[0] = max.peek();
        for (int i = k; i < a.length; i++) {
            if (max.peek() == a[i - k]) max.pop();
            while (!max.isEmpty() && max.peekTail() < a[i]) {
                max.removeTail();
            }
            max.push(a[i]);
            maxRes[resIdx] = max.peek();
            resIdx++;
        }
        return maxRes;
    }

    public static class Queue {
        int[] e = new int[100010];
        int head = 0;
        int tail = -1;

        public int pop() {
            return e[head++];
        }

        public int peek() {
            return e[head];
        }

        public int peekTail() {
            return e[tail];
        }

        public void removeTail() {
            tail--;
        }

        public void push(int x) {
            e[++tail] = x;
        }

        public boolean isEmpty() {
            return head > tail;
        }

    }
}