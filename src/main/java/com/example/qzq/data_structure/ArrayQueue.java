package com.example.qzq.data_structure;

/**
 * @Classname ArrayQueue
 * @Description
 * @Date 2019/10/25 11:21
 * @Created by qiziqian
 */
public class ArrayQueue {

    private int head;
    private int tail;
    private int size;
    private int[] array;

    public ArrayQueue(int size) {
        this.array = new int[size];
        head = 0;
        tail = 0;
        this.size = size;
    }

    public boolean push(int val) {
        if (tail == size) {
            if (head == 0) return false;
            for (int i = head; i >= 0; i++) {
                array[i - head] = array[i];
            }
        }
        array[tail] = val;
        tail++;
        return true;
    }

    public int pop() {
        if (head == tail) return 0;
        int i = array[head];
        tail--;
        return i;
    }
}
