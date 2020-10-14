package com.example.qzq.极客时间.数据结构与算法之美.O1背包;

/**
 * @ClassName : 基于回溯的O1背包
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-09-24 14:08
 */
public class 基于回溯的O1背包 {


    private final int[] weight = {2, 2, 4, 6, 3};  // 物品重量
    private final int n = 5; // 物品个数
    private final int w = 9; // 背包承受的最大重量
    // 回溯算法实现。注意：我把输入的变量都定义成了成员变量。
    private int maxW = Integer.MIN_VALUE; // 结果放到maxW中

    public void f(int i, int cw) { // 调用f(0, 0)
        if (cw == w || i == n) { // cw==w表示装满了,i==n表示物品都考察完了
            if (cw > maxW) maxW = cw;
            return;
        }
        f(i + 1, cw); // 选择不装第i个物品
        if (cw + weight[i] <= w) {
            f(i + 1, cw + weight[i]); // 选择装第i个物品
        }
    }
}