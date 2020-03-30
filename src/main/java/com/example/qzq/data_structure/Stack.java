package com.example.qzq.data_structure;

/**
 * @Classname Stack
 * @Description
 * @Date 2019/10/25 11:06
 * @Created by qiziqian
 */
public class Stack {

    private int[] array;
    private int size;
    //当前
    private int count;

    public Stack(int size) {
        array = new int[size];
        this.size = size;
        count = 0;
    }

    public int pop() {
        if (count == 0) return 0;
        int i = array[count - 1];
        array[count] = 0;
        count--;
        return i;
    }

    public boolean push(int val) {
        if (count == size) return false;
        array[count] = val;
        count++;
        return true;
    }
}
