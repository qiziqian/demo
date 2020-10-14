package com.example.qzq.剑指offer;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName : 二叉搜索树与双向链表
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-09-21 16:17
 */
// Definition for a Node.

public class 二叉搜索树与双向链表 {
    public static void main(String[] args) {
        Node root = new Node(5);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        root.left = node3;
        root.right = node7;

        node3.left = node2;
        node3.right = node4;

        node7.left = node6;
        node7.right = node8;
        treeToDoublyList(root);
    }


    public static Node treeToDoublyList(Node root) {
        Queue<Node> queue = new ArrayDeque<>();
        recur(root, queue);
        Node head = queue.poll();
        ;
        Node curr = head;
        while (!queue.isEmpty()) {
            Node nextNode = queue.poll();
            curr.right = nextNode;
            nextNode.left = curr;
            curr = nextNode;
        }
        head.left = curr;
        curr.right = head;
        return head;
    }

    public static void recur(Node root, Queue queue) {
        if (root == null) return;
        recur(root.left, queue);
        System.out.println(root.val);
        queue.add(root);
        recur(root.right, queue);
    }

}

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};