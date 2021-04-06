package com.example.qzq.acwing.数学知识.容斥原理;

import java.util.Scanner;

/**
 * @ClassName : 能被整除的数
 * @Author : qiziqian
 * @Description:
 * @Date: 2021-03-12 14:13
 */
public class 能被整除的数 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] p = new int[m];
        for (int i = 0; i < m; i++) {
            p[i] = sc.nextInt();
        }
        int res = 0;
        for (int i = 0; i < 1 << m; i++) {
            long t = 1, s = 0;
            for (int j = 0; j < m; j++) {
                if ((i >> j & 1) == 1) {
                    s++;
                    if (t * p[j] > n) {
                        t = -1;
                        break;
                    }
                    t *= p[j];
                }
            }
            if (t != -1) {
                if (s % 2 == 1) res += n / t;
                else res -= n / t;
            }
        }
        System.out.println(res);
    }


}