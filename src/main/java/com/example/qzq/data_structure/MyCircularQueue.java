package com.example.qzq.data_structure;

/**
 * @Classname MyCircularQueue
 * @Description 设计循环队列
 * @Date 2019/10/28 13:55      111  222
 * @Created by qiziqian
 */
public class MyCircularQueue {
    private int size;
    private int[] arr;
    private int head;
    private int tail;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        size = 0;
        arr = new int[k];
        head = 0;
        tail = 0;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if ((size + 1) > arr.length) return false;
        arr[tail] = value;
        if (size == 0) {
            head = tail;
        }
        tail = (tail + 1) % arr.length;
        size++;
        return true;

    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (size == 0) return false;
        head = (head + 1) % arr.length;
        size--;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (size == 0) return -1;
        return arr[head];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (size == 0) return -1;
        if (tail == 0) return arr[arr.length - 1];
        return arr[tail - 1];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return size == arr.length;
    }
}
