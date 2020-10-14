package com.example.qzq.剑指offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName : 和为s的连续正数序列
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-09-27 15:54
 */
public class 和为s的连续正数序列 {
    static List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) {
        findContinuousSequence3(15);
    }

    //凭直觉写出来的
    public static int[][] findContinuousSequence(int target) {
        for (int i = 1; i < target; i++) {
            List<Integer> arrayList = new ArrayList<>(i);
            arrayList.add(i);
            recur(i, i, arrayList, target);
        }

        int[][] array = new int[list.size()][];
        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i).stream().mapToInt(Integer::intValue).toArray();
        }
        return array;
    }

    public static void recur(int currIndex, int currSum, List<Integer> currList, int target) {
        if (currSum == target) {
            list.add(currList);
            return;
        } else if (currSum > target) {
            return;
        } else {

            List<Integer> arrayList = new ArrayList<>(currList);
            arrayList.add(currIndex + 1);
            recur(currIndex + 1, currSum + currIndex + 1, arrayList, target);
        }
    }

    public static int[][] findContinuousSequence3(int target) {
        List<List<Integer>> list = new ArrayList<>();
        int head = 1;
        int j = 1;
        int sum = 0;
        while (head <= target / 2) {
            if (sum < target) {
                sum += j;
                j++;
            } else if (sum > target) {
                sum -= head;
                head++;
            } else {
                List<Integer> currList = new ArrayList<>();
                for (int index = head; index < j; index++) {
                    currList.add(index);
                }
                list.add(currList);
                sum -= head;
                head++;
            }
        }
        int[][] array = new int[list.size()][];
        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i).stream().mapToInt(Integer::intValue).toArray();
        }
        return array;
    }

    //leetcode  削尖
    public int[][] findContinuousSequence2(int target) {
        List<int[]> result = new ArrayList<>();
        int i = 1;
        while (target > 0) {
            target -= i;
            i++;
            if (target > 0 && target % i == 0) {
                int[] array = new int[i];
                for (int k = target / i, j = 0; k < target / i + i; k++, j++) {
                    array[j] = k;
                }
                result.add(array);
            }
        }
        Collections.reverse(result);
        return result.toArray(new int[0][]);
    }
}