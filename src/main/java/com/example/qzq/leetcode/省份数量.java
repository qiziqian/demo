package com.example.qzq.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName : 省份数量
 * @Author : qiziqian
 * @Description:
 * @Date: 2021-01-07 10:32
 */
public class 省份数量 {
    public int findCircleNum2(int[][] M) {
        boolean[] isPass = new boolean[M.length];
        int provinceCount = 0;
        for (int i = 0; i < M.length; i++) {
            if (isPass[i]) continue;
            dfs(isPass, M, i);
            provinceCount++;
        }
        return provinceCount;
    }

    public void dfs(boolean[] isPass, int[][] M, int index) {
        isPass[index] = true;
        for (int i = 0; i < M[index].length; i++) {
            if (i == index) continue;
            if (M[index][i] == 1) {
                dfs(isPass, M, i);
            }

        }

    }

    public int findCircleNum(int[][] M) {
        boolean[] isPass = new boolean[M.length];
        int provinceCount = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < M.length; i++) {
            if (isPass[i]) continue;
            queue.offer(i);
            while (!queue.isEmpty()) {
                Integer row = queue.poll();
                isPass[row] = true;
                for (int column = 0; column < M[row].length; column++) {
                    if (row == column) continue;
                    if (M[row][column] != 1 && !isPass[column]) {
                        queue.offer(M[row][column]);
                        isPass[column] = true;
                    }

                }
            }
            provinceCount++;

        }
        return provinceCount;
    }
}