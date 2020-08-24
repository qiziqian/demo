package com.example.qzq.剑指offer;

import com.example.qzq.leetcode.ListNode;

/**
 * @ClassName : 在O1时间删除链表节点
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-08-20 10:11
 */
public class 删除链表的节点 {
    public static void main(String[] args) {

    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return head;
        if (head.val == val) {
            head = head.next;
            return head;
        }
        ListNode preNode = head;
        while (preNode.next != null) {
            ListNode next = preNode.next;
            if (next != null && next.val == val) {
                preNode.next = next.next;
                break;
            }
            preNode = preNode.next;
        }
        return head;
    }
}