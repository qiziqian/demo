package com.example.qzq.acwing.数据结构.链表;

/**
 * @Description
 * @Date 2021/3/4 20:30
 * @Author by qiziqian
 */
public class 单链表 {


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
