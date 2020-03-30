package com.example.qzq.data_structure;

/**
 * @Classname Heap
 * @Description
 * @Date 2019/11/7 13:38
 * @Created by qiziqian
 */
public class Heap {
    private int[] a;
    private int n;
    private int count;

    public Heap(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    //从下往上堆化
    public void insert(int data) {
        if (count == n) return;
        count++;
        a[count] = data;
        int i = count;
        while (i / 2 > 0 && a[i] > a[i / 2]) {
            swap(a, i, i / 2);
            i = i / 2;
        }
    }

    //删除堆顶值
    public void removeMax() {
        a[1] = a[count];
        count--;
        int i = 1;
        heapify(i, a, n);
    }

    //交换
    public void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }

    //堆排序
    public void sort(int[] a, int count) {
        buildHeap(a, count);
        int k = n;
        while (k > 1) {
            swap(a, 1, k);
            k--;
            heapify(1, a, k);
        }
    }

    //建堆
    public void buildHeap(int[] a, int count) {
        for (int i = count / 2; i >= 1; i++) {
            heapify(i, a, count);
        }
    }

    //堆化,将最大的值放到根节点
    public void heapify(int i, int[] a, int n) {
        while (true) {
            int maxPos = i;
            if (2 * i <= n && a[2 * i] > a[i]) maxPos = 2 * i;
            if (2 * i + 1 <= n && a[2 * i + 1] > a[maxPos]) maxPos = 2 * i + 1;
            if (maxPos == i) break;
            swap(a, i, maxPos);
            i = maxPos;
        }
    }
}
