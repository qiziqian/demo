package com.example.qzq.sortDemo; /**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */


/**
 * @Classname MyLinkedList
 * @Description 设计一个链表
 * @Date 2019/9/12 12:42
 * @Created by qiziqian
 */
public class MyLinkedList {

    Node first;
    Node last;
    int size = 0;

    Node node(int index) {
        if (index < (size >> 1)) {
            Node node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else {
            Node node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.pre;
            }
            return node;
        }
    }

    public int get(int index) {
        checkElementIndex(index);
        if (!(index >= 0 && index < size)) {
            return -1;
        }
        return node(index).val;
    }

    public void addAtHead(int val) {
        Node f = first;
        Node node = new Node(null, first, val);
        first = node;
        if (null == f) {
            last = node;
        } else {
            f.pre = node;
        }
        size++;

    }

    public void addAtTail(int val) {
        Node l = last;
        Node node = new Node(l, null, val);
        last = node;
        if (null == l) {
            first = node;
        } else {
            l.next = node;
        }
        size++;
    }

    public void addAtIndex(int index, int val) {
        checkPositionIndex(index);
        Node f = first;
        if (index == size) {
            Node l = last;
            Node newNode = new Node(l, null, val);
            last = newNode;
            if (l == null) {
                first = newNode;
            } else {
                l.next = newNode;
            }
            size++;
        } else if (index < size) {
            Node node = node(index);
            Node pre = node.pre;
            Node newNode = new Node(pre, node, val);
            node.pre = newNode;
            if (pre == null) {
                first = newNode;
            } else {
                pre.next = newNode;
            }
            size++;
        }


    }

    public void deleteAtIndex(int index) {
        checkElementIndex(index);

        Node n = node(index);
        Integer element = n.val;
        Node next = n.next;
        Node prev = n.pre;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            n.pre = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.pre = prev;
            n.next = null;
        }

        n.val = null;
        size--;
    }

    public void sort() {
        //让他能进循环,必须设置为true
        Boolean flag = true;
        for (int i = 0; i < size && flag; i++) {
            flag = false;
            for (int j = 0; j <= size - i - 2; j++) {
                if (node(j).val > node(j + 1).val) {
                    node(j).val = node(j).val ^ node(j + 1).val;
                    node(j).next.val = node(j).val ^ node(j + 1).val;
                    node(j).val = node(j).val ^ node(j + 1).val;
                    flag = true;
                }
            }
        }
    }

    private void checkElementIndex(int index) {
        if (!(index >= 0 && index < size)) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void checkPositionIndex(int index) {
        if (!(index >= 0 && index <= size)) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public String toString() {
        if (null != first) {
            StringBuilder sb = new StringBuilder();
            sb.append("[" + first.val);
            Node f = first;
            for (int i = 0; i < size; i++) {
                if (null != f.next) {
                    f = f.next;
                    sb.append("," + f.val);
                }
            }
            sb.append("]");
            return sb.toString();
        }
        return "[]";
    }

    class Node {
        Node next;
        Node pre;
        Integer val;

        public Node(Node pre, Node next, Integer val) {
            this.pre = pre;
            this.next = next;
            this.val = val;
        }

    }

}
