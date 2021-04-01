package com.example.qzq.acwing.基础算法.双指针;

import java.util.Scanner;

/**
 * @ClassName : 最长连续不重复子序列
 * @Author : qiziqian
 * @Description:
 * @Date: 2021-02-23 11:04
 */
public class 最长连续不重复子序列 {

    /*

    双指针的作用:
        替代双重循环,优化时间复杂度,将O(n²)优化成O(n)

    什么时候可以应用:  具备单调关系

     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(doublePointer(a));
    }

    public static int doublePointer(int[] a) {
        int[] map = new int[100005];
        int res = 0, l = 0;
        for (int i = 0; i < a.length; i++) {
            map[a[i]]++;
            //移动指针到指定位置
            while (l <= i && map[a[i]] > 1) {
                map[a[l]]--;
                l++;
            }
            //逻辑
            res = Math.max(res, i - l + 1);
        }
        return res;
    }
}