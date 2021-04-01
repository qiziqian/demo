package com.example.qzq.acwing.数据结构;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName : 栈
 * @Author : qiziqian
 * @Description:
 * @Date: 2021-03-08 17:39
 */
public class 栈 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(reader.readLine());
        Stack stack = new Stack();
        while (m-- > 0) {
            String[] s = reader.readLine().split(" ");
            if (s[0].equals("push")) {
                stack.push(Integer.parseInt(s[1]));
            } else if (s[0].equals("pop")) {
                stack.pop();
            } else if (s[0].equals("query")) {
                System.out.println(stack.find());
            } else if (s[0].equals("empty")) {
                if (stack.isEmpty()) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }


    private static class Stack {
        int s[] = new int[100010];
        int idx = 0;

        public void push(int x) {
            s[idx++] = x;
        }

        public int pop() {
            return s[--idx];
        }

        public int find() {
            return s[idx - 1];
        }

        public boolean isEmpty() {
            return idx == 0;
        }

    }
}