package com.example.qzq.acwing.数据结构.堆;

import java.util.Scanner;

/**
 * @Description
 * @Date 2021/4/2 19:09
 * @Author by qiziqian
 */
public class 堆排序 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Heap heap = new Heap();

        while (n-- > 0) {
            int i = sc.nextInt();
            heap.add(i);
        }

        for (int i = heap.size / 2; i > 0; i--) {
            heap.down(i);
        }

        while (m-- > 0) {
            System.out.print(heap.get() + " ");
            heap.deleteTop();
        }

    }


    public static class Heap {
        int[] h;
        int size = 0;

        public Heap() {
            h = new int[100010];
        }

        public void down(int n) {
            int u = n;
            if (n * 2 <= size && h[u] > h[n * 2]) u = n * 2;
            if (n * 2 + 1 <= size && h[u] > h[n * 2 + 1]) u = n * 2 + 1;
            if (u != n) {
                swap(u, n);
                down(u);
            }
        }

        public void add(int n) {
            h[++size] = n;
        }

        public void deleteTop() {
            h[1] = h[size--];
            down(1);
        }

        public int get() {
            return h[1];
        }

        public void swap(int i, int j) {
            int temp = h[i];
            h[i] = h[j];
            h[j] = temp;
        }
    }
}
