package com.example.qzq.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : 插入区间
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-11-05 17:19
 */
public class 插入区间 {

    public static void main(String[] args) {
        int[][] array = {{1, 5}, {6, 9}};
        insert(array, new int[]{0, 0});
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            int[][] temp = new int[1][];
            temp[0] = newInterval;
            return temp;
        }
        int maxLength = Math.max(intervals[intervals.length - 1][1] + 1, newInterval[1] + 1);
        int[] temp = new int[maxLength];
        //左边界 右边界
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] == intervals[i][1]) temp[intervals[i][0]] = 1;
            for (int j = intervals[i][0]; j < intervals[i][1]; j++) {
                temp[j] = 2;
            }
        }

        if (newInterval[0] == newInterval[1] && temp[newInterval[0]] != 0) {
            temp[newInterval[0]] = 1;
        }
        for (int i = newInterval[0]; i < newInterval[1]; i++) {
            temp[i] = 2;
        }
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < temp.length; i++) {

            if (temp[i] == 2) {
                int left = i;
                while (i < temp.length && temp[i] == 2) i++;
                int right = i;
                list.add(new int[]{left, right});
            } else if (temp[i] == 1) {
                list.add(new int[]{i, i});
            }
        }

        int[][] result = new int[list.size()][];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}