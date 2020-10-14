package com.example.qzq.剑指offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName : N皇后
 * @Author : qiziqian
 * @Description: 写了两个半钟头,
 * @Date: 2020-09-22 11:18
 */
public class N皇后 {


    /**
     * Author qiziqian
     * Description
     * 摆放位置,摆第一行,检查,然后第二行,检查,然后第三行,检查,以此类推
     * Date  2020/9/22
     **/


    static List<List<String>> list = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(solveNQueens(8));
    }

    public static List<List<String>> solveNQueens(int n) {
        recur(n, new ArrayList<>(), 0);
        return list;
    }

    public static void recur(int n, List<String> strList, int currRow) {
        if (currRow == n) {
            list.add(strList);
            return;
        }

        char[] charArray = new char[n];
        Arrays.fill(charArray, '.');

        for (int index = 0; index < n; index++) {
            if (isSuitable(n, strList, index)) {
                ArrayList<String> currList = new ArrayList<>(strList);
                charArray[index] = 'Q';
                currList.add(String.valueOf(charArray));
                charArray[index] = '.';
                recur(n, currList, currRow + 1);
            }
        }
    }

    public static boolean isSuitable(int n, List<String> strList, int index) {
        int leftIndex = index - 1;
        int rightIndex = index + 1;
        for (int i = strList.size() - 1; i >= 0; i--) {
            //列
            if (strList.get(i).charAt(index) == 'Q') return false;
            //↖
            if (leftIndex >= 0) {
                if (strList.get(i).charAt(leftIndex--) == 'Q') return false;
            }
            //↗
            if (rightIndex < n) {
                if (strList.get(i).charAt(rightIndex++) == 'Q') return false;
            }

        }
        return true;
    }

}