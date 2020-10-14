package com.example.qzq.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * @ClassName : 填充每个节点的下一个右侧节点指针II
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-09-28 10:02
 */

public class 填充每个节点的下一个右侧节点指针II {
    Queue<Node> queue = new ArrayDeque<>();

    //标准的层级遍历
    public Node connect1(Node root) {
        if (root == null) return root;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.println(node.val);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return null;
    }

    //本题把它串联成一个链表
    public Node connect2(Node root) {
        if (root == null) return root;

        Node curr = root;

        while (curr != null) {

            Node temp = new Node(0);
            Node pre = temp;

            while (curr != null) {
                if (curr.left != null) {
                    pre.next = curr.left;
                    pre = pre.next;
                }
                if (curr.right != null) {
                    pre.next = curr.right;
                    pre = pre.next;
                }
                curr = curr.next;
            }

            curr = temp.next;
        }

        return root;
    }

    public Node connect(Node root) {
        if (root == null)
            return root;
        Node cur = root;
        while (cur != null) {
            Node dummy = new Node(0);
            Node pre = dummy;

            while (cur != null) {
                if (cur.left != null) {
                    pre.next = cur.left;
                    pre = pre.next;
                }
                if (cur.right != null) {
                    pre.next = cur.right;
                    pre = pre.next;
                }
                cur = cur.next;
            }

            cur = dummy.next;
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;
}
