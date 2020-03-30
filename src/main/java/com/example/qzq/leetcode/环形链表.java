package com.example.qzq.leetcode;

import java.util.HashSet;

/**
 * @Classname 环形链表
 * @Description
 * @Date 2019/12/17 13:24
 * @Created by qiziqian
 */
public class 环形链表 {
    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        HashSet<ListNode> set = new HashSet<>();
        ListNode node = head;
        while (node.next != null) {
            if (set.contains(node)) return true;
            set.add(node);
            node = node.next;
        }
        return false;
    }

    public boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != slow) {
            if (fast == null || fast.next == null) return false;
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }
}
