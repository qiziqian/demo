package com.example.qzq.acwing.区间合并;

import java.util.*;

/**
 * @ClassName : 区间合并
 * @Author : qiziqian
 * @Description:
 * @Date: 2021-03-03 10:51
 */
public class 区间合并 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            a[i] = new int[]{l, r};
        }

        merge(a);
    }

    public static void merge(int[][] a) {
        Arrays.sort(a, Comparator.comparingInt(o -> o[0]));

        List<int[]> res = new ArrayList<>();
        res.add(a[0]);
        for (int i = 1; i < a.length; i++) {
            int[] pre = res.get(res.size() - 1);
            if (pre[1] < a[i][0]) {
                res.add(a[i]);
            } else {
                pre[1] = Math.max(pre[1], a[i][1]);
            }
        }
        System.out.println(res.size());
    }

}