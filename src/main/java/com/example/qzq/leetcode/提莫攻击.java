package com.example.qzq.leetcode;

import java.util.Arrays;

/**
 * @ClassName : 提莫攻击
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-10-16 10:44
 */
public class 提莫攻击 {
    public static void main(String[] args) {
        boolean[] array = new boolean[10];
        Arrays.fill(array, 2, 3 + 1, true);
        System.out.println("");
    }

    //超时
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        boolean[] array = new boolean[timeSeries[timeSeries.length - 1] + duration + 1];
        for (int i = 0; i < timeSeries.length; i++) {
            for (int j = timeSeries[i]; j < timeSeries[i] + duration; j++) {
                array[j] = true;
            }
        }
        int result = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i]) result++;
        }

        return result;
    }

    //反过来算就行了,但是效率低
    public int findPoisonedDuration2(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length < 1 || duration == 0) return 0;
        boolean[] array = new boolean[timeSeries[timeSeries.length - 1] + duration + 1];
        for (int i = timeSeries.length - 1; i >= 0; i--) {
            for (int j = timeSeries[i]; j < timeSeries[i] + duration; j++) {
                if (array[j]) break;
                array[j] = true;
            }
        }

        int result = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i]) result++;
        }

        return result;
    }

    //动态规划
    public int findPoisonedDuration3(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length < 1 || duration == 0) return 0;

        int result = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            if (timeSeries[i + 1] - timeSeries[i] > duration) {
                result += duration;
            } else {
                result += timeSeries[i + 1] - timeSeries[i];
            }
        }

        return result;
    }
}