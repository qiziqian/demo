package com.example.qzq.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName : 距离顺序排列矩阵单元格
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-11-17 17:07
 */
public class 距离顺序排列矩阵单元格 {
    public static void main(String[] args) {
        allCellsDistOrder(2, 3, 1, 2);
    }

    public static int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        boolean[][] array = new boolean[R][C];
        Queue<int[]> queue = new ArrayDeque<>();
        List<int[]> list = new ArrayList<>();
        queue.add(new int[]{r0, c0});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (array[poll[0]][poll[1]]) {
                continue;
            }
            array[poll[0]][poll[1]] = true;
            list.add(poll);
            if (poll[0] > 0) queue.add(new int[]{poll[0] - 1, poll[1]});
            if (poll[0] < R - 1) queue.add(new int[]{poll[0] + 1, poll[1]});
            if (poll[1] > 0) queue.add(new int[]{poll[0], poll[1] - 1});
            if (poll[1] < C - 1) queue.add(new int[]{poll[0], poll[1] + 1});
        }

        return list.toArray(new int[0][2]);
    }
}