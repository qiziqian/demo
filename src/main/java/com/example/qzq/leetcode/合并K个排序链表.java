package com.example.qzq.leetcode;

/**
 * @Classname 合并K个排序链表
 * @Description
 * @Date 2019/12/17 13:56
 * @Created by qiziqian
 */
public class 合并K个排序链表 {
    public static void main(String[] args) {
        ListNode node = new ListNode();
        ListNode node1 = new ListNode(1);
        ListNode[] listNodes = new ListNode[2];
        // listNodes[0] = node;
        listNodes[1] = node1;
        mergeKLists(listNodes);
    }

    //思路:
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length < 1) return null;

        ListNode[] node = new ListNode[lists.length];

        ListNode head = new ListNode(Integer.MAX_VALUE);
        int headIndex = 0;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) continue;
            node[i] = lists[i];
            if (head.val > node[i].val) {
                head = node[i];
                headIndex = i;
            }
        }
        if (lists[headIndex] == null) return null;
        node[headIndex] = node[headIndex].next;
        ListNode last = head;
        while (true) {
            ListNode min = new ListNode(Integer.MAX_VALUE);
            int index = -1;
            for (int i = 0; i < node.length; i++) {
                if (node[i] != null && node[i].val < min.val) {
                    min = node[i];
                    index = i;
                }
            }
            if (min.val == Integer.MAX_VALUE) break;
            node[index] = node[index].next;
            last.next = min;
            last = last.next;
        }
        return head;
    }
}
