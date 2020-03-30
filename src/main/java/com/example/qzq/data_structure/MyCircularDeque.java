package com.example.qzq.data_structure;

/**
 * @Classname MyCircularDeque
 * @Description
 * @Date 2019/12/17 17:47
 * @Created by qiziqian
 */
class MyCircularDeque {
    int[] queue;
    int count;
    int size;


    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        queue = new int[k];
        count = 0;
        size = k;
    }

    public static void main(String[] args) {
        MyCircularDeque myCircularDeque = new MyCircularDeque(77);
        myCircularDeque.insertFront(89);
        myCircularDeque.deleteLast();
        myCircularDeque.insertFront(19);
        myCircularDeque.insertFront(23);
        myCircularDeque.insertFront(23);
        myCircularDeque.insertFront(82);
        myCircularDeque.insertFront(45);
        myCircularDeque.deleteLast();
        myCircularDeque.insertLast(74);
        myCircularDeque.deleteFront();
        System.out.println(myCircularDeque.getFront());


        myCircularDeque.insertLast(8);
        myCircularDeque.insertLast(2);
        myCircularDeque.deleteLast();
        myCircularDeque.insertFront(9);
        myCircularDeque.deleteFront();
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (count >= size) return false;
        for (int i = count; i >= 1; i--) {
            queue[i] = queue[i - 1];
        }
        queue[0] = value;
        count++;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (count >= size) return false;
        queue[count] = value;
        count++;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (count == 0) return false;
        for (int i = 0; i < count - 1; i++) {
            queue[i] = queue[i + 1];
        }
        queue[count - 1] = 0;
        count--;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (count == 0) return false;
        queue[count - 1] = 0;
        count--;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        return queue[0];
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        return queue[count - 1];
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return count == size;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
