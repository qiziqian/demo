package com.example.qzq.acwing.数据结构;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName : 单链表
 * @Author : qiziqian
 * @Description: 为什么要用数组模拟链表?  快
 * @Date: 2021-03-05 10:02
 */


public class 单链表 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(reader.readLine());
        SingleLinkList list = new SingleLinkList();

        list.init();     // 初始化操作

        // 进行 m次操作
        while (m-- > 0) {
            String[] s = reader.readLine().split(" ");

            if (s[0].equals("H")) {
                int val = Integer.parseInt(s[1]);
                list.addToHead(val);
            } else if (s[0].equals("I")) {
                int k = Integer.parseInt(s[1]);
                int val = Integer.parseInt(s[2]);
                list.add(k - 1, val);
            } else if (s[0].equals("D")) {
                int k = Integer.parseInt(s[1]);

                if (k == 0) list.head = list.ne[list.head];
                else list.delete(k - 1);
            }
        }

        // 打印输出
        for (int i = list.head; i != -1; i = list.ne[i]) {
            System.out.print(list.e[i] + " ");
        }
    }

    public static class SingleLinkList {
        int N = 100010;
        //存值
        int[] e = new int[N];
        //存 下标为i的节点的下一个节点
        int[] ne = new int[N];
        int idx = 0;
        int head;

        public void init() {
            e = new int[N];
            ne = new int[N];
            head = -1;
            idx = 0;
        }

        public void addToHead(int num) {
            e[idx] = num;
            ne[idx] = head;
            head = idx;
            idx++;
        }

        public void add(int k, int num) {
            e[idx] = num;
            ne[idx] = ne[k];
            ne[k] = idx;
            idx++;
        }

        public void delete(int k) {
            ne[k] = ne[ne[k]];
        }
    }

}