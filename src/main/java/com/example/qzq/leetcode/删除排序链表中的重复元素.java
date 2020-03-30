package com.example.qzq.leetcode;

/**
 * @Classname 删除排序链表中的重复元素
 * @Description
 * @Date 2019/10/8 9:37
 * @Created by qiziqian
 */
public class 删除排序链表中的重复元素 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(3);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        deleteDuplicates(listNode);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode headNode = new ListNode(head.val);
        ListNode tempNode = headNode;
        while (head.next != null) {
            if (head.val == head.next.val) {
                head = head.next;
                tempNode.next = null;
                continue;
            } else {
                tempNode.next = head.next;
                tempNode = tempNode.next;
                head = head.next;
            }
        }
        return headNode;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
