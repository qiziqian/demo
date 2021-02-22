package com.example.qzq.剑指offer;

import com.example.qzq.data_structure.ListNode;

/**
 * @Description
 * @Date 2020/10/2 23:51
 * @Author by qiziqian
 */
public class 反转链表II {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        reverseBetween(node1, 2, 4);
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode current = head;
        int index = 1;
        while (index < m - 1) {
            current = current.next;
            index++;
        }

        ListNode left = current;
        left.next = reverse(left.next, n - m + 1);

        return head;
    }

    public static ListNode reverse(ListNode head, int reverseTime) {
        ListNode current = head;
        ListNode pre = null;
        while (reverseTime > 0 && current != null) {
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
            reverseTime--;
        }
        head.next = current;
        return pre;
    }
}
