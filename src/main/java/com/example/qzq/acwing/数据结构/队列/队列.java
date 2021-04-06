package com.example.qzq.acwing.数据结构.队列;

import org.apache.catalina.mapper.Mapper;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @ClassName : 队列
 * @Author : qiziqian
 * @Description:
 * @Date: 2021-03-09 13:35
 */
public class 队列 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        Queue queue = new Queue();
        while (m-- > 0) {
            String opt = scanner.next();
            if ("push".equals(opt)) {
                int x = scanner.nextInt();
                queue.addTail(x);
            } else if ("pop".equals(opt)) {
                queue.pop();
            } else if ("empty".equals(opt)) {
                System.out.println(queue.isEmpty());
            } else if ("query".equals(opt)) {
                System.out.println(queue.query());
            }
        }
    }


    public static class Queue {
        private int[] e = new int[100010];
        private int head = -1;
        private int tail = -1;

        public void addTail(int x) {
            if (head == -1) {
                e[++head] = x;
            }
            e[++tail] = x;
        }

        public int query() {
            return e[head];
        }

        public int pop() {
            return e[head++];
        }

        public boolean isEmpty() {
            if (head == -1) return true;
            return head > tail;
        }
    }
}