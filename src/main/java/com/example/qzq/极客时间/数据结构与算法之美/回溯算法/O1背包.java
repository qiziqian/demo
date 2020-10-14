package com.example.qzq.极客时间.数据结构与算法之美.回溯算法;

/**
 * @ClassName : O1背包
 * @Author : qiziqian
 * @Description: 在背包里装物品, 使其不超过W Kg,最后得到能容纳的最大重量
 * @Date: 2020-09-23 14:53
 */
public class O1背包 {

    public int maxW = Integer.MIN_VALUE; //存储背包中物品总重量的最大值

    public void f(int i, int cw, int[] items, int n, int w) {
        if (cw > w || i == n) {
            if (cw > maxW) maxW = cw;
            return;
        }

        f(i + 1, cw, items, n, w);
        if (cw + items[i] < w) {
            f(i + 1, cw + items[i + 1], items, n, w);
        }


    }
}