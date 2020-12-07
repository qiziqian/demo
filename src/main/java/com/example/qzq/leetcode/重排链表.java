package com.example.qzq.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : 重排链表
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-10-20 16:24
 */
public class 重排链表 {

    public void reorderList(ListNode head) {
        List<ListNode> nodeList = new ArrayList();
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = null;
            nodeList.add(current);
            current = next;
        }
        int left = 1;
        int right = nodeList.size() - 1;
        int index = 1;
        current = head;
        while (left <= right) {
            if (index % 2 == 0) {
                current.next = nodeList.get(left);
                left++;
            } else {
                current.next = nodeList.get(right);
                right--;
            }
            current = current.next;
            index++;
        }
    }
}