package com.example.qzq.acwing.基础算法.离散化;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName : 区间和
 * @Author : qiziqian
 * @Description:
 * @Date: 2021-03-01 10:08
 */
public class 区间和 {

    /*
    与 hash的区别: 离散是保序的,hash则不是
    特指 整数的,有序的离散化
    范围大,  0~999999,但是数的个数少,可能会需要用下标来做
    因此把它们映射到从0开始的连续的自然数

     1.可能会有重复元素 --->去重
     2.如何快速算出一个值离散化后的数是多少

        离散= 排序+去重+前缀和+二分
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int N = 300010;
        List<Integer> all = new ArrayList<>();
        List<int[]> add = new ArrayList<>();
        List<int[]> query = new ArrayList<>();
        int[] a = new int[N];
        int[] b = new int[N];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt(), c = sc.nextInt();
            add.add(new int[]{x, c});
            all.add(x);
        }
        for (int i = 0; i < m; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            all.add(l);
            all.add(r);
            query.add(new int[]{l, r});
        }

        Collections.sort(all);
        int last = unique(all);
        List<Integer> list = all.subList(0, last);

        for (int[] ints : add) {
            int i = find(list, ints[0]);
            a[i + 1] += ints[1];
        }
        for (int i = 1; i <= list.size(); i++) {
            b[i] = b[i - 1] + a[i];
        }
        for (int[] ints : query) {
            int l = find(list, ints[0]);
            int r = find(list, ints[1]);
            System.out.println(b[r + 1] - b[l] + " ");
        }

    }

    static int unique(List<Integer> list) {
        int j = 0;
        for (int i = 0; i < list.size(); i++) {
            if (i == 0 || list.get(i) != list.get(i - 1)) {
                list.set(j, list.get(i));
                j++;
            }
        }
        return j;
    }

    static int find(List<Integer> list, int x) {
        int l = 0, r = list.size() - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (list.get(mid) >= x) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}

