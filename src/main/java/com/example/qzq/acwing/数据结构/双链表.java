package com.example.qzq.acwing.数据结构;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @ClassName : 双链表
 * @Author : qiziqian
 * @Description:
 * @Date: 2021-03-05 11:14
 */
public class 双链表 {

    public static class DualLinkList {
        int[] l = new int[100010];
        int[] r = new int[100010];
        int[] e = new int[100010];
        int idx = 0;

        public void init() {
            r[0] = 1;
            l[1] = 0;
            idx = 2;
        }

        public void add(int k, int x) {
            e[idx] = x;
            r[idx] = r[k];
            l[idx] = k;
            l[r[k]] = idx;
            r[k] = idx;
            idx++;
        }

        public void remove(int k) {
            l[r[k]] = l[k];
            r[l[k]] = r[k];
        }
    }

}