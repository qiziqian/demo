package com.example.qzq.leetcode;

/**
 * @Classname 相交链表
 * @Description
 * @Date 2020/1/2 16:53
 * @Created by qiziqian
 */
public class 相交链表 {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1 = headA;
        ListNode node2 = headB;
        while (node1 != node2) {
            node1 = node1.next == null ? headB : node1.next;
            node2 = node2.next == null ? headA : node2.next;
            if (node1.next == null && node2.next == null) return null;
        }
        return node1;
    }
}
