package com.example.qzq.geekbang;

import com.example.qzq.leetcode.ListNode;

/**
 * @Classname 链表反转
 * @Description
 * @Date 2019/11/4 11:12
 * @Created by qiziqian
 */
public class 链表反转 {
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
