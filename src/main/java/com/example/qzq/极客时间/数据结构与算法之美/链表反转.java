package com.example.qzq.极客时间.数据结构与算法之美;

import com.example.qzq.data_structure.ListNode;

/**
 * @Classname 链表反转
 * @Description
 * @Date 2019/11/4 11:12
 * @Created by qiziqian
 */
public class 链表反转 {
    public static ListNode reverse(ListNode head) {
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
