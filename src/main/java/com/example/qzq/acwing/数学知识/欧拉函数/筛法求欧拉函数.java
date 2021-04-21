package com.example.qzq.acwing.数学知识.欧拉函数;

import java.util.Scanner;

/**
 * @ClassName : 筛法求欧拉函数
 * @Author : qiziqian
 * @Description:
 * @Date: 2021-04-21 14:06
 */
public class 筛法求欧拉函数 {


    static int N = 1000010;
    static int[] euler = new int[N];
    static boolean[] st = new boolean[N];
    static int[] prime = new int[N];
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long res = 0;
        getEuler(n);
        for (int i = 1; i <= n; i++) {
            res += euler[i];
        }
        System.out.println(res);
    }

    private static void getEuler(int x) {
        euler[1] = 1;
        for (int i = 2; i <= x; i++) {
            if (!st[i]) {
                prime[cnt++] = i;
                euler[i] = i - 1;
            }
            for (int j = 0; prime[j] <= x / i; j++) {
                int t = prime[j] * i;
                st[t] = true;
                if (i % prime[j] == 0) {
                    euler[t] = euler[i] * prime[j];
                    break;
                }
                euler[t] = euler[i] * (prime[j] - 1);
            }
        }

    }

}