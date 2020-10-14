package com.example.qzq.剑指offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : 复杂链表的复制
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-09-14 13:39
 */
public class 复杂链表的复制 {
    public static void main(String[] args) {
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node2.random = node1;
        node3.random = node5;
        node4.random = node2;
        node5.random = node1;
        copyRandomList2(node1);
    }

    public static Node copyRandomList2(Node head) {
        if (head == null) return null;
        copyNode(head);
        linkRandom(head);
        Node node = reConnect(head);
        return node;
    }

    public static void copyNode(Node head) {
        Node curr = head;
        while (curr != null) {
            Node node = new Node(curr.val);
            Node nextNode = curr.next;
            curr.next = node;
            node.next = nextNode;
            curr = nextNode;
        }
    }

    public static void linkRandom(Node head) {
        Node curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;

        }
    }

    public static Node reConnect(Node head) {
        Node copyHead = head.next;
        Node curr = head;
        Node curCopy = head.next;
        while (curr != null) {
            curr.next = curr.next.next;
            curr = curr.next;
            if (curCopy.next != null) {
                curCopy.next = curCopy.next.next;
                curCopy = curCopy.next;
            }
        }
        return copyHead;
    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Map<Node, Node> nodeMap = new HashMap();
        Node curr = head;
        while (curr != null) {
            nodeMap.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        curr = head;
        while (curr != null) {
            Node node = nodeMap.get(curr);
            node.next = nodeMap.get(curr.next);
            node.random = nodeMap.get(curr.random);
            curr = curr.next;
        }
        return nodeMap.get(head);
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}