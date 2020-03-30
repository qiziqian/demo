package com.example.qzq.leetcode;

import java.util.LinkedList;

/**
 * @Classname 回文链表
 * @Description
 * @Date 2019/10/23 11:07
 * @Created by qiziqian
 */
public class 回文链表 {
    public static void main(String[] args) {
        LinkedList<Object> objects = new LinkedList<>();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(1);
        node1.next = node2;
        // node2.next=node3;
        node3.next = node5;
        node4.next = node5;
        node5.next = node6;
        //reverse(node1);
        LinkedList<Object> objects1 = new LinkedList<>();
        objects1.add(111);
    }

    // 1  2  3  4  5  6   1  2  3   4   5  6     6  5  4  3
    // 1  2  3  4  5      1  2    5  4  3
    public static boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        slow = reverse(slow);
        while (slow != null) {
            if (head.val != slow.val) return false;
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    // 4 5 6 7 -->
    //1.拿到当前你节点的下一个节点
    //2.将当前节点的下一个节点变为上一个节点
    //3.当前节点的上一个节点是当前节点
    //当前节点为当前节点的下一个节点
    public static ListNode reverse(ListNode head) {
        ListNode preNode = null, currNode = head;
        while (currNode != null) {
            ListNode nextNode = currNode.next;
            currNode.next = preNode;
            preNode = currNode;
            currNode = nextNode;
        }
        return preNode;
    }
}
