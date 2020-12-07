package com.example.qzq.leetcode;

/**
 * @ClassName : 奇偶链表
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-11-13 11:07
 */
public class 奇偶链表 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        oddEvenList(node1);
    }

    public static ListNode oddEvenList(ListNode head) {
        ListNode current = head;
        ListNode pre;
        while (current != null && current.next != null) {
            ListNode next = current.next;
            if (current.next.next != null) {
                current.next = current.next.next;
                current = current.next;
                pre = current;
            }
            current.next = next;
            current = current.next;
        }


        return head;
    }
}