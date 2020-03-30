package com.example.qzq.leetcode;

/**
 * @Classname 两数相加
 * @Description
 * @Date 2019/10/21 10:01
 * @Created by qiziqian
 */
public class 两数相加 {
    public static void main(String[] args) {

    }

    // 999999
    // 999999
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean flag = false;
        ListNode headNode = new ListNode(0);
        ListNode curr = headNode;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int i1 = l1 == null ? 0 : l1.val;
            int i2 = l2 == null ? 0 : l2.val;
            int sum = (i1 + i2 + carry) % 10;
            carry = (i1 + i2 + carry) / 10;
            curr.next = new ListNode(sum);
            curr = curr.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return headNode.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
