package com.example.qzq.极客时间.数据结构与算法之美.O1背包;

/**
 * @ClassName : 基于查表的O1背包
 * @Author : qiziqian
 * @Description: 剪枝, 更加接近动态规划
 * @Date: 2020-09-24 16:17
 */
public class 基于查表的O1背包 {

    private final int[] weight = {2, 2, 4, 6, 3
    };  // 物品重量
    private final int n = 5; // 物品个数
    private final int w = 9; // 背包承受的最大重量
    private final boolean[][] mem = new boolean[5][10]; // 备忘录,默认值false
    private int maxW = Integer.MIN_VALUE; // 结果放到maxW中

    public void f(int i, int cw) { // 调用f(0, 0)
        if (cw == w || i == n) { // cw==w表示装满了,i==n表示物品都考察完了
            if (cw > maxW) maxW = cw;
            return;
        }
        if (mem[i][cw]) return; // 重复状态
        mem[i][cw] = true; // 记录(i, cw)这个状态
        f(i + 1, cw); // 选择不装第i个物品
        if (cw + weight[i] <= w) {
            f(i + 1, cw + weight[i]); // 选择装第i个物品
        }
    }
}