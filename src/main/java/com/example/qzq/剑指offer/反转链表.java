package com.example.qzq.剑指offer;

import com.example.qzq.leetcode.ListNode;

/**
 * @ClassName : 反转链表
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-08-20 11:38
 */
public class 反转链表 {

    public static void main(String[] args) {

    }

    //还是看了看以前写的才做出来了
    public ListNode reverseList(ListNode head) {
        ListNode preNode = null;
        ListNode currNode = head;
        while (currNode != null) {
            ListNode nextNode = currNode.next;
            currNode.next = preNode;
            preNode = currNode;
            currNode = nextNode;
        }
        return preNode;
    }

}