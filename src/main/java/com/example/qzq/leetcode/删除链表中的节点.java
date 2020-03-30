package com.example.qzq.leetcode;

/**
 * @Classname 删除链表中的节点
 * @Description
 * @Date 2019/10/8 10:29
 * @Created by qiziqian
 */
public class 删除链表中的节点 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(5);
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(9);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        deleteNode(listNode2);
        System.out.println(listNode1);
    }

    public static void deleteNode(ListNode node) {

        node.val = node.next.val;
        node.next = node.next.next;

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
