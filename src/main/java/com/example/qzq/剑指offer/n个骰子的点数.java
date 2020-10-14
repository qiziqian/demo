package com.example.qzq.剑指offer;

import java.util.ArrayList;

/**
 * @ClassName : n个骰子的点数
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-09-28 11:23
 */
public class n个骰子的点数 {
    public static void main(String[] args) {
        twoSum2(3);
    }

    //自己写出的 回溯的方式
    public static double[] twoSum(int n) {
        int[] numArray = new int[n * 6 + 1];
        double caseCount = Math.pow(6, n);

        for (int i = 1; i <= 6; i++) {
            recur(1, i, n, numArray);
        }
        ArrayList<Double> list = new ArrayList<>();
        for (int i = 0; i < numArray.length; i++) {
            if (numArray[i] == 0) continue;
            list.add((numArray[i] / caseCount));
        }
        double[] doubles = list.stream().mapToDouble(Double::doubleValue).toArray();
        return doubles;
    }

    public static void recur(int currIndex, int currSum, int n, int[] numArray) {
        if (currIndex == n) {
            numArray[currSum]++;
            return;
        }
        for (int i = 1; i <= 6; i++) {
            recur(currIndex + 1, currSum + i, n, numArray);
        }
    }

    //动态规划1     通过统计点数出现的次数
    public static double[] twoSum1(int n) {

        double caseCount = Math.pow(6, n);

        int[][] arr = new int[n + 1][66 + 1];
        for (int i = 1; i <= 6; i++) {
            arr[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= 6 * i; j++) {
                for (int x = 1; x <= 6; x++) {
                    if (j < x) continue;
                    arr[i][j] += arr[i - 1][j - x];
                }
            }
        }


        ArrayList<Double> list = new ArrayList<>();
        for (int i = 0; i < arr[n].length; i++) {
            if (arr[n][i] == 0) continue;
            list.add((arr[n][i] / caseCount));
        }
        double[] doubles = list.stream().mapToDouble(Double::doubleValue).toArray();
        return doubles;
    }

    //化二维数组为一维
    public static double[] twoSum2(int n) {

        double caseCount = Math.pow(6, n);

        int[] arr = new int[66 + 1];
        for (int i = 1; i <= 6; i++) {
            arr[i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 6 * i; j >= i; j--) {
                arr[j] = 0;
                for (int x = 1; x <= 6; x++) {
                    //这个判断是重点
                    if (j - x < i - 1) break;
                    arr[j] += arr[j - x];
                }
            }
        }
        double[] result = new double[5 * n + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = arr[i + n] / caseCount;
        }

        return result;
    }

    //动态规划2     直接统计概率
    public static double[] twoSum3(int n) {
        double pre[] = {1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d};

        for (int i = 2; i <= n; i++) {
            double[] temp = new double[i * 5 + 1];
            for (int j = 0; j < pre.length; j++) {
                for (int curr = 0; curr < 6; curr++) {
                    temp[j + curr] += pre[j] / 6;
                }
            }
            pre = temp;
        }

        return pre;
    }

}