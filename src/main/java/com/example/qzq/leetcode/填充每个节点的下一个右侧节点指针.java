package com.example.qzq.leetcode;

import com.example.qzq.data_structure.ArrayQueue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @ClassName : 填充每个节点的下一个右侧节点指针
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-10-15 10:12
 */
public class 填充每个节点的下一个右侧节点指针 {
    public Node connect(Node root) {
        if (root == null) return root;

        Queue<Node> queue = new ArrayDeque<>();
        if (root.left != null) queue.add(root.left);
        if (root.right != null) queue.add(root.right);
        while (!queue.isEmpty()) {
            Node pre = null;
            Queue<Node> levelQueue = new ArrayDeque<>(queue);
            queue.clear();
            while (!levelQueue.isEmpty()) {
                Node node = queue.poll();
                if (pre != null) pre.next = node;
                pre = node;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

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