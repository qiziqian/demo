package com.example.qzq.acwing.数据结构.堆;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @Description
 * @Date 2021/4/5 9:57
 * @Author by qiziqian
 */
public class 模拟堆 {
    static BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(read.readLine());


        Heap heap = new Heap(n);

        while (n-- > 0) {
            String[] s = read.readLine().split(" ");
            String op = s[0];
            if ("I".equals(op)) {
                int x = Integer.parseInt(s[1]);
                heap.insert(x);
            } else if ("PM".equals(op)) log.write(heap.getTop() + "\n");
            else if ("DM".equals(op)) {
                heap.removeTop();
            } else if ("D".equals(op)) {
                int k = Integer.parseInt(s[1]);
                heap.remove(k);
            } else if ("C".equals(op)) {
                int k = Integer.parseInt(s[1]);
                int x = Integer.parseInt(s[2]);
                heap.update(k, x);
            }
        }
        log.flush();
    }

    //这个交换过程其实有那么些绕 但关键是理解 如果hp[u]=k 则ph[k]=u 的映射关系
    //之所以要进行这样的操作是因为 经过一系列操作 堆中的元素并不会保持原有的插入顺序
    //从而我们需要对应到原先第K个堆中元素
    //如果理解这个原理 那么就能明白其实三步交换的顺序是可以互换
    //h,hp,ph之间两两存在映射关系 所以交换顺序的不同对结果并不会产生影响


    public static class Heap {
        private final int[] h;
        private final int[] ph;  //存放第k个插入点的下标
        private final int[] hp;  //存放堆中点的插入次序
        private int size;
        private int m;

        public Heap(int n) {
            this.h = new int[n + 1];
            this.ph = new int[n + 1];
            this.hp = new int[n + 1];
            this.size = 0;
            this.m = 0;      //m用来记录插入的数的个数
        }

        public void insert(int k) {
            m++;
            h[++size] = k;
            ph[m] = size;
            hp[size] = m;
            up(size);
        }

        public int getTop() {
            return h[1];
        }

        public void removeTop() {
            heapSwap(1, size);
            size--;
            down(1);
        }

        public void remove(int k) {
            int u = ph[k];                //这里一定要用u=ph[k]保存第k个插入点的下标
            heapSwap(u, size);          //因为在此处heapSwap操作后ph[k]的值已经发生
            size--;                    //如果在up,down操作中仍然使用ph[k]作为参数就会发生错误
            up(u);
            down(u);
        }

        public void update(int k, int x) {
            h[ph[k]] = x;
            down(ph[k]);
            up(ph[k]);
        }

        private void down(int u) {
            int t = u;
            if (u * 2 <= size && h[t] > h[u * 2]) t = u * 2;
            if (u * 2 + 1 <= size && h[t] > h[u * 2 + 1]) t = u * 2 + 1;
            if (u != t) {
                heapSwap(u, t);
                down(t);
            }
        }

        private void up(int u) {
            if (u / 2 > 0 && h[u] < h[u / 2]) {
                heapSwap(u, u / 2);
                up(u / 2);
            }
        }

        private void heapSwap(int u, int v) {
            swap(h, u, v);
            swap(hp, u, v);
            swap(ph, hp[u], hp[v]);
        }

        private void swap(int[] a, int u, int v) {
            int tmp = a[u];
            a[u] = a[v];
            a[v] = tmp;
        }
    }

}
