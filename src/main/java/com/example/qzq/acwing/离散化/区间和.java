package com.example.qzq.acwing.离散化;

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
        int[] a = new int[N];
        int[] s = new int[N];

        List<Integer> alls = new ArrayList<>();
        List<int[]> add = new ArrayList<>();
        List<int[]> query = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int c = sc.nextInt();
            add.add(new int[]{x, c});
            alls.add(x);
        }

        for (int i = 0; i < m; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            query.add(new int[]{l, r});
            alls.add(l);
            alls.add(r);
        }

        Collections.sort(alls);
        int unique = unique(alls);
        alls = alls.subList(0, unique);

        for (int[] item : add) {
            int index = find(item[0], alls);
            a[index] += item[1];
        }

        //求前缀和
        for (int i = 1; i <= alls.size(); i++) s[i] = s[i - 1] + a[i];

        for (int[] item : query) {
            int l = find(item[0], alls);
            int r = find(item[1], alls);
            System.out.println(s[r] - s[l - 1]);
        }
    }

    //去重
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

    static int find(int x, List<Integer> list) {
        int l = 0;
        int r = list.size() - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (list.get(mid) >= x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l + 1; //因为要考虑到前缀和
    }
}

